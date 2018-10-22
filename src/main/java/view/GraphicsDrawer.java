package view;

import model.gameObject.cannon.Cannon;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.gameObject.collision.Collision;
import model.gameObject.enemy.Enemy;
import model.gameObject.enemy.EnemyType;
import model.gameObject.missile.Missile;
import model.gameObject.modelinfo.ModelInfo;
import model.audio.SoundPlayer;
/**
 *
 * @author Patrik
 */
public class GraphicsDrawer {
    
    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage missileImage;
    private BufferedImage collisionImage;
    private BufferedImage backgroundImage;
    private Graphics graphics;
 

    public GraphicsDrawer() {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
            enemyImage1 = ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
            enemyImage2 = ImageIO.read(getClass().getResourceAsStream("/images/enemy2.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
            collisionImage = ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/background.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public void drawBackground(Graphics g) {
        this.graphics = g;
        graphics.drawImage(backgroundImage, 0,0, null);
    }
        
    public void visit(Cannon c) {
        graphics.drawImage(cannonImage, c.getX(), c.getY() /*- (int)(cannonImage.getHeight() * 0.5)*/, null);
    }
    
    public void visit(Enemy e) {
        BufferedImage enemyImage;
        if (e.getType() == EnemyType.SIMPLE ) enemyImage = enemyImage1;
        else enemyImage = enemyImage2;
        graphics.drawImage(enemyImage, e.getX(), e.getY(), null);
    }
    
    public void visit(Missile m) {
        graphics.drawImage(missileImage, m.getX(), m.getY(), null);
    }
    
    public void visit(Collision c) {        
        graphics.drawImage(collisionImage, c.getX(), c.getY(), null);

    }
    
    public void visit(ModelInfo mI) {
        graphics.drawString(mI.toString(), mI.getX(), mI.getY());
    }
        
}
