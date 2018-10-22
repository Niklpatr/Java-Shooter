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
public class RealisticStrategy implements Strategy{
    @Override
    public void move(int gravity, Missile m) 
    {
        m.setX((int) Math.ceil(m.getStartX() + m.getForce() * (double)m.getCount() * 0.05 * Math.cos(Math.toRadians(m.getAngle()))));
        m.setY((int) Math.ceil(m.getStartY() + m.getForce() * (double)m.getCount() * 0.05 * Math.sin(Math.toRadians(m.getAngle()))
                + (double)gravity * Math.pow((double)m.getCount() * 0.025, 2.0)));
    }
}
