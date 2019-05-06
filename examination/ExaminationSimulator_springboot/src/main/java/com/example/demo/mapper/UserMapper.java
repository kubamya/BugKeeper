/*
 * @(#)UserMapper.java 2019年2月15日下午3:29:43 demo Copyright 2019 Thuisoft, Inc.
 * All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */
package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper
 * @author Administrator
 * @version 1.0
 *
 */
@Mapper
public interface UserMapper {

    //用户登录
    public List<Map<String, Object>> login(Map<String, Object> queryParam);

}
