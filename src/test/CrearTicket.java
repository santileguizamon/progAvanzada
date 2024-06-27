package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import principal.Vuelo;

import javax.swing.JTable;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class CrearTicket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDni;
	private JTextField filtrar;
	private JButton Editar;
	private Vuelo vuelo = new Vuelo();
	 private DefaultTableModel model;
	private JLabel informacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearTicket frame = new CrearTicket();
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
	public CrearTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columnNames = {"nombreAvion", "nombreDestino", "nombreOrigen","fecha", "horarioSalida", "horarioLlegada"};
	    model = new DefaultTableModel(columnNames, 0);
		table = new JTable();
		actualizarTabla();
		table.setBackground(new Color(226, 226, 226));
		table.setBounds(42, 38, 649, 100);
		contentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(new Color(0, 0, 0));
		scrollBar.setForeground(new Color(192, 192, 192));
		scrollBar.setBounds(674, 38, 17, 100);
		contentPane.add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("PASAJES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(306, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(52, 173, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(206, 173, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setBounds(362, 173, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textNombre = new JTextField();
		textNombre.setBounds(52, 189, 106, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(206, 189, 106, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textDni = new JTextField();
		textDni.setBounds(362, 189, 106, 20);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		JComboBox boxAsientos = new JComboBox();
		boxAsientos.setMaximumRowCount(20);
		boxAsientos.setBounds(531, 188, 46, 22);
		contentPane.add(boxAsientos);
		
		JLabel lblNewLabel_4 = new JLabel("Asiento:");
		lblNewLabel_4.setBounds(531, 173, 46, 14);
		contentPane.add(lblNewLabel_4);
        
        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		agregarPasaje();
        	}
        });
        
        agregarBtn.setBounds(583, 273, 89, 23);
        contentPane.add(agregarBtn);
        
        JButton guardarBtn = new JButton("Guardar");
        guardarBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		guardarVenta();
        	}
        });
        guardarBtn.setBounds(583, 307, 89, 23);
        contentPane.add(guardarBtn);
        
        
        
        
        
        filtrar = new JTextField();
        filtrar.setBounds(89, 142, 86, 20);
        contentPane.add(filtrar);
        filtrar.setColumns(10);
        
        JLabel criterio = new JLabel("Criterio");
        criterio.setBounds(52, 145, 62, 14);
        contentPane.add(criterio);
        
        JButton filtrar = new JButton("Filtrar");
        filtrar.setBounds(185, 141, 89, 23);
        contentPane.add(filtrar);
        filtrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {       		
        		Filtrar(filtrar.getText());       		
        	}
        });
        
        
        Vuelo vueloPasaje = new Vuelo();
        
        

        JLabel informacion = new JLabel("New label");
        informacion.setBounds(42, 257, 520, 123);
        contentPane.add(informacion);
        
     // Configurar el modelo de selección
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Agregar un escuchador de selección
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String nombre = (String) table.getValueAt(selectedRow, 0);
                        String apellido = (String) table.getValueAt(selectedRow, 1);
                        String dni = (String) table.getValueAt(selectedRow, 2);
                        int asiento = (int) table.getValueAt(selectedRow, 3);
                        informacion.setText("Nombre:"+ nombre +"Apellido:"+ apellido + "Dni:"+ dni + "Asiento" + asiento);
                    }
                }
            }
        });
}
	 private void Filtrar(String criterio) {
	        // Limpiar el modelo de la tabla
	        model.setRowCount(0);

	        // Obtener la lista actualizada de productos
	        List<Vuelo> vuelos = vuelo.getAllVuelos();

	        // Agregar los datos al modelo
	        for (Vuelo vuelo : vuelos) {
	        	if(vuelo.getNombreAvion().contains(criterio)) {
	                model.addRow(new Object[]{vuelo.getNombreAvion(), vuelo.getNombreDestino(), vuelo.getNombreOrigen(), vuelo.getFecha(), vuelo.getHorarioSalida(), vuelo.getHorarioLlegada()  });
	        	}
	        }
	    }
	 
	
	 private void actualizarTabla() {
	        // Limpiar el modelo de la tabla
	        model.setRowCount(0);

	        // Obtener la lista actualizada de usuarios
	        List<Vuelo> vuelos = vuelo.getAllVuelos();

	        // Agregar los datos al modelo
	        for (Vuelo vuelo : vuelos) {
	            model.addRow(
	            		new Object[]
	            				{
	            						vuelo.getNombreAvion(),
	            						vuelo.getNombreDestino(),
	            						vuelo.getNombreOrigen(),
	            						vuelo.getFecha(),
	            						vuelo.getHorarioSalida(),
	            						vuelo.getHorarioLlegada()
	            						
	            						}
	            		);
	        }
	 }
	 
	 private void agregarPasaje() {
		 	String nombre = textNombre.getText();
		    String apellido = textApellido.getText();
		    String dni = textDni.getText();
		    //int asiento = (int) boxAsientos.getSelectedItem();

		    
		   
			// Actualizar la información del ticket
		    informacion.setText("Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni + " Asiento: " );

		    // Limpiar los campos de texto
		    textNombre.setText("");
		    textApellido.setText("");
		    textDni.setText("");
		    //boxAsientos.setSelectedIndex(0);
	    }
	 private void guardarVenta() {

		    // Guardar la venta en la base de datos
		    try {
				vuelo.guardarTicket(vuelo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		    // Limpiar la venta actual
		    vuelo = new Vuelo();
			informacion.setText("");
	    }
	 
	 
}
