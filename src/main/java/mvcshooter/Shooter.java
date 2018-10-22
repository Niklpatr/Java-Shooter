package mvcshooter;

import view.MainWindow;
import javax.swing.SwingUtilities;

/**
 *
 * @author Patrik
 */
public class Shooter {
    
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow().setVisible(true);
            }
        });
    }
}
