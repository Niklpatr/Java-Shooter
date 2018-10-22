/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.abstractFactory;

import model.gameObject.enemy.Enemy;
import model.gameObject.enemy.EnemyType;
import model.gameObject.enemy.SimpleEnemy;
import model.gameObject.missile.Missile;
import model.gameObject.missile.strategy.SimpleStrategy;

/**
 *
 * @author Patrik
 */
public class SimpleConcreteFactory implements AbstractFactory{

    @Override
    public Enemy createEnemy(int x, int y) {
        return new SimpleEnemy(x, y, EnemyType.SIMPLE);
    }

    @Override
    public Missile createMissile(int x, int y, int force, int angle) {
        return new Missile(x, y, angle, force, new SimpleStrategy());
    }
    
}