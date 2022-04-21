package com.example.demo.client;

import java.math.BigInteger;

import com.example.numberconversion.wsdl.NumberToWords;
import com.example.numberconversion.wsdl.NumberToWordsResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class NumberConversionClient extends WebServiceGatewaySupport{

    private static final Logger log = LoggerFactory.getLogger(NumberConversionClient.class);
    
    public NumberToWordsResponse getNumberToWords(BigInteger value){

        NumberToWords number = new NumberToWords();

        number.setUbiNum(value);

        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate()
                                        .marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/NumberConversion.wso", 
                                                                number, new SoapActionCallback("#POST"));
        
        return response;
    }
}
