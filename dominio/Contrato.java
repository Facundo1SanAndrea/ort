package dominio;

import java.io.Serializable;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class Contrato implements Serializable {

    private int id;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Empleado empleado;
    private int valor;

    public Contrato(int id, Cliente cliente, Vehiculo vehiculo, Empleado empleado, int valor) {
        this.id = id;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.valor = valor;
    }

    public int getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public int getValor() {
        return this.valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.cliente.getNombre() + " - " + this.vehiculo.getMatricula();
    }

}
