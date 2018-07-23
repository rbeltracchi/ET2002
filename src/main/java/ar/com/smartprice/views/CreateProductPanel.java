/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.views;

import ar.com.smartprice.dtos.ArbolCategoriesDto;
import ar.com.smartprice.dtos.CategoryDto;
import ar.com.smartprice.dtos.ProductDto;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 *
 * @author Lucho
 */
public class CreateProductPanel extends javax.swing.JPanel {
    private ArbolCategoriesDto arbol;
    private Vector<CategoryDto> hijosActuales;

    /**
     * Creates new form CreateProductPanel
     */
    public CreateProductPanel() {
        initComponents();
    }

    public CategoryDto getCategoriaSeleccionada(){
        int index =JComboBoxHijos.getSelectedIndex();
        if (hijosActuales!=null && index>=0){
            return hijosActuales.get(index);
        }
        return null;
    }
    public void llenaComboCategoria(ArbolCategoriesDto arbol) {
        this.arbol=arbol;
        this.jComboBoxPadre.removeAllItems();
        if (arbol==null)
            return;
        for(String padre : arbol.getPadres()){
            this.jComboBoxPadre.addItem(padre);
            }
        jComboBoxPadre.setSelectedIndex(0);
    }
   
    public ProductDto getProductDto(){
        ProductDto nuevo = new ProductDto();
       
        nuevo.setNombre(txtProctName.getText());
        nuevo.setMarca(txtProductBrand.getText());
        nuevo.setDescripcion(txtProductDesc.getText());
        nuevo.setCategoria(this.getCategoriaSeleccionada());
       
        return nuevo;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProctName = new javax.swing.JTextField();
        txtProductDesc = new javax.swing.JTextField();
        txtProductBrand = new javax.swing.JTextField();
        btnCreateProduct = new javax.swing.JButton();
        jComboBoxPadre = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        JComboBoxHijos = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(236, 241, 245));

        jPanel1.setBackground(new java.awt.Color(75, 82, 97));
        jPanel1.setForeground(new java.awt.Color(236, 241, 245));

        jLabel1.setForeground(new java.awt.Color(236, 241, 245));
        jLabel1.setText("Crear Producto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel1)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(75, 82, 97));
        jLabel2.setText("Nombre:");

        jLabel3.setForeground(new java.awt.Color(75, 82, 97));
        jLabel3.setText("Descripcion:");

        jLabel4.setForeground(new java.awt.Color(75, 82, 97));
        jLabel4.setText("Marca:");

        jLabel5.setForeground(new java.awt.Color(75, 82, 97));
        jLabel5.setText("Categoria:");

        txtProctName.setBackground(new java.awt.Color(236, 241, 245));
        txtProctName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtProctName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        txtProductDesc.setBackground(new java.awt.Color(236, 241, 245));
        txtProductDesc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtProductDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        txtProductBrand.setBackground(new java.awt.Color(236, 241, 245));
        txtProductBrand.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtProductBrand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        btnCreateProduct.setBackground(new java.awt.Color(0, 171, 170));
        btnCreateProduct.setForeground(new java.awt.Color(236, 241, 245));
        btnCreateProduct.setText("Guardar");
        btnCreateProduct.setBorder(null);
        btnCreateProduct.setFocusPainted(false);

        jComboBoxPadre.setBackground(new java.awt.Color(236, 241, 245));
        jComboBoxPadre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBoxPadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        jComboBoxPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPadreActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(75, 82, 97));
        jLabel6.setText("Subcategoria:");

        JComboBoxHijos.setBackground(new java.awt.Color(236, 241, 245));
        JComboBoxHijos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        JComboBoxHijos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProctName)
                            .addComponent(txtProductDesc)
                            .addComponent(txtProductBrand)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnCreateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JComboBoxHijos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxPadre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProctName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProductDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JComboBoxHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jComboBoxPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPadreActionPerformed
        // TODO add your handling code here:
        String padre = (String) jComboBoxPadre.getSelectedItem();
        if (arbol==null || padre==null)
            return;
        
        hijosActuales=arbol.getHijos(padre);
        
        JComboBoxHijos.removeAllItems();
        if (hijosActuales!=null){
            for (CategoryDto cat : hijosActuales){
                String hijo = cat.getName();
                JComboBoxHijos.addItem(hijo);
            }
        }
        JComboBoxHijos.setSelectedIndex(0);
        
    }//GEN-LAST:event_jComboBoxPadreActionPerformed


    private void JComboBoxHijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxHijosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxHijosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBoxHijos;
    public javax.swing.JButton btnCreateProduct;
    private javax.swing.JComboBox<String> jComboBoxPadre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtProctName;
    private javax.swing.JTextField txtProductBrand;
    private javax.swing.JTextField txtProductDesc;
    // End of variables declaration//GEN-END:variables
}