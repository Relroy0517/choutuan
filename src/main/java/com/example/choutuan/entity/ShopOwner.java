package com.example.choutuan.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
//店长

@Data
@TableName("ct_shopowner")
public class ShopOwner implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "soid", type = IdType.AUTO)
    private Long soid;

    //    姓名
    @TableField("name")
    private String name;
//    密码
    @TableField("password")
    private String password;
//电话号码
    @TableField("phone")
    private String phone;
// 判断是否登录的状态
@TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status=0;

    
}
