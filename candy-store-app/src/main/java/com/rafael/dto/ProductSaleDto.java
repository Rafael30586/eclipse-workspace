package com.rafael.dto;

public class ProductSaleDto {
	private long id;
	private int quantity;
	
	public ProductSaleDto(long id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
