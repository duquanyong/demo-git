//package com.example.demo;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.concurrent.Executors;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.stereotype.Component;
//import org.thymeleaf.util.DateUtils;
//
//import com.example.demo.util.DateUtil;
//import com.example.demo.ws.bean.Response;
//import com.example.demo.ws.service.WebSocketService;
// 
// 
///**
// * 数据定时绘制配置
// * @author duqy
// */
//@Component
//@Configuration
//@EnableScheduling
//public class ScheduleConfig implements SchedulingConfigurer {
//	    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	    @Autowired
//        private WebSocketService ws;
//        @Autowired
//        private SimpMessagingTemplate messagingTemplate;
//        /**   保洁员打卡数据   
//         * @throws Exception **/
//	    @Scheduled(cron = "0 0/1 * * * SUN-SAT") 
//	    public void buildWcCleanerData() throws Exception {
//	    	System.err.println(System.currentTimeMillis());
////            messagingTemplate.convertAndSend("/queue/notifications", DateUtil.format(new Date(), DateUtil.datePatternYMDHMS));
//            
//            ws.sendMessage();
//	    
//	    }
//
//
//		@Override
//		public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//			
//		}
//		 
//}
// 
//////秒 分 时 日 月 星期 年（可省略）
//////0 22 21 * * MON-FRI
//////@Scheduled(cron = "0 22 21 * * SUN-SAT") 
//////@Scheduled(cron = "33 22 18 * * SUN-SAT") 
////https://blog.csdn.net/u013456370/article/details/79411952