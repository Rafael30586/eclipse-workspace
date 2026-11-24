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
		response.setHeader(
	            "Access-Control-Allow-Origin",
	            "*"
	        );
		response.setHeader(
	            "Access-Control-Allow-Methods",
	            "GET, POST, PUT, DELETE, OPTIONS"
	        );
		
		
		String productName = request.getParameter("name");
		String flavour = request.getParameter("flavour");
		String measurement = request.getParameter("measurement"); 
		long productTypeId = Long.valueOf(request.getParameter("product-type-id"));
		long brandId = Long.valueOf(request.getParameter("brand-id"));
		
		
        ServletContext context = request.getServletContext();
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		String insertNewProductString = "INSERT INTO products(product_name, flavour, product_type_id, measurement, stock, quantity_sold, brand_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection.setAutoCommit(true);
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewProductString);
			preparedStatement.setString(1, productName);
			preparedStatement.setString(2, flavour);
			preparedStatement.setLong(3, productTypeId);
			preparedStatement.setString(4, measurement);
			preparedStatement.setInt(5, 0);
			preparedStatement.setLong(6, 0L);
			preparedStatement.setLong(7, brandId);
			preparedStatement.executeUpdate();
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
