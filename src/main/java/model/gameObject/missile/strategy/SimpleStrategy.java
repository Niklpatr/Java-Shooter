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
public class SimpleStrategy implements Strategy{
    @Override
    public void move(int gravity, Missile m) {
        m.setX((int) Math.ceil(m.getStartX() + m.getForce() * (double)m.getCount() * Math.cos(Math.toRadians(m.getAngle())) * 0.05));
        m.setY((int) Math.ceil(m.getStartY() + m.getForce() * (double)m.getCount() * Math.sin(Math.toRadians(m.getAngle())) * 0.05));
    }


}
