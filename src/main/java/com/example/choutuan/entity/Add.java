package com.example.choutuan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
//店铺


@Data
@TableName("ct_add")
public class Add implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId
    @TableField("aid")
    private Long aid;

    //    名字
    @TableField("name")
    private String name;

//电话号码
    @TableField("phone")
    private String phone;
// 地址
    @TableField("address")
    private String address;
//    id
    @TableField("uid")
    private String uid;

}
