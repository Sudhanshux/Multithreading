package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class Invoice {
	
	@Id
	private String id;
	
	@OneToMany
	@JoinColumn(name = "item")
	private List<Item> boughtItem;

	private long totalAmount ;
	
	private Date invoiceDate;

}
