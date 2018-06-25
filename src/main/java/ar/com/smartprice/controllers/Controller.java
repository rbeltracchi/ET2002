package ar.com.smartprice.controllers;

import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.services.UsersService;
import ar.com.smartprice.views.MainWindowFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * @author Andres
 * @version 0.1.0
 *
 * Esta clase será la encargada de llamar a los servicios y entregar las
 * solicitudes a las vistas.
 */
public class Controller implements ActionListener {

    private UserDto user;
    private MainWindowFrame view;

    public Controller(MainWindowFrame view) {
        this.view = view;
        this.view.setVisible(true);
        this.listenObjects();
    }

    /**
     * @author Andres Este metodo llamará a la vista principal.
     */
    public static void mainView() {
        //vista.mainView();
    }

    /**
     * @author Andres Este metodo llamará a la vista de registracion.
     */
    public static void registerView() {
    }

    /**
     * @author Andres Este metodo llamará a la vista de reseteo de password.
     */
    public static void resetPasswordView() {
    }

    /**
     * @author Andres Este metodo llamará a la vista de logueo.
     */
    private void login() {
        CredentialsDto credentials = new CredentialsDto(this.view.loginPanel.userLoginTextField.getText(), this.view.loginPanel.loginPassField.getText());
        this.user = UsersService.logIn(credentials);
        //TODO finalizado el proyecto Borrar el print
        System.out.println("usuario " + this.user.toString());
        if (this.user.getError() != null) {
            //TODO implementar ventana emergente para mostrar errores.
            System.out.println("Error " + this.user.getError().getMessage());
            JOptionPane.showMessageDialog(this.view, this.user.getError().getMessage());
            return;
        }

        if (!this.user.getToken().isEmpty() || this.user.getToken() != null) {
            this.user.toString();
            this.view.loginPanel.setVisible(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton login del panellogin
        if (e.getSource() == this.view.loginPanel.loginButton) {
            this.login();
        } else if (e.getSource() == this.view.loginPanel.signInButton) {
            System.out.println("boton registrarse");

            this.view.userPanel.remove(this.view.loginPanel);

            this.view.createAndShowUserSignPanel();

        } else if (e.getSource() == this.view.userSignInPanel.userTypeCombo) {
            System.out.println("evento en el combo");
            //String.valueOf(this.view.userSignInPanel.userTypeCombo.getSelectedItem());
            switch (String.valueOf(this.view.userSignInPanel.userTypeCombo.getSelectedItem())) {
                case "Consumidor":
                    System.out.println("Se selecciono Consumidor");
                    this.view.userSignInPanel.clearFields();
                    this.view.userSignInPanel.hideOffererFilds();
                    break;
                case "Oferente":
                    System.out.println("Se selecciono Oferente");
                    this.view.userSignInPanel.clearFields();
                    this.view.userSignInPanel.showOffererFilds();
                    break;
                    
                default:
                    throw new AssertionError();
            }
  
                  
            //this.view.userPanel
                
        }

    }

    /**
     * @author Andres Este metodo pone como observer al controlador en los
     * distintos objetos de las vistas.
     */
    private void listenObjects() {
        this.view.loginPanel.loginButton.addActionListener(this);
        this.view.loginPanel.signInButton.addActionListener(this);
        this.view.userSignInPanel.userTypeCombo.addActionListener(this);
    }

}
