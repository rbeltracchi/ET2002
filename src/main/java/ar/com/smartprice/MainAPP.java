package ar.com.smartprice;

import ar.com.smartprice.controllers.Controller;
import ar.com.smartprice.views.MainWindowFrame;
import ar.com.smartprice.views.Splash;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author Andres
 *
 */
public class MainAPP {

    public static void main(String[] args) throws MalformedURLException {
        Splash splash = new Splash();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - splash.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - splash.getHeight()) / 2);
        splash.setLocation(x, y);
        splash.setVisible(true);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.setVisible(false);
        MainWindowFrame view = new MainWindowFrame();
        Controller controller = new Controller(view);
    }
}
