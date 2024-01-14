package personal;

public class Limpieza {
    //atributos
    private String idLimpieza;
    private String nombre;
    //constructores
    public Limpieza(String idLimpieza, String nombre) {
        this.idLimpieza = idLimpieza;
        this.nombre = nombre;
    }
    //getter y setter
    public String getIdLimpieza() {
        return idLimpieza;
    }
    public void setIdLimpieza(String idLimpieza) {
        this.idLimpieza = idLimpieza;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //hashcode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idLimpieza == null) ? 0 : idLimpieza.hashCode());
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
        Limpieza other = (Limpieza) obj;
        if (idLimpieza == null) {
            if (other.idLimpieza != null)
                return false;
        } else if (!idLimpieza.equals(other.idLimpieza))
            return false;
        return true;
    }
    //-----------------------
    public void mostrarLimpieza(){
        System.out.println("------------------------");
        System.out.println("ID: " + this.idLimpieza);
		System.out.println("NOMBRE: " + this.nombre);
    }
}
