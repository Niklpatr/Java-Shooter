/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.enemy;

import model.gameObject.GameObject;
import view.GraphicsDrawer;

/**
 *
 * @author Patrik
 */
public abstract class Enemy extends GameObject {
    
    protected EnemyType type;
    
    public Enemy(int x, int y, EnemyType type) {
        super(x, y);
        this.type = type;
    }
    
    @Override
    public void accept(GraphicsDrawer d) {
        d.visit(this);
    }
    
    public abstract void move(int gravity);

    public EnemyType getType() {
        return type;
    }
    
    public boolean isOnBoard()
    {
        return (y >= 0 && y <= 500);
    }
    
    public abstract Enemy copy();
}

