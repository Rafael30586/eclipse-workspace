package com.rafael;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetPriceServlet extends HttpServlet {

	public SetPriceServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// Este servlet debería ser para hacer un patch, no un post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        ServletContext context = request.getServletContext();
		
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		long productId = Long.parseLong(request.getParameter("product-id")); 
		
		// String pricePerUnitString = request.getParameter("price-per-unit");
		// String pricePer100gString = request.getParameter("price-per-100g");
		Float price = Float.valueOf(request.getParameter("price"));
		
		// Float pricePerUnit = null;
		// Float pricePer100g = null;
		/*
		if(pricePerUnitString!=null) {
			pricePerUnit = Float.parseFloat(pricePerUnitString);
		}*/
		/*
		if(pricePer100gString!=null) {
			pricePer100g = Float.parseFloat(pricePer100gString);
		}*/
		
		// pricePerUnit = Float.parseFloat(request.getParameter("price-per-unit"));
		// pricePer100g = Float.parseFloat(request.getParameter("price-per-100g"));
		
		String setPricePerUnitString = "UPDATE products SET price_per_unit = ? WHERE id = ?";
		String setPricePer100gString = "UPDATE products SET price_per_100g = ? WHERE id = ?";
		String getMeasurementString = "SELECT measurement FROM products WHERE id = ?";
		
		try {
			connection.setAutoCommit(false);
			
			String measurement = null;
			PreparedStatement preparedStatement = connection.prepareStatement(getMeasurementString);
			preparedStatement.setLong(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			measurement = resultSet.getString("measurement");
			preparedStatement.close();
			
			/*if(pricePerUnit != null) {
				PreparedStatement setPricePerUnit = connection.prepareStatement(setPricePerUnitString);
				setPricePerUnit.setFloat(1, pricePerUnit);
				setPricePerUnit.setLong(2, productId);
				setPricePerUnit.executeUpdate();
				
			}*/
			
			/*if(pricePer100g != null) {
				PreparedStatement setPricePer100g = connection.prepareStatement(setPricePer100gString);
				setPricePer100g.setFloat(1, pricePer100g);
				setPricePer100g.setLong(2, productId);
				setPricePer100g.executeUpdate();
			}*/
			
			if("units".equals(measurement)) {
				preparedStatement = connection.prepareStatement(setPricePerUnitString);
				preparedStatement.setFloat(1, price);
				preparedStatement.setLong(2, productId);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}else if("grams".equals(measurement)) {
				preparedStatement = connection.prepareStatement(setPricePer100gString);
				preparedStatement.setFloat(1, price);
				preparedStatement.setLong(2, productId);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}else {
				// LAnzar error
			}
			
			connection.commit();
			
			// Mejorar este servlet de acuerdo a lo anotado en el cuaderno 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
