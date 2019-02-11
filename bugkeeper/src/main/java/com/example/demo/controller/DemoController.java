package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName:DemoController
 * @Description:TODO
 * @author:Administrator
 * @date:2018/12/11 0011 上午 9:48
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping("/getInfo")
    public List<Map<String, Object>> getInfo(){
        return demoService.getInfo();
    }
}
