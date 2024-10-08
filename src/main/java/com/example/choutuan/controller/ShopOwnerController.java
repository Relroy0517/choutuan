package com.example.choutuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.choutuan.common.R;
import com.example.choutuan.entity.Add;
import com.example.choutuan.entity.ShopOwner;
import com.example.choutuan.entity.User;
import com.example.choutuan.service.AddService;
import com.example.choutuan.service.ShopOwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/ShopOwner")
@Slf4j
public class ShopOwnerController {

    @Autowired
    private ShopOwnerService soService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!!!!";
    }
    @RequestMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("/back/page/home");
    }
    @RequestMapping("/reg")
    public ModelAndView reg(){
        return new ModelAndView("/back/page/register");
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/back/page/login");
    }

    @PostMapping("/login")
    public R<ShopOwner> doLogin(@RequestBody Map map, HttpSession session){
        log.info(map.toString());
        //获取手机号
        String name = map.get("name").toString();
        //获取密码
        String password = map.get("password").toString();
        if(name == null || name.isEmpty() || password == null || password.isEmpty()) {
            return R.error("用户名和密码不能为空");
        }
        QueryWrapper<ShopOwner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        ShopOwner so=soService.getOne(queryWrapper,false);
        System.out.println("查询");
        System.out.println("密码："+so.getPassword());
        System.out.println("密码："+password);

        if(Objects.equals(so.getPassword(), password))
        {System.out.println("登录成功");
            //session.setAttribute("user",user1.getUid());
            so.setStatus(0);
            return R.success(so);
        }
        else {
            System.out.println("错误");
            return R.error("密码错误");
        }

    }

    //   电话号码+密码注册
    @PostMapping("/register")
    public R<ShopOwner> register (@RequestBody Map map, HttpSession session) {
        log.info(map.toString());

        //获取姓名
        String name = map.get("name").toString();
        //获取手机号
        String phone = map.get("phone").toString();
        //获取密码
        String password = map.get("password").toString();

        if(name == null || phone.isEmpty() || password == null || password.isEmpty()) {
            return R.error("电话号码和密码不能为空");
        }
        ShopOwner so = new ShopOwner();
        so.setPhone(phone);
        so.setName(name);
        so.setPassword(password);
        so.setStatus(0);
        log.info("新增员工，员工信息：{}",so.toString());

        soService.save(so);

            return R.success(so);
        }


    }



