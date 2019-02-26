/*
 * @(#)UserServiceImpl.java 2019年2月15日下午3:32:03 demo Copyright 2019 Thuisoft,
 * Inc. All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject
 * to license terms.
 */
package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

/**
 * UserServiceImpl
 * @author Administrator
 * @version 1.0
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String, Object>> login(Map<String, Object> queryParam) {
        return userMapper.login(queryParam);
    }

}
