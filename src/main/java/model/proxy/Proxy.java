/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.proxy;

import java.util.ArrayList;
import model.Mode;
import model.RealModel;
import model.State;
import model.gameObject.GameObject;
import model.gameObject.cannon.Cannon;
import model.gameObject.collision.Collision;
import model.gameObject.enemy.Enemy;
import model.gameObject.missile.Missile;
import model.observer.Observer;

/**
 *
 * @author Patrik
 */
public class Proxy extends Model {
    RealModel realModel;
    
    public Proxy(Mode m) {
        realModel = new RealModel(m);
    }
    
    @Override
    public void toggleState() {
        realModel.toggleState();
    }
    @Override    
    public void attachObserver(Observer obs) {
        realModel.attachObserver(obs);
    }
    
    @Override    
    public State getState() {
        return realModel.getState();
    }
    @Override        
    public RealModel.Memento createMemento() {
        return realModel.createMemento();
    }
    @Override
    public void setMemento(RealModel.Memento memento) {
        realModel.setMemento(memento);
    }
    
    @Override
    public void toogleCannonState() {
        realModel.toogleCannonState();
    }    
    @Override
    public void createMissile() {
        realModel.createMissile();
    }
    @Override    
    public void createEnemy() {
        realModel.createEnemy();
    }
    @Override
    public void moveCannonUp() {
        realModel.moveCannonUp();
    }
    @Override
    public void moveCannonDown() {
        realModel.moveCannonDown();
    }
    @Override
    public void forceUp() {
        realModel.forceUp();
    }
    @Override
    public void forceDown() {
        realModel.forceDown();
    }
    @Override
    public void angleUp() {
        realModel.angleUp();
    }
    @Override
    public void angleDown() {
        realModel.angleDown();
    }
    @Override
    public void gravityUp() {
        realModel.gravityUp();
    }
    @Override
    public void gravityDown() {
        realModel.gravityDown();
    }
    @Override
    public Cannon getCannon() {
        return realModel.getCannon();
    }
    @Override
    public ArrayList<GameObject> getAllGameObjects() {
        return realModel.getAllGameObjects();
    }
    @Override
    public ArrayList<Missile> getMissiles() {
        return realModel.getMissiles();
    }
    @Override
    public ArrayList<Enemy> getEnemies() {
        return realModel.getEnemies();
    }
    @Override
    public ArrayList<Collision> getCollisions() {
        return realModel.getCollisions();
    }
    @Override
    public int getGravity() {
        return realModel.getGravity();
    }
    @Override
    public int getScore() {
        return realModel.getScore();
    }
    @Override
    public int getAngle() {
        return realModel.getAngle();
    }
    @Override
    public int getForce() {
        return realModel.getForce();
    }
}
