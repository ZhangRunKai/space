package com.ssm.service.impl;

import com.ssm.bean.PageBean;
import com.ssm.dao.BlogRepository;
import com.ssm.entity.Blog;
import com.ssm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ZhangRunKai
 * @date 2020/7/22 14:20
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll(PageBean pageBean) {
        return blogRepository.findAll();
    }


    @Override
    public boolean save(Blog blog) {
        LocalDateTime now = LocalDateTime.now();
        blog.setCreated(now);
        if(blogRepository.save(blog)==1)
            return true;
        return false;
    }

    @Override
    public Blog findId(Integer id) {
        return blogRepository.findId(id);
    }
}
