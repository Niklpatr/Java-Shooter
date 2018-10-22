/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.cannon;

import java.util.ArrayList;
import model.gameObject.GameObject;
import model.gameObject.abstractFactory.AbstractFactory;
import model.gameObject.cannon.state.CannonState;
import model.gameObject.cannon.state.DoubleShot;
import model.gameObject.cannon.state.SingleShot;
import model.gameObject.missile.Missile;
import view.GraphicsDrawer;

/**
 *
 * @author Patrik
 */
public class Cannon extends GameObject {
    private CannonState cannonState;
    private int angle;
    private int force;
    
    public Cannon(int x, int y) {
        super(x, y);
        angle = 0;
        force = 70;
        cannonState = new SingleShot();
    }    
    
    public Cannon(Cannon cannon) {
        super(cannon.x, cannon.y);
        this.angle = cannon.angle;
        this.force = cannon.force;
        this.cannonState = cannon.cannonState;
    }
    
    public ArrayList<Missile> shoot(AbstractFactory factory) {
        return cannonState.shoot(factory, this);
    }
    
    public void changeState() {
        
        if (this.cannonState instanceof SingleShot) cannonState = new DoubleShot();
        else if (this.cannonState instanceof DoubleShot) cannonState = new SingleShot();
        
    }

    
    @Override
    public void accept(GraphicsDrawer d) {
        d.visit(this);
    }

    public void forceUp() {
        if(force <= 100) force += 10;
    }
    
    public void forceDown() {
        if(force >= 5) force -= 10;
    }
    
    public void angleUp() {
        if(angle <= 5)
            angle += 5;
    }

    public void angleDown() {
        if(angle >= -85)
            angle -= 5;
    }
    
    public int getAngle() {
        return this.angle;
    }

    public int getForce() {
        return this.force;
    }
    
    public void moveUp() {    
        if(y >= 55)
            y -= 20;
    }
    
    public void moveDown() {
        if(y <= 400)
            y += 20;
    }
    public CannonState getState() {
        return this.cannonState;
    }
}
