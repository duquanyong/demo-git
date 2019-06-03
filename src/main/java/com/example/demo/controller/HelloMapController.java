package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;

@Controller
@ResponseBody
public class HelloMapController {
 
 
	@RequestMapping(value = "/gmap1")
	public JSONObject gmap1() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
		String url = "https://restapi.amap.com/v3/assistant/coordinate/convert?locations=116.481499,39.990475&coordsys=gps&output=json&key=07cff0e192384164c39b85a60392f0fa";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject jsonObj = new JSONObject();
		HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);
		ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, JSONObject.class);
		System.out.println(exchange.getBody());
		return exchange.getBody();
	}
	
	@RequestMapping(value = "/gmap2")
	public Map<String, Object> gmap2() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
		Map<String, String> map = new HashMap<>();
		map.put("locations", "116.481499,39.990475");
		map.put("coordsys", "gps");
		map.put("output", "json");
		map.put("key", "07cff0e192384164c39b85a60392f0fa");
		String url = "https://restapi.amap.com/v3/assistant/coordinate/convert?locations={locations}&coordsys={coordsys}&output={output}&key={key}";
		ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(url, JSONObject.class, map);
		System.out.println(JSONObject.toJSONString(responseEntity.getBody()));
		return responseEntity.getBody();
	}
}
