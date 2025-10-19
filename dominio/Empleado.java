package dominio;

import java.io.Serializable;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class Empleado extends Persona implements Serializable {
    private int numeroEmpleado;

    public Empleado(String nombre, int cedula, String direccion, int numeroEmpleado) {
        super(nombre, cedula, direccion);
        this.numeroEmpleado = numeroEmpleado;
    } 

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    @Override
    public String toString() {
        return (this.numeroEmpleado + " - " + this.getNombre());
    }
}
