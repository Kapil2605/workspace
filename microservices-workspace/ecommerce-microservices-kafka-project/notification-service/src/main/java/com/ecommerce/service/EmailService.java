package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderItemKafka;
import com.ecommerce.dto.OrderStatus;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendOrderMail(
	        String to,
	        Long orderId,
	        OrderStatus status,
	        List<OrderItemKafka> items,
	        Double amount
	) {

	    String firstProduct = items.get(0).getProductName();

	    String subject = (items.size() == 1)
	            ? "Order #" + orderId + " - " + firstProduct
	            : "Order #" + orderId + " - " + firstProduct + " & " + (items.size() - 1) + " more item(s)";

	    StringBuilder products = new StringBuilder();

	    for (OrderItemKafka item : items) {
	        products.append("- ")
	                .append(item.getProductName())
	                .append(" (Qty: ")
	                .append(item.getQuantity())
	                .append(")\n");
	    }

	    SimpleMailMessage mail = new SimpleMailMessage();

	    mail.setFrom("kapilkhola26@gmail.com");
	    mail.setTo(to);
	    mail.setSubject(subject);

	    mail.setText("""
	            Dear Customer,

	            We are pleased to confirm your order has been received successfully.

	            Order Details
	            Order ID: %d
	            Status: %s

	            Items:
	            %s

	            Total Amount: ₹%.2f

	            You will receive further updates once your order payment will be done.

	            Thank you for shopping with us.
	            """.formatted(orderId, status, products, amount));
	    
	    mailSender.send(mail);
	}
	public void sendPaymentStatusMail(
	        String to,
	        Long orderId,
	        OrderStatus status,
	        List<OrderItemKafka> items,
	        Double amount
	) {

	    String firstProduct = items.get(0).getProductName();

	    String subject;

	    if (items.size() == 1) {
	        subject = "Payment Update - Order #" + orderId + " - " + firstProduct;
	    } else {
	        subject = "Payment Update - Order #" + orderId + " - " + firstProduct
	                + " & " + (items.size() - 1) + " more item(s)";
	    }

	    String message;

	    if (status == OrderStatus.PAYMENT_SUCCESS) {

	        message = """
	                Dear Customer,

	                We are pleased to inform you that your payment has been successfully processed.

	                Payment Details
	                Order ID: %d
	                Status: %s
	                Amount Paid: ₹%.2f

	                Your order is now being processed and will be shipped soon.

	                Thank you for your purchase.
	                """.formatted(orderId, status, amount);

	    } else {

	        message = """
	                Dear Customer,

	                We regret to inform you that your payment attempt was not successful.

	                Payment Details
	                Order ID: %d
	                Status: %s
	                Amount: ₹%.2f

	                Please retry the payment using a different method or try again later.

	                Thank you.
	                """.formatted(orderId, status, amount);
	    }

	    SimpleMailMessage mail = new SimpleMailMessage();
	    mail.setFrom("kapilkhola26@gmail.com");
	    mail.setTo(to);
	    mail.setSubject(subject);
	    mail.setText(message);

	    mailSender.send(mail);
	}
	
	
}