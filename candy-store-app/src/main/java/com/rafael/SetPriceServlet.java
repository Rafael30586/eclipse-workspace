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
import java.sql.SQLException;

public class SetPriceServlet extends HttpServlet {

	public SetPriceServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        ServletContext context = request.getServletContext();
		
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		long productId = Long.parseLong(request.getParameter("product-id")); 
		
		String pricePerUnitString = request.getParameter("price-per-unit");
		String pricePer100gString = request.getParameter("price-per-100g");
		
		Float pricePerUnit = null;
		Float pricePer100g = null;
		
		if(pricePerUnitString!=null) {
			pricePerUnit = Float.parseFloat(pricePerUnitString);
		}
		
		if(pricePer100gString!=null) {
			pricePer100g = Float.parseFloat(pricePer100gString);
		}
		
		// pricePerUnit = Float.parseFloat(request.getParameter("price-per-unit"));
		// pricePer100g = Float.parseFloat(request.getParameter("price-per-100g"));
		
		String setPricePerUnitString = "UPDATE products SET price_per_unit = ? WHERE id = ?";
		String setPricePer100gString = "UPDATE products SET price_per_100g = ? WHERE id = ?";
		
		try {
			connection.setAutoCommit(false);
			
			if(pricePerUnit != null) {
				PreparedStatement setPricePerUnit = connection.prepareStatement(setPricePerUnitString);
				setPricePerUnit.setFloat(1, pricePerUnit);
				setPricePerUnit.setLong(2, productId);
				setPricePerUnit.executeUpdate();
				
			}
			
			if(pricePer100g != null) {
				PreparedStatement setPricePer100g = connection.prepareStatement(setPricePer100gString);
				setPricePer100g.setFloat(1, pricePer100g);
				setPricePer100g.setLong(2, productId);
				setPricePer100g.executeUpdate();
			}
			
			if(pricePer100g != null || pricePerUnit != null) {
				connection.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
