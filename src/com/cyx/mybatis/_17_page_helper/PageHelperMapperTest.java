package com.cyx.mybatis._17_page_helper;

import com.cyx.mybatis._03_mybatis_util.MyBatisUtil;
import com.cyx.mybatis.domain.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PageHelperMapperTest {

    @Test
    @DisplayName("测试 PageHelper 分页插件")
    void testGetMemberList() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            // 紧跟着的第一个 select 方法会被分页
            PageHelper.startPage(2, 2);
            List<Student> studentList1 = session.getMapper(PageHelperMapper.class).getStudentList();
            // 后面的不会被分页，除非再次调用 PageHelper.startPage
            List<Student> studentList2 = session.getMapper(PageHelperMapper.class).getStudentList();

            System.out.println(studentList1);
            /*
                控制台输出：
                    Page{count=true, pageNum=2, pageSize=2, startRow=2, endRow=4, total=9, pages=5, reasonable=true,
                pageSizeZero=true}[Student{id=3, name='叶孤城', age=24}, Student{id=4, name='李寻欢', age=28}]

                可以看出分页时，实际返回的结果 list 类型是 Page<E>。
            */
            System.out.println(studentList2);
            /*
                控制台输出：
                    [Student{id=1, name='陆小凤', age=23}, Student{id=2, name='西门吹雪', age=24}, Student{id=3, name='叶孤城', age=24},
                Student{id=4, name='李寻欢', age=28}, Student{id=5, name='楚留香', age=22}, Student{id=6, name='阿飞', age=20},
                Student{id=13, name='朱儿', age=18}, Student{id=14, name='任盈盈', age=20}, Student{id=574, name='蓝蝴蝶', age=17}]

                可以看出，第二次查询没有做分页。
            */

            // 分页时，实际返回的结果 list 类型是 Page<E>，如果想取出分页信息，需要强制转换为 Page<E>。
            Page<Student> page = (Page<Student>) studentList1;
            System.out.println(page.getTotal());

            // 用PageInfo对结果进行包装，PageInfo 包含了非常全面的分页属性
            PageInfo<Student> pageInfo = new PageInfo(studentList1);
            System.out.println(pageInfo);
        }
    }

}