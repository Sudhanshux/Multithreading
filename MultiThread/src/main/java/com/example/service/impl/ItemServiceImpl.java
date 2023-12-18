package com.example.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ItemDto;
import com.example.model.Item;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;

	/**
	 *Method to add item.
	 */
	@Override
	public ItemDto addItem(ItemDto itemDto) {
		Item item = new Item();
		item.setItemName(null);
		item.setItemDetails(null);
		item.setItemCost(null);
		Item savedItem = this.saveItem(item);
		return mapItemsToItemDto(savedItem);
	}

	
	
	private ItemDto mapItemsToItemDto(Item item) {
		 ItemDto itemDto = new ItemDto();
         itemDto.setId(item.getId());
         itemDto.setItemName(item.getItemName());
         return itemDto;
	}



	private Item saveItem(Item item) {
		return itemRepository.save(item);
	}



	public Optional<Item> fetchInvoice(String itemId) {
		return itemRepository.findById(itemId);
	}

}
