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


public class SetStockServlet extends HttpServlet { // Puede que este servlet no sirva. Será reemplazado por servlets para retirado de producto, de venta, ect
	
    public SetStockServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		
		if(option != "units" && option != "grams") {
			return; // Considerar lanzar un error con código 4xx (bad request) en esta parte
		}
		
		Long productId = Long.parseLong(request.getParameter("product-id"));
		
		ServletContext context = request.getServletContext();
		Connection connection = (Connection) context.getAttribute("dbConnection"); // objeto de conexión a base de datos
		
		try {
			connection.setAutoCommit(true);
			
			// Hay que corroborar si el producto con el id productId existe y si los campos stock_units y stock_grams son igual a null
			
			String searchProductByIdString = "SELECT EXISTS (SELECT 1 FROM products WHERE id = ?)";
			PreparedStatement searchProductById = connection.prepareStatement(searchProductByIdString);
			searchProductById.setLong(1, productId); 
			
			ResultSet productByIdExists = searchProductById.executeQuery();
			productByIdExists.next();
			Boolean productByIdExistsBoolean = productByIdExists.getBoolean(1);
			
			if(productByIdExistsBoolean != true) {
				return; // Considerar dar una respuesta 4xx bad request
			}
			
			Integer quantity = Integer.valueOf(request.getParameter("quantity"));
			
			// Continuar programando este método, falta corroborar si el campo elegido en option es null para poder inicializarlo
			
			if("grams".equals(option)) {
				
				String checkStockGramsString = "SELECT stock_grams FROM products WHERE id = ?";
				PreparedStatement checkStockGrams = connection.prepareStatement(checkStockGramsString);
				checkStockGrams.setLong(1, productId);
				ResultSet stockGramsResultSet = checkStockGrams.executeQuery();
				stockGramsResultSet.next();
				
				Integer stockGrams = stockGramsResultSet.getInt(1);
				
				if(stockGrams != null) {
					System.out.println("The stock in grams should be null before making this opeartion");
					return; // Lanzar una respuesta HTTP de tipo 4xx
				}
				
				String setQuantityString = "UPDATE products SET stock_grams = ? WHERE id = ?";
				PreparedStatement setQuantity = connection.prepareStatement(setQuantityString);
				setQuantity.setInt(1, quantity);
				setQuantity.setLong(2, productId);
				setQuantity.executeUpdate();
				
			}else if("units".equals(option)){ // colocar la lógica que corresponde si se quiere establecer el campo stock_units
				String checkStockUnitsString = "SELECT stock_units FROM products WHERE id = ?";
				PreparedStatement checkStockUnits = connection.prepareStatement(checkStockUnitsString);
				checkStockUnits.setLong(1, productId);
				ResultSet stockUnitsResultSet = checkStockUnits.executeQuery();
				stockUnitsResultSet.next();
				
				Integer stockUnits = stockUnitsResultSet.getInt(1);
				
				if(stockUnits != null) {
					System.out.print("The sotck in units should be null before making this operation");
					return; // Lanzar una respuesta HTTP 4xx
				}
				
				String setQuantityString = "UPDATE products SET stock_units = ? WHERE id = ?";
				PreparedStatement setQuantity = connection.prepareStatement(setQuantityString);
				setQuantity.setInt(1, quantity);
				setQuantity.setLong(2, productId);
				setQuantity.executeUpdate();
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		// long quantity = Long.parseLong(request.getParameter("quantity"));
		
		
	}

}
