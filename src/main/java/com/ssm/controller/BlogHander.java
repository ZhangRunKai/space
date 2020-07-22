package com.ssm.controller;

import com.ssm.bean.PageBean;
import com.ssm.bean.Result;
import com.ssm.entity.Blog;
import com.ssm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result save(){
        PageBean pageBean=new PageBean<Blog>();
        List<Blog> list=blogService.findAll(new PageBean());
        pageBean.setData(list);
        pageBean.setTotal(list.size());
        return Result.success(pageBean);
    }

    @RequestMapping("/findAllByUserId")
    @ResponseBody
    public Result findAllByUserId(){
        PageBean pageBean=new PageBean<Blog>();
        List<Blog> list=blogService.findAll(new PageBean());
        pageBean.setData(list);
        pageBean.setTotal(list.size());
        return Result.success(pageBean);
    }

    @RequestMapping("/findBlogId")
    @ResponseBody
    public Result packageType(@RequestParam(value = "blogId", required = true) Integer blogId){
        return Result.success(blogService.findId(blogId));
    }

}
