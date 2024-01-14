package models;

public class Monitores {
    //atributos
    private String idMonitores;
    private String nombre;
    //constructores
    public Monitores(String idMonitores, String nombre) {
        this.idMonitores = idMonitores;
        this.nombre = nombre;
    }
    //getter y setter
    public String getIdMonitores() {
        return idMonitores;
    }
    public void setIdMonitores(String idMonitores) {
        this.idMonitores = idMonitores;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //hascode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMonitores == null) ? 0 : idMonitores.hashCode());
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
        Monitores other = (Monitores) obj;
        if (idMonitores == null) {
            if (other.idMonitores != null)
                return false;
        } else if (!idMonitores.equals(other.idMonitores))
            return false;
        return true;
    }
    //--------------------------------------
    public void mostrarMonitores (){
        System.out.println("------------------------");
        System.out.println("ID: " + this.idMonitores);
		System.out.println("NOMBRE: " + this.nombre);
    }
}
