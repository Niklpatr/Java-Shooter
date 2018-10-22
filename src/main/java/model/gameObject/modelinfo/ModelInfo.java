/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.modelinfo;

import model.RealModel;
import model.gameObject.GameObject;
import model.gameObject.cannon.Cannon;
import view.GraphicsDrawer;

/**
 *
 * @author Patrik
 */
public class ModelInfo extends GameObject {

    private final RealModel model;
    private Cannon cannon;
    
    public ModelInfo(RealModel model) {
        super(20, 20);
        this.model = model;
        this.cannon = model.getState().getCannon();
    }
    
    @Override
    public String toString() {
        String score = "Score: " + model.getScore() + " ";
        String angle = "Angle: " + model.getAngle() + "° ";
        String gravity = "Gravity: " + model.getGravity() + " ";
        String force = "Force: " + model.getForce();
        return score + angle + gravity + force;
    }

    @Override
    public void accept(GraphicsDrawer d) {
        d.visit(this);
    }
    
}
