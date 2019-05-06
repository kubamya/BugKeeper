package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;

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
    @RequestMapping("/getUserInfo")
    public List<Map<String, Object>> getUserInfo(HttpServletRequest request) {
    	//获取前台传递参数
    	String name = request.getParameter("name");
    	
    	//组装查询参数
    	Map<String, Object> queryParams = new HashMap<>();
    	queryParams.put("name", name);
    	
    	//返回查询结果
        return demoService.getUserInfo(queryParams);
    }
    
    @ResponseBody
    @RequestMapping("/addUser")
    public Map<String, Object> addUser(HttpServletRequest request) {
    	//获取前台传递参数
    	String name = request.getParameter("name");
    	String loginid = request.getParameter("loginid");
    	
    	//组装查询参数
    	Map<String, Object> queryParams = new HashMap<>();
    	queryParams.put("name", name);
    	queryParams.put("loginid", loginid);
    	queryParams.put("bh", UUID.randomUUID().toString().replaceAll("-", ""));
    	
    	//定义返回结果集
    	Map<String, Object> resultMap = new HashMap<>();
    	
    	if(demoService.addUser(queryParams)) {
    		//添加成功
    		resultMap.put("result", "success");
    	}else {
    		//添加失败
    		resultMap.put("result", "fail");
    	}
        return resultMap;
    }
    
    @ResponseBody
    @RequestMapping("/delUser")
    public Map<String, Object> delUser(HttpServletRequest request) {
    	//定义返回结果集
    	Map<String, Object> resultMap = new HashMap<>();
    	
    	//接收前台返回参数
    	String bh = request.getParameter("bh");
    	
    	//组装查询参数
    	Map<String, Object> queryParams = new HashMap<>();
    	queryParams.put("bh", bh);
    	
    	if(demoService.delUser(queryParams)) {
    		resultMap.put("result", "success");
    	}else {
    		resultMap.put("result", "fail");
    	}
    	
    	return resultMap;
    }

    /*@ResponseBody
    @RequestMapping("/getInfo")
    public List<Map<String, Object>> getInfo() {
        System.out.println("11111111");
        return demoService.getInfo();
    }*/
}
