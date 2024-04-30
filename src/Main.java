import javax.swing.JOptionPane;

public class Main {

	public static void main (String [] args) {
		
		Empleado yo = new Empleado();
		
		String menu[] = {"Buscar vuelos","Crear paquete"};
		int opcion= 0;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccione la opcion a realizar", null, 0, 0, null, menu, menu[0]);
			switch (opcion) {
			case 0: 
				//crearReservaVuelo(); su funcion seria buscar un vuelo, seleccionarlo, y crear la reserva del vuelo en donde esta devuelve un ticket con la info necesaria
				break;
			case 1:
				//crearReservaVuelo(); lo mismo que la de arriba 
				//crearReservaDestino(); busca un hotel en el destino seleccionado y crea una reserva con su ticket
				break;
				
			}
		}while(opcion!=1 && opcion!=2); 
	}
	
}
