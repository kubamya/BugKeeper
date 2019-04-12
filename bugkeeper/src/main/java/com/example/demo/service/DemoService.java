package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DemoService {
    List<Map<String, Object>> getInfo();
    
    //获取用户详情
    List<Map<String, Object>> getUserInfo(Map<String, Object> queryParams);
    
    //添加用户信息
    boolean addUser(Map<String, Object> queryParams);
    
    //删除用户信息
    boolean delUser(Map<String, Object> queryParams);
}
