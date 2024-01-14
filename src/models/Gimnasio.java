package models;

import java.util.ArrayList;
import java.util.Iterator;

import main.ProgramaGimnasio;

public class Gimnasio {
    //atributos
    private String nombre;
    private String provincia;
    private ArrayList<Actividades> actividades;
    private ArrayList<SuscripcionFamiliar> suscripcionesFamiliares;
    private ArrayList<SuscripcionIndividual> suscripcionesIndividuales;
    private ArrayList<Monitores> monitores;
    private ArrayList<Limpieza> limpieza;
    //constructores
    public Gimnasio(String nombre, String provincia, ArrayList<Actividades> actividades,
			ArrayList<SuscripcionFamiliar> suscripcionesFamiliares,
			ArrayList<SuscripcionIndividual> suscripcionesIndividuales, ArrayList<Monitores> monitores,
			ArrayList<Limpieza> limpieza) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
		this.actividades = actividades;
		this.suscripcionesFamiliares = suscripcionesFamiliares;
		this.suscripcionesIndividuales = suscripcionesIndividuales;
		this.monitores = monitores;
		this.limpieza = limpieza;
	}
    //getter y setter
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public ArrayList<Actividades> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividades> actividades) {
		this.actividades = actividades;
	}

	public ArrayList<SuscripcionFamiliar> getSuscripcionesFamiliares() {
		return suscripcionesFamiliares;
	}

	public void setSuscripcionesFamiliares(ArrayList<SuscripcionFamiliar> suscripcionesFamiliares) {
		this.suscripcionesFamiliares = suscripcionesFamiliares;
	}

	public ArrayList<SuscripcionIndividual> getSuscripcionesIndividuales() {
		return suscripcionesIndividuales;
	}

	public void setSuscripcionesIndividuales(ArrayList<SuscripcionIndividual> suscripcionesIndividuales) {
		this.suscripcionesIndividuales = suscripcionesIndividuales;
	}

	public ArrayList<Monitores> getMonitores() {
		return monitores;
	}

	public void setMonitores(ArrayList<Monitores> monitores) {
		this.monitores = monitores;
	}

	public ArrayList<Limpieza> getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(ArrayList<Limpieza> limpieza) {
		this.limpieza = limpieza;
	}
    //hascode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Gimnasio other = (Gimnasio) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }
    //----------------toString
    /*@Override
    public String toString() {
        return "Gimnasio [nombre=" + nombre + ", provincia=" + provincia + ", actividades=" + actividades
                + ", suscripciones=" + suscripciones + "]";
    }
    //mostrarGimnasio
    public void mostrarGimnasio(){
        System.out.println("===========================================");
        System.out.println("NOMBRE DEL GIMNASIO: "+this.nombre);
        System.out.println("======MOSTRANDO LAS SUSCRIPCIONES=====");
        for (Suscripcion s : suscripciones) {
            s.mostrarSuscripcion();
            System.out.println("***************");
        }
        System.out.println("======MOSTRANDO LAS ACTIVIDADES=====");
        for (Actividades a : actividades) {
            a.mostrarActividades();
            System.out.println("*****************");
        }
        System.out.println("======MOSTRANDO LOS MONITORES======");
        for (Monitores m : monitores) {
            m.mostrarMonitores();
        }
    }*/
    //---------------------------------------------------------
    public void mostrarSuscripcion() {
        System.out.println("Mostrando todas las suscripciones: ");
        for(SuscripcionFamiliar suscripcion : suscripcionesFamiliares) {
            suscripcion.mostrarSuscripcion();
        }
        for (SuscripcionIndividual suscripcion2 : suscripcionesIndividuales) {
			suscripcion2.mostrarSuscripcion();
		}
        System.out.println("----------------------------");
    }
    //----------------------------------------------------------------------
    public void AñadirSuscripcionIndividual(SuscripcionIndividual snuevo) {
        this.suscripcionesIndividuales.add(snuevo);
    }
    //---------------------------------------------------------------
    public void AñadirSuscripcionFamiliar(SuscripcionFamiliar snuevo1) {
        this.suscripcionesFamiliares.add(snuevo1);
    }
    //-----------------------------------------------------
    public void mostrarActividades() {
        System.out.println("mostrando las actividades disponibles actualmente: ");
        for (Actividades actividades2 : actividades) {
            actividades2.mostrarActividades();
        }
        System.out.println("-----------------------------");
    }
    //--------------------------------------------------------------------
    public void mostrarPersonal() {
        System.out.println("Mostrando el personal actual del gimnasio");
        System.out.println("=====Monitor=====");
        for (Monitores monitor : monitores) {
            monitor.mostrarMonitores();
        }
        System.out.println("=====Limpieza=====");
        for (Limpieza limpiador : limpieza) {
            limpiador.mostrarLimpieza();
        }
    }
    //---------------------------------------------------------------
    public void borrarSuscripcionFamiliar(SuscripcionFamiliar sf3) {
        Iterator<SuscripcionFamiliar> it=suscripcionesFamiliares.iterator();
        while(it.hasNext()){
            Suscripcion sf=it.next();
            if(sf.getCodSuscripcion().equals(sf3)){
                    it.remove();
            }
        }
    }
	//----------------------------------------------------------------------
    public void borrarSuscripcionIndividual(Suscripcion s2) {
        Iterator<SuscripcionIndividual> it=suscripcionesIndividuales.iterator();
        while(it.hasNext()){
            SuscripcionIndividual s=it.next();
            if(s.equals(s2)){
                    it.remove();
            }
        }
    }
	//----------------------------------------------------------------------
	public ArrayList<SuscripcionIndividual> buscarSuscripcionPorDni(String palabra) {
			ArrayList<SuscripcionIndividual> suscripcionEncontrada = new ArrayList<SuscripcionIndividual>();
			for (SuscripcionIndividual suscripcion : ProgramaGimnasio.suscripcionesIndividuales) {
				String dni1 = suscripcion.getCliente().getdni();
				String codSus = suscripcion.getCodSuscripcion();
				if(dni1.contains(palabra) || codSus.contains(palabra))
				{
					suscripcionEncontrada.add(suscripcion);
				}
			}
			return suscripcionEncontrada;
	}
	//----------------------------------------------------------------------
	public boolean actualizarSuscripcion(SuscripcionIndividual s) 
	{
		return actualizarSuscripcion(s.getCodSuscripcion(), s.isPagado(), s.getPrecio(), s.getCliente());
	}
	//----------------------------------------------------------------------
	public boolean actualizarSuscripcion(String codigo, boolean pagado, double precio, Clientes cliente)
	{
		for (SuscripcionIndividual s : suscripcionesIndividuales) {
			if(s.getCodSuscripcion().equalsIgnoreCase(codigo))
			{
				s.setPagado(pagado);
				s.setPrecio(precio);
				s.setCliente(cliente);
				return true;
			}
		}
		return false;
	}
	//----------------------------------------------------------------------
	public void AñadirActividad(Actividades anuevo) {
		this.actividades.add(anuevo);
	}
	//----------------------------------------------------------------------
	public void borrarActividades(Actividades a3) {
        Iterator<Actividades> it=actividades.iterator();
        while(it.hasNext()){
            Actividades a=it.next();
            if(a.equals(a3)){
                 it.remove();
            }
        }
	}
	//----------------------------------------------------------------------
	public void borrarLimpieza(Limpieza l3) {
        Iterator<Limpieza> it=limpieza.iterator();
        while(it.hasNext()){
            Limpieza l=it.next();
            if(l.equals(l3)){
                 it.remove();
            }
        }
	}
	//----------------------------------------------------------------------
	public void borrarMonitores(Monitores m3) {
        Iterator<Monitores> it=monitores.iterator();
        while(it.hasNext()){
            Monitores m=it.next();
            if(m.equals(m3)){
                 it.remove();
            }
        }
	}
	//----------------------------------------------------------------------
	public void AñadirLimpieza(Limpieza l3) {
		this.limpieza.add(l3);
	}
	//----------------------------------------------------------------------
	public void AñadirMonitores(Monitores m3) {
		this.monitores.add(m3);
	}
}