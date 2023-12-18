package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ItemDto;
import com.example.service.ItemService;
import com.example.util.CustomApiResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/file-system")
public class ItemController {

	
	@Autowired
	private ItemService itemService;
	
	
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	/**
	 * API to add item .
	 * @param itemDto
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value = "Add item .")
	public CustomApiResponse<ItemDto> addItem(@RequestBody ItemDto itemDto ){
		ItemDto dto = itemService.addItem(itemDto);
		return new CustomApiResponse<ItemDto>(dto,HttpStatus.CREATED.value());
	}
}
