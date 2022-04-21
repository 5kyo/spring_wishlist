package com.example.demo;

import java.math.BigInteger;

import com.example.demo.client.NumberConversionClient;
import com.example.numberconversion.wsdl.NumberToWordsResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(NumberConversionClient quoteClient) {
	  return args -> {
		BigInteger number = BigInteger.valueOf(100);

		NumberToWordsResponse response = quoteClient.getNumberToWords(number);
		System.err.println(response.getNumberToWordsResult());
	  };
	}

}
