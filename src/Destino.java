import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Destino {

    public String destino;
    public String nombreHotel;
    public String movilidad;


    public void crearHotel() {
        this.destino = JOptionPane.showInputDialog(null, "Ingrese el nombre del destino:");
        if (this.destino == null || this.destino.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del hotel no puede estar vacío.");
            return;
        }
        this.nombreHotel = JOptionPane.showInputDialog(null, "Ingrese el nombre del hotel:");
        if (this.nombreHotel == null || this.nombreHotel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del hotel no puede estar vacía.");
            return;
        }
        this.movilidad = JOptionPane.showInputDialog(null, "Ingrese la opcion de movilidad");
        if (this.movilidad == null || this.movilidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La movilidad no puede estar vacía.");
            return;
        }

    }
        

        public void insertarHotelEnBD(Conexion connection, Vuelo vuelo) {
            try {
            	Connection conn = (Connection) Conexion.getInstance();
                Statement stmt = (Statement) conn.createStatement();     

                String query = "INSERT INTO hotel (destino, nombre_hotel, movilidad) VALUES (?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, this.destino);
                pstmt.setString(2, this.nombreHotel);
                pstmt.setString(3, this.movilidad);
                pstmt.executeUpdate();
                conn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }  
}


	
	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getNombreHotel() {
		return nombreHotel;
	}


	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}


	public String getMovilidad() {
		return movilidad;
	}



	public void setMovilidad(String movilidad) {
		this.movilidad = movilidad;
	}



	
}
