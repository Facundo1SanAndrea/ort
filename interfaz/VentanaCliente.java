package interfaz;

import dominio.*;
import javax.swing.*;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class VentanaCliente extends javax.swing.JFrame implements Observador {

    public VentanaCliente(Sistema sistema) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listaClientes = new javax.swing.JList();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        lblAnio = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Clientes");

        jPanel1.setLayout(null);

        listaClientes.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        listaClientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaClientesMouseClicked(evt);
            }
        });
        listaClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaClientesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaClientes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(370, 40, 280, 190);

        lblNombre.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre);
        lblNombre.setBounds(20, 80, 70, 20);

        txtNombre.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre);
        txtNombre.setBounds(120, 80, 230, 30);

        lblDireccion.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblDireccion.setText("Direccion");
        jPanel1.add(lblDireccion);
        lblDireccion.setBounds(20, 120, 80, 20);

        txtDireccion.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(120, 120, 230, 30);

        lblCelular.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblCelular.setText("Celular");
        jPanel1.add(lblCelular);
        lblCelular.setBounds(20, 160, 60, 20);

        txtCelular.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jPanel1.add(txtCelular);
        txtCelular.setBounds(120, 160, 140, 30);

        txtCedula.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jPanel1.add(txtCedula);
        txtCedula.setBounds(120, 40, 140, 30);

        lblCedula.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblCedula.setText("Cedula");
        jPanel1.add(lblCedula);
        lblCedula.setBounds(20, 40, 60, 20);

        txtAnio.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });
        jPanel1.add(txtAnio);
        txtAnio.setBounds(120, 200, 80, 30);

        lblAnio.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblAnio.setText("Año Ingreso");
        jPanel1.add(lblAnio);
        lblAnio.setBounds(20, 200, 90, 20);

        btnAgregar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnAgregar.setText("Registrar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(150, 260, 140, 40);

        btnEliminar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(400, 260, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        setBounds(0, 0, 678, 358);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtNombre.getText().trim();
        String cedulaTexto = txtCedula.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String anioTexto = txtAnio.getText().trim();
        String celularTexto = txtCelular.getText().trim();
        if (nombre.isEmpty() || cedulaTexto.isEmpty() || direccion.isEmpty() || anioTexto.isEmpty() || celularTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No deje campos vacíos", "Error de input", JOptionPane.WARNING_MESSAGE);
        } else if (!cedulaTexto.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cédula debe contener solo números", "Error de formato", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int anio = Integer.parseInt(anioTexto);
                int celular = Integer.parseInt(celularTexto); //solo para verificar que es numerico
                int cedula = Integer.parseInt(cedulaTexto);
                if (!modelo.existeCliente(cedula)) {
                    modelo.agregarCliente(nombre, cedula, direccion, celularTexto, anio);
                    cargarListas();
                    JOptionPane.showMessageDialog(this, "Cliente registrado correctamente!","Registro Cliente",JOptionPane.INFORMATION_MESSAGE);
                    txtNombre.setText("");
                    txtDireccion.setText("");
                    txtAnio.setText("");
                    txtCedula.setText("");
                    txtCelular.setText("");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Ya existe un cliente registrado con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Cedula, Celular y Año deben ser números válidos", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Cliente seleccionado = (Cliente) listaClientes.getSelectedValue();
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe selecionar un Cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar al cliente " + seleccionado.getNombre() + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            modelo.eliminarCliente(seleccionado);
            cargarListas();
            JOptionPane.showMessageDialog(this, "Cliente eliminado del registro.", "Cliente eliminado", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cargarListas() {
        //cargo el JList a partir del ArrayList de Vehiculos
        listaClientes.setListData(modelo.getListaClientes().toArray());
    }


    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void listaClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaClientesValueChanged
        int posicion = listaClientes.getSelectedIndex();
        if (posicion != -1) {
            modelo.getListaClientes().get(posicion);
            txtNombre.setText(modelo.getListaClientes().get(posicion).getNombre());
            txtDireccion.setText(modelo.getListaClientes().get(posicion).getDireccion());
            txtAnio.setText("" + modelo.getListaClientes().get(posicion).getAño());
            txtCedula.setText("" + modelo.getListaClientes().get(posicion).getCedula());
            txtCelular.setText(modelo.getListaClientes().get(posicion).getCelular());
        }
    }//GEN-LAST:event_listaClientesValueChanged

    private void listaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaClientesMouseClicked

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList listaClientes;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
