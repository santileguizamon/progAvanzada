package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test.HomeEmpleado;
import test.HomeGerente;
import principal.Usuario;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField inputNombre;
	private JPasswordField inputContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaInicio() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 317);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Inicio de sesion");
		lblNewLabel.setBounds(168, 23, 126, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		inputNombre = new JTextField();
		inputNombre.setBounds(135, 73, 189, 29);
		contentPane.add(inputNombre);
		inputNombre.setColumns(10);
		
		inputContraseña = new JPasswordField();
		inputContraseña.setBounds(135, 144, 189, 29);
		contentPane.add(inputContraseña);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(135, 54, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel errorNombre = new JLabel("Nombre incorrecto");
		errorNombre.setForeground(new Color(255, 0, 0));
		errorNombre.setBounds(135, 102, 94, 14);
		errorNombre.setVisible(false);
		contentPane.add(errorNombre);
						
		JLabel lblError = new JLabel("");
		lblError.setBounds(50, 236, 208, 28);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1_1.setBounds(135, 127, 94, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel errorContraseña = new JLabel("Contraseña incorrecto");
		errorContraseña.setForeground(Color.RED);
		errorContraseña.setBounds(135, 173, 126, 14);
		errorContraseña.setVisible(false);	
		contentPane.add(errorContraseña);
		
		JButton botonIngresar = new JButton("Ingresar");
		botonIngresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonIngresar.setBounds(182, 198, 89, 23);
		contentPane.add(botonIngresar);
		botonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String respuesta = Usuario.IniciarSesion(inputNombre.getText(), inputContraseña.getText());
				 if(respuesta.equals("1")) {
					 
					 HomeGerente homeGerente = new HomeGerente(inputNombre.getText());
					 homeGerente.setVisible(true);
					 dispose();
				 }else if(respuesta.equals("2")) {
					 
					 HomeEmpleado homeEmpleado = new HomeEmpleado(inputNombre.getText());
					 homeEmpleado.setVisible(true); 
					 dispose();
				 }{
					 lblError.setText(respuesta);
					lblError.setVisible(true);

				 }
		        
			}
		});
		
		JButton botonRegistro = new JButton("Registro");
		botonRegistro.setBounds(182, 232, 89, 23);
		contentPane.add(botonRegistro);
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro registro = new Registro();
				registro.setVisible(true);
				dispose();
			}
		});
	}
}

