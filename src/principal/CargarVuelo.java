package principal;

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

    assertEquals(vuelo.crearVuelo(nombreAvion, nombreDestino, nombreOrigen, fechaString, horaSalidaString, horaLlegadaString),true);
    
    

    
   
}




}
