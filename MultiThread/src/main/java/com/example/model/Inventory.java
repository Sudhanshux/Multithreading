package com.example.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class Inventory {

	@Id
	private String id;
	
	@OneToMany 
    @JoinColumn(name = "item")
	private Item item;
	
	private long itemCount;
	
	private long threshold;
	
	
}
