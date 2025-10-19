package dominio;

import java.io.Serializable;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class Vehiculo implements Serializable {
   private String matricula;
   private String marca;
   private String modelo;
   private String estado;
   private boolean estacionado;

    public Vehiculo(String matricula, String marca, String modelo, String estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.estacionado = false;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getEstado() {
        return estado;
    }
    
    public Boolean getEstacionado(){
        return estacionado;
    }
    
    public void setEstacionado(boolean esta){
        this.estacionado = esta;
    }
    
    @Override
    public String toString(){
       return  this.matricula+" - "+this.marca+" "+this.modelo;
    }
   
}
