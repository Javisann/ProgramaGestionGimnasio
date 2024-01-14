package gym;

import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;

import models.ActividadDB;
import models.LimpiezaDB;
import models.MonitorDB;
import models.SusIndividualDB;
import personal.Clientes;
import personal.Limpieza;
import personal.Monitores;
import ventanas.VentanaPrincipal;

public class ProgramaGimnasio {
	
	public static ArrayList<SuscripcionIndividual> suscripcionesIndividuales=SusIndividualDB.obtenersuscripcionesindividuales();
	public static ArrayList<SuscripcionFamiliar> suscripcionesFamiliares=new ArrayList<SuscripcionFamiliar>();
	public static ArrayList<Actividades> actividades=ActividadDB.obtenerActividades();
	public static ArrayList<Monitores> monitores=MonitorDB.obtenerMonitor();
	public static ArrayList<Limpieza> limpieza=LimpiezaDB.obtenerLimpieza();
	public static Gimnasio g1;
	
    public static void main (String[] args){
                //----------------------CLIENTES---------------------------------
                Clientes c1=new Clientes("c1", "Pedro", 50);
                Clientes c2=new Clientes("c2", "Maria");
                Clientes c3=new Clientes("c3", "Carlos");
                ArrayList<Clientes> familia1=new ArrayList<Clientes>();
                familia1.add(c1);
                familia1.add(c2);
                familia1.add(c3);
                familia1.add(new Clientes("c4", "Carla"));
                ArrayList<Clientes> familia2=new ArrayList<Clientes>();
                familia2.add(new Clientes("c6", "Hugo"));
                familia2.add(new Clientes("c7", "David"));
                familia2.add(new Clientes("c8", "Jose"));
                //-------------------SUSCRIPCIONESFAMILIARES-------------------------------------
                Suscripcion sf1=new SuscripcionFamiliar("sf1", true, familia1, 60);
                Suscripcion sf2=new SuscripcionFamiliar("sf2", false, familia2, 60);
                suscripcionesFamiliares.add((SuscripcionFamiliar) sf1);
                suscripcionesFamiliares.add((SuscripcionFamiliar) sf2);
                //----------------------GIMNASIO---------------------------------------
                g1=new Gimnasio("Paramount GYM", "Toledo", actividades, suscripcionesFamiliares, suscripcionesIndividuales, monitores, limpieza);
                //----------------------Ventana------------------------------------------
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true); //Decoracion
                    Properties props = new Properties();
                    props.put("logoString", "Paramount GYM");
                    props.put("textAntiAliasingMode", "grey");
                    props.put("dynamicLayout", "on");
                    AcrylLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); //Inserta el tema en la interfaz de usuario del proyecto
                } catch (Exception e) {
                    e.printStackTrace();
                }
				VentanaPrincipal frame = new VentanaPrincipal();
				frame.setTitle("Paramount GYM");
				frame.setVisible(true);
    }
}