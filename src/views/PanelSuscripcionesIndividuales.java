package views;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connection.ConfiguracionDB;
import db.SusIndividualDB;
import main.ProgramaGimnasio;
import models.Clientes;
import models.Suscripcion;
import models.SuscripcionFamiliar;
import models.SuscripcionIndividual;

import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class PanelSuscripcionesIndividuales extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txt_codigo;
	private JTextField txt_precio;
	private JTextField txt_dni;
	private JTextField txt_nombre;
	private JRadioButton rd_si;
	private JRadioButton rd_no;
	private JTextField txt_buscar;
	private ButtonGroup bg;

	/**
	 * Create the panel.
	 */
	public PanelSuscripcionesIndividuales() {
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lb_suscripciones = new JLabel("Gesti\u00F3n de Suscripciones Individuales");
		lb_suscripciones.setHorizontalAlignment(SwingConstants.CENTER);
		lb_suscripciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_suscripciones.setBounds(139, 11, 389, 30);
		add(lb_suscripciones);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 52, 693, 2);
		add(separator);
		
		rd_si = new JRadioButton("SI");
		rd_si.setSelected(true);
		rd_si.setBackground(new Color(255, 255, 255));
		rd_si.setBounds(104, 128, 45, 23);
		add(rd_si);
		
		rd_no = new JRadioButton("NO");
		rd_no.setBackground(new Color(255, 255, 255));
		rd_no.setBounds(163, 128, 45, 23);
		add(rd_no);
		
		JButton bt_AñadirSuscripcionIndividual = new JButton("A\u00F1adir Suscripci\u00F3n");
		bt_AñadirSuscripcionIndividual.setEnabled(false);
		bt_AñadirSuscripcionIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean pagado = false;
				if(rd_si.isSelected())
				{
					pagado = true;
				}
				else {
					pagado = false;
				}
				//COGER DATOS SUSCRIPCION
				String codigo=txt_codigo.getText();
				String textoprecio = txt_precio.getText();
				//---------------
				double precio = 0.0;
			    try {
			    		precio = Double.valueOf(textoprecio);
			    }
			    catch (NumberFormatException e3)
			    {
			    	e3.printStackTrace();
			    	    JFrame f = new JFrame();  
			    	    JOptionPane.showMessageDialog(f,"No pude convertir el numero."); 
			            return;
			    }
			    //COGER DATOS CLIENTE
			    String nombre=txt_nombre.getText();
			    String dni=txt_dni.getText();
			    //CREAMOS CLIENTE
			    Clientes c6=new Clientes(dni, nombre);
			    //CREAMOS LA SUSCRIPCION
			    SuscripcionIndividual s2=new SuscripcionIndividual(codigo, pagado, c6, precio);
			    SusIndividualDB.AñadirSuscripcionIndividual(s2);
			    //-----------------------------
			    blanquearTexto();
				//--------------------
			    cargarTablaSuscripcionesIndividuales(SusIndividualDB.obtenersuscripcionesindividuales());
			}
		});
		bt_AñadirSuscripcionIndividual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_AñadirSuscripcionIndividual.setBounds(434, 97, 239, 38);
		add(bt_AñadirSuscripcionIndividual);
		

		
		tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
		table.setBounds(10, 313, 663, 137);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bt_AñadirSuscripcionIndividual.setEnabled(false);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();
                txt_codigo.setText(model.getValueAt(selectedRowIndex, 0).toString());
                if(model.getValueAt(selectedRowIndex, 1).equals("Si")) {
                    rd_si.setSelected(true);
                }
                else if(model.getValueAt(selectedRowIndex, 1).equals("No")) {
                    rd_no.setSelected(true);
                }
                txt_precio.setText(model.getValueAt(selectedRowIndex, 2).toString());
                txt_nombre.setText(model.getValueAt(selectedRowIndex, 3).toString());
                txt_dni.setText(model.getValueAt(selectedRowIndex, 4).toString());
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10, 313, 663, 137);
        add(scroll);
        String[] headers = {"COD","PAGADO","PRECIO", "NOMBRE CLIENTE", "DNI CLIENTE"};
        tableModel.setColumnIdentifiers(headers);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        cargarTablaSuscripcionesIndividuales(ProgramaGimnasio.g1.getSuscripcionesIndividuales());
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 93, 108, 24);
		add(lblNewLabel);
		
		JLabel lblPagado = new JLabel("Pagado: ");
		lblPagado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPagado.setBounds(10, 128, 108, 24);
		add(lblPagado);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(10, 163, 108, 24);
		add(lblPrecio);
		
		JLabel lblDniCliente = new JLabel("DNI Cliente:");
		lblDniCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDniCliente.setBounds(10, 229, 108, 24);
		add(lblDniCliente);
		
		bg = new ButtonGroup();
		bg.add(rd_si);
		bg.add(rd_no);
		
		txt_codigo = new JTextField();
		txt_codigo.setEnabled(false);
		txt_codigo.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_codigo.setBounds(104, 97, 145, 20);
		add(txt_codigo);
		txt_codigo.setColumns(10);
		
		txt_precio = new JTextField();
		txt_precio.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_precio.setColumns(10);
		txt_precio.setBounds(104, 167, 145, 20);
		add(txt_precio);
		
		txt_dni = new JTextField();
		txt_dni.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_dni.setColumns(10);
		txt_dni.setBounds(104, 233, 145, 20);
		add(txt_dni);
		
		JLabel lb_nombre = new JLabel("Nombre:");
		lb_nombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_nombre.setBounds(10, 198, 108, 24);
		add(lb_nombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(104, 202, 145, 20);
		add(txt_nombre);
		
		JButton bt_Borrar = new JButton("Borrar");
		bt_Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // RECOGEMOS DATOS DE LAS CAJAS
					String codigo = txt_codigo.getText();
					boolean pagado = false;
					if(rd_si.isSelected())
					{
						pagado = true;
					}
					else {
						pagado = false;
					}
					double precio = Double.valueOf(txt_precio.getText());
		            String nombre = txt_nombre.getText();
				    String dni = txt_dni.getText();
				    
				    Clientes c7=new Clientes(dni, nombre);
				    //CREO SUSCRIPCION CON DATOS RECOGIDOS
				    SuscripcionIndividual s2 = new SuscripcionIndividual(codigo, pagado, c7, precio);
				    //BORRARLO
				    SusIndividualDB.borrarSuscripcionIndividual(s2);
				    //-----------------------------
				    blanquearTexto();
					//--------------------
				    cargarTablaSuscripcionesIndividuales(SusIndividualDB.obtenersuscripcionesindividuales());
			}
		});
		bt_Borrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_Borrar.setBounds(434, 146, 239, 38);
		add(bt_Borrar);
		
		JButton bt_reset = new JButton("Reset");
		bt_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blanquearTexto();
				bt_AñadirSuscripcionIndividual.setEnabled(true);
				txt_codigo.setEnabled(true);
			}
		});
		bt_reset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_reset.setBounds(434, 264, 239, 38);
		add(bt_reset);
		
		txt_buscar = new JTextField();
		txt_buscar.setBounds(10, 282, 156, 20);
		add(txt_buscar);
		txt_buscar.setColumns(10);
		
		JButton bt_buscar = new JButton("Buscar");
		bt_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palabra = txt_buscar.getText();
				palabra = palabra.trim();
				palabra = palabra.toLowerCase();
				if(palabra.isEmpty())
				{
					cargarTablaSuscripcionesIndividuales(ProgramaGimnasio.g1.getSuscripcionesIndividuales());
					return;
				}
				else {
					ArrayList<SuscripcionIndividual> suscripcionEncontrada = SusIndividualDB.buscarPorCodigo(palabra);
					cargarTablaSuscripcionesIndividuales(suscripcionEncontrada);
				}
			}
		});
		bt_buscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_buscar.setBounds(176, 279, 108, 23);
		add(bt_buscar);
		
		JButton bt_modificar = new JButton("Modificar");
		bt_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //PRIMERO RECOGEMOS DATOS
				String codigo = txt_codigo.getText();
				boolean pagado = false;
				if(rd_si.isSelected())
				{
					pagado = true;
				}
				else {
					pagado = false;
				}
				double precio = Double.valueOf(txt_precio.getText());
	            String nombre = txt_nombre.getText();
			    String dni = txt_dni.getText();
			    
			    Clientes c8=new Clientes(dni, nombre);
			    //CREO SUSCRIPCION
			    SuscripcionIndividual s = new SuscripcionIndividual(codigo,pagado , c8, precio);
			    //ACTUALIZO
			    SusIndividualDB.modificarSuscripcionIndividual(s);
			    //-----------------------------
			    blanquearTexto();
				//--------------------
			    cargarTablaSuscripcionesIndividuales(SusIndividualDB.obtenersuscripcionesindividuales());
			}
		});
		
		bt_modificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_modificar.setBounds(434, 191, 239, 38);
		add(bt_modificar);
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

	private void blanquearTexto() {
		txt_codigo.setText("");
		txt_precio.setText("");
		txt_nombre.setText("");
		txt_dni.setText("");
		rd_si.setSelected(false);
		rd_no.setSelected(false);
	}
}
