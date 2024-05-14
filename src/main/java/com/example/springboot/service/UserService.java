package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.pojo.entity.User;

public interface UserService extends IService<User> {
    String getName();
}
