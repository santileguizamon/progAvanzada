import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Reserva  {

	Destino destino;
	public String nombre;
	public String apellido;
	public String dni;
	public String email;
	public double precio;
	

	public void generarTicketReserva() {
	    LinkedList<Destino> hotelesDisponibles = obtenerHotelesDisponibles();
	    if (hotelesDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay hoteles disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
	    String hotelInfo = "";

        for (int i = 0; i < hotelesDisponibles.size(); i++) {
        	hotelInfo += (i + 1) + ". Nombre del destino: " + hotelesDisponibles.get(i).getDestino() + "\n";
        	hotelInfo += "Nombre del hotel: " + hotelesDisponibles.get(i).getNombreHotel() + "\n";
        	hotelInfo += "Forma de movilidad: " + hotelesDisponibles.get(i).getMovilidad() + "\n";
        }
        
        String seleccionStr = JOptionPane.showInputDialog(null, "Selecciona un hotel:\n" + hotelInfo, "Hoteles disponibles", JOptionPane.QUESTION_MESSAGE);
        if (seleccionStr == null || seleccionStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selección inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int seleccion;
        try {
            seleccion = Integer.parseInt(seleccionStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Selección inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

      
        if (seleccion > 0 && seleccion <= hotelesDisponibles.size()) {
            destino = hotelesDisponibles.get(seleccion - 1);
            nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:");
            apellido = JOptionPane.showInputDialog(null, "Ingresa tu apellido:");
            dni = JOptionPane.showInputDialog(null, "Ingresa tu número de documento:");
            email =  JOptionPane.showInputDialog(null, "Ingresa tu email:");
            precio = 1000.0; 
            
            String informacionTicket = "Nombre: " + nombre + "\n" +
                    "Apellido: " + apellido + "\n" +
                    "Documento: " + dni + "\n" +
                    "Datos del destino: " + destino + "\n";;
            JOptionPane.showMessageDialog(null, informacionTicket, "Reserva", JOptionPane.INFORMATION_MESSAGE);

        }

    }
	
	
	private LinkedList<Destino> obtenerHotelesDisponibles () {
		LinkedList<Destino> hotelesDisponibles = new LinkedList<>();

        try {
            Connection conn = (Connection) Conexion.getInstance();
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hotel");
            while (rs.next()) {
                Destino hotel = new Destino();
                hotel.destino = rs.getString("nombre_avion");
                hotel.nombreHotel = rs.getString("nombre_destino");
                hotel.movilidad = rs.getString("nombre_origen");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelesDisponibles;
	}
	
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	

	
	
	
	
}
