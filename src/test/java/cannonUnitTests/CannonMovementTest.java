/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cannonUnitTests;

import model.gameObject.cannon.Cannon;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Patrik
 */
public class CannonMovementTest
{

    @Test
    public void testCannonMovement()
    {
        System.out.println("[TEST] Cannon movement");

        // x=70; y=70
        Cannon cannon = new Cannon(70, 70);

        // 70 50
        cannon.moveUp();
        assertEquals(50, cannon.getY());

        // 70 50
        cannon.moveUp();
        assertEquals(50, cannon.getY());

        // 70 70
        cannon.moveDown();
        assertEquals(70, cannon.getY());

        //70 90
        cannon.moveDown();
        assertEquals(90, cannon.getY());

        System.out.println("[TEST] Cannon movement passed.");
    }
}
