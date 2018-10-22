/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.missile;

import model.gameObject.GameObject;
import view.GraphicsDrawer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import model.audio.SoundPlayer;
import model.gameObject.missile.strategy.Strategy;
/**
 *
 * @author Patrik
 */
public class Missile extends GameObject {
    
    private final int angle;
    private final int force;
    private int count;
    private final int startX;
    private final int startY;
    private final Strategy strategy;
    private final SoundPlayer soundplayer = new SoundPlayer();
            
    public Missile(int x, int y, int angle, int force, Strategy strategy)
    {
        super(x, y);
        this.angle = angle;
        this.force = force;
        this.strategy = strategy;
        this.count = 1;
        this.startX = x;
        this.startY = y;
        this.soundplayer.playSound("blaster-firing.wav");
    }
    
    public Missile(Missile m)
    {
        super(m.x, m.y);
        this.angle = m.angle;
        this.force = m.force;
        this.startX = m.startX;
        this.startY = m.startY;
        this.strategy = m.strategy;
        this.count = m.count;
        this.soundplayer.playSound("blaster-firing.wav");
    }

    public void move(int gravity) {
        count++;
        strategy.move(gravity, this);
    }
    
    public boolean isInBorders() {
         return (this.x <= 500 && this.y <= 500);
    }
    
    @Override
    public void accept(GraphicsDrawer d) {
       d.visit(this);
    }

    public int getAngle() {
        return angle;
    }

    public int getForce() {
        return force;
    }   
    
    public int getCount() {
        return count;
    }

    public int getStartX() {
         return startX;
     }

    public int getStartY() {
         return startY;
     }
}
