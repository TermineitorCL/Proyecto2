/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.RecetaJpaController;
import Data.Producto;
import Data.Receta;
import Data.UnidadMedida;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class IngresoReceta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Ingreso_receta
     */
    public IngresoReceta() {
        initComponents();
         CrearModelo2 ();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Proyecto2PU").createEntityManager();
        Proyecto2PUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Proyecto2PU").createEntityManager();
        productoQuery = java.beans.Beans.isDesignTime() ? null : Proyecto2PUEntityManager.createQuery("SELECT p FROM Producto p");
        productoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : productoQuery.getResultList();
        unidadMedidaQuery = java.beans.Beans.isDesignTime() ? null : Proyecto2PUEntityManager.createQuery("SELECT u FROM UnidadMedida u");
        unidadMedidaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : unidadMedidaQuery.getResultList();
        recetaQuery = java.beans.Beans.isDesignTime() ? null : Proyecto2PUEntityManager.createQuery("SELECT r FROM Receta r");
        recetaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : recetaQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        cb_Productofinal = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_Cantidad = new javax.swing.JTextField();
        bt_Guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Tablareceta = new javax.swing.JTable();
        tf_Insumos = new javax.swing.JTextField();
        cb_unidadMedida = new javax.swing.JComboBox<>();
        bt_recargar_tabla = new javax.swing.JButton();
        cb_estado = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Producto");

        cb_Productofinal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productoList, cb_Productofinal);
        bindingGroup.addBinding(jComboBoxBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cb_Productofinal, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.nombre}"), cb_Productofinal, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        cb_Productofinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ProductofinalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Estado");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Insumos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Unidad de medida");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad");

        bt_Guardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_Guardar.setText("Guardar");
        bt_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_GuardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ingreso de Nueva Receta");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, recetaList, tb_Tablareceta);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tb_Tablareceta, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.insumos}"), tb_Tablareceta, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tb_Tablareceta);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, unidadMedidaList, cb_unidadMedida);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cb_unidadMedida, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.descripcion}"), cb_unidadMedida, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        bt_recargar_tabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_recargar_tabla.setText("Recargar tabla");
        bt_recargar_tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_recargar_tablaActionPerformed(evt);
            }
        });

        cb_estado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Desactivado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(tf_Insumos))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_unidadMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(bt_Guardar)
                                .addContainerGap(138, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_Productofinal, 0, 111, Short.MAX_VALUE)
                            .addComponent(cb_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_recargar_tabla)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_Productofinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Guardar)
                    .addComponent(tf_Insumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_recargar_tabla)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_ProductofinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ProductofinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_ProductofinalActionPerformed

    private void bt_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_GuardarActionPerformed
        entityManager1.getTransaction().begin();
        Receta r = new Receta();
        
        r.setEstado((String)cb_estado.getSelectedItem());
        r.setInsumos(tf_Insumos.getText());
        r.setCantidad(Integer.parseInt(tf_Cantidad.getText()));
        Producto pr = (Producto)cb_Productofinal.getSelectedItem();
        r.setProductoId(pr);
        UnidadMedida um = (UnidadMedida)cb_unidadMedida.getSelectedItem();
        r.setUnidadMedidadId(um);
        JOptionPane.showMessageDialog(null,"Se a guardado correctamente");
        entityManager1.persist(r);
        entityManager1.flush();
        entityManager1.getTransaction().commit();
    }//GEN-LAST:event_bt_GuardarActionPerformed

    private void bt_recargar_tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_recargar_tablaActionPerformed

        // aqui se llama al metodo que permite cargar los datos a la tabla
        llenar_tabla(); 
    }//GEN-LAST:event_bt_recargar_tablaActionPerformed
    DefaultTableModel modelo2;
    private void CrearModelo2(){
        
        try {
            
            modelo2 = (new DefaultTableModel(
            null, new String [] {
            "insumo","estado",
            "cantidad"}){
            Class[] types = new Class [] {
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
             };
            boolean[] canEdit = new boolean [] {
            false,false,false,false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex){
            return canEdit [colIndex];
            }
            });
            tb_Tablareceta.setModel(modelo2);
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString()+"error2");
            }
        }
     private void llenar_tabla(){
         
        RecetaJpaController controlador_receta = new RecetaJpaController (entityManager1.getEntityManagerFactory());
        try{
            Object A[]=null;
            List<Receta> listaReceta;
            listaReceta=controlador_receta.findRecetaEntities();
            for (int i = 0; i < listaReceta.size(); i++) {
                modelo2.addRow(A);
                modelo2.setValueAt(listaReceta.get(i).getEstado(), i, 0);
                modelo2.setValueAt(listaReceta.get(i).getInsumos(), i, 1);
                modelo2.setValueAt(listaReceta.get(i).getCantidad(), i, 2);            
            }         
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    
    
    
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager Proyecto2PUEntityManager;
    private javax.swing.JButton bt_Guardar;
    private javax.swing.JButton bt_recargar_tabla;
    private javax.swing.JComboBox<String> cb_Productofinal;
    private javax.swing.JComboBox<String> cb_estado;
    private javax.swing.JComboBox<String> cb_unidadMedida;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Data.Producto> productoList;
    private javax.persistence.Query productoQuery;
    private java.util.List<Data.Receta> recetaList;
    private javax.persistence.Query recetaQuery;
    private javax.swing.JTable tb_Tablareceta;
    private javax.swing.JTextField tf_Cantidad;
    private javax.swing.JTextField tf_Insumos;
    private java.util.List<Data.UnidadMedida> unidadMedidaList;
    private javax.persistence.Query unidadMedidaQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
