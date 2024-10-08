package com.example.choutuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.choutuan.entity.Meal;
import com.example.choutuan.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MealMapper extends BaseMapper<Meal> {
}
