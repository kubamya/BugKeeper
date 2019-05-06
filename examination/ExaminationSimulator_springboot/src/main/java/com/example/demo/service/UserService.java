/*
 * @(#)UserService.java 2019年2月15日下午3:31:29 demo Copyright 2019 Thuisoft, Inc.
 * All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */
package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * UserService
 * @author Administrator
 * @version 1.0
 *
 */
@Service
public interface UserService {

    //用户登录
    public List<Map<String, Object>> login(Map<String, Object> queryParam);
}
