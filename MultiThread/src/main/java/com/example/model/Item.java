package com.example.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class Item {

	@Id
	private String id;
	
	private String itemName;
	
	private String itemCost;
	
	private String itemDetails;
		
}
