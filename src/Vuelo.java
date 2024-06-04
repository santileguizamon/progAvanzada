
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class Vuelo {

    public String nombreAvion;
    public String nombreDestino;
    public String nombreOrigen;
    public Time horarioSalida;
    public Time horarioLlegada;
    public Date fecha;

    public Vuelo(String nombreAvion, String nombreDestino, String nombreOrigen, Date fecha, Time horarioSalida, Time horarioLlegada) {
        this.nombreAvion = nombreAvion;
        this.nombreDestino = nombreDestino;
        this.nombreOrigen = nombreOrigen;
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
    }
    
    public boolean crearVuelo(String nombreAvion,String nombreDestino,String nombreOrigen,String fechaString,String horaSalidaString,
    String horaLlegadaString){

    	this.nombreAvion = JOptionPane.showInputDialog(null, "Ingrese el nombre del avion:");
        if (this.nombreAvion == null || this.nombreAvion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del avion no puede estar vacío.");
            return false;
        }
        this.nombreDestino = JOptionPane.showInputDialog(null, "Ingrese el nombre del destino:");
        if (this.nombreDestino == null || this.nombreDestino.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del destino no puede estar vacía.");
            return false;
        }
        this.nombreOrigen = JOptionPane.showInputDialog(null, "Ingrese el nombre del origen");
        if (this.nombreOrigen == null || this.nombreOrigen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del origen no puede estar vacio:");
            return false;
        }
        this.fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha del vuelo");
        if (this.fecha == null || ((CharSequence) this.fecha).isEmpty()) {
            JOptionPane.showMessageDialog(null, "La fecha no puede estar vacia");
            return false;
        }
        this.horarioSalida = JOptionPane.showInputDialog(null, "Ingrese el horario de salida");
        if (this.horarioSalida == null || ((CharSequence) this.horarioSalida).isEmpty()) {
            JOptionPane.showMessageDialog(null, "El horario de salida no puede estar vacio:");
            return false;
        }
        this.horarioLlegada = JOptionPane.showInputDialog(null, "Ingrese el horario de llegada");
        if (this.horarioLlegada == null || ((CharSequence) this.horarioLlegada).isEmpty()) {
            JOptionPane.showMessageDialog(null, "El horario de llegada no puede estar vacio:");
            return false;
        }
        Date fecha;
        Time horarioSalida;
        Time horarioLlegada;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false); 
            fecha = new Date(dateFormat.parse(fechaString).getTime());

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            timeFormat.setLenient(false);
            horarioSalida = new Time(timeFormat.parse(horaSalidaString).getTime());
            horarioLlegada = new Time(timeFormat.parse(horaLlegadaString).getTime());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir fechas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
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
