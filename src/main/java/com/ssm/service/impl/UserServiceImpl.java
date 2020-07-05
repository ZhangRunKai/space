package com.ssm.service.impl;

import com.ssm.entity.User;
import com.ssm.repository.UserRepository;
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
}