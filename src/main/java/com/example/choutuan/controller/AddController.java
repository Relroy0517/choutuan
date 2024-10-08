package com.example.choutuan.controller;


import com.example.choutuan.common.R;
import com.example.choutuan.entity.Add;
import com.example.choutuan.entity.User;
import com.example.choutuan.service.AddService;
import com.example.choutuan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/add")
@Slf4j
public class AddController {

    @Autowired
    private AddService addService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!!!!";
    }
    @RequestMapping("/reg")
    public ModelAndView doMenuEditUI(){
        ModelAndView  modelAndView= new ModelAndView("/page/register");
        return modelAndView;
    }


    //   电话号码+密码注册
    @PostMapping("/register")
    public R<Add> register (@RequestBody Map map, HttpSession session) {
        log.info(map.toString());

        //获取手机号
        String name = map.get("name").toString();

        //获取手机号
        String phone = map.get("phone").toString();

        //获取密码
        String address = map.get("address").toString();

        if(phone == null || phone.isEmpty() || address == null || address.isEmpty()) {
            return R.error("电话号码和密码不能为空");
        }
        Add add = new Add();
        add.setPhone(phone);
        add.setName(name);
        add.setAddress(address);
        //Add.setid(id);
        log.info("新增地址信息：{}",add.toString());
        addService.save(add);
            return R.success(add);
        }


    }



