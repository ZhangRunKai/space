package com.ssm.controller;

import com.ssm.bean.Result;
import com.ssm.entity.Blog;
import com.ssm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZhangRunKai
 * @date 2020/7/21 9:57
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/blog")
public class BlogHander {

    @Autowired
    BlogService blogService;

    @RequestMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Blog blog){

        if(blogService.save(blog)) return Result.success();
        return Result.fail();
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Result save(@RequestBody Blog blog){

        if(blogService.save(blog)) return Result.success();
        return Result.fail();
    }

}
