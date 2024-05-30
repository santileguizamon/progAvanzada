import java.util.LinkedList;

public interface Usedb {
	
	void addVuelo(Vuelo nombreAvion);
	void addDestino(Vuelo nombreDestino);
	void addOrigen(Vuelo nombreOrigen);
	void addHorario(Vuelo horarioSalidaLlegada);
	void addFecha(Vuelo fecha);
	void obtenerVuelos(LinkedList<Vuelo> vuelos);
	void addhotelesDisponibles(LinkedList<Destino>destino);
	
	
}
