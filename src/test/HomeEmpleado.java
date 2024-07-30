package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public HomeEmpleado(String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(132, 35, 193, 14);
		contentPane.add(lblNewLabel);
		
		JButton pasajeBtn = new JButton("Crear Ticket");
		pasajeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearTicket ticket = new CrearTicket();
				dispose();
			}
		});
		pasajeBtn.setBounds(89, 90, 110, 23);
		contentPane.add(pasajeBtn);
		
		JButton reservaBtn = new JButton("Crear Reserva");
		reservaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearReserva reserva = new CrearReserva();
				dispose();
			}
		});
		reservaBtn.setBounds(215, 90, 110, 23);
		contentPane.add(reservaBtn);
		
		JButton botonCerrarSesion = new JButton("Cerrar sesion");
		botonCerrarSesion.setBounds(315, 216, 97, 23);
		contentPane.add(botonCerrarSesion);
		
		JButton btnNewButton = new JButton("Ver Vuelos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(89, 134, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver Hoteles");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(215, 134, 110, 23);
		contentPane.add(btnNewButton_1);
		botonCerrarSesion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				PantallaInicio nuevo = new PantallaInicio();
				dispose();
				
			}
		});
	}
}
