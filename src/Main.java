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
				//crearReservaVuelo();
				break;
			case 1:
				//crearReservaVuelo();
				//crearReservaDestino();
				break;
				
			}
		}while(opcion!=1 && opcion!=2); 
	}
	
}
