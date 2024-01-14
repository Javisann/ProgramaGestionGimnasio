package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		
		PanelSuscripcionesIndividuales psi=new PanelSuscripcionesIndividuales();
		PanelSuscripcionesFamiliares psf=new PanelSuscripcionesFamiliares();
		PanelActividades pa=new PanelActividades();
		PanelPersonal pp=new PanelPersonal();
		PanelBuscar pb=new PanelBuscar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 522);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mn_menuPrincipal = new JMenu("Men\u00FA");
		menuBar.add(mn_menuPrincipal);
		
		JMenuItem mni_inicio = new JMenuItem("Inicio");
		mni_inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				contentPane.revalidate(); contentPane.repaint();
			}
		});
		mn_menuPrincipal.add(mni_inicio);
		
		JMenu mn_suscripciones = new JMenu("Gestion de Suscripciones");
		mn_menuPrincipal.add(mn_suscripciones);
		
		JMenuItem mni_suscripcionIndividual = new JMenuItem("Suscripciones Individuales");
		mni_suscripcionIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(psi);
				psi.revalidate(); psi.repaint();
			}
		});
		mn_suscripciones.add(mni_suscripcionIndividual);
		
		JMenuItem mni_suscripcionesFamiliares = new JMenuItem("Suscripciones Familiares");
		mni_suscripcionesFamiliares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(psf);
				psf.revalidate(); psf.repaint();
			}
		});
		mn_suscripciones.add(mni_suscripcionesFamiliares);
		
		JMenu mn_gimnasio = new JMenu("Gestion del Gimnasio");
		mn_menuPrincipal.add(mn_gimnasio);
		
		JMenuItem mni_actividades = new JMenuItem("Mostrar Actividades");
		mni_actividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(pa);
				pa.revalidate(); pa.repaint();
			}
		});
		mn_gimnasio.add(mni_actividades);
		
		JMenuItem mni_personal = new JMenuItem("Mostrar Personal");
		mni_personal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(pp);
				pp.revalidate(); pp.repaint();
			}
		});
		mn_gimnasio.add(mni_personal);
		
		JMenuItem mni_buscar = new JMenuItem("Buscar...");
		mni_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(pb);
				pb.revalidate(); pb.repaint();
			}
		});
		mn_menuPrincipal.add(mni_buscar);
		
		JMenuItem mni_salir = new JMenuItem("Salir");
		mni_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mn_menuPrincipal.add(mni_salir);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 52, 693, 2);
		contentPane.add(separator);
		
		JLabel lb_titulo = new JLabel("PARAMOUNT GYM");
		lb_titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_titulo.setBounds(160, 11, 330, 30);
		contentPane.add(lb_titulo);
		
		String user = System.getProperty("user.name");
		JLabel lblNewLabel = new JLabel("Bienvenido al programa de gesti\u00F3n de PARAMOUNT GYM, " + user);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 65, 446, 30);
		contentPane.add(lblNewLabel);
	}
}
