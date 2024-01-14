package views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.ActividadDB;
import db.LimpiezaDB;
import db.MonitorDB;
import db.SusIndividualDB;
import main.ProgramaGimnasio;
import models.Actividades;
import models.Clientes;
import models.Limpieza;
import models.Monitores;
import models.SuscripcionFamiliar;
import models.SuscripcionIndividual;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelBuscar extends JPanel {
	private JTable table_buscar;
	private JTextField txt_buscar;
	private DefaultTableModel tableModel;
	private JRadioButton rd_susIndividual;
	private JRadioButton rd_susFamiliar;
	private JRadioButton rd_actividades;
	private JRadioButton rd_limpieza;
	private JRadioButton rd_monitores;

	/**
	 * Create the panel.
	 */
	public PanelBuscar() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lb_tituloBuscar = new JLabel("Buscar");
		lb_tituloBuscar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_tituloBuscar.setBounds(295, 11, 86, 32);
		add(lb_tituloBuscar);
		
		tableModel = new DefaultTableModel();
		table_buscar = new JTable(tableModel);
		table_buscar.setBounds(10, 244, 663, 206);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 54, 687, 2);
		add(separator);
		
		txt_buscar = new JTextField();
		txt_buscar.setBounds(10, 185, 257, 20);
		add(txt_buscar);
		txt_buscar.setColumns(10);
		
		JButton bt_buscar = new JButton("Buscar");
		bt_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		bt_buscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bt_buscar.setBounds(277, 183, 89, 23);
		add(bt_buscar);
		
		JLabel lblNewLabel = new JLabel("\u00BFQue quieres buscar...?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(246, 67, 185, 32);
		add(lblNewLabel);
		
        JScrollPane scroll = new JScrollPane(table_buscar);
        scroll.setBounds(10, 216, 663, 234);
        add(scroll);
		
		rd_susIndividual = new JRadioButton("Suscripciones Individuales");
		rd_susIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String[] headers = {"COD","PAGADO","PRECIO", "NOMBRE CLIENTE", "DNI CLIENTE"};
		        tableModel.setColumnIdentifiers(headers);
		        table_buscar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        cargarTablaSuscripcionesIndividuales(SusIndividualDB.obtenersuscripcionesindividuales());
			}
		});
		rd_susIndividual.setBackground(new Color(255, 255, 255));
		rd_susIndividual.setBounds(53, 122, 149, 23);
		add(rd_susIndividual);
		
		rd_susFamiliar = new JRadioButton("Suscripciones Familiares");
		rd_susFamiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String[] headers = {"COD","PAGADO","PRECIO", "DNI CLIENTE"};
		        tableModel.setColumnIdentifiers(headers);
		        table_buscar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        cargarTablaSuscripcionesFamiliares(ProgramaGimnasio.g1.getSuscripcionesFamiliares());
			}
		});
		rd_susFamiliar.setBackground(new Color(255, 255, 255));
		rd_susFamiliar.setBounds(204, 122, 149, 23);
		add(rd_susFamiliar);
		
		rd_actividades = new JRadioButton("Actividades");
		rd_actividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String[] headers = {"NOMBRE","DURACION","SESIONES"};
		        tableModel.setColumnIdentifiers(headers);
		        table_buscar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        cargarTablaActividades(ActividadDB.obtenerActividades());
			}
		});
		rd_actividades.setBackground(new Color(255, 255, 255));
		rd_actividades.setBounds(355, 122, 89, 23);
		add(rd_actividades);
		
		rd_limpieza = new JRadioButton("Limpieza");
		rd_limpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String[] headers = {"IDPersonal","Nombre"};
		        tableModel.setColumnIdentifiers(headers);
		        table_buscar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        cargarTablaLimpieza(LimpiezaDB.obtenerLimpieza());
			}
		});
		rd_limpieza.setBackground(new Color(255, 255, 255));
		rd_limpieza.setBounds(446, 122, 86, 23);
		add(rd_limpieza);
		
		rd_monitores = new JRadioButton("Monitores");
		rd_monitores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String[] headers = {"IDPersonal","Nombre"};
		        tableModel.setColumnIdentifiers(headers);
		        table_buscar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        cargarTablaMonitores(MonitorDB.obtenerMonitor());
			}
		});
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rd_susIndividual);
		bg.add(rd_susFamiliar);
		bg.add(rd_actividades);
		bg.add(rd_limpieza);
		bg.add(rd_monitores);
		
		rd_monitores.setBackground(new Color(255, 255, 255));
		rd_monitores.setBounds(534, 122, 86, 23);
		add(rd_monitores);
	}
	public void buscar() {
		if(rd_susIndividual.isSelected()) {
			ArrayList<SuscripcionIndividual> suscripcionEncontrada = new ArrayList<SuscripcionIndividual>();
			String palabra = txt_buscar.getText();
			palabra = palabra.trim();
			palabra = palabra.toLowerCase();
			for (SuscripcionIndividual suscripcion : ProgramaGimnasio.suscripcionesIndividuales) {
				String dni1 = suscripcion.getCliente().getdni();
				String codSus = suscripcion.getCodSuscripcion();
				if(dni1.contains(palabra) || codSus.contains(palabra))
				{
					suscripcionEncontrada.add(suscripcion);
				}
			}
			cargarTablaSuscripcionesIndividuales(suscripcionEncontrada);
		}else if(rd_susFamiliar.isSelected()) {
			ArrayList<SuscripcionFamiliar> suscripcionEncontrada = new ArrayList<SuscripcionFamiliar>();
			String palabra = txt_buscar.getText();
			palabra = palabra.trim();
			palabra = palabra.toLowerCase();
			for (SuscripcionFamiliar suscripcion : ProgramaGimnasio.suscripcionesFamiliares) {
				String codSus = suscripcion.getCodSuscripcion();
				if(codSus.contains(palabra))
				{
					suscripcionEncontrada.add(suscripcion);
				}
			}
			cargarTablaSuscripcionesFamiliares(suscripcionEncontrada);
		}else if(rd_actividades.isSelected()){
			ArrayList<Actividades> actividadEncontrada = new ArrayList<Actividades>();
			String palabra = txt_buscar.getText();
			palabra = palabra.trim();
			palabra = palabra.toLowerCase();
			for (Actividades actividad : ProgramaGimnasio.actividades) {
				String nombre=actividad.getNombre();
				if(nombre.contains(palabra))
				{
					actividadEncontrada.add(actividad);
				}
			}
			cargarTablaActividades(actividadEncontrada);
		}else if(rd_limpieza.isSelected()) {
			ArrayList<Limpieza> limpiezaEncontrada = new ArrayList<Limpieza>();
			String palabra = txt_buscar.getText();
			palabra = palabra.trim();
			palabra = palabra.toLowerCase();
			for (Limpieza limpieza : ProgramaGimnasio.limpieza) {
				if(limpieza.getIdLimpieza().contains(palabra))
				{
					limpiezaEncontrada.add(limpieza);
				}
			}
			cargarTablaLimpieza(limpiezaEncontrada);
		}else if(rd_monitores.isSelected()) {
			ArrayList<Monitores> monitorEncontrada = new ArrayList<Monitores>();
			String palabra = txt_buscar.getText();
			palabra = palabra.trim();
			palabra = palabra.toLowerCase();
			for (Monitores monitores : ProgramaGimnasio.monitores) {
				if(monitores.getIdMonitores().contains(palabra))
				{
					monitorEncontrada.add(monitores);
				}
			}
			cargarTablaMonitores(monitorEncontrada);
		}
		
	}
	private void cargarTablaSuscripcionesIndividuales(ArrayList <SuscripcionIndividual> suscripcionesIndividuales){
		tableModel.getDataVector().removeAllElements();
		for (SuscripcionIndividual suscripcionIndividual : suscripcionesIndividuales) {
			String codSuscripcion=suscripcionIndividual.getCodSuscripcion();
			Boolean pagado=suscripcionIndividual.isPagado();
			double precio=suscripcionIndividual.getPrecio();
			String clienteNombre=suscripcionIndividual.getCliente().getNombre();
			String cliente=suscripcionIndividual.getCliente().getdni();
			if(pagado) {
				Object[] data= {codSuscripcion, "Si", precio, clienteNombre, cliente};
				tableModel.addRow(data);
			}
			else {
				Object[] data= {codSuscripcion, "No", precio, clienteNombre, cliente};
				tableModel.addRow(data);
			}
		}
		revalidate();
		repaint();
	}
	public void cargarTablaSuscripcionesFamiliares(ArrayList <SuscripcionFamiliar> suscripcionesFamiliares){
		tableModel.getDataVector().removeAllElements();
			for (SuscripcionFamiliar suscripcionFamiliar : suscripcionesFamiliares) {
				String codSuscripcion=suscripcionFamiliar.getCodSuscripcion();
				Boolean pagado=suscripcionFamiliar.isPagado();
				double precio=suscripcionFamiliar.getPrecio();
				ArrayList<Clientes> clientes=suscripcionFamiliar.getClientes();
				if(pagado) {
					Object[] data= {codSuscripcion, "Si", precio, clientes};
					tableModel.addRow(data);
				}
				else {
					Object[] data= {codSuscripcion, "No", precio, clientes};
					tableModel.addRow(data);
				}
			}
		revalidate();
		repaint();
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
}
