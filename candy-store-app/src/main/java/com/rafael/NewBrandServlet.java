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


public class NewBrandServlet extends HttpServlet {
	
    public NewBrandServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brandName = request.getParameter("brand-name");
		
		String insertNewBrandString = "INSERT INTO brands(brand_name) VALUES(?)";
		
		ServletContext context = request.getServletContext();
		
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		
		try {
			connection.setAutoCommit(true);
			
			PreparedStatement insertNewBrandStatement = connection.prepareStatement(insertNewBrandString);
			insertNewBrandStatement.setString(1,brandName);
			insertNewBrandStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
