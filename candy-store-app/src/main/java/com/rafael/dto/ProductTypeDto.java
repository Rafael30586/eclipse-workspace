package com.rafael.dto;

public class ProductTypeDto {
	
	private Long id;
	private String name;
	
	public ProductTypeDto() {
		super();
	}

	public ProductTypeDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
