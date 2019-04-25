package com.cyx.mybatis._16_plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.*;

@Intercepts(@Signature(
        type = ResultSetHandler.class,
        method = "handleResultSets",
        args = Statement.class))
public class Key4MapInterceptor implements Interceptor {

    // 接受自定义属性
    private Properties properties;

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 放行
        List<Object> objectList = (List<Object>) invocation.proceed();
        for (Object object : objectList) {
            // 若集合对象不是 Map 类型则停止遍历，直接返回数据
            if (!(object instanceof Map)) {
                break;
            }
            // 若是 Map 类型，则进行处理
            handleMap((Map<String, Object>) object);
        }

        return objectList;
    }

    /**
     * 对 Map 集合的 key 进行处理
     */
    private void handleMap(Map<String, Object> map) {
        String prefix = properties.getProperty("prefix");
        // 因为循环中无法删除 Map 中的 key，所以重新创建一个 Set 集合来存放 key
        Set<String> keySet = new HashSet<>(map.keySet());

        for (String key : keySet) {
            // 用来存放修改过后的 key
            String newKey = key;

            // 若 prefix 属性不为空且 Map 的 key 是以该属性值开头，则从 key 中删除该开头
            if (prefix != null && key.startsWith(prefix)) {
                newKey = key.substring(prefix.length());
            }

            // 若 key 中带有下划线“_”，则删除下划线，且下划线后一个字母大写
            if (newKey.contains("_")) {
                newKey = handleKey(newKey);
            }

            // 若 key 修改过，则对 map 做修改
            if (!newKey.equals(key)) {
                // 因为 Map 中无法修改 key，所以需要删除该 key 并重新存入新的 key
                map.put(newKey, map.get(key));
                map.remove(key);
            }
        }
    }

    /**
     * 处理 key
     */
    private String handleKey(String key) {
        // 拼接新的 key
        StringBuilder builder = new StringBuilder(15);
        // 是否是下划线
        boolean underline = false;

        // 循环字符串
        for (char c : key.toCharArray()) {
            // 若字符为下划线
            if (c == '_') {
                underline = true;
            } else {
                // 若 underline 为 true，则该字节大写，否则小写
                if (underline) {
                    builder.append(Character.toUpperCase(c));
                    underline = false;
                } else {
                    builder.append(Character.toLowerCase(c));
                }
            }
        }
        return builder.toString();
    }
}
