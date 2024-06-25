package principal;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;


public class Vuelo {

    private String nombreAvion;
    private String nombreDestino;
    private String nombreOrigen;
    private Time horarioSalida;
    private Time horarioLlegada;
    private Date fecha;
    private List<DetalleVuelo> detalles;

    public Vuelo(String nombreAvion, String nombreDestino, String nombreOrigen, Date fecha, Time horarioSalida, Time horarioLlegada) {
        this.nombreAvion = nombreAvion;
        this.nombreDestino = nombreDestino;
        this.nombreOrigen = nombreOrigen;
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        this.detalles = new ArrayList<>();
    }
    
    public Vuelo() {
    	
    }
    
    public boolean crearVuelo(String nombreAvion,String nombreDestino,String nombreOrigen,Date fecha,Time horaSalida,
    Time horaLlegada){
    		
    	
        this.nombreAvion = nombreAvion;
        this.nombreDestino = nombreDestino;
        this.nombreOrigen = nombreOrigen;
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        return insertarVueloEnBD(this);
       
    }

    public boolean insertarVueloEnBD(Vuelo vuelo) {
        try {
        	Connection conn = (Connection) Conexion.getInstance();
            Statement stmt = (Statement) conn.createStatement();     

            String query = "INSERT INTO vuelos (nombre_avion, nombre_destino, nombre_origen, fecha, horario_salida, horario_llegada) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, vuelo.nombreAvion);
            pstmt.setString(2, vuelo.nombreDestino);
            pstmt.setString(3, vuelo.nombreOrigen);
            pstmt.setDate(4, (java.sql.Date) vuelo.fecha);
            pstmt.setTime(5, (Time) vuelo.horarioSalida);
            pstmt.setTime(6, (Time) vuelo.horarioLlegada);
            pstmt.executeUpdate();
            conn.close();
            
            return true;
            
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al insertar vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
    public static boolean deleteDestino(String nombreAvion) {
        try {
        	Connection conn = (Connection) Conexion.getInstance();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM vuelos WHERE nombreAvion = ?");
            statement.setString(1, nombreAvion);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Vuelo eliminado exitosamente");
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    public List<Vuelo> getAllVuelos() {
        List<Vuelo> vuelos = new ArrayList<>();
        try (Connection conn = (Connection) Conexion.getInstance();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM vuelos");
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()) {
                Vuelo vuelo = new Vuelo(
                    resultSet.getString("nombreAvion"),
                    resultSet.getString("nombreDestino"),
                    resultSet.getString("nombreOrigen"),
                    resultSet.getDate("fecha"),
                    resultSet.getTime("horarioSalida"),
                    resultSet.getTime("horarioLlegada")
                );
                vuelos.add(vuelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vuelos;
    }
    
    public static void updatedVuelo( String updatedAvion, String updatedNombreDestino,String updatedOrigen,  Date updatedFecha, Time updatedHorarioSalida, Time updatedHorarioLlegada) {
        
    	Connection conn = (Connection) Conexion.getInstance();
        try {
			Statement stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    PreparedStatement pstmt = null;

    try {
        pstmt = conn.prepareStatement("UPDATE vuelos SET nombreAvion =?, nombreDestino =?, nombreOrigen =?,  fecha =?,  horarioSalida =?,  horarioLlegada =? WHERE nombreAvion =?");
        pstmt.setString(1, updatedAvion);
        pstmt.setString(2, updatedNombreDestino);
        pstmt.setString(3, updatedOrigen);
        pstmt.setDate(4, (java.sql.Date) updatedFecha);
        pstmt.setTime(5, updatedHorarioSalida);
        pstmt.setTime(6, updatedHorarioLlegada);
        pstmt.setString(7, updatedAvion);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error updating vuelo: " + e.getMessage());
    } finally {
        try {
            if (pstmt!= null) {
                pstmt.close();
            }
            if (conn!= null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    
}
    
    
    


public String getNombreAvion() {
	return nombreAvion;
}


public void setNombreAvion(String nombreAvion) {
	this.nombreAvion = nombreAvion;
}


public String getNombreDestino() {
	return nombreDestino;
}


public void setNombreDestino(String nombreDestino) {
	this.nombreDestino = nombreDestino;
}


public String getNombreOrigen() {
	return nombreOrigen;
}


public void setNombreOrigen(String nombreOrigen) {
	this.nombreOrigen = nombreOrigen;
}


public Date getHorarioSalida() {
	return horarioSalida;
}


public void setHorarioSalida(Date horarioSalida) {
	this.horarioSalida = (Time) horarioSalida;
}


public Date getHorarioLlegada() {
	return horarioLlegada;
}


public void setHorarioLlegada(Date horarioLlegada) {
	this.horarioLlegada = (Time) horarioLlegada;
}


public Date getFecha() {
	return fecha;
}


public void setFecha(Date fecha) {
	this.fecha = fecha;
}


@Override
public String toString() {
	return "Vuelo [nombreAvion=" + nombreAvion + ", nombreDestino=" + nombreDestino + ", nombreOrigen=" + nombreOrigen
			+ ", horarioSalida=" + horarioSalida + ", horarioLlegada=" + horarioLlegada + ", fecha=" + fecha + "]";
}
        
        
	
	
	
	
	
	
	
	



	
}
