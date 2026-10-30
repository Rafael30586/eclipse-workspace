package com.rafael;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael.dto.ProductSaleDto;

public class RegisterSaleServlet extends HttpServlet {
	
	// private ObjectMapper objectMapper = new ObjectMapper();
	private ObjectMapper objectMapper = new ObjectMapper();
	
    public RegisterSaleServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Double amount = Double.parseDouble(request.getParameter("amount"));
		Date currentDateAndTime = new Date(System.currentTimeMillis());
		UUID saleUuid = UUID.randomUUID();
		
		ProductSaleDto[] productSales = objectMapper.readValue(request.getInputStream(), ProductSaleDto[].class);
		// El método getInputStream devuelve un objeto de tipo ServletInputStream, que hereda de InputStream
		
		
		ServletContext context = request.getServletContext();
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		String registerSaleString = "INSERT INTO sales(amount, sold_at, id) VALUES(?, ?, ?)";
		String registerSaleProductString = "INSERT INTO sale_product(sale_id, product_id, quantity) VALUES(?, ?, ?)";
		String updateUnitsSoldString = "UPDATE products SET units_sold = units_sold + ? WHERE id = ?";
		String updateKilogramsSoldString = "UPDATE products SET kilograms_sold = kilograms_sold + ? WHERE id = ?";
		String getMeasurementString = "SELECT measurement FROM products WHERE id = ?";
		String substractStockUnitsString = "UPDATE products SET stock_units = stock_units - ? WHERE id = ?";
		String substractStockGramsString = "UPDATE products SET stock_grams = stock_grams - ? WHERE id = ?";
		String getProductPricePerUnitString = "SELECT price_per_unit FROM products WHERE id = ?";
		String getProductPricePer100gString = "SELECT price_per_100g FROM products WHERE id = ?";
		
		try {
			connection.setAutoCommit(false);
			
		
		    long productId = 0L;
		    int quantity = 0;
		    PreparedStatement registerSaleProduct = null;
		    PreparedStatement getMeasurement = null;
		    ResultSet getMeasurementResultSet = null;
		    String measurement = null;
		    PreparedStatement updateUnitsSold;
		    PreparedStatement updateKilogramsSold;
		    PreparedStatement substractStockUnits;
		    PreparedStatement substractStockGrams;
		    double kilograms = 0.0; 
		    double amount = 0.0;
		    double price = 0.0;
		    PreparedStatement getProductPricePerUnit;
		    PreparedStatement getProductPricePer100g;
		    
		    for(ProductSaleDto p :  productSales) {
		    	productId = p.getId();
		    	quantity = p.getQuantity();
		    	registerSaleProduct = connection.prepareStatement(registerSaleProductString);
		    	registerSaleProduct.setObject(1, saleUuid);
		    	registerSaleProduct.setLong(2, productId);
		    	registerSaleProduct.setInt(3, quantity);
		    	registerSaleProduct.executeUpdate();
		    	
		    	getMeasurement = connection.prepareStatement(getMeasurementString);
		    	getMeasurement.setLong(1, productId);
		    	getMeasurementResultSet = getMeasurement.executeQuery();
		        getMeasurementResultSet.next();
		        measurement = getMeasurementResultSet.getString("measurement");
		      
		        if("units".equals(measurement)) {
		        	updateUnitsSold = connection.prepareStatement(updateUnitsSoldString);
		        	updateUnitsSold.setInt(1, quantity);
		        	updateUnitsSold.setLong(2, productId);
		        	updateUnitsSold.executeUpdate();
		        	
		        	substractStockUnits = connection.prepareStatement(substractStockUnitsString);
		        	substractStockUnits.setInt(1,quantity);
		        	substractStockUnits.setLong(2,productId);
		        	substractStockUnits.executeUpdate();
		        	
		        	getProductPricePerUnit = connection.prepareStatement(getProductPricePerUnitString);
		        	getProductPricePerUnit.setLong(1, productId);;
		        	ResultSet productPricePerUnitResultSet = getProductPricePerUnit.executeQuery();
		        	productPricePerUnitResultSet.next();
		        	price = productPricePerUnitResultSet.getDouble("price_per_unit");
		        }else if("grams".equals(measurement)) {
		        	updateKilogramsSold = connection.prepareStatement(updateKilogramsSoldString);
		        	kilograms = ((double)quantity)/1000.0;
		        	updateKilogramsSold.setDouble(1, kilograms);
		        	updateKilogramsSold.setLong(2, productId);
		        	updateKilogramsSold.executeUpdate();
		        	
		        	substractStockGrams = connection.prepareStatement(substractStockGramsString);
		        	substractStockGrams.setInt(1, quantity);
		        	substractStockGrams.setLong(2, productId);
		        	substractStockGrams.executeUpdate();
		        	
		        	getProductPricePer100g = connection.prepareStatement(getProductPricePer100gString);
		        	getProductPricePer100g.setLong(1, productId);
		        	ResultSet productPricePer100gResultSet = getProductPricePer100g.executeQuery();
		        	productPricePer100gResultSet.next();
		        	price = productPricePer100gResultSet.getDouble("price_per_100g");
		        }else {
		        	return; // Devolver una página de error
		        }
		        
		        amount = amount + (price * quantity); 
		        
		    }
		    
		    PreparedStatement registerSale = connection.prepareStatement(registerSaleString);
			registerSale.setDouble(1, amount);
			registerSale.setDate(2, currentDateAndTime);
			// registerSale.setString(3,saleUuid);
			registerSale.setObject(3, saleUuid);
		    registerSale.executeUpdate();
	    	
		    
		    connection.commit();
		    
			// Probar de ustilizar una sola variable del tipo PreparedSatement en todo el servlet
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
