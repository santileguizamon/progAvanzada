
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class Vuelo {

    public String nombreAvion;
    public String nombreDestino;
    public String nombreOrigen;
    public Date horarioSalida;
    public Date horarioLlegada;
    public Date fecha;

    public Vuelo(String nombreAvion, String nombreDestino, String nombreOrigen, Date fecha, Date horarioSalida, Date horarioLlegada) {
        this.nombreAvion = nombreAvion;
        this.nombreDestino = nombreDestino;
        this.nombreOrigen = nombreOrigen;
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
    }
    
    public void crearVuelo(Conexion connection) {

        String nombreAvion = JOptionPane.showInputDialog(null, "Ingrese el nombre del avión:");
        String nombreDestino = JOptionPane.showInputDialog(null, "Ingrese el nombre del destino:");
        String nombreOrigen = JOptionPane.showInputDialog(null, "Ingrese el nombre del origen:");
        String fechaString = JOptionPane.showInputDialog(null, "Ingrese la fecha (formato dd/mm/aaaa):");
        String horaSalidaString = JOptionPane.showInputDialog(null, "Ingrese la hora de salida (formato hh:mm):");
        String horaLlegadaString = JOptionPane.showInputDialog(null, "Ingrese la hora de llegada (formato hh:mm):");
        Date fecha = null;
        Date horarioSalida = null;
        Date horarioLlegada = null;
        try {
            fecha = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);
            horarioSalida = (Date) new SimpleDateFormat("HH:mm").parse(horaSalidaString);
            horarioLlegada = (Date) new SimpleDateFormat("HH:mm").parse(horaLlegadaString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al convertir fechas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.nombreAvion = nombreAvion;
        this.nombreDestino = nombreDestino;
        this.nombreOrigen = nombreOrigen;
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        insertarVueloEnBD(connection, this);
        JOptionPane.showMessageDialog(null, "Vuelo creado con éxito!");
    }

    public void insertarVueloEnBD(Conexion connection, Vuelo vuelo) {
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

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al insertar vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

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
	this.horarioSalida = horarioSalida;
}


public Date getHorarioLlegada() {
	return horarioLlegada;
}


public void setHorarioLlegada(Date horarioLlegada) {
	this.horarioLlegada = horarioLlegada;
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
