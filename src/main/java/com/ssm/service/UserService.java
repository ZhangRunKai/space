package com.ssm.service;

import java.util.List;

import com.ssm.bean.Result;
import com.ssm.entity.User;
/**
 * @author ZhangRunKai
 * @date 2020/7/4 18:19
 */
public interface UserService {
    public List<User> findAll();

    public User findUserByUserName(String userName);

}
