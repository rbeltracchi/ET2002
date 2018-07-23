
package ar.com.smartprice.administration;

import ar.com.smartprice.administration.controllers.Controller;
import ar.com.smartprice.administration.views.AdministrationMainWindow;

/**
 * Aplicacion administrativa de SmartPrice
 * @version 1.0
 * @author Andres
 */
public class Administration {
    public static void main(String[] args) {       
        AdministrationMainWindow view = new AdministrationMainWindow();
        Controller controller = new Controller(view);
    }
}
