
package dominio;

import java.io.Serializable;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class Movimiento implements Serializable {
    private Vehiculo vehiculo;
    private Empleado empleadoEntrada;
    private Empleado empleadoSalida;
    private String fechaEntrada;
    private String fechaSalida;
    private String notaEntrada;
    private String notaSalida;

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setEmpleadoEntrada(Empleado empleado) {
        this.empleadoEntrada = empleado;
    }

    public void setEmpleadoSalida(Empleado empleado) {
        this.empleadoSalida = empleado;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setNotaEntrada(String notaEntrada) {
        this.notaEntrada = notaEntrada;
    }

    public void setNotaSalida(String notaSalida) {
        this.notaSalida = notaSalida;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public Empleado getEmpleadoEntrada() {
        return this.empleadoEntrada;
    }

    public Empleado getEmpleadoSalida() {
        return this.empleadoSalida;
    }

    public String getFechaEntrada() {
        return this.fechaEntrada;
    }

    public String getFechaSalida() {
        return this.fechaSalida;
    }

    public String getNotaEntrada() {
        return this.notaEntrada;
    }

    public String getNotaSalida() {
        return this.notaSalida;
    }
    
    public String toStringEntrada(){
       return  this.fechaEntrada + " - Entrada - " + this.vehiculo.getMatricula();
    }
    
    public String toStringSalida(){
        return  this.fechaSalida + " - Salida - " + this.vehiculo.getMatricula();
    }
}
