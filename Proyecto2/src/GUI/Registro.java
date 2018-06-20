/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Data.Usuario;
import javax.swing.JOptionPane;
/**
 *
 * @author Diseño Estabanquillo Codigo Matias
 */
public class Registro extends javax.swing.JInternalFrame {

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Proyecto2PU").createEntityManager();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_guardarRegistro = new javax.swing.JButton();
        tf_nombreRegistro = new javax.swing.JTextField();
        tf_correoRegistro = new javax.swing.JTextField();
        tf_contraRegistro = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox<>();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Contraseña :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Correo :");

        tf_guardarRegistro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_guardarRegistro.setText("Guardar");
        tf_guardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_guardarRegistroActionPerformed(evt);
            }
        });

        tf_nombreRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreRegistroActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Registro de usuario");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tipo de Usuario :");

        cb_tipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_guardarRegistro)
                            .addComponent(tf_correoRegistro)
                            .addComponent(tf_nombreRegistro)
                            .addComponent(tf_contraRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(cb_tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_nombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_contraRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_correoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(tf_guardarRegistro)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nombreRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombreRegistroActionPerformed

    private void tf_guardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_guardarRegistroActionPerformed

        String tf1 = tf_nombreRegistro.getText();
        String tf2 = tf_contraRegistro.getText();
        String tf3 = tf_correoRegistro.getText();

        if (tf1.isEmpty() && tf2.isEmpty() && tf3.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Porfavor Ingrese datos", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (tf1.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Porfavor Ingrese un nombre", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (tf2.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Porfavor Ingrese una contraseña ", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (tf3.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Porfavor ingrese un correo", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            entityManager1.getTransaction().begin();
            Usuario u = new Usuario();
            u.setNombre(tf_nombreRegistro.getText());
            u.setPass(tf_contraRegistro.getText());
            u.setCorreo(tf_correoRegistro.getText());
            u.setTipo((String)cb_tipo.getSelectedItem());
            
            entityManager1.persist(u);
            entityManager1.flush();
            entityManager1.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro guardado con exito");
            limpiar();
            
        }
    }//GEN-LAST:event_tf_guardarRegistroActionPerformed

    public void limpiar() {
        tf_nombreRegistro.setText("");
        tf_contraRegistro.setText("");
        tf_correoRegistro.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_tipo;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField tf_contraRegistro;
    private javax.swing.JTextField tf_correoRegistro;
    private javax.swing.JButton tf_guardarRegistro;
    private javax.swing.JTextField tf_nombreRegistro;
    // End of variables declaration//GEN-END:variables
}
