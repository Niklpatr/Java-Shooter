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
public interface CannonState {
    ArrayList<Missile> shoot(AbstractFactory factory, Cannon cannon);    
}