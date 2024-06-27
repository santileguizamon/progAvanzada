package test;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import principal.Destino;


public class CargarHotel extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
	    private JTable table;
	    private DefaultTableModel model;
	    private JLabel elemento;
	    private JButton Editar;
	    private Destino seleccionar;
	    private JTextField filtrar;
	private Destino destino = new Destino();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarHotel frame = new CargarHotel();
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
	public CargarHotel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	
	
	// Inicializar controlador y usuario seleccionado
    destino = new Destino();
    
 // Crear la tabla y el modelo
    String[] columnNames = {"destino", "nombre_hotel", "movilidad"};
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
    		JFrame frame = new JFrame("Agregar Hotel");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 200);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));
            
            JLabel lblDestino = new JLabel("Destino:");
            JTextField txtDestino = new JTextField();
            JLabel lblNombreHotel = new JLabel("Nombre Hotel:");
            JTextField txtNombreHotel = new JTextField();
            JLabel lblMovilidad = new JLabel("Movilidad:");
            JTextField txtMovilidad = new JTextField();
            panel.add(lblDestino);
            panel.add(txtDestino);
            panel.add(lblNombreHotel);
            panel.add(txtNombreHotel);
            panel.add(lblMovilidad);
            panel.add(txtMovilidad);

            JButton btnAceptar = new JButton("Aceptar");
            btnAceptar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String destino = txtDestino.getText();
                    String nombreHotel = txtNombreHotel.getText();
                    String movilidad = txtMovilidad.getText();
                    Destino newDestino = new Destino(destino, nombreHotel, movilidad);
                    newDestino.insertarHotelEnBD(newDestino);
                    actualizarTabla();
                    frame.dispose();
                }
            });
            panel.add(btnAceptar);
            frame.getContentPane().add(panel);
            frame.setVisible(true);
        }
    });
    btnAgregar.setBounds(187, 280, 187, 58);
    contentPane.add(btnAgregar);
    
    Editar = new JButton("Editar");
    Editar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		int selectedRow = table.getSelectedRow();
            if (selectedRow!= -1) {
                int id = (int) table.getValueAt(selectedRow, 0);
                String destino = (String) table.getValueAt(selectedRow, 1);
                String nombreHotel = (String) table.getValueAt(selectedRow, 2);
                String movilidad = (String) table.getValueAt(selectedRow, 3);

                JFrame frame = new JFrame("Editar Hotel");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(300, 200);
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 2));

                JLabel lblDestino = new JLabel("Destino:");
                JTextField txtDestino = new JTextField(destino);
                JLabel lblNombreHotel = new JLabel("Nombre Hotel:");
                JTextField txtNombreHotel = new JTextField(nombreHotel);
                JLabel lblMovilidad = new JLabel("Movilidad:");
                JTextField txtMovilidad = new JTextField(movilidad);

                panel.add(lblDestino);
                panel.add(txtDestino);
                panel.add(lblNombreHotel);
                panel.add(txtNombreHotel);
                panel.add(lblMovilidad);
                panel.add(txtMovilidad);
                
                JButton btnAceptar = new JButton("Aceptar");
                btnAceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String updatedDestino = txtDestino.getText();
                        String updatedNombreHotel = txtNombreHotel.getText();
                        String updatedMovilidad = txtMovilidad.getText();

                        Destino.updateDestino(id, updatedDestino, updatedNombreHotel, updatedMovilidad);
                        actualizarTabla();
                        frame.dispose();
                    }
                });
                panel.add(btnAceptar);
                frame.getContentPane().add(panel);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un hotel");
            }       	
    	}
    });
    Editar.setBounds(581, 280, 166, 58);
    contentPane.add(Editar);
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.setBounds(23, 380, 101, 22);
    contentPane.add(menuBar);
   

    // Crear el botón de eliminar
    
    
    filtrar = new JTextField();
    filtrar.setBounds(15, 316, 86, 20);
    contentPane.add(filtrar);
    filtrar.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("Criterio");
    lblNewLabel.setBounds(127, 319, 62, 14);
    contentPane.add(lblNewLabel);
    
    JButton filtrar = new JButton("Filtrar");
    filtrar.setBounds(185, 141, 89, 23);
    contentPane.add(filtrar);
    filtrar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {       		
    		Filtrar(filtrar.getText());       		
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
                    String destino = (String) table.getValueAt(selectedRow, 0);
                    String hotel = (String) table.getValueAt(selectedRow, 1);
                    String movilidad = (String) table.getValueAt(selectedRow, 2);
                    
                    elemento.setText("Seleccionado: Destino=" + destino + ", Nombre Hotel=" + hotel + ", Movilidad=" + movilidad);
                    
                }
            }
        }
    });
    
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		
			if (seleccionar.getNombreHotel()!=null) {
				
    			Destino.deleteDestino(seleccionar.getNombreHotel());
    			JOptionPane.showMessageDialog(null, "Elimnado");
    			 actualizarTabla();
			} else {
				JOptionPane.showMessageDialog(null, "Seleccione un hotel");
			}
    		
    		
    		
    	}
    });
}
	

	private void actualizarTabla() {
    // Limpiar el modelo de la tabla
    model.setRowCount(0);

    // Obtener la lista actualizada de usuarios
    List<Destino> destinos = destino.getAllDestinos();

    // Agregar los datos al modelo
    for (Destino destino : destinos) {
        model.addRow(
        		new Object[]
        				{
        						destino.getDestino(),
        						destino.getNombreHotel(),
        						destino.getMovilidad(),
        						}
        		);
    	}
	}

	private void Filtrar(String criterio) {
        // Limpiar el modelo de la tabla
        model.setRowCount(0);

        // Obtener la lista actualizada de productos
        List<Destino> destinos = destino.getAllDestinos();

        // Agregar los datos al modelo
        for (Destino destino : destinos) {
        	if(destino.getDestino().contains(criterio)) {
                model.addRow(new Object[]{destino.getDestino(), destino.getNombreHotel(), destino.getMovilidad()});
        	}
        }
    }
    

}
