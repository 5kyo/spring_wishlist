package com.example.demo;

import java.math.BigInteger;

import com.example.demo.client.NumberConversionClient;
// import com.example.demo.message.Email;
import com.example.numberconversion.wsdl.NumberToWordsResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class DemoApplication {


	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class);

		// JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		// System.out.println("Sending an email message.");
		// jmsTemplate.convertAndSend("mailbox", new Email("gtm_hde@hotmail.com", "Hello"));
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
