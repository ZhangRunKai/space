package com.ssm.service;

import com.ssm.bean.PageBean;
import com.ssm.entity.Blog;

import java.util.List;

/**
 * @author ZhangRunKai
 * @date 2020/7/22 14:19
 */
public interface BlogService {

    public List<Blog> findAll(PageBean pageBean);

    public boolean save(Blog blog);

    public Blog findId(Integer id);
}
