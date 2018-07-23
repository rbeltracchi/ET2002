/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.views;

import ar.com.smartprice.dtos.PrecioDto;
import ar.com.smartprice.dtos.ProductDto;
import ar.com.smartprice.dtos.UserDto;
import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 *
 * @author Lucho
 */
public class CreatePricePanel extends javax.swing.JPanel implements  FocusListener{

    public PrecioDto precio;
    private JDialog owner;

    /**
     * Creates new form createPricePanel
     */
    public CreatePricePanel() {
        
        initComponents();
        btnEliminarPrecio.setEnabled(false);
        txtPrecioUnitario.addFocusListener(this);
        txtPrecioTotal.addFocusListener(this);
        jCantidadMinima.addFocusListener(this);
        //setFormatter();
    }
    
    public void setValues(PrecioDto precio) {
        this.precio=precio;       
        jtextProduct.setText(precio.getProducto().getNombre());
        txtPrecioUnitario.setText(String.valueOf(precio.getPrecio()));
        jTextDetalle.setText(precio.getDescripcion());
        jCantidadMinima.setValue(precio.getCompraMinima());
        
        this.seleccionarCampos(precio.getFechaInicio()!=null);
        ofertaCB.setEnabled(false);
        btnEliminarPrecio.setEnabled(true);
        btnModificarPrecio.setText("Actualizar");
    }
    public void setOwner(JDialog owner){
        this.owner=owner;
    }
    public void cerrar(){
        owner.dispose();
    }
    public void setValues (UserDto oferente, ProductDto producto){
        this.precio= new PrecioDto();
        precio.setProducto(producto);
        precio.setOferente(oferente);
        jtextProduct.setText(precio.getProducto().getNombre());
        ofertaCB.setEnabled(true);
        ofertaCB.setSelected(false);
        this.hideOpcionesOferta();
        btnEliminarPrecio.setEnabled(false);
        btnModificarPrecio.setText("Publicar");
        
    }

    private void seleccionarCampos(boolean oferta){

        jCantidadMinima.setEnabled(oferta);
        jFechaFin.setEnabled(oferta);
        jFechaInicio.setEnabled(oferta);
        txtPrecioTotal.setEnabled(oferta);
        jTextDetalle.setEnabled(oferta);
        labelDetalle.setEnabled(oferta);
        labelCant.setEnabled(oferta);
        labelInicio.setEnabled(oferta);
        labelFin.setEnabled(oferta);
        labelTotal.setEnabled(oferta);
    }
    public void showOpcionesOferta(){
        this.seleccionarCampos(true);
    }
    public void hideOpcionesOferta(){
        this.seleccionarCampos(false);
    }

