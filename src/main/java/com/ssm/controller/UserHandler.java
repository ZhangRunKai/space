package com.ssm.controller;

/**
 * @author ZhangRunKai
 * @date 2020/7/4 18:20
 */
import com.ssm.bean.Result;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list", userService.findAll());
        return modelAndView;
    }

    @RequestMapping("/test")
    public Result test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("rs","Result.success()");
        return Result.success();
    }

    @RequestMapping("/json")
    public @ResponseBody User json(@RequestBody User user){
        System.out.println("first:"+user);
        user= userService.findAll().get(0);
        System.out.println("second:"+user);
        return user;
    }
}
