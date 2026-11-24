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



public class DropProductsServlet extends HttpServlet {
	
    public DropProductsServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long productId = Long.valueOf(request.getParameter("product-id"));
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		String motive = request.getParameter("motive");
		
		ServletContext context = request.getServletContext();
		Connection connection = (Connection)context.getAttribute("dbConnection");

		//String substractUnitsString = "UPDATE products SET stock_units = stock_units - ? WHERE id = ?";
		//String substractGramsString = "UPDATE products SET stock_grams = stock_grams - ? WHERE id = ?";
		String registerProductRetirementString = "INSERT INTO dropped_products(quantity, date, motive, product_id) VALUES(?,?,?,?)";
		// String getMeasurementString = "SELECT measurement FROM products WHERE id = ?";
		String substractStockString = "UPDATE products SET stock = stock - ? WHERE id = ?";
		
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement preparedStatement = connection.prepareStatement(substractStockString);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setLong(2, productId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		    // Se registra en la tabla dropped_products el retiro de productos junto con el motivo, la fecha, etc
			preparedStatement = connection.prepareStatement(registerProductRetirementString);
			preparedStatement.setInt(1, quantity);
			Date currentDate = new Date(System.currentTimeMillis()); 
			preparedStatement.setDate(2, currentDate);
			preparedStatement.setString(3, motive);
			preparedStatement.setLong(4, productId);
			preparedStatement.executeUpdate();
			
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
