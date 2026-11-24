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

public class AddStock extends HttpServlet {
	
    public AddStock() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long productId = Long.parseLong(request.getParameter("product-id"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		
		ServletContext context = request.getServletContext();
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		String registerStockAdditionString = "INSERT INTO stock_additions(product_id, quantity, date) VALUES(?, ?, ?)";
		String stockAdditionString = "UPDATE products SET stock = stock + ? WHERE id = ?";
		
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement preparedStatement = connection.prepareStatement(stockAdditionString);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setLong(2, productId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		    
		    preparedStatement = connection.prepareStatement(registerStockAdditionString);
		    preparedStatement.setLong(1, productId);
		    preparedStatement.setInt(2, quantity);
		    Date currentDate = new Date(System.currentTimeMillis());
		    preparedStatement.setDate(3, currentDate);
		    preparedStatement.executeUpdate();
		    
		    connection.commit();
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
