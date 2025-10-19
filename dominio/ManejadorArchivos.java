package dominio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class ManejadorArchivos {

    private Formatter out;

    //Archivo
    public void crearArchivo(String nombreArchivo) {
        try {
            out = new Formatter(nombreArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //Archivo de texto
    public void crearArchivo(String nombreArchivo, boolean extender) {
        try {
            FileWriter f = new FileWriter(nombreArchivo, extender);
            out = new Formatter(f);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void grabarLinea(String linea) {
        if (out != null) {
            out.format("%s%n", linea);
        }
    }

    public void guardarObjeto(String nombreArchivo, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);

        }
    }

    // Leer objeto serializado
    public Object leerObjeto(String nombreArchivo) {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return obj;
    }

    public void cerrar() {
        if (out != null) {
            out.close();
        }
    }

}
