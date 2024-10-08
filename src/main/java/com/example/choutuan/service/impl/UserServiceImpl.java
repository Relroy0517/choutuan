package com.example.choutuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.choutuan.entity.User;
import com.example.choutuan.mapper.UserMapper;
import com.example.choutuan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    // 查询所有Category数据
    @Transactional
    public List<User> listAlluu() {
        return this.baseMapper.selectList(null);
    }
}
