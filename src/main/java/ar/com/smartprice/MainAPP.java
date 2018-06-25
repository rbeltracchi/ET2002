package ar.com.smartprice;

import ar.com.smartprice.controllers.Controller;
import ar.com.smartprice.views.MainWindowFrame;

/**
 *
 * @author Andres
 */
public class MainAPP {

    public static void main(String[] args) {
        MainWindowFrame view = new MainWindowFrame();
        Controller controller = new Controller(view);
    }
}