    public void reset(){
        this.setValues(precio);
    }
    private void ofertaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaCBActionPerformed
        // TODO add your handling code here:
        if (ofertaCB.isSelected())
            this.showOpcionesOferta();
        else this.hideOpcionesOferta();
    }//GEN-LAST:event_ofertaCBActionPerformed

    private void jTextDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDetalleActionPerformed

    private void txtPrecioUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioFocusLost
    
    }//GEN-LAST:event_txtPrecioUnitarioFocusLost

    private void txtPrecioTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioTotalFocusLost
        String campoIngresado = txtPrecioTotal.getText();
        if (campoIngresado.length()>10){
        campoIngresado= campoIngresado.substring(0, 9);
        txtPrecioTotal.setText(campoIngresado);
    }//GEN-LAST:event_txtPrecioTotalFocusLost
    }  

    @Override
    public void focusGained(FocusEvent fe) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (fe.getSource()==txtPrecioUnitario){
            String campoIngresado = txtPrecioUnitario.getText();
            if (campoIngresado.length()>10){
                campoIngresado= campoIngresado.substring(0, 9);
                }
            txtPrecioUnitario.setText(campoIngresado);
            float precioTotal = getInt(jCantidadMinima)* getFloat(txtPrecioUnitario);
            txtPrecioTotal.setText(String.valueOf(precioTotal));            
        }
        else 
            if (fe.getSource()==txtPrecioTotal){
                String campoIngresado = txtPrecioTotal.getText();
                if (campoIngresado.length()>10){
                    campoIngresado= campoIngresado.substring(0, 9);
                    }
                txtPrecioTotal.setText(campoIngresado);
                float precioU =  getFloat(txtPrecioTotal)/ getInt(jCantidadMinima);
                txtPrecioUnitario.setText(String.valueOf(precioU));            
            }
        else 
            if (fe.getSource()==jCantidadMinima){
                float precioTotal = getInt(jCantidadMinima)* getFloat(txtPrecioUnitario);
                txtPrecioTotal.setText(String.valueOf(precioTotal));              
            }        
    }

    
    public PrecioDto getModificado(){
        PrecioDto nuevo = new PrecioDto();
        nuevo.copiar(precio);
        nuevo.setPrecio( getFloat(txtPrecioUnitario));
        if (ofertaCB.isSelected()){
            nuevo.setCompraMinima(getInt(jCantidadMinima));
            nuevo.setFechaInicio(jFechaInicio.getText());
            nuevo.setFechaFin(jFechaFin.getText());
            nuevo.setDescripcion(jTextDetalle.getText());
        }
        return nuevo;
    }



