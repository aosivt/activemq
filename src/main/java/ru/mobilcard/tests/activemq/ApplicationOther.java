package ru.mobilcard.tests.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import java.io.IOException;

import java.util.Scanner;

@SpringBootApplication
@EnableJms
public class ApplicationOther {

    public static void main(String[] args) throws IOException {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationOther.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
//        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));


        var scaner = new Scanner(System.in);
        while (true) {
            var inputString = scaner.nextLine();
            jmsTemplate.convertAndSend("mailbox", new EmailCompany("info@example.com", inputString));
        }
    }

}
