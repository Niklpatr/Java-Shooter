/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherTests;

import model.Mode;
import model.RealModel;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Patrik
 */
public class MementoTest
{
    @Test
    public void createMementoTest()
    {
        System.out.println("[TEST] Memento values");

        // New realistic model
        RealModel model = new RealModel(Mode.REALISTIC);

        // Default gravity is 10, we increase gravity to 15
        for (int i=0; i < 5; i++) {
            model.gravityUp();
        }

        // Default angle is 0, we decrease it to 5
        model.angleUp();

        // Default force is 70, we increase it to 80
        for (int i=0; i < 1; i++) {
            model.forceUp();
        }

        // We create the memento with given values (gravity is 15, angle is -5, force is 90)
        RealModel.Memento memento = model.createMemento();

        // Now we change these attributes (gravity is 14, angle is -4, force is 81)
        model.gravityDown();
        model.angleUp();
        model.forceUp();

        // If we set the created memento, values will change back (to the values saved in memento)
        model.setMemento(memento);
        assertEquals(15, model.getGravity());
        assertEquals(5, model.getAngle());
        assertEquals(80, model.getForce());

        System.out.println("[TEST] Memento values passed.");
    }
}
