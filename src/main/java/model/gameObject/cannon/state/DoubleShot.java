/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.cannon.state;

import java.util.ArrayList;
import model.gameObject.abstractFactory.AbstractFactory;
import model.gameObject.cannon.Cannon;
import model.gameObject.missile.Missile;

/**
 *
 * @author Patrik
 */
public class DoubleShot implements CannonState {
    @Override
    public ArrayList<Missile> shoot(AbstractFactory factory, Cannon cannon) {
        ArrayList<Missile> shotsFired = new ArrayList<Missile>();
        for (int i = 0; i < 2; i++)
            shotsFired.add(factory.createMissile(cannon.getX(), cannon.getY(), cannon.getForce(), cannon.getAngle()+i*20));
        return shotsFired;
    }
}
