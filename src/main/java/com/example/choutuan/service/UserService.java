package com.example.choutuan.service;

import com.example.choutuan.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface UserService extends IService<User> {
    List<User> listAlluu();
}
