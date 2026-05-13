package com.rafael.dao;

import com.rafael.model.Personaje;
import java.sql.*;

public class PersonajeDao {
	
	public Personaje obtenerPersonaje(int pid) {
		
		Personaje p = new Personaje();
		p.setPid(101);
		p.setNombre("john 117");
		p.setApodo("master chief");
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rafael","postgres","rafael");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from personajes where id="+pid);
			
			if(rs.next()) {
				p.setPid(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApodo(rs.getString("apodo"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}

}
