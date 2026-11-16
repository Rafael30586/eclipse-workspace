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
import com.rafael.dto.BrandDto;

public class ShowBrandsServlet extends HttpServlet {
	
    public ShowBrandsServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		
		String getAllBrandsString = "SELECT * FROM brands";
		LinkedList<BrandDto> brandList = new LinkedList<BrandDto>();
		
		try {
			connection.setAutoCommit(true);
			
			PreparedStatement preparedStatement = connection.prepareStatement(getAllBrandsString);
			ResultSet allBrandsResultSet = preparedStatement.executeQuery();
			
			allBrandsResultSet.next();
			BrandDto brandDataForwarder;
			while(allBrandsResultSet.next()) {
				brandDataForwarder = new BrandDto(allBrandsResultSet.getLong(1),allBrandsResultSet.getString(2));
				brandList.add(brandDataForwarder);
			}
			
			ObjectMapper mapper = new ObjectMapper();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			mapper.writeValue(response.getWriter(), brandList);
			
		} catch (SQLException e) {
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
