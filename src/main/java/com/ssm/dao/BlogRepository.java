package com.ssm.dao;

import com.ssm.entity.Blog;

import java.util.List;

/**
 * @author ZhangRunKai
 * @date 2020/7/21 9:58
 */
public interface BlogRepository {

    public List<Blog> findAll(Integer id);

    public int save(Blog blog);
}
