import javax.swing.JOptionPane;

public class Destino {

	public String destino;
	public String nombreHotel;
	public String movilidad;
	
	
	
	public void crearHotel() {
		this.destino = JOptionPane.showInputDialog(null,"Ingrese el nombre del hotel:");
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
