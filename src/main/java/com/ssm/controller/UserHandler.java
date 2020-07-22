package com.ssm.controller;

/**
 * @author ZhangRunKai
 * @date 2020/7/4 18:20
 */
import com.ssm.bean.JwtUtil;
import com.ssm.bean.Result;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @RequestMapping("/login")
    public @ResponseBody Result login(@RequestBody User user, HttpServletResponse response){
        User user1=userService.findUserByUserAccount(user.getUserAccount());
        if(user1.getUserPassword().equals(user.getUserPassword())){
            response.setHeader("Access-Control-Expose-Headers","token");
            response.setHeader("token",JwtUtil.sign(user.getUserName(),user.getUserAccount()));
            return Result.success(user);
        }
        else{
            return Result.fail();
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public  Result register(@RequestBody User user,HttpServletResponse response){
        user.setRoleId(2);
        if(userService.save(user)){
            response.setHeader("Access-Control-Expose-Headers","token");
            response.setHeader("token",JwtUtil.sign(user.getUserName(),user.getUserAccount()));
            user.setUserPassword("");
            return Result.success(user);
        }
        return Result.fail();
    }

    @RequestMapping("/test")
    public @ResponseBody Result login( HttpServletResponse response){
        response.setHeader("token",JwtUtil.sign("1232321","asdsad"));
        return Result.success();
    }


}
