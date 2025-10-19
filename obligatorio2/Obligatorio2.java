package obligatorio2;

import interfaz.*;
import dominio.*;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class Obligatorio2 {

    public static void main(String[] args){
        Sistema sistema = new Sistema();
        VentanaMenu vMenu = new VentanaMenu(sistema);
        vMenu.setVisible(true);
    }
}
