package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import principal.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField ingresoUsuario;
	private JLabel lblNewLabel_2;
	private JTextField ingresoContraseña;
	private JLabel lblNewLabel_3;
	private JTextField ingresoRol;
	private JLabel lblNewLabel_4;

	
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("REGISTRATE");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel.setBounds(210, 25, 97, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre de usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(140, 66, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		ingresoUsuario = new JTextField();
		ingresoUsuario.setBounds(140, 81, 222, 26);
		contentPane.add(ingresoUsuario);
		ingresoUsuario.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Contraseña:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(140, 139, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		ingresoContraseña = new JTextField();
		ingresoContraseña.setBounds(140, 156, 222, 26);
		contentPane.add(ingresoContraseña);
		ingresoContraseña.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Rol:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(140, 213, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		ingresoRol = new JTextField();
		ingresoRol.setBounds(140, 228, 222, 26);
		contentPane.add(ingresoRol);
		ingresoRol.setColumns(10);
		
		lblNewLabel_4 = new JLabel("1- Administrador     2- Empleado");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_4.setBounds(180, 256, 182, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblError.setBounds(10, 414, 389, 75);
		contentPane.add(lblError);
		
		JButton botonRegistro = new JButton("Enviar");
		botonRegistro.setBounds(210, 291, 89, 23);
		contentPane.add(botonRegistro);
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String respuesta = Usuario.Registrarse(ingresoUsuario.getText(),ingresoContraseña.getText() );
				 if(respuesta.equals("Ok")) {
					 HomeGerente home = new HomeGerente(ingresoUsuario.getText());
					 dispose();
				 }else {
					 lblError.setText(respuesta);
						lblError.setVisible(true);

				 }
				}
				
			
		});
		
	}
}
