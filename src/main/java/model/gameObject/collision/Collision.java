/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.collision;

import model.audio.SoundPlayer;
import model.gameObject.GameObject;
import view.GraphicsDrawer;

/**
 *
 * @author Patrik
 */
public class Collision extends GameObject {

    private int time;
    private final SoundPlayer soundplayer = new SoundPlayer();
    
    public Collision(int x, int y) {
        super(x, y);
        time = 0;
        soundplayer.playSound("WilhelmScream.wav");
    }
    
    public Collision(Collision collision) {
        super(collision.x, collision.y);
        this.time = collision.time;
    }

    @Override
    public void accept(GraphicsDrawer d) {
        d.visit(this);
    }
    
    public int getTime() {
        return time;
    }
    
    public void tickTime() {
        time++;
    }
}
