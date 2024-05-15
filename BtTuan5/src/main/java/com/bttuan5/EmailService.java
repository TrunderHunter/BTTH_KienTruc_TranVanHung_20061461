package com.bttuan5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendOrderConfirmation(Long customerId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("customer-email@example.com");
        message.setSubject("Order Confirmation");
        message.setText("Your order has been confirmed.");
        emailSender.send(message);
    }

    public void sendOrderRejection(Long customerId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("customer-email@example.com");
        message.setSubject("Order Rejection");
        message.setText("Your order has been rejected due to insufficient stock.");
        emailSender.send(message);
    }
}
