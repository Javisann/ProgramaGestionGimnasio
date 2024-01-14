package gym;

import java.util.Objects;

public class Suscripcion {
    //atributos de suscripcion
    private String codSuscripcion;
    private boolean pagado;
    //constructores
    public Suscripcion(String codSuscripcion, boolean pagado) {
        this.codSuscripcion = codSuscripcion;
        this.pagado = pagado;
    }
    public Suscripcion(String codSuscripcion) {
        this.codSuscripcion = codSuscripcion;
        this.pagado = true;
    }
    //getter y setter
    public String getCodSuscripcion() {
        return codSuscripcion;
    }
    public void setCodSuscripcion(String codSuscripcion) {
        this.codSuscripcion = codSuscripcion;
    }
    public boolean isPagado() {
        return pagado;
    }
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    //--------------------------------------
	@Override
	public int hashCode() {
		return Objects.hash(codSuscripcion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suscripcion other = (Suscripcion) obj;
		return Objects.equals(codSuscripcion, other.codSuscripcion);
	}
    //toString
    /*@Override
    public String toString() {
        return "Suscripcion [codSuscripcion=" + codSuscripcion + ", pagado=" + pagado + "]";
    }*/
    //mostrarSuscripcion
    public void mostrarSuscripcion(){
        System.out.println("---------------------------");
        System.out.println("*****SUSCRIPCION*****");
        System.out.println("Cod: " + this.codSuscripcion);
        
        if(this.pagado){
            System.out.println("FACTURA PAGADA");
        }else{
            System.out.println("FACTURA NO PAGADA");
        }
    }

}
