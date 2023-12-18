package com.example.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Order {

	private String Id;
	
	@OneToOne
	@JoinColumn(name="payment")
	private Payment payment;
	
}
