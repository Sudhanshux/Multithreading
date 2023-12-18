package com.example.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class InvoiceDto {

	private String id;
	
	private List<String> boughtItemId;

	private long totalAmount ;

	private Date invoiceDate;
}
