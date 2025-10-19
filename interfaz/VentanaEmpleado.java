package interfaz;

import dominio.*;

import javax.swing.*;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class VentanaEmpleado extends javax.swing.JFrame implements Observador {

    public VentanaEmpleado(Sistema sistema) {
        initComponents();
        setModelo(sistema);
    }

    @Override
    public void actualizar() {
        //Cada vez que el modelo cambie, vuelvo a cargar la lista
        cargarListas();
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
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmpleados = new javax.swing.JList();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Empleados");

        jPanel1.setLayout(null);

        lblNombre.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre);
        lblNombre.setBounds(20, 90, 100, 30);

        txtNombre.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre);
        txtNombre.setBounds(120, 90, 230, 30);

        lblCedula.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblCedula.setText("Cedula");
        jPanel1.add(lblCedula);
        lblCedula.setBounds(20, 40, 100, 30);

        txtCedula.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedula);
        txtCedula.setBounds(120, 40, 130, 30);

        lblDireccion.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblDireccion.setText("Direccion");
        jPanel1.add(lblDireccion);
        lblDireccion.setBounds(20, 140, 110, 30);

        txtDireccion.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(120, 140, 230, 30);

        lblNumero.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblNumero.setText("Numero");
        jPanel1.add(lblNumero);
        lblNumero.setBounds(20, 190, 90, 30);

        txtNumero.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumero);
        txtNumero.setBounds(120, 190, 140, 30);

        lstEmpleados.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lstEmpleados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstEmpleados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEmpleadosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEmpleados);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(371, 32, 320, 190);

        btnRegistrar.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar);
        btnRegistrar.setBounds(120, 250, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        setBounds(0, 0, 702, 340);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void cargarListas() {
        //cargo el JList a partir del ArrayList de Vehiculos
        lstEmpleados.setListData(modelo.getListaEmpleados().toArray());
    }

    private void lstEmpleadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEmpleadosValueChanged
        int posicion = lstEmpleados.getSelectedIndex();
        if (posicion != -1) {
            modelo.getListaEmpleados().get(posicion);
            txtNombre.setText(modelo.getListaEmpleados().get(posicion).getNombre());
            txtDireccion.setText(modelo.getListaEmpleados().get(posicion).getDireccion());
            txtNumero.setText("" + modelo.getListaEmpleados().get(posicion).getNumeroEmpleado());
            txtCedula.setText("" + modelo.getListaEmpleados().get(posicion).getCedula());
        }
    }//GEN-LAST:event_lstEmpleadosValueChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombre.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String numeroTxt = txtNumero.getText().trim();
        String cedulaTxt = txtCedula.getText().trim();
        if (nombre.isEmpty() || direccion.isEmpty() || numeroTxt.isEmpty() || cedulaTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No deje campos vacíos", "Faltan datos", JOptionPane.ERROR_MESSAGE);
        } else if (!cedulaTxt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe contener solo números", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } else if (!numeroTxt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Ya existe un empleado con ese numero identificador", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int numero = Integer.parseInt(numeroTxt);
                int cedula = Integer.parseInt(cedulaTxt);
                if (!modelo.existeEmpleado(numero)) {
                    modelo.agregarEmpelado(nombre, cedula, direccion, numero);
                    cargarListas();
                    JOptionPane.showMessageDialog(this, "Empleado registrado correctamente!","Registro Empleado",JOptionPane.INFORMATION_MESSAGE);
                    txtNombre.setText("");
                    txtDireccion.setText("");
                    txtNumero.setText("");
                    txtCedula.setText("");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "EL numero de Empleado ingresado ya existe.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } catch (NumberFormatException | IllegalStateException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Numero y Cedula deben ser válidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JList lstEmpleados;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
