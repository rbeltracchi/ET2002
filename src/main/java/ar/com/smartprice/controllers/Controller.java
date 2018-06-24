package ar.com.smartprice.controllers;

import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.services.UsersService;
import ar.com.smartprice.views.FrameWindowMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Andres
 * @version 0.1.0
 *
 * Esta clase será la encargada de llamar a los servicios y entregar las
 * solicitudes a las vistas.
 */
public class Controller implements ActionListener{
    private UserDto user;
    private FrameWindowMain view;

    public Controller(FrameWindowMain view) {
        this.view = view;
        this.view.setVisible(true);
        this.view.loginPanel.loginButton.addActionListener(this);
    }
    
    /**
     * @author Andres
     * Este metodo llamará a la vista principal.
     */
    public static void mainView() {
        //vista.mainView();
    }

    /**
     * @author Andres
     * Este metodo llamará a la vista de registracion.
     */
    public static void registerView() {
    }
    
    /**
     * @author Andres
     * Este metodo llamará a la vista de reseteo de password.
     */
    public static void resetPasswordView() {
    }
    
    /**
     * @author Andres
     * Este metodo llamará a la vista de logueo.
     */
    public static void loginView(CredentialsDto credentials) {
        
        //UsersService userService = new UsersService();
        //UsersService.logIn(credentials);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton login del panellogin
        if(e.getSource()== this.view.loginPanel.loginButton){
            
            System.out.println(this.view.loginPanel.userLoginTextField.getText());
            System.out.println(this.view.loginPanel.loginPassField.getText());
            
            CredentialsDto credentials = new CredentialsDto(this.view.loginPanel.userLoginTextField.getText(), this.view.loginPanel.loginPassField.getText());
            this.user = UsersService.logIn(credentials);
                       
            //System.out.println("usuario " + this.user.toString());
            if(this.user.getError() != null){
                //TODO implementar ventana emergente para mostrar errores.
                System.out.println("Error " + this.user.getError().getMessage());
                return;
            }
            
            if (!this.user.getToken().isEmpty() || this.user.getToken() != null ){
                this.user.toString();
                this.view.loginPanel.setVisible(false);
            }
        }
        
    }

}
