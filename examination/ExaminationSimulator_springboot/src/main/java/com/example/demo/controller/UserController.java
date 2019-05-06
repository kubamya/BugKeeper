/*
 * @(#)UserController.java 2019年2月11日下午1:41:21 demo Copyright 2019 Thuisoft,
 * Inc. All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject
 * to license terms.
 */
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

/**
 * UserController
 * @author Administrator
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public List<Map<String, Object>> getInfo(HttpServletRequest request) {

        //获取传递参数
        String loginid = request.getParameter("loginid");
        String password = request.getParameter("password");

        //组装查询参数
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("loginid", loginid);
        queryParams.put("password", password);

        //定义结果集
        List<Map<String, Object>> resultMap = new ArrayList<>();
        //数据库操作
        try {
            resultMap = userService.login(queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
