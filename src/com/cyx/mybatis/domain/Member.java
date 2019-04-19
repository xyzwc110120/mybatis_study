package com.cyx.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Member {

    private Long id;
    private String account;
    private String password;
    private Integer balance;
    private String createTime;

    public Member() {
    }

    public Member(Long id, String account, String password, Integer balance) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}