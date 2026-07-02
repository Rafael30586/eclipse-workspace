package com.rafael.listener;

import java.sql.Connection;
import java.sql.SQLException;

import com.rafael.db.DatabaseConnectionManager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextListener implements ServletContextListener, ServletContextAttributeListener {

 
    public ApplicationContextListener() {
    
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         
    }

	
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         
    }

	
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext context = sce.getServletContext();
    	String username = context.getInitParameter("username");
    	String password = context.getInitParameter("password");
    	String driver = context.getInitParameter("driver");
    	String dburl = context.getInitParameter("dburl");
    	
    	// System.out.println("username: "+username+"------ password: "+password);
    	
    	try {
			DatabaseConnectionManager dbManager = new DatabaseConnectionManager(username, password, driver, dburl);
			Connection connection = dbManager.getConnection();
			context.setAttribute("dbConnection", connection);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
         
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    	Connection connection = (Connection)sce.getServletContext().getAttribute("dbConnection");
    	try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
         
    }

	
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         
    }
	
}
