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

public class NewProductServlet extends HttpServlet {

    public NewProductServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("name");
		String flavour = request.getParameter("flavour");
		// float pricePerUnit = Float.valueOf(request.getParameter("price-per-unit"));
		// float pricePer100g = Float.valueOf(request.getParameter("price-per-100g"));
		// int stockUnits = Integer.valueOf(request.getParameter("stock-units"));
		int stockUnits = 0;
		// long stockGrams = Long.valueOf(request.getParameter("stock-grams"));
		long stockGrams = 0;
		// long unitsSold = Long.valueOf(request.getParameter("unitsSold"));
		long productTypeId = Long.valueOf(request.getParameter("product-type-id"));
		// double kGramsSold = Double.valueOf(request.getParameter("kilograms-sold"));
		
		long brandId = Long.valueOf(request.getParameter("brandId"));
		
		
		String statement = "INSERT INTO product(product_name,flavour, stock_units, stock_grams ,product_type_id) VALUES(?,?,?,?,?)";
		String saveBrandProductRelationString = "INSERT INTO product_brand(product_id, brand_id) VALUES(?,?)";
		
		
        ServletContext context = request.getServletContext();
		
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement preparedStatement = connection.prepareStatement(statement);
			preparedStatement.setString(0, productName);
			preparedStatement.setString(1, flavour);
			// preparedStatement.setFloat(2, pricePerUnit);
			// preparedStatement.setFloat(3, pricePer100g);
			preparedStatement.setInt(2, stockUnits);
			preparedStatement.setLong(3, stockGrams);
			preparedStatement.setLong(4, productTypeId);
			// preparedStatement.setDouble(7, kGramsSold);
			
			preparedStatement.executeUpdate();
			
			long productId;
			String productIdStatement = "SELECT id FROM products WHERE name="+productName+"AND flavour="+flavour;
			PreparedStatement findProductId = connection.prepareStatement(productIdStatement);
			ResultSet productIdResult = findProductId.executeQuery();
			productId = productIdResult.getLong(0);
			
			findProductId.executeQuery();
			
			
			
			PreparedStatement saveProductBrandRelation = connection.prepareStatement(statement);
			saveProductBrandRelation.setLong(0,productId);
			saveProductBrandRelation.setLong(1, brandId);
			
			saveProductBrandRelation.executeUpdate();
			
			connection.commit();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		// Método incompleto
	}

}
