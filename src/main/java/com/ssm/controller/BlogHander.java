package com.ssm.controller;

import com.ssm.bean.Header;
import com.ssm.bean.JwtUtil;
import com.ssm.bean.PageBean;
import com.ssm.bean.Result;
import com.ssm.entity.Blog;
import com.ssm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.JmxException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ZhangRunKai
 * @date 2020/7/21 9:57
 */
@Controller
@RequestMapping("/blog")
public class BlogHander {

    @Autowired
    BlogService blogService;

    @RequestMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Blog blog,HttpServletRequest request){
        String token=request.getHeader(Header.AUTHORZATION);
        Integer userId=JwtUtil.getUserId(token);
        blog.setUserId(userId);
        blog.setStatus(true);
        if(blogService.save(blog))
            return Result.success();
        return Result.fail();
    }

    /**
     * 验证当前博客创建者以及登陆用户是否为同一个人
     * 如果为同个人，则进行更新
     * 更新成功返回200
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Blog blog,HttpServletRequest request){
        if(JwtUtil.checkAuth(request.getHeader(Header.AUTHORZATION),blog.getUserId())
                &&blogService.update(blog)){
            return Result.success();
        }
        else return Result.authFail();
    }


    /**
     * 根据用户id查找该用户所有的博客，默认是管理员
     * 管理员发布相当于公告，会在首页进行展示
     * 获取数据后做分页处理并返回
     */
    @RequestMapping(value = "/findAllByUserId",method = RequestMethod.GET,params = {"userId","currentPage"})
    @ResponseBody
    public Result findAllByUserId(
            HttpServletRequest request,
            @RequestParam(value = "userId",required = false,defaultValue = "1")int userId,
            @RequestParam("currentPage") int currentPage){

        Integer findUserId;
        try{
            String token=request.getHeader(Header.AUTHORZATION);
            findUserId = JwtUtil.getUserId(token);
        }catch (Exception e){
            findUserId = 1;
            System.out.println("没有token");
        }
        PageBean pageBean = new PageBean<Blog>();
        List<Blog> list=blogService.findAll(userId,findUserId);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(5);
        pageBean.setTotal(list.size());//返回总的数量
        int sum = 5*currentPage;
        pageBean.setData(list.subList(sum-5,Math.min(sum,list.size())));//截取当前页的数据
        return Result.success(pageBean);
    }

    @RequestMapping(value = "/findBlogId",method = RequestMethod.GET)
    @ResponseBody
    public Result packageType(@RequestParam(value = "blogId", required = true) Integer blogId){
        return Result.success(blogService.findId(blogId));
    }

}
