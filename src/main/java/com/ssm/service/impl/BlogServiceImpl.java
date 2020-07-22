package com.ssm.service.impl;

import com.ssm.dao.BlogRepository;
import com.ssm.entity.Blog;
import com.ssm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhangRunKai
 * @date 2020/7/22 14:20
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;
    @Override
    public boolean save(Blog blog) {
        if(blogRepository.save(blog)==1)
            return true;
        return false;
    }
}
