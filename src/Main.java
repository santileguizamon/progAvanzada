import javax.swing.JOptionPane;

public class Main {

	public static void main (String [] args) {
		
		Empleado yo = new Empleado();
		Gerente el = new Gerente();
		
		String menu[] = {"Crear pasaje","Crear Reserva","Agregar vuelos","Agregar hoteles"};
		int opcion= 0;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccione la opcion a realizar", null, 0, 0, null, menu, menu[0]);
			switch (opcion) {
			case 0: 
				yo.pasaje.generarTicketVuelo();
				break;
			case 1:
				yo.reserva.generarTicketReserva();
				break;
			case 2:
				el.vuelo.crearVuelo(null);
				break;
			case 3:
				el.destino.crearHotel();
				break;
			}
		}while(opcion!=3 && opcion!=4); 
	}
	
}
