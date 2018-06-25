/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.views;
//import ar.com.smartprice.utils.Validations;

import javax.swing.JTextField;

/**
 *
 * @author Santiago
 */
public final class UserSignInPanel extends javax.swing.JPanel {

    /**
     * Creates new form singInOffererPanel
     */
    public UserSignInPanel() {
        initComponents();
        //setBackground( Color(102,51,153,100));
        this.hideOffererFilds();
        this.hideWarnings();
        

        /*
       nameInvalid.setVisible(false);
       lastNameInvalid.setVisible(false);
       emailInvalid.setVisible(false);
       businessNameInvalid.setVisible(false);
       cuitInvalid.setVisible(false);
       passwordInvalid.setVisible(false);
       repeatPasswordInvalid.setVisible(false);
         */
 /*
       if (jRadioButton1.isSelected()){
            nameLabel.setVisible(false);
            nameTextField.setVisible(false);
            //nameSeparator.setVisible(false);
            lastNameLabel.setVisible(false);
            lastNameTextField.setVisible(false);
            //lastNameSeparator.setVisible(false);
            businessNameLabel.setVisible(false);
            businessNameTextField.setVisible(false);
            //businessNameSeparator.setVisible(false);
            cuitLabel.setVisible(false);
            cuitTextField.setVisible(false);
            //cuitSeparator.setVisible(false);
            nameInvalid.setVisible(false);  
       }
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupChangeUser = new javax.swing.ButtonGroup();
        nameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        businessNameTextField = new javax.swing.JTextField();
        cuitTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        businessNameLabel = new javax.swing.JLabel();
        cuitLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        repeatPasswordLabel = new javax.swing.JLabel();
        repeatPasswordField = new javax.swing.JPasswordField();
        passwordDisplayRadioButton = new javax.swing.JRadioButton();
        nameInvalid = new javax.swing.JLabel();
        lastNameInvalid = new javax.swing.JLabel();
        emailInvalid = new javax.swing.JLabel();
        businessNameInvalid = new javax.swing.JLabel();
        cuitInvalid = new javax.swing.JLabel();
        passwordInvalid = new javax.swing.JLabel();
        repeatPasswordInvalid = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        userTypeCombo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        nameLabel.setText("Nombre");

        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        lastNameLabel.setText("Apellido");

        emailLabel.setText("E-mail");

        businessNameLabel.setText("Razon Social");

        cuitLabel.setText("CUIT");

        passwordLabel.setText("Contraseña");

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        repeatPasswordLabel.setText("Repetir contraseña");

        repeatPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatPasswordFieldActionPerformed(evt);
            }
        });

        passwordDisplayRadioButton.setText("Mostrar Contraseña ");
        passwordDisplayRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordDisplayRadioButtonActionPerformed(evt);
            }
        });

        nameInvalid.setFont(nameInvalid.getFont().deriveFont(nameInvalid.getFont().getStyle() | java.awt.Font.BOLD, nameInvalid.getFont().getSize()+1));
        nameInvalid.setForeground(new java.awt.Color(255, 0, 0));
        nameInvalid.setText("Nombre invalido");

        lastNameInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lastNameInvalid.setText("Apellido invalido");

        emailInvalid.setForeground(new java.awt.Color(255, 0, 51));
        emailInvalid.setText("E-mail invalido");

        businessNameInvalid.setForeground(new java.awt.Color(255, 0, 51));
        businessNameInvalid.setText("Razon social invalida");

        cuitInvalid.setForeground(new java.awt.Color(255, 0, 51));
        cuitInvalid.setText("Cuit invalido");

        passwordInvalid.setForeground(new java.awt.Color(255, 0, 51));
        passwordInvalid.setText("Contraseña invalida");

        repeatPasswordInvalid.setForeground(new java.awt.Color(255, 0, 51));
        repeatPasswordInvalid.setText("Contraseña no coincide");

        registerButton.setText("Registrarse");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        userTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consumidor", "Oferente" }));
        userTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTypeComboActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(repeatPasswordInvalid))
                    .addComponent(repeatPasswordLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(businessNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(businessNameInvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(registerButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passwordDisplayRadioButton)))
                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(repeatPasswordField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cuitTextField)
                    .addComponent(lastNameTextField)
                    .addComponent(userTypeCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailTextField)
                    .addComponent(PasswordField)
                    .addComponent(businessNameTextField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameInvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lastNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lastNameInvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cuitLabel)
                                .addGap(18, 18, 18)
                                .addComponent(cuitInvalid))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordInvalid))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addGap(18, 18, 18)
                                .addComponent(emailInvalid)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel)
                    .addComponent(emailInvalid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(passwordInvalid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(repeatPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(repeatPasswordInvalid, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repeatPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameInvalid))
                .addGap(6, 6, 6)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameInvalid))
                .addGap(6, 6, 6)
                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuitLabel)
                    .addComponent(cuitInvalid))
                .addGap(6, 6, 6)
                .addComponent(cuitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(businessNameLabel)
                    .addComponent(businessNameInvalid))
                .addGap(6, 6, 6)
                .addComponent(businessNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordDisplayRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerButton)
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addContainerGap(197, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    /*
    *@author Santiago
    *   METODO QUE VALIDA EMAIL Y PASSWORD
    *   ESTE METODO LLAMA A OTROS QUE ESTAN EN LA CLASE VALIDATIONS
    *   SIN EL METODO SE REPETIRIA EL MISMO CODIGO TANTO PARA USUARIO CONSUMIDOR COMO OFERENTE
     */
    public void validarMailPass(JTextField email, JTextField pas, JTextField rp) {
        /*
           if ( ! Validations.SANITIZACION(emailTextField.getText())){
               emailInvalid.setVisible(false);
               if (Validations.EMAILVALIDATION(emailTextField.getText())){
                   emailInvalid.setVisible(false);
                   if ( Validations.VALIDARPASSWORD(PasswordField.getPassword(), repeatPasswordField.getPassword())){
                       passwordInvalid.setVisible(false);
                       repeatPasswordInvalid.setVisible(false);
                   } else {
                       PasswordField.setText("");
                       passwordInvalid.setVisible(true);
                       repeatPasswordField.setText("");
                       repeatPasswordInvalid.setVisible(true);
                   }
               }else{
                   emailTextField.setText("");
                   emailInvalid.setVisible(true);
               }
           } else {
               emailTextField.setText("");
               emailInvalid.setVisible(true);   
        }
         */
    }

    /**
     *
     * @author Santiago BOTON PARA REGISTRARSE ANTES DE CREAR UNA INSTANCIA DE
     * USERDTO VERIFICA: SANITIZACION: TODOS LOS CAMPOS ESCRITURA CORRECTA :
     * MAIL, CUIT, CONTRASEÑAS
     *
     * EN CASO DE QUE EL USUARIO YA ESTE REGISTRADO DEBERIA MOSTRAR MENSAJE.
     */
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        /*
        if (jRadioButton1.isSelected()){
            validarMailPass(emailTextField, PasswordField,repeatPasswordField);
        } else {
              if (jRadioButton2.isSelected()){
                  if (Validations.SANITIZACION(nameTextField.getText())){ // nombre
                      nameInvalid.setVisible(false);
                      if (Validations.SANITIZACION(lastNameTextField.getText())){ // apellido
                          lastNameInvalid.setVisible(false);
                          if (Validations.SANITIZACION(businessNameTextField.getText())){ // razon social
                              businessNameInvalid.setVisible(false);
                              if (Validations.VALIDARCUIT(cuitTextField.getText())){ // cuit
                                  cuitInvalid.setVisible(false);
                                  // falta validar mail y pass
                              } else {
                                  
                              }
                          } else {
                              
                          }
                      } else {
                          
                      }
                  } else {
                      
                  }
                  
              }
            }
         */
    }//GEN-LAST:event_registerButtonActionPerformed

