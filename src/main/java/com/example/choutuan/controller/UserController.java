package com.example.choutuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.choutuan.common.R;
import com.example.choutuan.entity.User;
import com.example.choutuan.service.UserService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!!!!";
    }
    @RequestMapping("/reg")
    public ModelAndView register(){
        ModelAndView  modelAndView= new ModelAndView("/front/page/register");
        return modelAndView;
    }
    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView  modelAndView= new ModelAndView("/front/page/home");
        return modelAndView;
    }
    @RequestMapping("/login")
    public ModelAndView Login(){
        ModelAndView  modelAndView= new ModelAndView("/front/page/login");
        return modelAndView;
    }
    @GetMapping("/get")
    public void getUser(){

        // 调用service层的查询方法
        List<User> userList = userService.listAlluu();
        System.out.println(userList);
        if (userList != null) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    @PostMapping("/login")
    public R<User> doLogin(@RequestBody Map map, HttpSession session){
        log.info(map.toString());
        //获取手机号
        String name = map.get("name").toString();
        //获取密码
        String password = map.get("password").toString();
        if(name == null || name.isEmpty() || password == null || password.isEmpty()) {
            return R.error("用户名和密码不能为空");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        User user1=userService.getOne(queryWrapper, false);

        if(user1==null)
        {
            System.out.println("用户不存在");
            return R.error("用户不存在");

        }
        System.out.println("查询");
        System.out.println("密码："+user1.getPassword());
        System.out.println("密码："+password);
        if(Objects.equals(user1.getPassword(), password))
        {System.out.println("登录成功");
            //session.setAttribute("user",user1.getUid());
            user1.setStatus(0);
            return R.success(user1);
        }
        else {
            System.out.println("错误");
            return R.error("密码错误");
        }

    }
    //   电话号码+密码注册
    @PostMapping("/register")
    public R<User> register (@RequestBody Map map, HttpSession session) {
        log.info(map.toString());

        //获取手机号
        String name = map.get("name").toString();

        //获取手机号
        String phone = map.get("phone").toString();

        //获取密码
        String password = map.get("password").toString();

        if(phone == null || phone.isEmpty() || password == null || password.isEmpty()) {
            return R.error("电话号码和密码不能为空");
        }
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        user.setName(name);
        user.setOperator("0");
        user.setStatus(0);
        log.info("新增员工，员工信息：{}",user.toString());

        userService.save(user);

        return R.success(user);
        }


    }



