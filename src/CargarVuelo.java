
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Test;

public class CargarVuelo {
	
@Test
public void testCrearVuelo(){
	
		Vuelo vuelo = new Vuelo(null, null, null, null, null, null);
    String nombreAvion = "B747";
    String nombreDestino = "New York";
    String nombreOrigen = "Madrid";
    String fechaString = "10/12/2022";
    String horaSalidaString = "12:00";
    String horaLlegadaString = "15:00";

    vuelo.crearVuelo(connection,nombreAvion, nombreDestino, nombreOrigen, fechaString, horaSalidaString, horaLlegadaString);

    
    assertEquals(nombreAvion, vuelo.getNombreAvion());
    assertEquals(nombreDestino, vuelo.getNombreDestino());
    assertEquals(nombreOrigen, vuelo.getNombreOrigen());
    assertEquals(fechaString, new SimpleDateFormat("dd/MM/yyyy").format(vuelo.getFecha()));
    assertEquals(horaSalidaString, new SimpleDateFormat("HH:mm").format(vuelo.getHorarioSalida()));
    assertEquals(horaLlegadaString, new SimpleDateFormat("HH:mm").format(vuelo.getHorarioLlegada()));
}




}
