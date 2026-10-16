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
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long productId = Long.valueOf(request.getParameter("product-id"));
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		String motive = request.getParameter("motive");
		
		ServletContext context = request.getServletContext();
		Connection connection = (Connection)context.getAttribute("dbConnection");

		String substractUnitsString = "UPDATE products SET stock_units = stock_units - ? WHERE id = ?";
		String substractGramsString = "UPDATE products SET stock_grams = stock_grams - ? WHERE id = ?";
		String registerProductRetirementString = "INSERT INTO dropped_products(quantity, date, motive, product_id) VALUES(?,?,?,?)";
		String getMeasurementString = "SELECT measurement FROM products WHERE id = ?";
		
		try {
			connection.setAutoCommit(false);
			
			// primero traemos el valor del measurement que le corresponde al producto
			String measurement = null;
			PreparedStatement getMeasurement = connection.prepareStatement(getMeasurementString);
			getMeasurement.setLong(1,productId);
			ResultSet getMeasurementResult = getMeasurement.executeQuery();
		    getMeasurementResult.next();
		    measurement = getMeasurementResult.getString("measurement");
		    
		    // Se ejecuta un resta de unidades o de gramos según el valor del measurement obtenido anteriormente
		    if("units".equals(measurement)) {
		    	PreparedStatement substractUnits = connection.prepareStatement(substractUnitsString);
				substractUnits.setInt(1, quantity);
				substractUnits.setLong(2, productId);
				substractUnits.executeUpdate();
		    }else if("grams".equals(measurement)) {
		    	PreparedStatement substractGrams = connection.prepareStatement(substractGramsString);
		    	substractGrams.setInt(1, quantity);
		    	substractGrams.setLong(2, productId);
		    	substractGrams.executeUpdate();
		    }else {
		    	return; // enviar un código 4xx
		    }
		    
		   
		    // Se registra en la tabla dropped_products el retiro de productos junto con el motivo, la fecha, etc
			PreparedStatement registerProductRetirement = connection.prepareStatement(registerProductRetirementString);
			registerProductRetirement.setInt(1, quantity);
			Date currentDate = new Date(System.currentTimeMillis()); 
			registerProductRetirement.setDate(2, currentDate);
			registerProductRetirement.setString(3, motive);
			registerProductRetirement.setLong(4, productId);
			registerProductRetirement.executeUpdate();
			
			connection.commit();
			
			// Hay que corroborar si este servlet funciona
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