private float getFloat(JTextField textField){
    String campoIngresado =  textField.getText();
    if (campoIngresado=="")
        return 0F;
    campoIngresado=campoIngresado.replaceAll(",", ".");
    float precioFloat;
    try{
        precioFloat= Float.parseFloat(campoIngresado);
    }
    catch(NumberFormatException ex){
        precioFloat=0F;
    }
    
    return precioFloat;
}
private Integer getInt(JTextField textField){
    String campoIngresado =  textField.getText();
    if (campoIngresado=="")
        return 0;
    campoIngresado=campoIngresado.replace("[,.]", "");
    Integer precioInt;
    try{
        precioInt= Integer.parseInt(textField.getText());
    }
    catch (NumberFormatException ex){
        precioInt=0;
    }
    return precioInt;
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
        labelProducto = new javax.swing.JLabel();
        labelDetalle = new javax.swing.JLabel();
        labelUnitario = new javax.swing.JLabel();
        labelCant = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        labelInicio = new javax.swing.JLabel();
        labelFin = new javax.swing.JLabel();
        jTextDetalle = new javax.swing.JTextField();
        btnModificarPrecio = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        jFechaFin = new javax.swing.JFormattedTextField();
        jCantidadMinima = new javax.swing.JFormattedTextField();
        jFechaInicio = new javax.swing.JFormattedTextField();
        ofertaCB = new javax.swing.JCheckBox();
        jtextProduct = new javax.swing.JTextField();
        btnEliminarPrecio = new javax.swing.JButton();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtPrecioTotal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(220, 229, 236));

        jPanel1.setBackground(new java.awt.Color(75, 82, 97));

        jLabel1.setBackground(new java.awt.Color(0, 171, 170));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 171, 170));
        jLabel1.setText("Editar Precio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        labelProducto.setBackground(new java.awt.Color(75, 82, 97));
        labelProducto.setForeground(new java.awt.Color(75, 82, 97));
        labelProducto.setText("Producto:");

        labelDetalle.setBackground(new java.awt.Color(75, 82, 97));
        labelDetalle.setForeground(new java.awt.Color(75, 82, 97));
        labelDetalle.setText("Datos de la Oferta:");

        labelUnitario.setBackground(new java.awt.Color(75, 82, 97));
        labelUnitario.setForeground(new java.awt.Color(75, 82, 97));
        labelUnitario.setText("Precio Unitario:");

        labelCant.setBackground(new java.awt.Color(75, 82, 97));
        labelCant.setForeground(new java.awt.Color(75, 82, 97));
        labelCant.setText("Cantidad Minima:");

        labelTotal.setBackground(new java.awt.Color(75, 82, 97));
        labelTotal.setForeground(new java.awt.Color(75, 82, 97));
        labelTotal.setText("Precio Total:");

        labelInicio.setBackground(new java.awt.Color(75, 82, 97));
        labelInicio.setForeground(new java.awt.Color(75, 82, 97));
        labelInicio.setText("Inicio de la Oferta:");

        labelFin.setBackground(new java.awt.Color(75, 82, 97));
        labelFin.setForeground(new java.awt.Color(75, 82, 97));
        labelFin.setText("Fin de la Oferta:");

        jTextDetalle.setBackground(new java.awt.Color(236, 241, 245));
        jTextDetalle.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        btnModificarPrecio.setBackground(new java.awt.Color(0, 171, 170));
        btnModificarPrecio.setForeground(new java.awt.Color(220, 229, 236));
        btnModificarPrecio.setText("Publicar");
        btnModificarPrecio.setBorder(null);

        ResetButton.setBackground(new java.awt.Color(0, 171, 170));
        ResetButton.setForeground(new java.awt.Color(220, 229, 236));
        ResetButton.setText("Reset");
        ResetButton.setBorder(null);

        jFechaFin.setBackground(new java.awt.Color(236, 241, 245));
        jFechaFin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        jFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        jFechaFin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jCantidadMinima.setBackground(new java.awt.Color(236, 241, 245));
        jCantidadMinima.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        jCantidadMinima.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jCantidadMinima.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jFechaInicio.setBackground(new java.awt.Color(236, 241, 245));
        jFechaInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        jFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        jFechaInicio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        ofertaCB.setBackground(new java.awt.Color(220, 229, 236));
        ofertaCB.setForeground(new java.awt.Color(75, 82, 97));
        ofertaCB.setText("Oferta");
        ofertaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaCBActionPerformed(evt);
            }
        });

        jtextProduct.setBackground(new java.awt.Color(236, 241, 245));
        jtextProduct.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtextProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));
        jtextProduct.setEnabled(false);
        jtextProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextProductActionPerformed(evt);
            }
        });

        btnEliminarPrecio.setBackground(new java.awt.Color(0, 171, 170));
        btnEliminarPrecio.setForeground(new java.awt.Color(220, 229, 236));
        btnEliminarPrecio.setText("Eliminar");
        btnEliminarPrecio.setBorder(null);
        btnEliminarPrecio.setBorderPainted(false);

        txtPrecioUnitario.setBackground(new java.awt.Color(236, 241, 245));
        txtPrecioUnitario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPrecioUnitario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        txtPrecioTotal.setBackground(new java.awt.Color(236, 241, 245));
        txtPrecioTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPrecioTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 82, 97)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDetalle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelProducto, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelCant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ofertaCB))
                            .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEliminarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnModificarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jFechaFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(labelUnitario)
                    .addComponent(labelTotal)
                    .addComponent(labelInicio)
                    .addComponent(labelFin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUnitario)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ofertaCB))
                    .addComponent(labelCant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInicio)
                    .addComponent(jFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFin)
                    .addComponent(jFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtextProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextProductActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ResetButton;
    public javax.swing.JButton btnEliminarPrecio;
    public javax.swing.JButton btnModificarPrecio;
    private javax.swing.JFormattedTextField jCantidadMinima;
    private javax.swing.JFormattedTextField jFechaFin;
    private javax.swing.JFormattedTextField jFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextDetalle;
    private javax.swing.JTextField jtextProduct;
    private javax.swing.JLabel labelCant;
    private javax.swing.JLabel labelDetalle;
    private javax.swing.JLabel labelFin;
    private javax.swing.JLabel labelInicio;
    private javax.swing.JLabel labelProducto;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelUnitario;
    private javax.swing.JCheckBox ofertaCB;
    private javax.swing.JTextField txtPrecioTotal;
    private javax.swing.JTextField txtPrecioUnitario;
    // End of variables declaration//GEN-END:variables
}
