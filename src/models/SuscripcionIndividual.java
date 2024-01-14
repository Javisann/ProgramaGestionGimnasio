package models;

public class SuscripcionIndividual extends Suscripcion{
    //atributos nuevos
    private Clientes cliente;
    private double precio;
    //super constructores
    public SuscripcionIndividual(String codSuscripcion, boolean pagado, Clientes cliente, double precio) {
        super(codSuscripcion, pagado);
        this.cliente = cliente;
        this.precio = precio;
    }
    public SuscripcionIndividual(String codSuscripcion, Clientes cliente, double precio) {
        super(codSuscripcion);
        this.cliente = cliente;
        this.precio = precio;
    }
    //getter y setter
    public Clientes getCliente() {
        return cliente;
    }
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
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
        System.out.println("Tipo de suscripcion->INDIVIDUAL");
        System.out.println("Cliente: "+this.cliente);
        //this.cliente.mostrarCliente();
        System.out.println("Precio: "+this.precio);
    }
}