
package interfaz;

import dominio.Sistema;
import dominio.Observador;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class VentanaInfoAutores extends javax.swing.JFrame implements Observador {

    public VentanaInfoAutores(Sistema sistema) {
        initComponents();
        setModelo(sistema);
    }

    @Override
    public void actualizar() {
        //Cada vez que el modelo cambie, vuelvo a cargar la lista
        ManejadorTema.aplicarTema(this, modelo.isModoOscuro());

    }

    public void setModelo(Sistema nuevoModelo) {
        this.modelo = nuevoModelo;
        modelo.agregarObservador(this);
        actualizar(); // para refrescar datos en pantalla
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("INFORMACION DE LOS AUTORES");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 30, 310, 40);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("223939");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 460, 70, 40);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("FACUNDO SAN ANDREA");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(340, 420, 220, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/Fernando_Gonzalez.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 90, 250, 320);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel7.setText("FERNANDO GONZALEZ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 420, 200, 50);

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel8.setText(" 258053");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(400, 460, 80, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/FacundoSanAndrea.PNG"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(320, 90, 250, 320);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 550);

        setBounds(0, 0, 600, 575);
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
