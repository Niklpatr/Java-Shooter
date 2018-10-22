package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.RealModel;
import model.Mode;
import controller.Controller;
import model.proxy.Model;
import model.proxy.Proxy;
/**
 *
 * @author Patrik
 */
public class MainWindow extends JFrame {


    public MainWindow() {
        try {
            Model model = new Proxy(Mode.REALISTIC);
            Canvas canvas = new Canvas(0, 0, 500, 500, model);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("TotallyNotAngryBirds");
            this.setResizable(false);
            
            
            final Controller controller = new Controller(model);

            Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                  (int) (obrazovka.getWidth() / 2 - 250),
                  (int) (obrazovka.getHeight() / 2 - 250));

            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_F1) {
                        showHelp();
                    } else controller.keyPressed(evt.getKeyCode());
                }
            });

            this.add(canvas);
            this.pack();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public void showHelp() {
        JOptionPane.showMessageDialog(this, 
              "Controls:\n f5 save\nf6 load\n up up\n down down\n space shoot\n shift less force\n ctrl more force\n left aimHigher\n right aimLower"
                      + "\n caps lock toggle shot\n Q toggle mode\n + gravityUP\n - gravitydown\n");
    }
}
