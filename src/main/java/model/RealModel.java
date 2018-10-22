/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import model.gameObject.GameObject;
import model.gameObject.abstractFactory.AbstractFactory;
import model.gameObject.abstractFactory.RealisticConcreteFactory;
import model.gameObject.abstractFactory.SimpleConcreteFactory;
import model.gameObject.cannon.Cannon;
import model.gameObject.collision.Collision;
import model.gameObject.enemy.Enemy;
import model.gameObject.missile.Missile;
import model.gameObject.modelinfo.ModelInfo;
import model.observer.Observer;
import model.proxy.Model;
/**
 *
 * @author Patrik
 */
public class RealModel extends Model{
    private State state;
    private ArrayList<Observer> observers;
    private AbstractFactory factory;
    private ModelInfo modelInfo;
    private Mode mode;

    public RealModel(Mode m) {
        mode = m;
        state = new State(m);
        observers = new ArrayList<Observer>();
        if (m == Mode.SIMPLE) factory =  new SimpleConcreteFactory();
        else factory = new RealisticConcreteFactory();
        modelInfo = new ModelInfo(this);
        run();                
    }
    
    @Override
    public void toggleState() {
        if (mode == Mode.SIMPLE) {
            this.state.setGravity(30);
            factory =  new RealisticConcreteFactory();
            mode = Mode.REALISTIC;
        }
        else {
            mode = Mode.SIMPLE;
            this.state.setGravity(30);
            factory =  new SimpleConcreteFactory();
        }
    }
    @Override
    public void attachObserver(Observer obs) {
        this.observers.add(obs);
    }

    private void notifyObservers() {
        for(Observer it: observers) it.update();
    }
    @Override
    public State getState() {
        return this.state;
    }
    
        
    public class Memento
    {
        State state;
        
        Memento(RealModel model) {
            state = new State(mode);
            setState(model);        
        }
        
        private void setState(RealModel model) {
            for(Collision c: model.getState().getCollisions()) {
                state.getCollisions().add(new Collision(c));
            }
            for(Enemy e: model.getState().getEnemies()) {
                state.getEnemies().add(e.copy());
            }
            for(Missile m: model.getState().getMissiles()) {
                state.getMissiles().add(new Missile(m));
            }
            state.setCannon(new Cannon(model.getState().getCannon()));
            state.setGravity(model.getState().getGravity());
            state.setScore(model.getState().getScore());
        }
        
        private State getState() {
            return this.state;
        }
    }
    
