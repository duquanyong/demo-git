package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMapTests {

	@Test
	public void contextLoads() {

	}
	@Bean
	public RestTemplate restTemplate() {
		// 构造器中指定编码格式
		List<HttpMessageConverter<?>> messageCoverters = new ArrayList<HttpMessageConverter<?>>();
		messageCoverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
		messageCoverters.add(new AllEncompassingFormHttpMessageConverter());
		messageCoverters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate template = new RestTemplate(messageCoverters);
		return template;
	}
	
//    @Test
//    public void rtExchangeTest() { // throws JSONException 
////        RestTemplate restTemplate = new RestTemplate();
////        String url = "https://restapi.amap.com/v3/assistant/coordinate/convert?locations=116.481499,39.990475&coordsys=gps&output=xml&key=4b764f6e2297fc4d4370de7820852348";
////        HttpHeaders headers = new HttpHeaders();
//////        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
////        JSONObject jsonObj = new JSONObject();
////        jsonObj.put("start",1);
////        jsonObj.put("page",5);
////
////        HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);
////       
////        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, 
////                                          HttpMethod.GET, entity, JSONObject.class);
////        
////        System.out.println(exchange.getBody());
//    }
	
    @Test
    public void rtExchangeTest() { // throws JSONException 
 
        String url = "https://restapi.amap.com/v3/assistant/coordinate/convert?locations=116.481499,39.990475&coordsys=gps&output=xml&key=4b764f6e2297fc4d4370de7820852348";
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JSONObject> entity = restTemplate.getForEntity(url
                , JSONObject.class);

        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("statusCode.is2xxSuccessful()"+statusCode.is2xxSuccessful());

        JSONObject body = entity.getBody();
        System.out.println("entity.getBody()"+body);


        ResponseEntity.BodyBuilder status = ResponseEntity.status(statusCode);
        status.contentLength(100);
        status.body("我在这里添加一句话");
        ResponseEntity<Class<JSONObject>> body1 = status.body(JSONObject.class);
        Class<JSONObject> body2 = body1.getBody();
        System.out.println("body1.toString()"+body1.toString());
    }

}
