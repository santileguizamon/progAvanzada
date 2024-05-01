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
				JOptionPane.showMessageDialog(null, "Aqui se da la posibilidad de buscar vuelos y crear el pasaje");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Aqui se da la posibilidad de buscar hoteles en el destino y crear la reserva");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "El gerente tiene la capacidad de agregar vuelos");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "El gerente tiene la capacidad de agregar hoteles");
				break;
			}
		}while(opcion!=3 && opcion!=4); 
	}
	
}
