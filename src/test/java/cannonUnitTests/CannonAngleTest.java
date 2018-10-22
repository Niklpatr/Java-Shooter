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
public class CannonAngleTest {

    @Test
    public void testCannonAngles()
    {
        System.out.println("[TEST] Cannon angles");

        // Angle == 0
        Cannon cannon = new Cannon(70, 70);

        // Angle == 5
        cannon.angleUp();
        assertEquals(5, cannon.getAngle());

        // Angle == 0
        cannon.angleDown();
        assertEquals(0, cannon.getAngle());

        System.out.println("[TEST] Cannon angles passed.");
    }
}
