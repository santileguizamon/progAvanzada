package principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class Conexion {
	private static final String URL = "jdbc:mysql://localhost:3306/aerolinea2";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Conexion instance;
	private Connection connection; 
	
	
	private Conexion() {
		try {
			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			JOptionPane.showConfirmDialog(null, "se conecto");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static Conexion getInstance() {
		if(instance == null) {
			instance = new Conexion();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
