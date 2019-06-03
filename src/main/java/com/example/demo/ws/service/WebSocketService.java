package com.example.demo.ws.service;

/**
 * Created by  on 17/1/12.
 */

//import com.us.example.bean.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.ws.bean.Response;
@Service
public class WebSocketService {

    @Autowired
    //使用SimpMessagingTemplate 向浏览器发送消息
    private SimpMessagingTemplate template;

    public void sendMessage() throws Exception{
        for(int i=0;i<10;i++)
        {
            Thread.sleep(1000);
            template.convertAndSend("/topic/getResponse",new Response("Welcome,duquanyong !"+i + "xxx" + i));
            System.out.println("----------------------duquanyong"+i);
        }
    }

}
