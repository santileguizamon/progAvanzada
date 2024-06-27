package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HomeGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public HomeGerente(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido"+ nombre);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNewLabel.setBounds(125, 11, 200, 28);
		contentPane.add(lblNewLabel);
		
		JButton botonCargarVuelo = new JButton("Cargar Vuelo");
		botonCargarVuelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCargarVuelo.setBounds(151, 50, 132, 23);
		contentPane.add(botonCargarVuelo);
		botonCargarVuelo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				CargarVuelo nuevo = new CargarVuelo();
				dispose();
				
			}
		});
		
		
		JButton botonCargarHotel = new JButton("Cargar Hotel");
		botonCargarHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarHotel hotel = new CargarHotel();
				dispose();
			}
		});
		botonCargarHotel.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCargarHotel.setBounds(151, 84, 132, 23);
		contentPane.add(botonCargarHotel);
		
		JButton botonCrearTicket = new JButton("Crear Ticket");
		botonCrearTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearTicket ticket = new CrearTicket();
				dispose();
			}
		});
		botonCrearTicket.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCrearTicket.setBounds(151, 118, 132, 23);
		contentPane.add(botonCrearTicket);
		
		JButton botonCrearReserva = new JButton("Crear Reserva");
		botonCrearReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearReserva reserva = new CrearReserva();
				dispose();
			}
		});
		botonCrearReserva.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCrearReserva.setBounds(151, 152, 132, 23);
		contentPane.add(botonCrearReserva);
		
		JButton botonCerrarSesion = new JButton("Cerrar sesion");
		botonCerrarSesion.setBounds(315, 216, 97, 23);
		contentPane.add(botonCerrarSesion);
		botonCerrarSesion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				PantallaInicio nuevo = new PantallaInicio();
				dispose();
				
			}
		});
	}
}
