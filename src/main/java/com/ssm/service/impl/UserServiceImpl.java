package com.ssm.service.impl;

import com.ssm.entity.User;
import com.ssm.dao.UserRepository;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author ZhangRunKai
 * @date 2020/7/4 18:19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUserAccount(String userAccount) {
        System.out.println("准备进入数据层");
        User user= userRepository.findUserByUserAccount(userAccount);
        System.out.println(user);
        return user;
    }

    @Override
    public Boolean save(User user) {
        //System.out.println(userRepository.findUserByUserAccount(user.getUserAccount()));
        Integer rs=userRepository.save(user);
        return rs==1;
//        if(userRepository.findUserByUserAccount(user.getUserAccount())==null){
//            return userRepository.save(user)==1;
//        }
//        return false;
    }
}