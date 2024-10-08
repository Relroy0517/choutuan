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
@TableName("ct_shop")
public class Shop implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Long sid;

    //    店名
    @TableField("name")
    private String name;

//电话号码
    @TableField("phone")
    private String phone;
// 地址
    @TableField("address")
    private String address;
//    店长id
    @TableField("soid")
    private Long soid;
//    特色
    @TableField("label")
    private String label;

}
