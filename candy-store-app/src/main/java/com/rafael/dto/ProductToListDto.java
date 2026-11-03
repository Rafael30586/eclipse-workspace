package com.rafael.dto;

import java.util.ArrayList;
// import java.util.LinkedList;

public class ProductToListDto {
	private Long id;
	private String productName;
	private String flavour;
	private ArrayList<String> brands;
	private Double pricePerUnit;
	private Double pricePer100g;
	private Integer stockUnits;
	private Integer stockGrams;
	private Integer unitsSold;
	private Double kiloGramsSold;
	private Long droppedProducts; // Traer la información de la tabla dropped_products y completar con gramos o unidades según el
	// measurement
}
