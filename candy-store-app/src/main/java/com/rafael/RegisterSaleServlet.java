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
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael.dto.ProductSaleDto;

public class RegisterSaleServlet extends HttpServlet {
	
	// private ObjectMapper objectMapper = new ObjectMapper();
	private ObjectMapper objectMapper = new ObjectMapper();
	
    public RegisterSaleServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double amount = Double.parseDouble(request.getParameter("amount"));
		Date currentDateAndTime = new Date(System.currentTimeMillis());
		UUID saleUuid = UUID.randomUUID();
		
		ProductSaleDto[] productSales = objectMapper.readValue(request.getInputStream(), ProductSaleDto[].class);
		// El método getInputStream devuelve un objeto de tipo ServletInputStream, que hereda de InputStream
		
		
		ServletContext context = request.getServletContext();
		Connection connection = (Connection)context.getAttribute("dbConnection");
		
		String registerSaleString = "INSERT INTO sales(amount, sold_at) VALUES(?, ?)";
		String registerSaleProductString = "INSERT INTO sale_product(sale_id, product_id, quantity) VALUES(?, ?, ?)";
		String updateUnitsSold = "UPDATE products SET units_sold = units_sold + ? WHERE id = ?";
		String updateKilogramsSold = "UPDATE products SET kilograms_sold = kilograms_sold + ? WHERE id = ?";
		String getMeasurementString = "SELECT measurement FROM products WHERE id = ?";
		String getSaleIdString = "SELECT id FROM sales WHERE "; // Falta completar este String luego de hacer modificaciones en la tabla de sales
		
		
		
	}

}
