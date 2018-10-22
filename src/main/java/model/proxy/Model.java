/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import model.Mode;
import model.RealModel;
import model.RealModel.Memento;
import model.State;
import model.gameObject.GameObject;
import model.gameObject.abstractFactory.RealisticConcreteFactory;
import model.gameObject.abstractFactory.SimpleConcreteFactory;
import model.gameObject.cannon.Cannon;
import model.gameObject.collision.Collision;
import model.gameObject.enemy.Enemy;
import model.gameObject.missile.Missile;
import model.gameObject.modelinfo.ModelInfo;
import model.observer.Observer;

/**
 *
 * @author Patrik
 */
public abstract class Model {
    
    public abstract void toggleState();
    
    public abstract void attachObserver(Observer obs);
        
    public abstract State getState();
            
    public abstract Memento createMemento();
    
    public abstract void setMemento(Memento memento);
    
    public abstract void toogleCannonState();    
    
    public abstract void createMissile();
        
    public abstract void createEnemy();
    
    public abstract void moveCannonUp();
    
    public abstract void moveCannonDown();
    
    public abstract void forceUp();
    
    public abstract void forceDown();
    
    public abstract void angleUp();

    public abstract void angleDown();

    public abstract void gravityUp();
    
    public abstract void gravityDown();
    
    public abstract Cannon getCannon();
    
    public abstract ArrayList<GameObject> getAllGameObjects();
    public abstract ArrayList<Missile> getMissiles();
    public abstract ArrayList<Enemy> getEnemies();
    public abstract ArrayList<Collision> getCollisions();
    public abstract int getGravity();    
    public abstract int getScore();
    public abstract int getAngle();
    public abstract int getForce();
    
}
