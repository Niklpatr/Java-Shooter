/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.gameObject.cannon.Cannon;
import model.gameObject.collision.Collision;
import model.gameObject.enemy.Enemy;
import model.gameObject.missile.Missile;

/**
 *
 * @author Patrik
 */
public class State {
    private ArrayList<Missile> missiles;
    private Cannon cannon;
    private ArrayList<Enemy> enemies;
    private ArrayList<Collision> collisions;  
    private int gravity;
    private int score;

    public State(Mode m) {
        this.missiles = new ArrayList<Missile>();
        this.enemies = new ArrayList<Enemy>();
        this.collisions = new ArrayList<Collision>();
        this.cannon = new Cannon(60, 100); 
        if (m == Mode.SIMPLE) this.gravity = 30;
        else this.gravity = 30;
        this.score = 0;
    }
    
        
    public ArrayList<Missile> getMissiles() {
        return missiles;
    }

    public void setMissiles(ArrayList<Missile> m) {
        this.missiles = m;
    }
    
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> e) {
        this.enemies = e;
    }
    
    public ArrayList<Collision> getCollisions() {
        return collisions;
    }

    public void setCollisions(ArrayList<Collision> c) {
        this.collisions = c;
    }
    
    
    public Cannon getCannon() {
        return cannon;
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
