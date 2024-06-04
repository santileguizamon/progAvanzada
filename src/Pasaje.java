import javax.swing.*;

import java.sql.*;

import java.util.LinkedList;


public class Pasaje {

    private String nombre;
    private String apellido;
    private String documento;
    private Vuelo vuelo;
    private String puertaEmbarque;
    private String asiento;
    private double precio;


    public void generarTicketVuelo() {

        LinkedList<Vuelo> vuelos = obtenerVuelos();
        if (vuelos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vuelos disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String vuelosInfo = "";

        for (int i = 0; i < vuelos.size(); i++) {
            vuelosInfo += (i + 1) + ". Nombre del avión: " + vuelos.get(i).getNombreAvion() + "\n";
            vuelosInfo += "Nombre del destino: " + vuelos.get(i).getNombreDestino() + "\n";
            vuelosInfo += "Horario de salida: " + vuelos.get(i).getHorarioSalida() + "\n";
            vuelosInfo += "Horario de llegada: " + vuelos.get(i).getHorarioLlegada() + "\n";
            vuelosInfo += "Fecha: " + vuelos.get(i).getFecha() + "\n\n";
        }

        String seleccionStr = JOptionPane.showInputDialog(null, "Selecciona un vuelo:\n" + vuelosInfo, "Vuelos disponibles", JOptionPane.QUESTION_MESSAGE);
        if (seleccionStr == null || seleccionStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selección inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int seleccion;
        try {
            seleccion = Integer.parseInt(seleccionStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Selección inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (seleccion > 0 && seleccion <= vuelos.size()) {
            vuelo = vuelos.get(seleccion - 1);
            nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            apellido = JOptionPane.showInputDialog(null, "Ingresa tu apellido:");
            if (apellido == null || apellido.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            documento = JOptionPane.showInputDialog(null, "Ingresa tu número de documento:");
            if (documento == null || documento.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El documento no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            puertaEmbarque = "Puerta " + (int) (Math.random() * 10 + 1);
            asiento = "Asiento " + (int) (Math.random() * 100 + 1);
            precio = 1000.0;

            String informacionTicket = "Nombre: " + nombre + "\n" +
                    "Apellido: " + apellido + "\n" +
                    "Documento: " + documento + "\n" +
                    "Datos del vuelo: " + vuelo + "\n" +
                    "Puerta de embarque: " + puertaEmbarque + "\n" +
                    "Asiento: " + asiento + "\n" +
                    "Precio final: " + precio + "\n";
            JOptionPane.showMessageDialog(null, informacionTicket, "Ticket de vuelo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Selección inválida", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private LinkedList<Vuelo> obtenerVuelos() {
        LinkedList<Vuelo> vuelos = new LinkedList<>();

        try {
            Connection conn = (Connection) Conexion.getInstance();
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vuelos");
            while (rs.next()) {
                vuelo.nombreAvion = rs.getString("nombre_avion");
                vuelo.nombreDestino = rs.getString("nombre_destino");
                vuelo.nombreOrigen = rs.getString("nombre_origen");
                vuelo.horarioSalida = rs.getTime("horario_salida");
                vuelo.horarioLlegada = rs.getTime("horario_llegada");
                vuelo.fecha = rs.getDate("fecha");
                vuelos.add(vuelo);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vuelos;
    }


	

    
	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public String getPuertaEmbarque() {
		return puertaEmbarque;
	}

	public void setPuertaEmbarque(String puertaEmbarque) {
		this.puertaEmbarque = puertaEmbarque;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
