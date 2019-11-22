package ru.mobilcard.tests.activemq;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(EmailCompany emailCompany) {
        System.out.println("Received <" + emailCompany + ">");
    }

}
