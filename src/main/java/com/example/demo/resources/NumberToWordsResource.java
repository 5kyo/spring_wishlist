package com.example.demo.resources;

import java.math.BigInteger;

import com.example.demo.client.NumberConversionClient;
import com.example.numberconversion.wsdl.NumberToWordsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ws")
public class NumberToWordsResource {

    @Autowired
    NumberConversionClient numberConversionClient;

    @PostMapping(consumes = ("text/plain"))
    public String numberToWordsResponse(@RequestBody String value){
        BigInteger number = new BigInteger(value);
        NumberToWordsResponse response = numberConversionClient.getNumberToWords(number);
        return response.getNumberToWordsResult();
    }
}
