package com.example.choutuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
//店铺


@Data
@TableName("ct_meal")
public class Meal implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "mid", type = IdType.AUTO)
    private Long mid;
    //    名字
    @TableField("name")
    private String name;
    //    价格
    @TableField("price")
    private BigDecimal price;
    //电话号码
    @TableField("description")
    private String description;
// 地址
    @TableField("img")
    private String img;
//    id
    @TableField("sid")
    private Long sid;
//    时间


}