    private void run() 
    {
        Timer t = new Timer();
        t.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                moveMissiles();
                moveEnemies();
                checkCollisions();
                removeEnemy();
                notifyObservers();
            }
        }, 0, 10);
        t.schedule(new TimerTask()
        {
            @Override
            public void run() 
            {
                createEnemy();
            }
        }, 0, 2000);
    }
    @Override
     public Memento createMemento() {
        System.out.println("Saving");
        return new Memento(this);
    }
    
    @Override 
    public void setMemento(Memento memento) {
        System.out.println("Loading");
        state.setCollisions(new ArrayList<Collision>());
        state.setEnemies(new ArrayList<Enemy>());
        state.setMissiles(new ArrayList<Missile>());
        
        for(Collision c: memento.getState().getCollisions()) {
            state.getCollisions().add(new Collision(c));
        }
        for(Enemy e: memento.getState().getEnemies()) {
            state.getEnemies().add(e.copy());
        }
        for(Missile m: memento.getState().getMissiles())
        {
            state.getMissiles().add(new Missile(m));
        }
        state.setCannon(new Cannon(memento.getState().getCannon()));
        state.setGravity(memento.getState().getGravity());
        state.setScore(memento.getState().getScore());
    }
    
    private void checkCollisions() {
        Iterator<Missile> missilesIterator = state.getMissiles().iterator();
        while (missilesIterator.hasNext()) {
            
            Missile m = missilesIterator.next();
            Iterator<Enemy> enemiesIterator = state.getEnemies().iterator();
            while (enemiesIterator.hasNext()) {
                Enemy e = enemiesIterator.next();
                
                if (m.doesCollide(e)) {
                    state.getCollisions().add(new Collision(e.getX(), e.getY()));                    
                    enemiesIterator.remove();   
                    missilesIterator.remove();

                    state.setScore(state.getScore()+1);
                }
            }
        }
    }
    
    private void removeEnemy() {
        Iterator<Collision> it = state.getCollisions().iterator();
        while(it.hasNext()) {
            Collision c = it.next();
            c.tickTime();
            if(c.getTime() >= 15) {
                it.remove();
            }
        }
    }
    
    private void moveMissiles() {
        Iterator<Missile> it = state.getMissiles().iterator();
        while(it.hasNext()) {
            Missile m = it.next();
            m.move(state.getGravity());
            if(!m.isInBorders()) {
                it.remove();
            }
        }
    }

    private void moveEnemies() {
        Iterator<Enemy> it = state.getEnemies().iterator();
        while(it.hasNext()) {
            Enemy e = it.next();
            e.move(state.getGravity());
            if(!e.isOnBoard()) {
                it.remove();
            }
        }        
    }

    @Override
    public void toogleCannonState() {
        state.getCannon().changeState();
    }    
    
    @Override
    public void createMissile() {
        state.getMissiles().addAll(state.getCannon().shoot(factory));
        notifyObservers();
    }

    private boolean nearOtherEnemies(int x, int y) {
        for(Enemy e: state.getEnemies()) {
            if(Math.abs(e.getX() - x) < 30 && Math.abs(e.getY() - y) < 30)
            return true;
        }
        return false;
    }
    
    @Override
    public void createEnemy() {
        if(state.getEnemies().size() > 50) return;
        
        int x;
        int y;
        while(true) {
            x = ThreadLocalRandom.current().nextInt(120, 400);
            y = ThreadLocalRandom.current().nextInt(50, 400);
            if (!nearOtherEnemies(x, y)) break;
        } 
        
        state.getEnemies().add(factory.createEnemy(x, y));
    }
    
    @Override
    public void moveCannonUp() {
        this.state.getCannon().moveUp();
        notifyObservers();
    }
    @Override
    public void moveCannonDown() {
        this.state.getCannon().moveDown();
        notifyObservers();
    }
    @Override
    public void forceUp() {
        this.state.getCannon().forceUp();
        notifyObservers();
    }
    @Override
    public void forceDown() {
        this.state.getCannon().forceDown();
        notifyObservers();
    }
    @Override
    public void angleUp() {
        this.state.getCannon().angleUp();
        notifyObservers();
    }
    @Override
    public void angleDown() {
        this.state.getCannon().angleDown();
        notifyObservers();
    }

    @Override
    public void gravityUp() {
        if(state.getGravity() < 50)
            this.state.setGravity(this.state.getGravity()+1);
    }
    
    @Override
    public void gravityDown()
    {
        if(state.getGravity() > 0)
            this.state.setGravity(this.state.getGravity()-1);
    }
    
    @Override
    public Cannon getCannon() {
        return this.state.getCannon();
    }
    
    @Override
    public ArrayList<GameObject> getAllGameObjects() {
        ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
        gameObjects.add(state.getCannon());
        gameObjects.addAll(state.getEnemies());
        gameObjects.addAll(state.getMissiles());
        gameObjects.addAll(state.getCollisions());
        gameObjects.add(modelInfo);
        return gameObjects;
    }    

    @Override
    public ArrayList<Missile> getMissiles() {
        return state.getMissiles();
    }

    @Override
    public ArrayList<Enemy> getEnemies() {
        return state.getEnemies();
    }

    @Override
    public ArrayList<Collision> getCollisions() {
        return state.getCollisions();
    }

    @Override
    public int getGravity() {
        return state.getGravity();
    }
    
    @Override
    public int getScore() {
        return state.getScore();
    }
    @Override
    public int getAngle() {
        return state.getCannon().getAngle();
    }
    @Override
    public int getForce() {
        return state.getCannon().getForce();
    }
    
}
