package com.example.demo.resources;

import com.example.demo.message.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class MQResource {

    @Autowired
	private JmsTemplate jmsTemplate;
    
    @PostMapping()
    public String send(@RequestBody Message message){
		try{
			jmsTemplate.convertAndSend("DEV.QUEUE.1", message.getMessage());
			return "OK";
		}catch(JmsException e){
			e.printStackTrace();
			return "FAIL";
		}
    }

	@GetMapping("/send/loop")
	public void loop() throws InterruptedException{
		for(int i = 1; i < 1000; i++){
			System.out.println(i);
			jmsTemplate.convertAndSend("DEV.QUEUE.1", "I'm here on the loop: " + i);
		}
	}
}
