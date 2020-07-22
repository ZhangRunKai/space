package com.ssm.dao;


import com.ssm.entity.User;
/**
 * @author ZhangRunKai
 * @date 2020/7/4 18:14
 */
import java.util.List;
public interface UserRepository {
    public List<User> findAll();

    public User findUserByUserAccount(String userAccount);

    public Boolean saveByUser(User user);

    public int save(User user);
}