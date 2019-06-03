package com.example.demo.caroil.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.caroil.model.CarOil;
import com.example.demo.caroil.service.CarOilService;
import com.example.demo.util.Page;
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
public class CarOilController {
    //日志
    private static Logger logger = LoggerFactory.getLogger(CarOilController.class);
    
    @Autowired
    private CarOilService carOilService;
    
    /**
     *  展示数据 信息
     * @return
     */
    @RequestMapping("/show")
    public Map<String, Object> pushcarin(@RequestParam(name="access_token",required = false)  String access_token) { // @RequestBody JSONObject jsonObject,
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	List<CarOil> list =  carOilService.selectCarOilListByCarNoAndDate("14150376219", "roadclean_car_oil_201905", "2019-05-03");
    	resultMap.put("message", "成功");
    	resultMap.put("list", list);
    	resultMap.put("code", "1001");
		return resultMap;
    }
    
    
    @RequestMapping("/getList")
    public @ResponseBody Page<CarOil>  getMembersByPage(HttpServletRequest requet, HttpServletResponse response,
            Page<CarOil> page) {
        try {
            if (page == null) {
                page = new Page<CarOil>();
            }
            page = carOilService.findListByPage(page);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
}
