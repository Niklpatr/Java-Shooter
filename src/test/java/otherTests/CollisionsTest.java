/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherTests;

import model.gameObject.GameObject;
import model.gameObject.enemy.EnemyType;
import model.gameObject.enemy.SimpleEnemy;
import model.gameObject.missile.Missile;
import model.gameObject.missile.strategy.SimpleStrategy;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Patrik
 */
public class CollisionsTest
{

    @Test
    public void testCollisions()
    {
        System.out.println("[TEST] Collisions");

        // Missile is located on x=70, y=100; enemy on x=0, y=0; they shouldn't collide
        GameObject missile = new Missile(70, 100, 0, 0, mock(SimpleStrategy.class));
        GameObject enemy = new SimpleEnemy(70, 0, EnemyType.SIMPLE);
        assertEquals(false, enemy.doesCollide(missile));
        
        // Missile and enemy should collide
        missile = new Missile(70, 100, 0, 0, mock(SimpleStrategy.class));
        enemy = new SimpleEnemy(70, 100, EnemyType.REALISTIC);
        assertEquals(true, enemy.doesCollide(missile));

        System.out.println("[TEST] Collisions passed.");
    }
}
