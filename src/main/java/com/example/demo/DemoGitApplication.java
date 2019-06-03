package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = {"com.example.demo","com.example.demo.ws"})
@EnableScheduling
public class DemoGitApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoGitApplication.class, args);
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
}
