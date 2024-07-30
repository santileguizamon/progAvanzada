package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import principal.Destino;
import principal.Vuelo;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VerHotel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField filtro;
	private DefaultTableModel model;
	private Destino destino = new Destino();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerHotel frame = new VerHotel();
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
	public VerHotel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		destino = new Destino();
		
		
		String[] columnNames = {"nombreHotel", "nombreDestino", "movilidad"};
		 model = new DefaultTableModel(columnNames, 0);
		table = new JTable();
		table.setBounds(37, 27, 514, 196);
		contentPane.add(table);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filtrar(filtro.getText());
			}
		});
		btnFiltrar.setBounds(330, 251, 89, 23);
		contentPane.add(btnFiltrar);
		
		filtro = new JTextField();
		filtro.setBounds(188, 252, 113, 20);
		contentPane.add(filtro);
		filtro.setColumns(10);
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
}
