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
		
		String unitAdditionString = "UPDATE products SET stock_units = stock_units + ? WHERE id = ?";
		String gramAdditionString = "UPDATE products SET stock_grams = stock_grams + ? WHERE id = ?";
		String registerStockAdditionString = "INSERT INTO stock_additions(product_id, quantity, date) VALUES(?, ?, ?)";
		String getMeasurementString = "SELECT measurement FROM products WHERE id = ?";
		
		try {
			connection.setAutoCommit(false);
			// Continuar desarrollando este método desde acá, se puede tomar como referencia el DropProductServlet para algunas cosas
			
			// primero traemos el valor del measurement que le corresponde al producto
			String measurement = null;
			PreparedStatement getMeasurement = connection.prepareStatement(getMeasurementString);
			getMeasurement.setLong(1,productId);
			ResultSet getMeasurementResult = getMeasurement.executeQuery();
		    getMeasurementResult.next();
		    measurement = getMeasurementResult.getString("measurement");
		    
		    // Se suman unidades o gramos según el valor de measuremnt
		    if("units".equals(measurement)){
		    	PreparedStatement unitAddition = connection.prepareStatement(unitAdditionString);
		    	unitAddition.setInt(1, quantity);
		    	unitAddition.setLong(2, productId);
		    	unitAddition.executeUpdate();
		    }else if("grams".equals(measurement)) {
		    	PreparedStatement gramAddition = connection.prepareStatement(gramAdditionString);
		    	gramAddition.setInt(1, quantity);
		    	gramAddition.setLong(2, productId);
		    	gramAddition.executeUpdate();
		    }
		    
		    // Registro de la suma de stock
		    PreparedStatement registerStockAddition = connection.prepareStatement(registerStockAdditionString);
		    registerStockAddition.setLong(1, productId);
		    registerStockAddition.setInt(2, quantity);
		    Date currentDate = new Date(System.currentTimeMillis());
		    registerStockAddition.setDate(3, currentDate);
		    registerStockAddition.executeUpdate();
		    
		    connection.commit();
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
