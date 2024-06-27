package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import principal.Destino;
import principal.Pasaje;
import principal.Vuelo;

public class CrearReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField;
	private Destino destino = new Destino();
	private JTextField filtro;
	private List<Pasaje> listaPasajes = new ArrayList<Pasaje>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearReserva frame = new CrearReserva();
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
	public CrearReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columnNames = {"nombreHotel", "nombreDestino", "movilidad"};
	    model = new DefaultTableModel(columnNames, 0);
		table = new JTable();
		table.setBounds(31, 11, 365, 125);
		contentPane.add(table);
		
		
		filtro = new JTextField();
        filtro.setBounds(98, 142, 86, 20);
        contentPane.add(filtro);
        filtro.setColumns(10);
		
        JLabel criterio = new JLabel("Criterio");
        criterio.setBounds(52, 145, 62, 14);
        contentPane.add(criterio);
        
        JButton filtrar = new JButton("Filtrar");
        filtrar.setBounds(185, 141, 89, 23);
        contentPane.add(filtrar);
        filtrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {       		
        		Filtrar(filtro.getText());       		
        	}
        });
        
        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		agregarPasaje();
        	}
        });
        
        
        Destino destino = new Destino();
        
        JLabel informacion = new JLabel("New label");
        informacion.setBounds(52, 186, 247, 64);
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
                        String destino = (String) table.getValueAt(selectedRow, 0);
                        String hotel = (String) table.getValueAt(selectedRow, 1);
                        String movilidad = (String) table.getValueAt(selectedRow, 2);
   
                        informacion.setText("Nombre Destino:"+ destino +"Nombre Hotel:"+ hotel + "Movilidad:"+ movilidad);
                    }
                }
            }
        });
 }
	 private void Filtrar(String criterio) {
	        // Limpiar el modelo de la tabla
	        model.setRowCount(0);

	        // Obtener la lista actualizada de productos
	        List<Destino> destinos = destino.getAllDestinos();

	        // Agregar los datos al modelo
	        for (Destino destino : destinos) {
	        	if(destino.getNombreHotel().contains(criterio)) {
	                model.addRow(new Object[]{destino.getDestino(), destino.getNombreHotel(), destino.getMovilidad() });
	        	}
	        }
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
	            						destino.getMovilidad()
	            				}
	            		);
	        }
	 }
	 
	 private void agregarPasaje() {
		 int selectedRow = table.getSelectedRow();
		    
			if (selectedRow!= -1) {
		        String nombreDestino = (String) table.getValueAt(selectedRow, 0);
		        String nombreHotel = (String) table.getValueAt(selectedRow, 1);
		        String movilidad = (String) table.getValueAt(selectedRow, 2);
		        
		        Pasaje pasaje = new Pasaje(nombreDestino, nombreHotel, movilidad);

		        listaPasajes.add(pasaje);
		        JLabel informacion ;
		        informacion.setText("Pasaje agregado: " + nombreHotel + " en " + nombreDestino + " con movilidad " + movilidad);
		    } else {
		    	JLabel informacion ;
		        informacion.setText("Seleccione un hotel de la tabla");
		    }
		}


		

	 
}
