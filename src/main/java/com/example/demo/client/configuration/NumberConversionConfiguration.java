package com.example.demo.client.configuration;

import com.example.demo.client.NumberConversionClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NumberConversionConfiguration {
    
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        
        marshaller.setContextPath("com.example.numberconversion.wsdl");
        return marshaller;
    }

    @Bean
    public NumberConversionClient numberConversionClient(Jaxb2Marshaller marshaller) {
      NumberConversionClient client = new NumberConversionClient();
      client.setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL");
      client.setMarshaller(marshaller);
      client.setUnmarshaller(marshaller);
      return client;
    }
}
