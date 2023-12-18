package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.InvoiceDto;
import com.example.service.InvoiceService;
import com.example.util.CustomApiResponse;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	/**
	 * Api to create invoice.
	 * @param invoiceDto
	 * @return
	 */
	@PostMapping()
	public CustomApiResponse<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto ){
		InvoiceDto dto = invoiceService.createInvoice(invoiceDto);
		return new CustomApiResponse<InvoiceDto>(dto,HttpStatus.CREATED.value());
	}

}
