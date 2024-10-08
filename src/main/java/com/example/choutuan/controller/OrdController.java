package com.example.choutuan.controller;


import com.example.choutuan.common.R;
import com.example.choutuan.entity.Add;
import com.example.choutuan.entity.Ord;
import com.example.choutuan.service.AddService;
import com.example.choutuan.service.OrdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/0rd")
@Slf4j
public class OrdController {

    @Autowired
    private OrdService ordService;

    @RequestMapping("/reg")
    public ModelAndView doMenuEditUI(){
        ModelAndView  modelAndView= new ModelAndView("/page/register");
        return modelAndView;
    }


    //   订单添加
    @PostMapping("/register")
    public R<Ord> register (@RequestBody Map map, HttpSession session) {
        log.info(map.toString());

        //获取菜名
        String name = map.get("name").toString();

        //获取价格
        BigDecimal price = (BigDecimal) map.get("price");

        //获取密码
        String password = map.get("password").toString();

        if(price == null  || password == null || password.isEmpty()) {
            return R.error("电话号码和密码不能为空");
        }
        Ord ord = new Ord();
        ord.setPrice(price);
        ord.setName(name);
        //Add.setid(id);
        log.info("新增员工，员工信息：{}",ord.toString());

        ordService.save(ord);
            return R.success(ord);
        }


    }



