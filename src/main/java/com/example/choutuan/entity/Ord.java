package com.example.choutuan.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@TableName("ct_ord")
public class Ord implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Long oid;

    //    姓名
    @TableField("name")
    private String name;

//下单时间
    @TableField("time")
    private LocalDateTime time;
    //    下一步对它做什么
    @TableField(value = "operator", fill = FieldFill.INSERT)
    private String operator="0";
// 判断是否完成的状态
    @TableField(value = "status", fill = FieldFill.INSERT)
    private Integer status=0;

//    价格
    @TableField("price")
    private BigDecimal price;
//哪个菜
@TableField("mid")
private Long mid;
//    哪个店
@TableField("sid")
private Long sid;
//    哪个人
@TableField("uid")
private Long uid;


}
