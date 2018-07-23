/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.views;

import ar.com.smartprice.controllers.Controller;
import ar.com.smartprice.dtos.ArbolCategoriesDto;
import ar.com.smartprice.dtos.ListadoDeProductDto;
import ar.com.smartprice.dtos.PrecioDto;
import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.services.CategoriesService;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Juan
 */
public class MainWindowFrame extends javax.swing.JFrame {

    private Controller controller;
    public LoginPanel loginPanel;

    //userPanel = new javax.swing.JPanel();
    //public SignInButtonPanel signInButton;
    public UserSignInPanel userSignInPanel;
    public LogoPanel logoPanel;
    public SearchPanel searchPanel;
    public UserLoggedPanel userLoggedPanel;
    public OffererLoggedPanel offererLoggedPanel;    
    public CreatePricePanel createPricePanel;
   
    public CreateProductPanel createProductPanel = new CreateProductPanel();
    public ProfilePanel profilePanel;

    public SelectProductPanel selectProductPanel;
    public ProductDetailDialog poductDetailDialog;
    public  JDialog dialogoCreateProduct;

    /**
     * Creates new form FrameVentPpal
     */
    public MainWindowFrame() {

        initComponents();

        loginPanel = new LoginPanel();
        loginPanel.setSize(220, 464);
        loginPanel.setLocation(2, 5);
        userPanel.removeAll();
        userPanel.add(loginPanel, BorderLayout.CENTER);
        userPanel.revalidate();
        userPanel.repaint();
        this.createPricePanel = new CreatePricePanel();
        this.userSignInPanel = new UserSignInPanel();
        this.userLoggedPanel = new UserLoggedPanel();
        this.offererLoggedPanel = new OffererLoggedPanel();
        selectProductPanel = new SelectProductPanel();
        profilePanel = new ProfilePanel();
        selectProductPanel.revalidate();
        selectProductPanel.repaint();
        selectProductPanel.setSize(600, 600);
        selectProductPanel.setLocation(2, 180);
        searchPanel = new SearchPanel();
        searchPanel.llenaComboCategoria(CategoriesService.getArbol());
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
        searchPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        resultPanel.add(searchPanel);
        logoPanel = new LogoPanel();
        logoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.add(logoPanel);
        resultPanel.revalidate();

        resultPanel.repaint();

    }

    public void showUserSignPanel() {
        //this.userSignInPanel = new UserSignInPanel();
        userSignInPanel.setSize(220, 600);
        userSignInPanel.setLocation(0, 5);
        userSignInPanel.clearFields();
        userPanel.removeAll();
        userPanel.add(userSignInPanel, BorderLayout.CENTER);
        userPanel.revalidate();
        userPanel.repaint();
    }

    public void showUserLoginPanel() {

        logout();

    }

    public void showUserLoggedPanel() {

        userLoggedPanel.setSize(220, 464);
        userLoggedPanel.setLocation(0, 5);
        
       
        profilePanel.clearFields();
        userPanel.removeAll();
        userPanel.add(userLoggedPanel, BorderLayout.CENTER);
        userPanel.revalidate();
        userPanel.repaint();
    }

    public void showOffererLoggedPanel(UserDto user) {
        offererLoggedPanel.setSize(220, 464);
        offererLoggedPanel.setLocation(0, 5);
       
        profilePanel.clearFields();
        userPanel.removeAll();
        userPanel.add(offererLoggedPanel, BorderLayout.CENTER);
        
        selectProductPanel.showAddButtons();
        userPanel.revalidate();
        userPanel.repaint();
    }

    public void showSelectProductPanel(ListadoDeProductDto listProducts) {
        if (listProducts.getData() != null || !listProducts.getData().isEmpty()) {
            resultPanel.removeAll();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(searchPanel);
            panel.add(selectProductPanel);
            //resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
            selectProductPanel.setProductos(listProducts);

            
            //selectProductPanel.setVisible(true);
            resultPanel.add(panel);
            // resultPanel.add(searchPanel, BorderLayout.CENTER);
            //resultPanel.setAlignmentY(Component.TOP_ALIGNMENT);
            //resultPanel.add(selectProductPanel, BorderLayout.CENTER);

            resultPanel.revalidate();
            resultPanel.repaint();
        }

    }

