/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cannonUnitTests;

import java.util.ArrayList;
import model.gameObject.abstractFactory.AbstractFactory;
import model.gameObject.cannon.Cannon;
import model.gameObject.cannon.state.DoubleShot;
import model.gameObject.cannon.state.SingleShot;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import model.gameObject.cannon.state.CannonState;
import model.gameObject.missile.Missile;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;


/**
 *
 * @author Patrik
 */
public class CannonStateTest {
    @Test
    public void testShoot() {
        System.out.println("[TEST] Cannon state switching");

        // New cannon
        Cannon cannon = new Cannon(70,100);

        // SINGLE shooting mode
        assertEquals(cannon.getState() instanceof SingleShot, true);

        // DOUBLE shooting mode
        cannon.changeState();
        assertEquals(cannon.getState() instanceof DoubleShot, true);

        System.out.println("[TEST] Cannon state switching passed");
    }

    @Test
    public void testShootingModes() {
        System.out.println("[TEST] Cannon shooting modes");

        // New factory and cannon (using mock)
        AbstractFactory factory = mock(AbstractFactory.class);
        Cannon cannon = mock(Cannon.class);

        // If the cannon shooting mode is DOUBLE, 2 shots should be fired
        CannonState instance = new DoubleShot();
        ArrayList<Missile> result = instance.shoot(factory, cannon);
        assertEquals(2, result.size());


        // If the cannon shooting mode is SINGLE, 1 single shot should be fired
        instance = new SingleShot();
        result = instance.shoot(factory, cannon);
        assertEquals(1, result.size());

        System.out.println("[TEST] Cannon shooting modes passed");
    }

    
}
