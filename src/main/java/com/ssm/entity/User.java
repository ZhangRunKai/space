package com.ssm.entity;

import lombok.Data;

/**
 * @author ZhangRunKai
 * @date 2020/6/30 16:36
 */

@Data
public class User {

    private Integer id;
    private String userName;
    private String userAccount;
    private String userPassword;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
