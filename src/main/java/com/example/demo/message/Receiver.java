package com.example.demo.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Receiver {

    private static final String qName = "DEV.QUEUE.1";

    @JmsListener(destination = qName)
    public void receiveMessage(Message msg) {
        System.out.println("Received <" + msg.getMessage() + ">");
    }
}
