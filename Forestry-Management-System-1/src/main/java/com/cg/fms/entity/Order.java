package com.cg.fms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column(name="order_number")
	private String orderNumber;

	@Column(name="delivery_place")
	private String deliveryPlace;

	@Column(name="delivery_date")
	private String deliveryDate;

	@Column(name="quantity")
	private String quantity;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer1;
	
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> products;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Scheduler> scheduler;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Contract> contract;

	
	public Order() {
		
	}


	public Order(String orderNumber, String deliveryPlace, String deliveryDate, String quantity,
			Customer customer1) {
		super();
		this.orderNumber = orderNumber;
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.customer1 = customer1;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getDeliveryPlace() {
		return deliveryPlace;
	}


	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}


	public String getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



	public Customer getCustomer() {
		return customer1;
	}


	public void setCustomer(Customer customer1) {
		this.customer1 = customer1;
	}


	
	
	
}