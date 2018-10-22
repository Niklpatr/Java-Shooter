/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.enemy;

/**
 *
 * @author Patrik
 */
public class SimpleEnemy extends Enemy{
    public SimpleEnemy(int x, int y, EnemyType type) {
        super(x, y, type);
    }

    @Override
    public void move(int gravity) {
        //do nothing
    }

    @Override
    public Enemy copy() {
        SimpleEnemy e = new SimpleEnemy(this.x, this.y, this.type);
        return e;
    }
}