    /**
     *
     * @author Santiago BOTON MOSTRAR / OCULTAR CONTRASEÑA VISTA PASSWORDFIELD
     */
    private void passwordDisplayRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordDisplayRadioButtonActionPerformed
        if (passwordDisplayRadioButton.isSelected()) {
            PasswordField.setEchoChar((char) 0);
            repeatPasswordField.setEchoChar((char) 0);
        } else {
            if (!passwordDisplayRadioButton.isSelected()) {
                PasswordField.setEchoChar('*');
                repeatPasswordField.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_passwordDisplayRadioButtonActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void repeatPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeatPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repeatPasswordFieldActionPerformed

    private void userTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTypeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTypeComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel businessNameInvalid;
    private javax.swing.JLabel businessNameLabel;
    private javax.swing.JTextField businessNameTextField;
    private javax.swing.ButtonGroup buttonGroupChangeUser;
    private javax.swing.JLabel cuitInvalid;
    private javax.swing.JLabel cuitLabel;
    private javax.swing.JTextField cuitTextField;
    private javax.swing.JLabel emailInvalid;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lastNameInvalid;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel nameInvalid;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JRadioButton passwordDisplayRadioButton;
    private javax.swing.JLabel passwordInvalid;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JPasswordField repeatPasswordField;
    private javax.swing.JLabel repeatPasswordInvalid;
    private javax.swing.JLabel repeatPasswordLabel;
    public javax.swing.JComboBox<String> userTypeCombo;
    // End of variables declaration//GEN-END:variables

    public void hideOffererFilds() {
        
        nameLabel.setVisible(false);
        nameTextField.setVisible(false);
        //nameSeparator.setVisible(false);
        lastNameLabel.setVisible(false);
        lastNameTextField.setVisible(false);
        //lastNameSeparator.setVisible(false);
        businessNameLabel.setVisible(false);
        businessNameTextField.setVisible(false);
        //businessNameSeparator.setVisible(false);
        cuitLabel.setVisible(false);
        cuitTextField.setVisible(false);
        //cuitSeparator.setVisible(false);
        nameInvalid.setVisible(false);
    }

    public void showOffererFilds() {
        
        nameLabel.setVisible(true);
        nameTextField.setVisible(true);
        //nameSeparator.setVisible(true);
        lastNameLabel.setVisible(true);
        lastNameTextField.setVisible(true);
        //lastNameSeparator.setVisible(true);
        businessNameLabel.setVisible(true);
        businessNameTextField.setVisible(true);
        //businessNameSeparator.setVisible(true);
        cuitLabel.setVisible(true);
        cuitTextField.setVisible(true);
        //cuitSeparator.setVisible(true);
    }

    public void clearFields() {
        emailTextField.setText("");
        PasswordField.setText("");
        repeatPasswordField.setText("");
        nameTextField.setText("");
        lastNameTextField.setText("");
        cuitTextField.setText("");
        businessNameTextField.setText("");
    }

    private void hideWarnings() {
        emailInvalid.setVisible(false);
        passwordInvalid.setVisible(false);
        repeatPasswordInvalid.setVisible(false);
        nameInvalid.setVisible(false);
        lastNameInvalid.setVisible(false);
        cuitInvalid.setVisible(false);
        businessNameInvalid.setVisible(false);
    }

}