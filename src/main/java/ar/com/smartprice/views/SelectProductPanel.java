/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.views;

import ar.com.smartprice.controllers.Controller;
import ar.com.smartprice.dtos.ListadoDePreciosDto;
import ar.com.smartprice.dtos.ListadoDeProductDto;
import ar.com.smartprice.dtos.PrecioDto;
import ar.com.smartprice.dtos.ProductDto;
import ar.com.smartprice.dtos.UserDto;
import java.awt.Color;
import java.util.Comparator;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class SelectProductPanel extends javax.swing.JPanel implements ListSelectionListener {
    private Controller controller;
    private ListadoDeProductDto productos;
    private ProductDto productoSeleccionado;
    private ListadoDePreciosDto precios;
    private boolean soloOferente=false;
    private UserDto oferente;
    /**
     * Creates new form SelectProductPanel
     */
    public SelectProductPanel(Controller controller, ListadoDeProductDto productos) {
        this.productos = productos;
        this.controller= controller;
        initComponents();
        hideAddButtons();
        productable.getSelectionModel().addListSelectionListener(this);
    }
    
    public SelectProductPanel(){
        initComponents();
        hideAddButtons();
        productable.getSelectionModel().addListSelectionListener(this);
        productable.setGridColor(Color.decode("#00ABAA"));
        productable.getTableHeader().setBackground(Color.decode("#4B5261"));
        productable.getTableHeader().setForeground(Color.decode("#ECF1F5"));
        productable.setSelectionBackground(Color.decode("#00ABAA"));
        priceTable.setSelectionBackground(Color.decode("#00ABAA"));
        priceTable.setSelectionForeground(Color.decode("#ECF1F5"));
         productable.setSelectionForeground(Color.decode("#ECF1F5"));
        priceTable.setGridColor(Color.decode("#00ABAA"));
        priceTable.getTableHeader().setBackground(Color.decode("#4B5261"));
        priceTable.getTableHeader().setForeground(Color.decode("#ECF1F5"));
    }
    
    public void setRestriccion(boolean soloOferente, UserDto oferente){
        this.soloOferente=soloOferente;
        this.oferente= oferente;
    }

    public ListadoDeProductDto getProductos() {
        return productos;
    }

    public void setProductos(ListadoDeProductDto productos) {
        this.productos = productos;
        Vector<String> header = productos.getHeader();
        Vector data = productos.getData();
        DefaultTableModel model = new DefaultTableModel(data, header){
               @Override
               public boolean isCellEditable(int row, int column){
                  return false;
               }
        };
        productable.setModel(model);
        productable.changeSelection(0, 0, false, false);
    }
    
    
    public ProductDto getElementAt(int index){
        return productos.getAtIndex(index);
    }
    
    public void hideAddButtons(){
        this.btnAddProduct.setVisible(false);
        this.btnAddPrice.setVisible(false);
    }
    public void showAddButtons(){
        this.btnAddProduct.setVisible(true);
        this.btnAddPrice.setVisible(true);
    }
    
    public ProductDto getProductoSeleccionado(){
        int row = productable.getSelectedRow();
        if (row>=0){
            return productos.getAtIndex(row);
        }
        else 
            return null;
    }
    public PrecioDto precioSeleccionado(){
        int row = priceTable.getSelectedRow();
        if (row>=0){
            return precios.getAtIndex(row);
        }
        else 
            return null;
    }
    public void reordenar(Comparator<PrecioDto> comparador){
        if (precios!=null)
            precios.ordenar(comparador);
        loadPrices(precios);
    }
    public void loadPrices(ListadoDePreciosDto lista) {

        if (lista.getData() != null || !lista.getData().isEmpty()) {
            Vector<String> header = lista.getHeader();
            Vector data = lista.getData();
            DefaultTableModel model = new DefaultTableModel(data, header){
               @Override
               public boolean isCellEditable(int row, int column){
                  return false;
               }
            };
            model.setDataVector(data, header);
            this.priceTable.setModel(model);

            /*

            resultPanel.add(selectProductPanel, BorderLayout.CENTER);
            resultPanel.revalidate();
            resultPanel.repaint();
             */
        }
    }
    
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == productable.getSelectionModel()) {
            actualizarPanelPrecios();
        }
    }
    public void actualizarPanelPrecios(){
        int row = productable.getSelectedRow();
        if (row<0)
            return;
        productoSeleccionado = productos.getAtIndex(row);
        if (productoSeleccionado != null) {
            precios = productoSeleccionado.getPrecios();
            if (soloOferente)
                precios= ListadoDePreciosDto.filtrarPorOferente(precios, oferente);
        } else {
            precios = new ListadoDePreciosDto();
        }
        this.loadPrices(precios);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        priceTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        btnAddPrice = new javax.swing.JButton();

        setBackground(new java.awt.Color(236, 241, 245));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        productable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        productable.setFocusable(false);
        productable.setMinimumSize(new java.awt.Dimension(600, 600));
        productable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productable);
        productable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        priceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        priceTable.setAutoscrolls(false);
        priceTable.setFocusable(false);
        priceTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        priceTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(priceTable);
        priceTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.setBackground(new java.awt.Color(75, 82, 97));

        jLabel2.setForeground(new java.awt.Color(236, 241, 245));
        jLabel2.setText("Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(75, 82, 97));
        jPanel2.setPreferredSize(new java.awt.Dimension(888, 35));

        jLabel1.setForeground(new java.awt.Color(236, 241, 245));
        jLabel1.setText("Precios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        btnAddProduct.setBackground(new java.awt.Color(0, 171, 170));
        btnAddProduct.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(236, 241, 245));
        btnAddProduct.setText("+");
        btnAddProduct.setBorder(null);
        btnAddProduct.setFocusPainted(false);

        btnAddPrice.setBackground(new java.awt.Color(0, 171, 170));
        btnAddPrice.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAddPrice.setForeground(new java.awt.Color(236, 241, 245));
        btnAddPrice.setText("+");
        btnAddPrice.setBorder(null);
        btnAddPrice.setFocusPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnAddPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnAddPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddPrice;
    public javax.swing.JButton btnAddProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable priceTable;
    public javax.swing.JTable productable;
    // End of variables declaration//GEN-END:variables


}
