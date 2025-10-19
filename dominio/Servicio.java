package dominio;

import java.io.Serializable;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class Servicio implements Serializable {

    private Vehiculo vehiculo;
    private Empleado empleado;
    private String servicio;
    private String fecha;
    private int valor;

    public Servicio(Vehiculo vehiculo, Empleado empleado, String servicio, String fecha, int valor) {
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.servicio = servicio;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getServicio() {
        return servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "$" + this.valor + " - " + this.servicio + " - "+this.vehiculo.getMatricula();
    }
    
    public String toStringReporte(){
        return this.fecha + " - " + this.servicio + " - " + this.vehiculo.getMatricula();
    }

}
