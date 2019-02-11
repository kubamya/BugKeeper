package com.example.demo.service.impl;

import com.example.demo.mapper.DemoMapper;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName:DemoServiceImpl
 * @Description:TODO
 * @author:Administrator
 * @date:2018/12/11 0011 上午 9:47
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Map<String, Object>> getInfo() {
        return demoMapper.getInfo();
    }
}
