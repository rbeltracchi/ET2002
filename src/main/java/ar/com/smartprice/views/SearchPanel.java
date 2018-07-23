/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.views;

import ar.com.smartprice.dtos.ArbolCategoriesDto;
import ar.com.smartprice.dtos.CategoryDto;
import ar.com.smartprice.dtos.SearchDto;
import ar.com.smartprice.models.services.GmapService;
import java.util.Vector;

/**
 *
 * @author ze
 */
public class SearchPanel extends javax.swing.JPanel{
    //private Controller controller;
    //private ArbolCategoriesDto arbolCategorias;
    public static final int PRECIO_ONLY = 0;
    public static final int PRECIO_DISTANCIA = 1;
    public static final int DISTANCIA_PRECIO = 2;
    public javax.swing.JComboBox<String> combotest;
    private ArbolCategoriesDto arbol;
    private Vector<CategoryDto> hijosActuales;
    private String direccionValidada="";
    
    
    /**
     * Creates new form searcherPanel
     */
    public SearchPanel() {
        initComponents();  
        chkMyPrices.setVisible(false);
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
    
    public String getLocationTextField(){
        return locationTextField.getText();
    }
    public void setLocationTextField(String location){
        locationTextField.setText(location);
    }
    public int getCriterioOrdenacion(){
        if (precio_only_radioButton.isSelected())
            return PRECIO_ONLY;
        if (precioDistanciaRadioButton.isSelected())
            return PRECIO_DISTANCIA;
        if (distanciaPrecioRadioButton.isSelected())
            return DISTANCIA_PRECIO;
        return PRECIO_ONLY;
    }
    public CategoryDto getCategoriaSeleccionada(){
        int index =jComboBoxSubcategoria.getSelectedIndex();
        if (hijosActuales!=null && index>=0){
            return hijosActuales.get(index);
        }
        return null;
    }
    public SearchDto getCriteriosBusqueda(){
        SearchDto nuevo = new SearchDto();
        nuevo.setCategoria(this.getCategoriaSeleccionada());
        nuevo.setSearchWord(txtSearch.getText());
        nuevo.setUserLocation(locationTextField.getText());
        nuevo.setSoloDelOferente(chkMyPrices.isSelected());
        return nuevo;
    }
    public void showOpcionesOferente(){
        chkMyPrices.setVisible(true);
    }
    public void hideOpcionesOferente(){
        chkMyPrices.setVisible(false);
    }
    private void validarDireccion(){
    direccionValidada = GmapService.validateAddress(locationTextField.getText());
    locationTextField.setText(direccionValidada);
    locationTextField.setCaretPosition(0);
    if (direccionValidada.equalsIgnoreCase("Direccion Invalida")){
            distanciaPrecioRadioButton.setEnabled(false);
            precioDistanciaRadioButton.setEnabled(false);
            precio_only_radioButton.setSelected(true);
    }
    else{
            distanciaPrecioRadioButton.setEnabled(true);
            precioDistanciaRadioButton.setEnabled(true);
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtersSearcherButtonGroup = new javax.swing.ButtonGroup();
        SmartPricePUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SmartPricePU").createEntityManager();
        categoriaQuery = java.beans.Beans.isDesignTime() ? null : SmartPricePUEntityManager.createQuery("SELECT c FROM Categoria c");
        categoriaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : categoriaQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jComboBoxSubcategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxPadre = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        locationTextField = new javax.swing.JTextField();
        precio_only_radioButton = new javax.swing.JRadioButton();
        distanciaPrecioRadioButton = new javax.swing.JRadioButton();
        precioDistanciaRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        chkMyPrices = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(236, 241, 245));

        jPanel1.setBackground(new java.awt.Color(236, 241, 245));

        txtSearch.setBackground(new java.awt.Color(236, 241, 245));
        txtSearch.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(75, 82, 97));
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        jComboBoxSubcategoria.setBackground(new java.awt.Color(236, 241, 245));
        jComboBoxSubcategoria.setForeground(new java.awt.Color(75, 82, 97));
        jComboBoxSubcategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        jLabel2.setForeground(new java.awt.Color(75, 82, 97));
        jLabel2.setText("Busqueda:");

        jComboBoxPadre.setBackground(new java.awt.Color(236, 241, 245));
        jComboBoxPadre.setForeground(new java.awt.Color(75, 82, 97));
        jComboBoxPadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        jComboBoxPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPadreActionPerformed(evt);
            }
        });
        jComboBoxPadre.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxPadrePropertyChange(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 171, 170));
        btnSearch.setForeground(new java.awt.Color(236, 241, 245));
        btnSearch.setText("Buscar");
        btnSearch.setBorder(null);
        btnSearch.setFocusPainted(false);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(236, 241, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 171, 170)));

        locationTextField.setBackground(new java.awt.Color(236, 241, 245));
        locationTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        locationTextField.setForeground(new java.awt.Color(75, 82, 97));
        locationTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        locationTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                locationTextFieldFocusLost(evt);
            }
        });

        precio_only_radioButton.setBackground(new java.awt.Color(236, 241, 245));
        filtersSearcherButtonGroup.add(precio_only_radioButton);
        precio_only_radioButton.setForeground(new java.awt.Color(75, 82, 97));
        precio_only_radioButton.setSelected(true);
        precio_only_radioButton.setText("Solo precio");
        precio_only_radioButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        distanciaPrecioRadioButton.setBackground(new java.awt.Color(236, 241, 245));
        filtersSearcherButtonGroup.add(distanciaPrecioRadioButton);
        distanciaPrecioRadioButton.setForeground(new java.awt.Color(75, 82, 97));
        distanciaPrecioRadioButton.setText("Distancia/Precio");
        distanciaPrecioRadioButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        distanciaPrecioRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaPrecioRadioButtonActionPerformed(evt);
            }
        });

        precioDistanciaRadioButton.setBackground(new java.awt.Color(236, 241, 245));
        filtersSearcherButtonGroup.add(precioDistanciaRadioButton);
        precioDistanciaRadioButton.setForeground(new java.awt.Color(75, 82, 97));
        precioDistanciaRadioButton.setText("Precio/Distancia");
        precioDistanciaRadioButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        precioDistanciaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioDistanciaRadioButtonActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(75, 82, 97));
        jLabel3.setText("Ubicación:");

        chkMyPrices.setBackground(new java.awt.Color(236, 241, 245));
        chkMyPrices.setForeground(new java.awt.Color(75, 82, 97));
        chkMyPrices.setText("Solo Mis Precios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio_only_radioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(distanciaPrecioRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioDistanciaRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkMyPrices))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio_only_radioButton)
                    .addComponent(distanciaPrecioRadioButton)
                    .addComponent(precioDistanciaRadioButton)
                    .addComponent(chkMyPrices, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPadre, 0, 125, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        /*
        String textoBuscador = (String) searcherTextField.getText();
        String catPadre = (String) categoriesComboBox.getSelectedItem();
        String catHijo = (String) jComboBoxSubCategories.getSelectedItem();
        System.out.println("Iniciar Buscador con textoBuscador= "+textoBuscador);
        System.out.println("Categoria = "+catPadre+"->"+catHijo);
*/
    }//GEN-LAST:event_btnSearchActionPerformed

    private void precioDistanciaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioDistanciaRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioDistanciaRadioButtonActionPerformed

    private void locationTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationTextFieldFocusLost
        // TODO add your handling code here:
        this.validarDireccion();
    }//GEN-LAST:event_locationTextFieldFocusLost

    private void jComboBoxPadrePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxPadrePropertyChange

    }//GEN-LAST:event_jComboBoxPadrePropertyChange

    private void jComboBoxPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPadreActionPerformed
        
        String padre = (String) jComboBoxPadre.getSelectedItem();
        if (arbol==null || padre==null)
            return;
        
        hijosActuales=arbol.getHijos(padre);
        
        jComboBoxSubcategoria.removeAllItems();
        if (hijosActuales!=null){
            for (CategoryDto cat : hijosActuales){
                String hijo = cat.getName();
                jComboBoxSubcategoria.addItem(hijo);
            }
        }
        jComboBoxSubcategoria.setSelectedIndex(0);
        
    }//GEN-LAST:event_jComboBoxPadreActionPerformed

    private void distanciaPrecioRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaPrecioRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanciaPrecioRadioButtonActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SmartPricePUEntityManager;
    public javax.swing.JButton btnSearch;
    private java.util.List<ar.com.smartprice.models.entities.Categoria> categoriaList;
    private javax.persistence.Query categoriaQuery;
    public javax.swing.JCheckBox chkMyPrices;
    public javax.swing.JRadioButton distanciaPrecioRadioButton;
    public javax.swing.ButtonGroup filtersSearcherButtonGroup;
    private javax.swing.JComboBox<String> jComboBoxPadre;
    private javax.swing.JComboBox<String> jComboBoxSubcategoria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField locationTextField;
    public javax.swing.JRadioButton precioDistanciaRadioButton;
    public javax.swing.JRadioButton precio_only_radioButton;
    public javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

   
}
