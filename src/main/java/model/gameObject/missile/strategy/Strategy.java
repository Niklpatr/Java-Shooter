/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.missile.strategy;

import model.gameObject.missile.Missile;

/**
 *
 * @author Patrik
 */
public interface Strategy {
    void move(int gravity, Missile m);
}
