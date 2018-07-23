package ar.com.smartprice.administration.controllers;

import ar.com.smartprice.administration.views.AdministrationMainWindow;
import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.dtos.CategoryDto;
import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.models.services.AdministratorService;
import ar.com.smartprice.models.services.BrandsService;
import ar.com.smartprice.models.services.CategoriesService;
import ar.com.smartprice.models.services.ProductService;
import ar.com.smartprice.models.services.UsersService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andres
 */
public class Controller implements ActionListener {

    private AdministrationMainWindow view;

    private AdministratorDto administrator;
    private CategoryDto categories;

    private AdministratorService adminService = new AdministratorService();
    private UsersService userService = new UsersService();
    private BrandsService brandService;
    private CategoriesService categoriesService;
    private ProductService productService;

    public Controller(AdministrationMainWindow view) {
        this.view = view;
        this.view.setVisible(true);
        this.listenObjects();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //LOGIN
        if (e.getSource() == this.view.panelLogin.btnLogin) {
            System.out.println("ADMIN LOGIN");
            if(this.view.panelLogin.txtEmail.getText().isEmpty() || String.valueOf(this.view.panelLogin.txtPassword.getPassword()).isEmpty()){
                return;
            }
            this.administrator = adminService.logIn(new CredentialsDto(this.view.panelLogin.txtEmail.getText(), String.valueOf(this.view.panelLogin.txtPassword.getPassword())));
            if(administrator == null)
                return;
            
            if (this.administrator != null || !this.administrator.getToken().isEmpty() || this.administrator.getToken() != null) {
                System.out.println(this.administrator.toString());
                this.view.setCategories(CategoriesService.readall());
                this.view.administratorLogged(administrator.getName());
            }
            
        } else if (e.getSource() == this.view.panelLogged.btnLogout) {
            System.out.println("ADMIN LOGOUT");
            this.administrator = this.adminService.logOut();
            this.view.administratorLogout();
        }else if (e.getSource() == this.view.panelLogged.btnProfile){
            System.out.println("ADMIN Profile");
            
        }

    }

    private void listenObjects() {
        //panelLogin login
        this.view.panelLogin.btnLogin.addActionListener(this);

        //panelAdministratorLogged logout
        this.view.panelLogged.btnLogout.addActionListener(this);
        //panelAdministratorLogged profile
        this.view.panelLogged.btnProfile.addActionListener(this);

    }
}
