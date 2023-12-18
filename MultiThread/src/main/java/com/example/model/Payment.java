package com.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class Payment {

	@Id
	private String id;
	
	private String paymentType;
	
	private String status;
	
	private Date paymentDate;
	
	@OneToMany 
    @JoinColumn(name = "item")
	private Item boughtItem;
	
}
