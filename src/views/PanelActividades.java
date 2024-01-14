package views;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.ActividadDB;
import main.ProgramaGimnasio;
import models.Actividades;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PanelActividades extends JPanel {
	private JTextField txt_nombre;
	private JTextField txt_duracion;
	private JTextField txt_sesiones;
	private DefaultTableModel tableModel;
	private JTable table_actividades;
	
	/**
	 * Create the panel.
	 */
	public PanelActividades() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel lb_actividades = new JLabel("Gestion de Actividades");
		lb_actividades.setHorizontalAlignment(SwingConstants.CENTER);
		lb_actividades.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_actividades.setBounds(168, 11, 330, 30);
		add(lb_actividades);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 52, 693, 2);
		add(separator);
		
		JButton bt_AñadirActividades = new JButton("A\u00F1adir Actividad");
		bt_AñadirActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COGER DATOS ACTIVIDAD
				String nombre=txt_nombre.getText();
				String textoduracion = txt_duracion.getText();
				String textosesiones= txt_sesiones.getText();
				//---------------
				double duracion = 0.0;
			    try {
			    		duracion = Double.valueOf(textoduracion);
			    }
			    catch (NumberFormatException e3)
			    {
			    	e3.printStackTrace();
			    	    JFrame f = new JFrame();  
			    	    JOptionPane.showMessageDialog(f,"No pude convertir el numero."); 
			            return;
			    }
				//---------------
				int sesiones = 0;
			    try {
			    		sesiones = Integer.valueOf(textosesiones);
			    }
			    catch (NumberFormatException e3)
			    {
			    	e3.printStackTrace();
			    	    JFrame f = new JFrame();  
			    	    JOptionPane.showMessageDialog(f,"No pude convertir el numero."); 
			            return;
			    }
			    //CREAMOS LA ACTIVIDAD
			    Actividades a3=new Actividades(nombre, duracion, sesiones);
			    ActividadDB.AñadirActividad(a3);
			    //---------------------------------------
			    blanquearTexto();
				//-------------------------------------
			    cargarTablaActividades(ActividadDB.obtenerActividades());
			}
		});
		bt_AñadirActividades.setEnabled(false);
		bt_AñadirActividades.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_AñadirActividades.setBounds(433, 108, 174, 39);
		add(bt_AñadirActividades);
		
		
		tableModel = new DefaultTableModel();
        table_actividades = new JTable(tableModel);
		table_actividades.setBounds(10, 313, 663, 137);
		table_actividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_actividades.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bt_AñadirActividades.setEnabled(false);
                DefaultTableModel model = (DefaultTableModel) table_actividades.getModel();
                int selectedRowIndex = table_actividades.getSelectedRow();
                txt_nombre.setText(model.getValueAt(selectedRowIndex, 0).toString());
                txt_duracion.setText(model.getValueAt(selectedRowIndex, 1).toString());
                txt_sesiones.setText(model.getValueAt(selectedRowIndex, 2).toString());
            }
        });

        JScrollPane scroll = new JScrollPane(table_actividades);
        scroll.setBounds(10, 313, 663, 137);
        add(scroll);
        String[] headers = {"NOMBRE","DURACION(horas)","SESIONES(Por semana)"};
        tableModel.setColumnIdentifiers(headers);
        table_actividades.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        cargarTablaActividades(ProgramaGimnasio.g1.getActividades());
		
		JButton bt_nuevaActividad = new JButton("Reset");
		bt_nuevaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blanquearTexto();
				bt_AñadirActividades.setEnabled(true);
			}
		});
		bt_nuevaActividad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_nuevaActividad.setBounds(433, 208, 174, 39);
		add(bt_nuevaActividad);
		
		txt_nombre = new JTextField();
		txt_nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nombre.setBounds(212, 110, 174, 39);
		add(txt_nombre);
		txt_nombre.setColumns(10);
		
		txt_duracion = new JTextField();
		txt_duracion.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_duracion.setColumns(10);
		txt_duracion.setBounds(212, 158, 174, 39);
		add(txt_duracion);
		
		txt_sesiones = new JTextField();
		txt_sesiones.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_sesiones.setColumns(10);
		txt_sesiones.setBounds(212, 208, 174, 39);
		add(txt_sesiones);
		
		JLabel lb_nombre = new JLabel("Nombre:");
		lb_nombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_nombre.setBounds(10, 108, 196, 39);
		add(lb_nombre);
		
		JLabel lb_duracion = new JLabel("Duraci\u00F3n:");
		lb_duracion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_duracion.setBounds(6, 158, 196, 39);
		add(lb_duracion);
		
		JLabel lb_sesiones = new JLabel("Sesiones:");
		lb_sesiones.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_sesiones.setBounds(6, 208, 196, 39);
		add(lb_sesiones);
		
		JButton bt_borrarActividades = new JButton("Borrar Actividad");
		bt_borrarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // RECOGEMOS DATOS
					String nombre = txt_nombre.getText();
					double duracion = Double.valueOf(txt_duracion.getText());
					int sesiones = Integer.valueOf(txt_sesiones.getText());
				    //CREO ACTIVIDAD CON LOS DATOS
				    Actividades a3=new Actividades(nombre, duracion, sesiones);
				    //BORRARLO
				    ActividadDB.borrarActividad(a3);
				    //-----------------------------
				    blanquearTexto();
					//--------------------
				    cargarTablaActividades(ActividadDB.obtenerActividades());
			}
		});
		bt_borrarActividades.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_borrarActividades.setBounds(433, 158, 174, 39);
		add(bt_borrarActividades);
	}
	public void cargarTablaActividades(ArrayList<Actividades> actividades){
		tableModel.getDataVector().removeAllElements();
		for (Actividades actividades2 : actividades) {
			String nombre=actividades2.getNombre();
			double duracion=actividades2.getDuracion();
			int sesiones= actividades2.getSesiones(); 
			Object[] data= {nombre, duracion, sesiones};
			tableModel.addRow(data);
		}
		revalidate();
		repaint();
	}
	private void blanquearTexto() {
		txt_nombre.setText("");
		txt_duracion.setText("");
		txt_sesiones.setText("");
	}
}
