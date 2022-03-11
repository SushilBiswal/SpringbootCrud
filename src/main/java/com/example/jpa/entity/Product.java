package com.example.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue
	private int product_id;
	private String productName;
	private int product_quantity;
	private double product_price;
   
	@Column(name = "ind_indx")
	private boolean indInd;
	
    @Column(name = "password_active_indx")
	private boolean password_active_ind;
}
