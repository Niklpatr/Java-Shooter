/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameObject.enemy;

/**
 *
 * @author Patrik
 */
public class RealisticEnemy extends Enemy{

    public RealisticEnemy(int x, int y, EnemyType type) {
        super(x, y, type);
    }
    private int wiggleCount = 0;

    @Override
    public void move(int gravity) {
        this.y += Math.round(1 + 0.01 * gravity);

        wiggleCount++;
        if (wiggleCount < 30) {
            this.x--;
        } else {
            this.x++;
        }
        wiggleCount = wiggleCount%60;
    }

    @Override
    public Enemy copy() {
        RealisticEnemy e = new RealisticEnemy(this.x, this.y, this.type);
        return e;
    }

}
