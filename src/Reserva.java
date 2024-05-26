import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Reserva implements Usedb {

	Destino destino;
	Pasajero pasajero;
	public double precio;
	

	public void generarTicketReserva(Pasajero pasajero, Destino destino) {
	    LinkedList<Destino> hotelesDisponibles = obtenerHotelesDisponibles(hotelesDisponibles);
	    Destino hotelSeleccionado = seleccionarHotel(hotelesDisponibles);

	    if (hotelSeleccionado != null) {

	    	String contenidoTicket = generarContenidoTicketHotel(hotelSeleccionado, destino, pasajero);
	        JOptionPane.showMessageDialog(null, contenidoTicket, "Ticket de reserva de hotel", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(null, "No se seleccionó ningún hotel", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
	private Destino seleccionarHotel(LinkedList<Destino> hotelesDisponibles) {
	    String[] opcionesHotel = new String[hotelesDisponibles.size()];
	    for (int i = 0; i < hotelesDisponibles.size(); i++) {
	        opcionesHotel[i] = hotelesDisponibles.get(i).getNombreHotel();
	    }

	    int indiceHotelSeleccionado = JOptionPane.showOptionDialog(null, "Selecciona un hotel:", "Elegir hotel", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesHotel, opcionesHotel[0]);

	    if (indiceHotelSeleccionado != -1) {
	        return hotelesDisponibles.get(indiceHotelSeleccionado);
	    } else {
	        return null;
	    }
	}
	
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
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
