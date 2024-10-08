package com.example.choutuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.choutuan.entity.Add;
import com.example.choutuan.entity.User;
import com.example.choutuan.mapper.AddMapper;
import com.example.choutuan.mapper.UserMapper;
import com.example.choutuan.service.AddService;
import com.example.choutuan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AddServiceImpl extends ServiceImpl<AddMapper, Add> implements AddService {


}
