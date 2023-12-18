package com.example.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PaymentDto {

	private String id;
	
	private String paymentType;
	
	private String status;
	
	private Date paymentDate;
	
	private ItemDto boughtItem;
	
}

