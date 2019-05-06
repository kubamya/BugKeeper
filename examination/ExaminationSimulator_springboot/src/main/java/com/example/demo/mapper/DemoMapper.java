package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemoMapper {
    List<Map<String, Object>> getInfo();
    
  //获取用户详情
    List<Map<String, Object>> getUserInfo(Map<String, Object> queryParams);
    
  //添加用户信息
    void addUser(Map<String, Object> queryParams);
    
  //删除用户信息
    void delUser(Map<String, Object> queryParams);
}
