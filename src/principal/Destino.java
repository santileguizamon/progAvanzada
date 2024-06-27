package principal;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Destino {

    public String destino;
    public String nombreHotel;
    public String movilidad;


    public Destino(String destino, String nombreHotel, String movilidad) {
		this.destino = destino;
		this.nombreHotel = nombreHotel;
		this.movilidad = movilidad;
	}
    public Destino() {
    	
    };


	public boolean crearHotel(String destino, String nombreHotel, String movilidad) {
        
        this.destino = destino;
        this.nombreHotel = nombreHotel;
        this.movilidad = movilidad;
        	return insertarHotelEnBD(this);
    }
        

        public boolean insertarHotelEnBD( Destino destino) {
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

                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar destino: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }  
        }
        
        public static void updateDestino(int id, String destino, String nombreHotel, String movilidad) {
          
            	Connection conn = (Connection) Conexion.getInstance();
                try {
					Statement stmt = (Statement) conn.createStatement();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            
            PreparedStatement pstmt = null;

            try {
                pstmt = conn.prepareStatement("UPDATE destino SET destino =?, nombre_hotel =?, movilidad =? WHERE id =?");
                pstmt.setString(1, destino);
                pstmt.setString(2, nombreHotel);
                pstmt.setString(3, movilidad);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error updating hotel: " + e.getMessage());
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
    


	
	public String getDestino() {
		
		return destino;
	}

	
	public List<Destino> getAllDestinos() {
        List<Destino> destinos = new ArrayList<>();
        try (Connection conn = (Connection) Conexion.getInstance();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM destino");
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()) {
                Destino destino = new Destino(
                    resultSet.getString("destino"),
                    resultSet.getString("nombreHotel"),
                    resultSet.getString("movilidad")
                );
                destinos.add(destino);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinos;
    }
	
	 public static boolean deleteDestino(String nombreHotel) {
	        try {
	        	Connection conn = (Connection) Conexion.getInstance();
	            PreparedStatement statement = conn.prepareStatement("DELETE FROM destinos WHERE nombreHotel = ?");
	            statement.setString(1, nombreHotel);
	            
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Hotel eliminado exitosamente");
	                return true;
	            }
	            return false;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;

	        }
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
