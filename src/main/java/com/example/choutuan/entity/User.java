package com.example.choutuan.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Data
@TableName("ct_user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

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
//    判断管理权限
@TableField(value = "operator", fill = FieldFill.INSERT)
    private String operator="0";

}
