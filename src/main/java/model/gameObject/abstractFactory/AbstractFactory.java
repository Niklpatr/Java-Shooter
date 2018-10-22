/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.abstractFactory;

import model.gameObject.enemy.Enemy;
import model.gameObject.missile.Missile;

/**
 *
 * @author Patrik
 */
public interface AbstractFactory {
    Enemy createEnemy(int x, int y);
    Missile createMissile(int x, int y, int force, int angle);
}
