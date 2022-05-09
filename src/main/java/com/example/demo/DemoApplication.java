package com.example.demo;

import java.math.BigInteger;

import com.example.demo.client.NumberConversionClient;
// import com.example.demo.message.Email;
import com.example.numberconversion.wsdl.NumberToWordsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableJms
public class DemoApplication {


	@Autowired
	private JmsTemplate jmsTemplate;
	public static void main(String[] args) {
		
		// ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class);

		// JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		// System.out.println("Sending an email message.");
		// jmsTemplate.convertAndSend("mailbox", new Email("gtm_hde@hotmail.com", "Hello"));
	}

	@GetMapping("send")
	String send(){
		try{
			jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello World!");
			return "OK";
		}catch(JmsException e){
			e.printStackTrace();
			return "FAIL";
		}
	}

	@Bean
	CommandLineRunner lookup(NumberConversionClient quoteClient) {
	  return args -> {
		BigInteger number = BigInteger.valueOf(100);

		NumberToWordsResponse response = quoteClient.getNumberToWords(number);
		System.err.println(response.getNumberToWordsResult());
	  };
	}

	// @Bean
	// public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, 
	// 												DefaultJmsListenerContainerFactoryConfigurer configurer){
		
	// 	DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

	// 	configurer.configure(factory, connectionFactory);

	// 	return factory;
	// }

	// @Bean
	// public MessageConverter jacksonJmsMessageConverter(){
	// 	MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	// 	converter.setTargetType(MessageType.TEXT);
	// 	converter.setTypeIdPropertyName("_type");
	// 	return converter;
	// }

}
