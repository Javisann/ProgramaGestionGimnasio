package personal;

public class Clientes {
    //atributos
    private String dni;
    private String nombre;
    private double saldo;
    //constructores
    public Clientes(String dni, String nombre, double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.saldo = saldo;
    }
    public Clientes(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.saldo = 0;
    }
    //getter y setter
    public String getdni() {
        return dni;
    }
    public void setdni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //hascode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
        Clientes other = (Clientes) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }
    //toString
    @Override
    public String toString() {
        return dni;
    }
    //---------------------------------------------
    public boolean disminuirSaldo(double dinero){
        if(dinero<0){
            return false;
        }
        else if(this.saldo<dinero){
            return false;
        }
        else{
        this.saldo-=dinero;
        return true;
        }
    }
    //--------------------------------------------
	public boolean aumentarSaldo(double dinero){
		if(dinero < 0)
		{
			return false;
		}
		else
		{
            this.saldo = this.saldo + dinero;	
            return true;
		}
	}
	//------------------------------------------
	public void mostrarCliente() {
        System.out.println("****************************");
		System.out.println("DNI: " + dni);
		System.out.println("NOMBRE: " + nombre);
		System.out.println("SALDO: " + saldo);
	}
}