package view;

import model.gameObject.cannon.Cannon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.RealModel;
import model.gameObject.GameObject;
import model.proxy.Model;

/**
 *
 * @author Patrik
 */
public class Canvas extends JPanel implements model.observer.Observer{ 
    GraphicsDrawer drawer = new GraphicsDrawer();
    private final Model model;

    public Canvas(int x, int y, int width, int height, Model model) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true); 
        
        this.model = model;
        this.model.attachObserver(this);
    }
    
    /*
    public void thisIsHowYouForceGuiToRepaint() {        
        repaint();
    }
*/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    
        drawer.drawBackground(g);
        
        for(GameObject gameO: model.getAllGameObjects()) gameO.accept(drawer);
    }
    
     @Override
    public void update() {
        repaint();
    }
    
}
