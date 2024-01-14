package views;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import db.LimpiezaDB;
import db.MonitorDB;
import models.Limpieza;
import models.Monitores;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPersonal extends JPanel {
	private JTable table;
	private JTextField txt_id;
	private JTextField txt_nombre;
	private DefaultTableModel tableModel;
	private JButton bt_Añadir;
	private JRadioButton rd_limpieza;
	private JRadioButton rd_monitor;

	/**
	 * Create the panel.
	 */
	public PanelPersonal() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		JLabel lb_personal = new JLabel("Gesti\u00F3n de Personal");
		lb_personal.setHorizontalAlignment(SwingConstants.CENTER);
		lb_personal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_personal.setBounds(171, 11, 330, 30);
		add(lb_personal);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(0, 52, 693, 2);
		add(separator_1);
		
		
		tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
		table.setBounds(10, 313, 663, 137);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bt_Añadir.setEnabled(false);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();
                txt_id.setText(model.getValueAt(selectedRowIndex, 0).toString());
                txt_nombre.setText(model.getValueAt(selectedRowIndex, 1).toString());
                
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10, 313, 663, 137);
        add(scroll);
		
		rd_limpieza = new JRadioButton("Limpieza");
		rd_limpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String[] headers = {"IDLimpieza","Nombre"};
		        tableModel.setColumnIdentifiers(headers);
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        cargarTablaLimpieza(LimpiezaDB.obtenerLimpieza());
			}
		});
		rd_limpieza.setBackground(new Color(255, 255, 255));
		rd_limpieza.setBounds(167, 268, 77, 23);
		add(rd_limpieza);
		
		rd_monitor = new JRadioButton("Monitor");
		rd_monitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String[] headers = {"IDMonitores","Nombre"};
		        tableModel.setColumnIdentifiers(headers);
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        cargarTablaMonitores(MonitorDB.obtenerMonitor());
			}
		});
		rd_monitor.setBackground(new Color(255, 255, 255));
		rd_monitor.setBounds(249, 268, 77, 23);
		add(rd_monitor);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rd_limpieza);
		bg.add(rd_monitor);
        
		JLabel lb_id = new JLabel("ID:");
		lb_id.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_id.setBounds(10, 140, 145, 46);
		add(lb_id);
		
		JLabel lb_nombre = new JLabel("Nombre:");
		lb_nombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_nombre.setBounds(10, 197, 145, 50);
		add(lb_nombre);
		
		txt_id = new JTextField();
		txt_id.setEnabled(false);
		txt_id.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_id.setBounds(165, 148, 161, 37);
		add(txt_id);
		txt_id.setColumns(10);
		
		txt_nombre = new JTextField();
		txt_nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(165, 207, 161, 37);
		add(txt_nombre);
		
		bt_Añadir = new JButton("A\u00F1adir");
		bt_Añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COGER DATOS ACTIVIDAD
				String id=txt_id.getText();
				String nombre=txt_nombre.getText();
			    //CREO PERSONAL CON LOS DATOS
				if(rd_limpieza.isSelected())
				{
					Limpieza l3=new Limpieza(id, nombre);
					LimpiezaDB.AñadirLimpieza(l3);
				    cargarTablaLimpieza(LimpiezaDB.obtenerLimpieza());
				}
				else if(rd_monitor.isSelected()) {
					Monitores m3=new Monitores(id, nombre);
					MonitorDB.AñadirMonitor(m3);
				    cargarTablaMonitores(MonitorDB.obtenerMonitor());
				}
			    //-----------------------------
			    blanquearTexto();
			}
		});
		bt_Añadir.setEnabled(false);
		bt_Añadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_Añadir.setBounds(439, 148, 136, 37);
		add(bt_Añadir);
		
		JButton bt_borrar = new JButton("Borrar");
		bt_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // RECOGEMOS DATOS
					String id= txt_id.getText();
					String nombre = txt_nombre.getText();
				    //CREO PERSONAL CON LOS DATOS Y BORRARLO
					if(rd_limpieza.isSelected())
					{
						Limpieza l3=new Limpieza(id, nombre);
						LimpiezaDB.borrarLimpieza(l3);
					    cargarTablaLimpieza(LimpiezaDB.obtenerLimpieza());
					}
					else if(rd_monitor.isSelected()) {
						Monitores m3=new Monitores(id, nombre);
						MonitorDB.borrarMonitor(m3);
					    cargarTablaMonitores(MonitorDB.obtenerMonitor());
					}
				    //-----------------------------
				    blanquearTexto();
					//--------------------
			}
		});
		bt_borrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_borrar.setBounds(439, 189, 136, 37);
		add(bt_borrar);
		
		JButton bt_reset = new JButton("Reset");
		bt_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blanquearTexto();
				bt_Añadir.setEnabled(true);
				txt_id.setEnabled(true);
			}
		});
		bt_reset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_reset.setBounds(439, 230, 136, 37);
		add(bt_reset);
		
		JLabel lb_tipo = new JLabel("Tipo:");
		lb_tipo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_tipo.setBounds(10, 252, 145, 50);
		add(lb_tipo);
		
		
	}
	
	public void cargarTablaLimpieza(ArrayList<Limpieza> limpieza){
		tableModel.getDataVector().removeAllElements();
		for (Limpieza limpieza1 : limpieza) {
			String idLimpieza=limpieza1.getIdLimpieza();
			String nombre=limpieza1.getNombre();
			Object[] data= {idLimpieza, nombre};
			tableModel.addRow(data);
		}
		revalidate();
		repaint();
	}
	public void cargarTablaMonitores(ArrayList<Monitores> monitores) {
		tableModel.getDataVector().removeAllElements();
		for (Monitores monitores1 : monitores) {
			String idMonitor=monitores1.getIdMonitores();
			String nombre=monitores1.getNombre();
			Object[] data= {idMonitor, nombre};
			tableModel.addRow(data);
		}
		revalidate();
		repaint();
	}
	private void blanquearTexto() {
		txt_id.setText("");
		txt_nombre.setText("");
		rd_limpieza.setSelected(false);
		rd_monitor.setSelected(false);
	}
}
