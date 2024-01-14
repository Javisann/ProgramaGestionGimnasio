package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import gym.ProgramaGimnasio;
import gym.SuscripcionFamiliar;
import gym.SuscripcionIndividual;
import personal.Clientes;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSuscripcionesFamiliares extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txt_codigo;
	private JTextField txt_precio;
	private JTextField txt_dni1;
	
	public static ArrayList<SuscripcionFamiliar> suscripcionesFamiliares=ProgramaGimnasio.suscripcionesFamiliares;
	private JTextField txt_dni2;
	private JTextField txt_dni3;
	private JTextField txt_dni4;
	private JRadioButton rd_si;
	private JRadioButton rd_no;
	private JRadioButton rd_4;
	private JRadioButton rd_3;
	private JTextField txt_nombre1;
	private JTextField txt_nombre2;
	private JTextField txt_nombre3;
	private JTextField txt_nombre4;
	
	/**
	 * Create the panel.
	 */
	public PanelSuscripcionesFamiliares() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lb_suscripciones = new JLabel("Gesti\u00F3n de Suscripciones Familiares");
		lb_suscripciones.setHorizontalAlignment(SwingConstants.CENTER);
		lb_suscripciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_suscripciones.setBounds(139, 11, 389, 30);
		add(lb_suscripciones);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 52, 693, 2);
		add(separator);
		
		JButton bt_Añadir = new JButton("A\u00F1adir Suscripci\u00F3n");
		bt_Añadir.addActionListener(new ActionListener() {
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
				if(rd_4.isSelected())
				{
				    //COGER DATOS CLIENTES
				    String nombre1=txt_nombre1.getText();
				    String dni1=txt_dni1.getText();
				    String nombre2=txt_nombre2.getText();
				    String dni2=txt_dni2.getText();
				    String nombre3=txt_nombre3.getText();
				    String dni3=txt_dni3.getText();
				    String nombre4=txt_nombre4.getText();
				    String dni4=txt_dni4.getText();
				    //CREAMOS CLIENTES
				    Clientes c6=new Clientes(dni1, nombre1);
				    Clientes c7=new Clientes(dni2, nombre2);
				    Clientes c8=new Clientes(dni3, nombre3);
				    Clientes c9=new Clientes(dni4, nombre4);
				    //CREAMOS ARRAYLIST
				    ArrayList<Clientes> familia5= new ArrayList<Clientes>();
				    familia5.add(c6);
				    familia5.add(c7);
				    familia5.add(c8);
				    familia5.add(c9);
				    //CREAMOS LA SUSCRIPCION
				    SuscripcionFamiliar sf3=new SuscripcionFamiliar(codigo, pagado, familia5, precio);
				    ProgramaGimnasio.g1.AñadirSuscripcionFamiliar(sf3);
				    //-----------------------------
				    blanquearTexto();
					//--------------------
				    cargarTablaSuscripcionesFamiliares(ProgramaGimnasio.g1.getSuscripcionesFamiliares());
				}else if(rd_3.isSelected()) {
				    //COGER DATOS CLIENTES
				    String nombre1=txt_nombre1.getText();
				    String dni1=txt_dni1.getText();
				    String nombre2=txt_nombre2.getText();
				    String dni2=txt_dni2.getText();
				    String nombre3=txt_nombre3.getText();
				    String dni3=txt_dni3.getText();
				    //CREAMOS CLIENTES
				    Clientes c6=new Clientes(dni1, nombre1);
				    Clientes c7=new Clientes(dni2, nombre2);
				    Clientes c8=new Clientes(dni3, nombre3);
				    //CREAMOS ARRAYLIST
				    ArrayList<Clientes> familia5= new ArrayList<Clientes>();
				    familia5.add(c6);
				    familia5.add(c7);
				    familia5.add(c8);
				    //CREAMOS LA SUSCRIPCION
				    SuscripcionFamiliar sf3=new SuscripcionFamiliar(codigo, pagado, familia5, precio);
				    ProgramaGimnasio.g1.AñadirSuscripcionFamiliar(sf3);
				    //-----------------------------
				    blanquearTexto();
					//----------------------------
				    cargarTablaSuscripcionesFamiliares(ProgramaGimnasio.g1.getSuscripcionesFamiliares());
				}
			}
		});
		bt_Añadir.setEnabled(false);
		bt_Añadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_Añadir.setBounds(10, 275, 195, 30);
		add(bt_Añadir);
		
		rd_si = new JRadioButton("SI");
		rd_si.setSelected(true);
		rd_si.setBackground(new Color(255, 255, 255));
		rd_si.setBounds(106, 103, 45, 23);
		add(rd_si);
		
		rd_no = new JRadioButton("NO");
		rd_no.setBackground(new Color(255, 255, 255));
		rd_no.setBounds(160, 103, 45, 23);
		add(rd_no);
		
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
                txt_codigo.setText(model.getValueAt(selectedRowIndex, 0).toString());
                if(model.getValueAt(selectedRowIndex, 1).equals("Si")) {
                    rd_si.setSelected(true);
                }
                else if(model.getValueAt(selectedRowIndex, 1).equals("No")) {
                    rd_no.setSelected(true);
                }
                txt_precio.setText(model.getValueAt(selectedRowIndex, 2).toString());
            }
        });
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10, 313, 663, 137);
        add(scroll);
        String[] headers = {"COD","PAGADO","PRECIO", "DNI CLIENTE"};
        tableModel.setColumnIdentifiers(headers);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        cargarTablaSuscripcionesFamiliares(ProgramaGimnasio.g1.getSuscripcionesFamiliares());
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 65, 108, 24);
		add(lblNewLabel);
		
		JLabel lblPagado = new JLabel("Pagado: ");
		lblPagado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPagado.setBounds(10, 100, 108, 24);
		add(lblPagado);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(10, 135, 108, 24);
		add(lblPrecio);
		
		JLabel lblDniCliente = new JLabel("DNI Cliente:");
		lblDniCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDniCliente.setBounds(10, 229, 108, 24);
		add(lblDniCliente);
		
		txt_codigo = new JTextField();
		txt_codigo.setEnabled(false);
		txt_codigo.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_codigo.setBounds(106, 65, 145, 20);
		add(txt_codigo);
		txt_codigo.setColumns(10);
		
		txt_precio = new JTextField();
		txt_precio.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_precio.setColumns(10);
		txt_precio.setBounds(106, 139, 145, 20);
		add(txt_precio);
		
		txt_dni1 = new JTextField();
		txt_dni1.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_dni1.setColumns(10);
		txt_dni1.setBounds(106, 233, 108, 20);
		add(txt_dni1);
		
		JLabel lb_personas = new JLabel("Personas:");
		lb_personas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_personas.setBounds(10, 170, 108, 24);
		add(lb_personas);
		
		rd_3 = new JRadioButton("3");
		rd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_nombre4.setEnabled(false);
				txt_dni4.setEnabled(false);
			}
		});
		rd_3.setSelected(true);
		rd_3.setBackground(new Color(255, 255, 255));
		rd_3.setBounds(106, 173, 45, 23);
		add(rd_3);
		
		rd_4 = new JRadioButton("4");
		rd_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_nombre4.setEnabled(true);
				txt_dni4.setEnabled(true);
			}
		});
		rd_4.setBackground(new Color(255, 255, 255));
		rd_4.setBounds(160, 173, 45, 23);
		add(rd_4);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rd_3);
		bg.add(rd_4);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(rd_si);
		bg2.add(rd_no);
		
		txt_dni2 = new JTextField();
		txt_dni2.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_dni2.setColumns(10);
		txt_dni2.setBounds(224, 233, 108, 20);
		add(txt_dni2);
		
		txt_dni3 = new JTextField();
		txt_dni3.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_dni3.setColumns(10);
		txt_dni3.setBounds(342, 233, 108, 20);
		add(txt_dni3);
		
		txt_dni4 = new JTextField();
		txt_dni4.setEnabled(false);
		txt_dni4.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_dni4.setColumns(10);
		txt_dni4.setBounds(460, 233, 108, 20);
		add(txt_dni4);
		
		JButton bt_borrar = new JButton("Borrar Suscripci\u00F3n");
		bt_borrar.addActionListener(new ActionListener() {
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
		            String nombre1 = txt_nombre1.getText();
				    String dni1 = txt_dni1.getText();
		            String nombre2 = txt_nombre2.getText();
				    String dni2 = txt_dni2.getText();
		            String nombre3 = txt_nombre3.getText();
				    String dni3 = txt_dni3.getText();
		            String nombre4 = txt_nombre4.getText();
				    String dni4 = txt_dni4.getText();
				    Clientes c6=new Clientes(dni1, nombre1);
				    Clientes c7=new Clientes(dni2, nombre2);
				    Clientes c8=new Clientes(dni3, nombre3);
				    Clientes c9=new Clientes(dni4, nombre4);
				    ArrayList<Clientes> familia5 = new ArrayList<Clientes>();
				    familia5.add(c6);
				    familia5.add(c7);
				    familia5.add(c8);
				    familia5.add(c9);
				    //CREO SUSCRIPCION CON DATOS RECOGIDOS
				    SuscripcionFamiliar sf3 =new SuscripcionFamiliar(codigo, pagado, familia5, precio);
				    //BORRARLO
				    ProgramaGimnasio.g1.borrarSuscripcionFamiliar(sf3);
				    //-----------------------------
				    blanquearTexto();
					//--------------------
				    cargarTablaSuscripcionesFamiliares(ProgramaGimnasio.g1.getSuscripcionesFamiliares());
			}
		});
		bt_borrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_borrar.setBounds(215, 275, 184, 30);
		add(bt_borrar);
		
		JButton bt_reset = new JButton("Reset");
		bt_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blanquearTexto();
				bt_Añadir.setEnabled(true);
				txt_codigo.setEnabled(true);
			}
		});
		bt_reset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_reset.setBounds(409, 275, 192, 30);
		add(bt_reset);
		
		JLabel lb_nombre = new JLabel("Nombres:");
		lb_nombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_nombre.setBounds(10, 198, 108, 24);
		add(lb_nombre);
		
		txt_nombre1 = new JTextField();
		txt_nombre1.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nombre1.setColumns(10);
		txt_nombre1.setBounds(106, 202, 108, 20);
		add(txt_nombre1);
		
		txt_nombre2 = new JTextField();
		txt_nombre2.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nombre2.setColumns(10);
		txt_nombre2.setBounds(224, 202, 108, 20);
		add(txt_nombre2);
		
		txt_nombre3 = new JTextField();
		txt_nombre3.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nombre3.setColumns(10);
		txt_nombre3.setBounds(342, 202, 108, 20);
		add(txt_nombre3);
		
		txt_nombre4 = new JTextField();
		txt_nombre4.setEnabled(false);
		txt_nombre4.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nombre4.setColumns(10);
		txt_nombre4.setBounds(460, 202, 108, 20);
		add(txt_nombre4);
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
	private void blanquearTexto() {
		txt_codigo.setText("");
		txt_precio.setText("");
		txt_dni1.setText("");
		txt_dni2.setText("");
		txt_dni3.setText("");
		txt_dni4.setText("");
		txt_nombre1.setText("");
		txt_nombre2.setText("");
		txt_nombre3.setText("");
		txt_nombre4.setText("");
		rd_3.setSelected(false);
		rd_4.setSelected(false);
	}
}
