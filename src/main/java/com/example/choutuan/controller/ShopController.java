package com.example.choutuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.choutuan.common.R;
import com.example.choutuan.entity.Shop;
import com.example.choutuan.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/Shop")
@Slf4j
public class ShopController {

    @Autowired
    private ShopService shopService;

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
    public R<Shop> register (@RequestBody Map map, HttpSession session) {
        log.info(map.toString());

        //获取店名
        String name = map.get("name").toString();
        System.out.println(name);
        //获取手机号
        String phone = map.get("phone").toString();
        System.out.println(phone);
        //获取标签
        String label = map.get("label").toString();
        System.out.println(label);
//        获取地址
        String address = map.get("address").toString();
        System.out.println(address);
//        获取soid
        Long soid=Long.valueOf((Integer) map.get("soid"));
        System.out.println(soid);
        if(phone == null || phone.isEmpty() ) {
            return R.error("电话号码和密码不能为空");
        }


        Shop shop = new Shop();

        shop.setPhone(phone);
        shop.setName(name);
        shop.setLabel(label);
        shop.setAddress(address);
        shop.setSoid(soid);

        log.info("新增店铺，店铺信息：{}",shop.toString());
        shopService.save(shop);
//        R.success(shop);
            return R.success(shop);
        }

    /**
     * 员工信息分页查询
     * @param page
     * @param pageSize
     * @param soid
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, Long soid){
        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,soid);

        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Shop> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        if (soid != null) {
            queryWrapper.eq(Shop::getSoid, soid);
        }
        //添加排序条件
        queryWrapper.orderByDesc(Shop::getSid);

        //执行查询
        shopService.page(pageInfo,queryWrapper);
        System.out.println("总数："+pageInfo.getTotal());
        System.out.println("当前："+pageInfo.getCurrent());
        System.out.println(pageInfo.getRecords());
        return R.success(pageInfo);

    }
    }



