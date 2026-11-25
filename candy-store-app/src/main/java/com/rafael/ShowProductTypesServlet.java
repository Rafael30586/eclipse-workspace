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
import java.util.LinkedList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael.dto.ProductTypeDto;


public class ShowProductTypesServlet extends HttpServlet {
	
    public ShowProductTypesServlet() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader(
	            "Access-Control-Allow-Origin",
	            "*"
	        );
		response.setHeader(
	            "Access-Control-Allow-Methods",
	            "GET, POST, PUT, DELETE, OPTIONS"
	        );
		
		
		ServletContext context = request.getServletContext();
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		String getAllProductTypesString = "SELECT * FROM categorization";
		LinkedList<ProductTypeDto> productTypesList = new LinkedList<ProductTypeDto>();
		
		try {
			connection.setAutoCommit(true);
			
			PreparedStatement preparedStatement = connection.prepareStatement(getAllProductTypesString);
			ResultSet allProductTypesResultSet = preparedStatement.executeQuery();
			
			// allProductTypesResultSet.next();
			ProductTypeDto productTypeDataForwarder;
			while(allProductTypesResultSet.next()) {
				productTypeDataForwarder = new ProductTypeDto(allProductTypesResultSet.getLong(1), allProductTypesResultSet.getString(2));
				productTypesList.add(productTypeDataForwarder);
			}
			ObjectMapper mapper = new ObjectMapper();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			mapper.writeValue(response.getWriter(), productTypesList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
