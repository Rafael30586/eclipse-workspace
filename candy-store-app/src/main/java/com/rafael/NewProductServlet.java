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
		String measurement = request.getParameter("measurement");
		Integer stockUnits = null;
		Long stockGrams = null; 
		long productTypeId = Long.valueOf(request.getParameter("product-type-id"));
		long brandId = Long.valueOf(request.getParameter("brand-id"));
		
		if("grams".equals(measurement)) { 
			stockGrams = 0L;
		}else if("units".equals(measurement)){
			stockUnits = 0;
		}else {
			return; // Enviar respuesta con status code de bad request
		}
		
		
		String saveProductString = null;
		String saveBrandProductRelationString = "INSERT INTO product_brand(product_id, brand_id) VALUES(?,?)";
		
		if("grams".equals(measurement)) {
			saveProductString = "INSERT INTO products(product_name, flavour, stock_grams, product_type_id, measurement) VALUES(?,?,?,?,?)";
		}else if("units".equals(measurement)) {
			saveProductString = "INSERT INTO products(product_name, flavour, stock_units, product_type_id, measurement) VALUES(?,?,?,?,?)";
		}
		
        ServletContext context = request.getServletContext();
		
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement saveProduct = connection.prepareStatement(saveProductString);
			saveProduct.setString(1, productName);
			saveProduct.setString(2, flavour);
			// saveProduct.setInt(3, stockUnits);
			if("grams".equals(measurement)) {
				saveProduct.setLong(3, stockGrams);
			}else if("units".equals(measurement)) {
				saveProduct.setLong(3, stockUnits);
			}
			// saveProduct.setLong(4, stockGrams);
			saveProduct.setLong(4, productTypeId);
			saveProduct.setString(5, measurement);
			
			saveProduct.executeUpdate();
			
			long productId;
			String productIdStatement = "SELECT id FROM products WHERE product_name=? AND flavour=?";
			PreparedStatement findProductId = connection.prepareStatement(productIdStatement);
			findProductId.setString(1, productName);
			findProductId.setString(2, flavour);
			ResultSet productIdResult = findProductId.executeQuery();
			productIdResult.next();
			productId = productIdResult.getLong(1);
			
			findProductId.executeQuery();
			
			
			
			PreparedStatement saveProductBrandRelation = connection.prepareStatement(saveBrandProductRelationString);
			saveProductBrandRelation.setLong(1,productId);
			saveProductBrandRelation.setLong(2, brandId);
			
			saveProductBrandRelation.executeUpdate();
			
			connection.commit();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
