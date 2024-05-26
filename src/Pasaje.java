import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class Pasaje implements Usedb {

	Vuelo vuelo;
	Pasajero pasajero;
	public String puertaEmbarque;
	public String asiento;
	public double precio;
	
	
	public void mostrarTicketVuelo() {

        LinkedList<Vuelo> vuelos = obtenerVuelos(vuelos);

        String vuelosInfo = "";
        for (Vuelo vuelo : vuelos) {
            vuelosInfo += "Nombre del avión: " + vuelo.getNombreAvion() + "\n";
            vuelosInfo += "Nombre del destino: " + vuelo.getNombreDestino() + "\n";
            vuelosInfo += "Horario de salida: " + vuelo.getHorarioSalida() + "\n";
            vuelosInfo += "Horario de llegada: " + vuelo.getHorarioLlegada() + "\n";
            vuelosInfo += "Fecha" + vuelo.getFecha() + "\n\n";
            }

        int seleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona un vuelo:\n" + vuelosInfo, "Vuelos disponibles", JOptionPane.QUESTION_MESSAGE, null, null, "0"));

        if (seleccion > 0 && seleccion <= vuelos.size()) {
            Vuelo vueloSeleccionado = vuelos.get(seleccion - 1);
            String nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:");
            String apellido = JOptionPane.showInputDialog(null, "Ingresa tu apellido:");
            String documento = JOptionPane.showInputDialog(null, "Ingresa tu número de documento:");
            Ticket ticket = new Ticket(nombre, apellido, documento, vueloSeleccionado);
            JOptionPane.showMessageDialog(null, ticket.getInformacionTicket(), "Ticket de vuelo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

	
	
	class Ticket {
	    private String nombre;
	    private String apellido;
	    private String documento;
	    private Vuelo vuelo;
	    private String puertaEmbarque;
		private String asiento;
		private double precio;


	    public Ticket(String nombre, String apellido, String documento, Vuelo vuelo) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.documento = documento;
	        this.vuelo = vuelo;
	    }

	    public String getInformacionTicket() {
	        return "Nombre: " + nombre + "\n" +
	               "Apellido: " + apellido + "\n" +
	               "Documento: " + documento + "\n" +
	               "Datos del vuelo: " + vuelo + "\n"+
	               "Puerta de embarque" + puertaEmbarque + "\n" +
	               "Asiento: " + asiento + "\n" +
	               "Precio final:" + precio + "\n";
	        }
	                      
		
	    public LinkedList<Vuelo> obtenerVuelos() {

	        LinkedList<Vuelo> vuelos = new LinkedList<>();
	        String url = "jdbc:mysql://localhost:3306/aerolinea";
	        String user = "";
	        String password = "";
	        try {
	            Connection conn = DriverManager.getConnection(url, user, password);
	            Statement stmt = (Statement) conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM vuelos");

	            while (rs.next()) {
	                Vuelo vuelo = new Vuelo();
	                vuelo.nombreAvion = rs.getString("nombre_avion");
	                vuelo.nombreDestino = rs.getString("nombre_destino");
	                vuelo.nombreOrigen = rs.getString("nombre_origen");
	                vuelo.horarioSalida = rs.getDate("horario_salida");
	                vuelo.horarioLlegada = rs.getDate("horario_llegada");
	                vuelo.fecha = rs.getDate("fecha");
	                vuelos.add(vuelo);
	            }
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return vuelos;
	    }
	

    
	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public String getPuertaEmbarque() {
		return puertaEmbarque;
	}

	public void setPuertaEmbarque(String puertaEmbarque) {
		this.puertaEmbarque = puertaEmbarque;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public void addVuelo(Vuelo nombreAvion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDestino(Vuelo nombreDestino) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrigen(Vuelo nombreOrigen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHorario(Vuelo horarioSalidaLlegada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFecha(Vuelo fecha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtenerVuelos(LinkedList<Vuelo> vuelos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtenerHotelesDisponibles(LinkedList<Destino> destino) {
		// TODO Auto-generated method stub
		
	}




	
}



	@Override
	public void addVuelo(Vuelo nombreAvion) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addDestino(Vuelo nombreDestino) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addOrigen(Vuelo nombreOrigen) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addHorario(Vuelo horarioSalidaLlegada) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addFecha(Vuelo fecha) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void obtenerVuelos(LinkedList<Vuelo> vuelos) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void obtenerHotelesDisponibles(LinkedList<Destino> destino) {
		// TODO Auto-generated method stub
		
	}
