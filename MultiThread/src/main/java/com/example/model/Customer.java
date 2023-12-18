package com.example.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	private String id;
	
	private String name;
	
	private String address;
	
	private String mobileNumber;
		
}
