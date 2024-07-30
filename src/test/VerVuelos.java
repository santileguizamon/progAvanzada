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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VerVuelos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField filtro;
	private DefaultTableModel model;
	private Vuelo vuelo = new Vuelo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerVuelos frame = new VerVuelos();
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
	public VerVuelos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		vuelo = new Vuelo();
		
		String[] columnNames = {"nombreAvion", "nombreDestino", "nombreOrigen","fecha", "horarioSalida", "horarioLlegada"};
	    model = new DefaultTableModel(columnNames, 0);
		table = new JTable();
		actualizarTabla();
		table.setBounds(25, 28, 524, 208);
		contentPane.add(table);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filtrar(filtro.getText());
			}
		});
		btnFiltrar.setBounds(286, 259, 89, 23);
		contentPane.add(btnFiltrar);
		
		filtro = new JTextField();
		filtro.setBounds(143, 260, 110, 20);
		contentPane.add(filtro);
		filtro.setColumns(10);
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
}
