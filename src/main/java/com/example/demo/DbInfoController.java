package com.example.demo;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

/**
 * com.bkgd.processingdatereception.controller
 *  展示static数据集合中的信息，用来检查和测试使用
 * @author duqy
 * @date 2019-5-5
 * @time 15:36
 * @project_name dps
 */
@RequestMapping("/")
@RestController
public class DbInfoController {
    //日志
    private static Logger logger = LoggerFactory.getLogger(DbInfoController.class);
   
    
    /**
     *  展示数据 信息
     * @return
     */
    @RequestMapping("/index")
    
    public Map<String, Object> pushcarin(@RequestParam(name="access_token",required = false)  String access_token) { // @RequestBody JSONObject jsonObject,
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("message", "成功");
    	resultMap.put("code", "1001");
		return resultMap;
    }
    
}
