package models;

import java.util.Objects;

public class Actividades {
    //atributos
    private String nombre;
    private double duracion;
    private int sesiones;
    //constructores
    public Actividades(String nombre, double duracion, int sesiones) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.sesiones = sesiones;
    }
    //getter y setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getDuracion() {
        return duracion;
    }
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    public int getSesiones() {
        return sesiones;
    }
    public void setSesiones(int sesiones) {
        this.sesiones = sesiones;
    }
    //-----------------------------------------------
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividades other = (Actividades) obj;
		return Objects.equals(nombre, other.nombre);
	}
    //mostrarActividad
    public void mostrarActividades(){
        System.out.println("---------------------");
        System.out.println("Nombre->"+this.nombre);
        System.out.println("Duracion (Horas)->"+this.duracion);
        System.out.println("Sesiones por semana->"+this.sesiones);
    }

}
