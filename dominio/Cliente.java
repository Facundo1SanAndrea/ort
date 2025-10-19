package dominio;

import java.io.Serializable;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class Cliente extends Persona implements Serializable {

    private int año;
    private String celular;

    public Cliente(String nombre, int cedula, String direccion, String celular, int año) {
        super(nombre, cedula, direccion);
        this.celular = celular;
        this.año = año;
    }

    public int getAño() {
        return año;
    }

    public String getCelular() {
        return celular;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return (this.getCedula()+" - "+this.getNombre());
    }

}
