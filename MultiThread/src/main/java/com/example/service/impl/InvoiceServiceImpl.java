package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.InvoiceDto;
import com.example.dto.ItemDto;
import com.example.model.Invoice;
import com.example.model.Item;
import com.example.model.Order;
import com.example.repository.InvoiceRepostiory;
import com.example.repository.ItemRepository;
import com.example.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepostiory invoiceRepostiory;

	@Autowired
	private ItemRepository itemRepository;

	/**
	 *Method to create invoice.
	 */
	@Override
	public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = new Invoice();

		List<Item> boughtItems = itemRepository.findAllById(invoiceDto.getBoughtItemId());
		invoice.setBoughtItem(boughtItems);
		invoice.setTotalAmount(invoiceDto.getTotalAmount());
		invoice.setInvoiceDate(invoiceDto.getInvoiceDate());
		// Save the invoice to the database
		Invoice savedInvoice = this.saveInvoice(invoice);
		// Map the saved entity back to DTO and return
		return mapToInvoiceDto(savedInvoice);
	}



	private InvoiceDto mapToInvoiceDto(Invoice invoice) {
		InvoiceDto invoiceDto = new InvoiceDto();
		invoiceDto.setId(invoice.getId());
		invoiceDto.setTotalAmount(invoice.getTotalAmount());
		invoiceDto.setInvoiceDate(invoice.getInvoiceDate());

		// Mapping the boughtItem field from Invoice entity to ItemDto list in InvoiceDto
		List<ItemDto> itemDtos = mapItemsToItemDtos(invoice.getBoughtItem());
		List<String> itemIds = itemDtos.stream().map( i -> i.getId()).collect(Collectors.toList());
		invoiceDto.setBoughtItemId(itemIds);
		return invoiceDto;	
	}



	private List<ItemDto> mapItemsToItemDtos(List<Item> items) {
		List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(item.getId());
            itemDto.setItemName(item.getItemName());
            itemDtos.add(itemDto);
        }
        return itemDtos;
	}



	private Invoice saveInvoice(Invoice inv) {
		return invoiceRepostiory.save(inv);
	}



	public Optional<Invoice> fetchInvoice(String invoiceId) {
		return invoiceRepostiory.findById(invoiceId);
	}



	@Override
	public void generateInvoice(Order order) {
		// TODO Auto-generated method stub
		
	}

}
