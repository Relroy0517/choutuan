package com.example.choutuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.choutuan.common.R;
import com.example.choutuan.entity.Add;
import com.example.choutuan.entity.Meal;
import com.example.choutuan.entity.Shop;
import com.example.choutuan.service.AddService;
import com.example.choutuan.service.MealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/Meal")
@Slf4j
public class MealController {

    @Autowired
    private MealService mealService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!!!!";
    }
    @RequestMapping("/reg")
    public ModelAndView doMenuEditUI(){
        ModelAndView  modelAndView= new ModelAndView("/page/register");
        return modelAndView;
    }




    @GetMapping("/meals")
    public  R<Page> page(int page,Long sid){


        int pageSize =5;

        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,sid);

        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Meal> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        if (sid != null) {
            queryWrapper.eq(Meal::getSid, sid);
        }
        //添加排序条件
        queryWrapper.orderByDesc(Meal::getMid);

        //执行查询
        mealService.page(pageInfo,queryWrapper);
        System.out.println("总数："+pageInfo.getTotal());
        System.out.println("当前："+pageInfo.getCurrent());
        System.out.println(pageInfo.getRecords());
        return R.success(pageInfo);
    }


    @DeleteMapping("/delete")
    public R delete(@RequestBody Map map, HttpSession session){
        Long id = (Long) map.get("id");
        Meal meal = mealService.getById(id);
        if(meal!=null){
            mealService.removeById(id);
            return R.success("删除成功");

        }
        else {
        return R.success("无该菜品");}
    }

    //   店铺+
    @PostMapping("/register")
    public R<Meal> register (@RequestBody Map map, HttpSession session) {
        log.info(map.toString());

        //获取菜名
        String name = map.get("name").toString();

        //获取价格
        String pri = map.get("price").toString();

        BigDecimal price =new BigDecimal(pri);
        //获取描述
        String description = map.get("description").toString();

        //获取图片
        String img = map.get("img").toString();
//        获取sid
        Long sid = Long.parseLong(map.get("sid").toString());

        if(name == null || description.isEmpty() || img == null ) {
            return R.error("不能为空");
        }
        Meal meal = new Meal();
        meal.setName(name);
        meal.setPrice(price);
        meal.setDescription(description);
        meal.setImg(img);
        meal.setSid(sid);
        log.info("新增员工，员工信息：{}",meal.toString());

//        mealService.save(meal);

        try {
            mealService.save(meal);
        } catch (Exception e) {
            e.printStackTrace();
        }

            return R.success(meal);
        }


    }



