package com.example.service;

import com.example.dto.InvoiceDto;
import com.example.model.Order;

public interface InvoiceService {

	InvoiceDto createInvoice(InvoiceDto invoiceDto);

	void generateInvoice(Order order);

}
