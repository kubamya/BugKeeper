package com.example.util;

import java.util.HashMap;
import java.util.Map;



public class CommonReturnUtil {

    public static Map<String, Object> CommonReturnMsg(boolean result,Map<String, Object> data, String msg){
        //定义返回map
        Map<String, Object> resultMap = new HashMap<>();
        if(result){
            resultMap.put("result","success");
        }else {
            resultMap.put("result", "fail");
        }

        //返回的提示信息
        resultMap.put("msg", msg);

        //返回的数据
        resultMap.put("data", data.get("data"));
        return resultMap;
    }

}
