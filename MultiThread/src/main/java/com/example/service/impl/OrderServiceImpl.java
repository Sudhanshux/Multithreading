package com.example.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.exception.CustomException;
import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.example.service.InventoryService;
import com.example.service.InvoiceService;
import com.example.service.PaymentService;

@Service
public class OrderServiceImpl {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired 
	private InvoiceService invoiceService;
	
	@Async("threadPoolTaskExecutor")
	@Scheduled(fixedDelay = 300000, initialDelay = 300000)
	 public void processOrder(String orderId) {
		 Optional<Order> orderOpt = orderRepository.findById(orderId);
		 if(!orderOpt.isPresent()) {
			 throw new CustomException("Order not found.", HttpStatus.NOT_FOUND);
		 }
		 Order order = orderOpt.get();
		 if (order != null) {
			 System.out.println("Processing order " + orderId);

//			 create payment
			 paymentService.performPayment(order);
			 
//			 update inventory
			 inventoryService.updateInventory(order);
			 
			 invoiceService.generateInvoice(order);
			 System.out.println("Order " + orderId + " processed.");
		 } else {
			 System.out.println("Order " + orderId + " not found.");
		 }
	 }

	
	
	
}
