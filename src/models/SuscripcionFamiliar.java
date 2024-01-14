package models;

import java.util.ArrayList;

public class SuscripcionFamiliar extends Suscripcion{
    //atributos nuevos
    private ArrayList<Clientes> clientes;
    private double precio;
    //constructores
    public SuscripcionFamiliar(String codSuscripcion, boolean pagado, ArrayList<Clientes> clientes, double precio) {
        super(codSuscripcion, pagado);
        this.clientes = clientes;
        this.precio = precio;
    }
    public SuscripcionFamiliar(String codSuscripcion, ArrayList<Clientes> clientes, double precio) {
        super(codSuscripcion);
        this.clientes = clientes;
        this.precio = precio;
    }
    //getter y setter
    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //super toString
        @Override
        public void mostrarSuscripcion() {
            super.mostrarSuscripcion();
            System.out.println("Tipo de suscripcion->FAMILIAR");
            System.out.println("Clientes: "+this.clientes);
            System.out.println("Precio: "+this.precio);
    }
}
