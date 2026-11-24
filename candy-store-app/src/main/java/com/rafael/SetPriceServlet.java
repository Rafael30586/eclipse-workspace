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
		
		Float price = Float.valueOf(request.getParameter("price"));
		
		String setPriceString = "UPDATE products SET price = ? WHERE id = ?";
		
		try {
			connection.setAutoCommit(true);
			
		    PreparedStatement preparedStatement = connection.prepareStatement(setPriceString);
		    preparedStatement.setDouble(1, price);
		    preparedStatement.setLong(2, productId);
		    preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
