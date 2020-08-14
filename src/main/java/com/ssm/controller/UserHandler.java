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

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/login")
    public @ResponseBody Result login(@RequestBody User user,HttpServletRequest request,HttpServletResponse httpServletResponse){

        System.out.println("auth="+request.getHeader("Authorization"));
        User user1=userService.findUserByUserAccount(user.getUserAccount());
        if(user1.getUserPassword().equals(user.getUserPassword())){
            httpServletResponse.setHeader("Access-Control-Expose-Headers","Authorization");
            try{
                httpServletResponse.setHeader("Authorization",JwtUtil.createToken(user1.getUserId()));
            }
            catch (Exception e){
                e.printStackTrace();
                return Result.fail();
            }
            return Result.success(user1);
        }
        else{
            return Result.fail();
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public  Result register(@RequestBody User user,HttpServletResponse response){
        System.out.println(user);
        user.setRoleId(2);
        if(userService.save(user)){
            response.setHeader("Access-Control-Expose-Headers","token");
            User user1=userService.findUserByUserAccount(user.getUserAccount());
            if(user1==null) return Result.fail();
            try{
                response.setHeader("Authorization",JwtUtil.createToken(user.getUserId()));
            }
            catch (Exception E){
                return Result.fail();
            }
            user.setUserPassword("");
            return Result.success(user);
        }
        return Result.fail();
    }


}
