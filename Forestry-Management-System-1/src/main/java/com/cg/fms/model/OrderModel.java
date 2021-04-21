package com.cg.fms.model;

import java.util.Set;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class OrderModel {
	
	private String orderNumber;

	@NotEmpty(message="deliveryPlace  cannot be empty")
	@NotNull(message="deliveryPlace cannot be omitted")
	private String deliveryPlace;
	
	@NotEmpty(message="deliveryDate  cannot be empty")
	@NotNull(message="deliveryDate cannot be omitted")
	private String deliveryDate;

	@NotEmpty(message="quantity  cannot be empty")
	@NotNull(message="quantity cannot be omitted")
	private String quantity;
	

	
	private String customerId;
	
	
	public OrderModel() {
		
	}

	public OrderModel(String orderNumber,
			@NotEmpty(message = "deliveryPlace  cannot be empty") @NotNull(message = "deliveryPlace cannot be omitted") String deliveryPlace,
			@NotEmpty(message = "deliveryDate  cannot be empty") @NotNull(message = "deliveryDate cannot be omitted") String deliveryDate,
			@NotEmpty(message = "quantity  cannot be empty") @NotNull(message = "quantity cannot be omitted") String quantity,
			String customerId) {
		super();
		this.orderNumber = orderNumber;
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.customerId = customerId;
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

	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((deliveryPlace == null) ? 0 : deliveryPlace.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderModel other = (OrderModel) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (deliveryPlace == null) {
			if (other.deliveryPlace != null)
				return false;
		} else if (!deliveryPlace.equals(other.deliveryPlace))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderModel [orderNumber=" + orderNumber + ", deliveryPlace=" + deliveryPlace + ", deliveryDate="
				+ deliveryDate + ", quantity=" + quantity + ", customerId="
				+ customerId + "]";
	}
	
	
	

	
	}

	