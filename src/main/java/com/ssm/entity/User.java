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
    private Integer roleId;

    public User() {
    }

    public User(Integer id, String userName, String userAccount, String userPassword, Integer roleId) {
        this.id = id;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
