package test;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import principal.Destino;
import principal.Vuelo;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class CargarVuelo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JLabel elemento;
    private JButton Editar;
    private Vuelo seleccionar;
    private JTextField filtrar;
    private Vuelo vuelo = new Vuelo();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarVuelo frame = new CargarVuelo();
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
    public CargarVuelo() {
    	this.setVisible(true);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        // Inicializar controlador y usuario seleccionado
        vuelo = new Vuelo();
       

        // Crear la tabla y el modelo
        String[] columnNames = {"nombreAvion", "nombreDestino", "nombreOrigen","fecha", "horarioSalida", "horarioLlegada"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();
        contentPane.setLayout(null);

        // Crear el JScrollPane y agregar la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 19, 911, 190);
        contentPane.add(scrollPane);

        // Crear el JLabel para mostrar la selección
        elemento = new JLabel("Seleccionado:");
        elemento.setBounds(5, 5, 911, 14);
        contentPane.add(elemento);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame frame = new JFrame("Agregar Vuelo");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(300, 200);
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 2));
                
                JLabel lblAvion = new JLabel("Nombre Avion:");
                JTextField txtAvion = new JTextField();
                JLabel lblNombreDestino = new JLabel("Destino:");
                JTextField txtNombreDestino = new JTextField();
                JLabel lblOrigen = new JLabel("Origen:");
                JTextField txtOrigen = new JTextField();
                JLabel lblFecha = new JLabel("Fecha:");
                JTextField txtFecha = new JTextField();
                JLabel lblSalida = new JLabel("Horario de salida:");
                JTextField txtSalida = new JTextField();
                JLabel lblLlegada = new JLabel("Horario de llegada:");
                JTextField txtLlegada = new JTextField();
                panel.add(lblAvion);
                panel.add(txtAvion);
                panel.add(lblNombreDestino);
                panel.add(txtNombreDestino);
                panel.add(lblOrigen);
                panel.add(txtOrigen);
                panel.add(lblFecha);
                panel.add(txtFecha);
                panel.add(lblSalida);
                panel.add(txtSalida);
                panel.add(lblLlegada);
                panel.add(txtLlegada);
                
                JButton btnAceptar = new JButton("Aceptar");
                btnAceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    	
                        String avion = txtAvion.getText();
                        String destino = txtNombreDestino.getText();
                        String origen = txtNombreDestino.getText();
                        Date fecha = null;
						try {
							fecha = dateFormat.parse(txtFecha.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        Time salida = null;
						try {
							salida = (Time) timeFormat.parse(txtSalida.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        Time llegada = null;
						try {
							llegada = (Time) timeFormat.parse(txtLlegada.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        Vuelo newVuelo = new Vuelo(avion, destino, origen, fecha, salida, llegada);
                        newVuelo.insertarVueloEnBD(newVuelo);
                        actualizarTabla();
                        frame.dispose();
                    }
                });
                panel.add(btnAceptar);
                frame.getContentPane().add(panel);
                frame.setVisible(true);
       
        	}
        });
        btnAgregar.setBounds(214, 293, 187, 58);
        contentPane.add(btnAgregar);
        
        Editar = new JButton("Editar");
        Editar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int selectedRow = table.getSelectedRow();
                if (selectedRow!= -1) {
                	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    
                    String nombreAvion = (String) table.getValueAt(selectedRow, 0);
                    String nombreDestino = (String) table.getValueAt(selectedRow, 1);
                    String nombreOrigen = (String) table.getValueAt(selectedRow, 2);
                    Date fecha = (Date) table.getValueAt(selectedRow, 3);
                    Time horarioSalida = (Time) table.getValueAt(selectedRow, 4);
                    Time horarioLlegada = (Time) table.getValueAt(selectedRow, 5);

                    JFrame frame = new JFrame("Editar Vuelo");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(300, 200);
                    JPanel panel = new JPanel();
                    panel.setLayout(getLayout());

                    JLabel lblAvion = new JLabel("Nombre Avion:");
                    JTextField txtAvion = new JTextField(nombreAvion);
                    JLabel lblNombreDestino = new JLabel("Destino:");
                    JTextField txtNombreDestino = new JTextField(nombreDestino);
                    JLabel lblOrigen = new JLabel("Origen:");
                    JTextField txtOrigen = new JTextField(nombreOrigen);
                    JLabel lblFecha = new JLabel("Fecha:");
                    JTextField txtFecha = new JTextField(fecha.toGMTString());
                    JLabel lblSalida = new JLabel("Horario de salida:");
                    JTextField txtSalida = new JTextField(horarioSalida.toGMTString());
                    JLabel lblLlegada = new JLabel("Horario de llegada:");
                    JTextField txtLlegada = new JTextField(horarioLlegada.toGMTString());
                    panel.add(lblAvion);
                    panel.add(txtAvion);
                    panel.add(lblNombreDestino);
                    panel.add(txtNombreDestino);
                    panel.add(lblOrigen);
                    panel.add(txtOrigen);
                    panel.add(lblFecha);
                    panel.add(txtFecha);
                    panel.add(lblSalida);
                    panel.add(txtSalida);
                    panel.add(lblLlegada);
                    panel.add(txtLlegada);
                    
                    JButton btnAceptar = new JButton("Aceptar");
                    btnAceptar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        	
                            String updatedAvion = txtAvion.getText();
                            String updatedNombreDestino = txtNombreDestino.getText();
                            String updatedOrigen = txtOrigen.getText();
                            Date updatedFecha = null;
    						try {
    							updatedFecha = dateFormat.parse(txtFecha.getText());
    						} catch (ParseException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						}
                            Time updatedHorarioSalida = null;
    						try {
    							updatedHorarioSalida = (Time) timeFormat.parse(txtSalida.getText());
    						} catch (ParseException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						}
                            Time updatedHorarioLlegada = null;
    						try {
    							updatedHorarioLlegada = (Time) timeFormat.parse(txtLlegada.getText());
    						} catch (ParseException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						}
    						
                            Vuelo.updatedVuelo(updatedAvion, updatedNombreDestino, updatedOrigen,updatedFecha, updatedHorarioSalida, updatedHorarioLlegada );
                            actualizarTabla();
                            frame.dispose();
                        }
                    });
                    panel.add(btnAceptar);
                    frame.getContentPane().add(panel);
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un Vuelo");
                }       	
        		
        		
        	}
        });
        Editar.setBounds(470, 293, 166, 58);
        contentPane.add(Editar);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(23, 380, 101, 22);
        contentPane.add(menuBar);
        
        filtrar = new JTextField();
        filtrar.setBounds(25, 235, 86, 20);
        contentPane.add(filtrar);
        filtrar.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Criterio");
        lblNewLabel.setBounds(26, 220, 62, 14);
        contentPane.add(lblNewLabel);
        
        
        
        JButton filtro = new JButton("Filtrar");
        filtro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Filtrar(filtrar.getText());
        	}
        });
        filtro.setBounds(118, 234, 89, 23);
        contentPane.add(filtro);
        
       

        // Crear el botón de eliminar
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {      		
    			if (seleccionar.getNombreAvion()!=null) {
    				
        			Vuelo.deleteDestino(seleccionar.getNombreAvion());
        			JOptionPane.showMessageDialog(null, "Elimnado");
        			 actualizarTabla();
    			} else {
    				JOptionPane.showMessageDialog(null, "Seleccione un hotel");
    			}        		
        	}
        });
       
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
                        String nombreAvion = (String) table.getValueAt(selectedRow, 0);
                        String nombreDestino = (String) table.getValueAt(selectedRow, 1);
                        String nombreOrigen = (String) table.getValueAt(selectedRow, 2);
                        Date fecha = (Date) table.getValueAt(selectedRow, 3);
                        Time horarioSalida = (Time) table.getValueAt(selectedRow, 4);
                        Time horarioLlegada = (Time) table.getValueAt(selectedRow, 5);
                        
                        
                    }
                }
            }
        });
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
}