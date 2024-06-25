package principal;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;

import org.junit.Test;

public class CrearPasaje {

	 private static final String nombre_avion = "Boeing 737";
	    private static final String nombre_destino = "Buenos Aires";
	    private static final String nombre_origen = "Córdoba";
	    private static final Time horario_salida = (Time) new Date(122, 5, 29, 10, 0, 0);
	    private static final Time horario_llegada = (Time) new Date(122, 5, 29, 15, 0, 0);
	    private static final Date fecha = new Date(122, 5, 29);

	    private Vuelo vuelo;
	    private LinkedList<Vuelo> vuelos;
	    
	   public void agregar() {
	        vuelo = new Vuelo(nombre_avion, nombre_destino, nombre_origen, horario_salida, horario_llegada, (Time) fecha);
	        vuelos = new LinkedList<>();
	        vuelos.add(vuelo);
	        }
	@Test
	public String testCrearPasaje(LinkedList<Vuelo> vuelos, int seleccion){
		String nombre = "Juan";
        String apellido = "Perez";
        String documento = "12345678";
        
        String informacionTicket = "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Documento: " + documento + "\n" +
                "Datos del vuelo: " + vuelo + "\n" +
                "Puerta de embarque: " + "Puerta " + (int) (Math.random() * 10 + 1) + "\n" +
                "Asiento: " + "Asiento " + (int) (Math.random() * 100 + 1) + "\n" +
                "Precio final: " + 1000.0 + "\n";

        return informacionTicket;
		
		
	}
	
}
