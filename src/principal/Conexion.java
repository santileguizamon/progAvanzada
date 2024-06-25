package principal;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
	private static final String URL = "jbdc:mysql://localhost:3306/aerolinea";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Conexion instance;
	private Connection connection; 
	
	
	private Conexion() {
		try {
			connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
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
