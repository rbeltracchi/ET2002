/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.views;

/**
 *
 * @author ze
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userLoginTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        loginPassField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ze\\Pictures\\User1.jpg")); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setText("Usuario ");

        userLoginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLoginTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Contraseña ");

        loginPassField.setText("jPasswordField1");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Olvide mi contraseña");

        loginButton.setText("Iniciar Seción");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(userLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(loginPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userLoginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLoginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userLoginTextFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String user,pass;
        user=userLoginTextField.getText();
        pass=loginPassField.getText();

        //        boolean mailValido = validarEmail(user);
        //
        //        if (mailValido == true) {
            //            if (user.equals("useroferente@gmail.com") && pass.equals("123456")) {
                //
                //                OferenteLoginView loginOfer = new OferenteLoginView();
                //                loginOfer.setVisible(true);
                //                this.dispose();
                //            } else{
                //                if (user.equals("userconsumidor@gmail.com") && pass.equals("1234")) {
                    //                    PanelConsLogin pCons = new PanelConsLogin();
                    //                    pCons.setSize(600, 400);
                    //                    pCons.setLocation(5, 5);
                    //
                    //                    panelPpal1.removeAll();
                    //                    panelPpal1.add(pCons, BorderLayout.CENTER);
                    //                    panelPpal1.revalidate();
                    //                    panelPpal1.repaint();
                    //                    /*ConsLoginView loginCons = new ConsLoginView();
                    //                    loginCons.setVisible(true);
                    //                    this.dispose();*/
                    //                } else {
                    //                    JOptionPane.showMessageDialog(null, "El Usuario o la Contraseña es Invalido!!!");
                    //                    MainView venPPal = new MainView();
                    //                    venPPal.setVisible(true);
                    //                    this.dispose();
                    //
                    //                }
                //            }
            //        } else {
            //            JOptionPane.showMessageDialog(null, "Ingrese un E-Mail valido!!! ");
            //            MainView venPPal = new MainView();
            //            venPPal.setVisible(true);
            //            this.dispose();
            //        }
        //
    }//GEN-LAST:event_loginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField loginPassField;
    private javax.swing.JTextField userLoginTextField;
    // End of variables declaration//GEN-END:variables
}