    public void showProductDetailDialog(PrecioDto p) {
        //this.userSignInPanel = new UserSignInPanel();
        final JDialog frame = new JDialog(this, "Dialogo", true);
        ProductDetails panel = new ProductDetails();
        panel.setData(p);
        frame.getContentPane().add(panel);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2, (Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
        frame.pack();
        frame.setVisible(true);
    }

    public void showPriceEditDialog(PrecioDto p) {
        //this.userSignInPanel = new UserSignInPanel();
        final JDialog frame = new JDialog(this, "Dialogo", true);
        frame.setSize(502, 436);
        ProductDetails panel = new ProductDetails();
        panel.setData(p);
        frame.getContentPane().add(panel);
        
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) - frame.getWidth() / 2, (Toolkit.getDefaultToolkit().getScreenSize().height) - frame.getHeight() / 2);
        frame.pack();
        frame.setVisible(true);
    }

   

    public void showCreatePricePanel(PrecioDto precio, Controller controller, boolean creandoPrecio) {
        this.controller=controller;
        final JDialog frame = new JDialog(this, "Dialogo", true);
        
        createPricePanel = new CreatePricePanel();
        createPricePanel.btnModificarPrecio.addActionListener(controller);
        createPricePanel.btnEliminarPrecio.addActionListener(controller);        
        createPricePanel.setSize(600, 400);
        createPricePanel.setLocation(0, 300);
        createPricePanel.setOwner(frame);
        if (creandoPrecio)
            createPricePanel.setValues(precio.getOferente(), precio.getProducto());
        else 
            createPricePanel.setValues(precio);
        frame.getContentPane().add(createPricePanel);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2, (Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
        //frame.setUndecorated(true);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        

    }
        public void showProfilePanel(UserDto user) {

        resultPanel.removeAll();

        profilePanel.setUser(user);

        resultPanel.add(profilePanel, BorderLayout.CENTER);
        resultPanel.revalidate();
        resultPanel.repaint();

    }

    public void showCreateProductPanel(ArbolCategoriesDto arbol) {
        
        dialogoCreateProduct = new JDialog(this, "Crear Producto", true);
        createProductPanel.setSize(600, 430);
        createProductPanel.setLocation(0, 300);
        createProductPanel.llenaComboCategoria(arbol);
        dialogoCreateProduct.getContentPane().add(createProductPanel);
        dialogoCreateProduct.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2, (Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
        dialogoCreateProduct.pack();
        
        System.out.println(this.createProductPanel.btnCreateProduct.getActionListeners().length);
        dialogoCreateProduct.setVisible(true);
    }

    public void logout() {

        loginPanel.loginPassField.setText(null);
        resultPanel.removeAll();
        resultPanel.add(searchPanel, BorderLayout.CENTER);
        resultPanel.add(logoPanel, BorderLayout.CENTER);
        resultPanel.revalidate();
        resultPanel.repaint();
        selectProductPanel.hideAddButtons();
        userPanel.removeAll();
        userPanel.add(loginPanel, BorderLayout.CENTER);
        userPanel.revalidate();
        userPanel.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPanel = new javax.swing.JPanel();
        resultPanel = new javax.swing.JPanel();
        topLogoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SmartPrice\n");
        setBackground(new java.awt.Color(75, 82, 97));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        userPanel.setBackground(new java.awt.Color(75, 82, 97));
        userPanel.setPreferredSize(new java.awt.Dimension(220, 364));

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        resultPanel.setBackground(new java.awt.Color(236, 241, 245));
        resultPanel.setPreferredSize(new java.awt.Dimension(400, 105));

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        topLogoPanel.setBackground(new java.awt.Color(75, 82, 97));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.jpg"))); // NOI18N

        javax.swing.GroupLayout topLogoPanelLayout = new javax.swing.GroupLayout(topLogoPanel);
        topLogoPanel.setLayout(topLogoPanelLayout);
        topLogoPanelLayout.setHorizontalGroup(
            topLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLogoPanelLayout.createSequentialGroup()
                .addContainerGap(434, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(378, 378, 378))
        );
        topLogoPanelLayout.setVerticalGroup(
            topLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLogoPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topLogoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topLogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel resultPanel;
    private javax.swing.JPanel topLogoPanel;
    public javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables


}
