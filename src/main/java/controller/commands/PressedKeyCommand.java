/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

import java.awt.event.KeyEvent;
import model.RealModel;
import model.proxy.Model;

/**
 *
 * @author Patrik
 */
public class PressedKeyCommand implements Command {
    private final Model model;

    public PressedKeyCommand(Model model) {
        this.model = model;
    }


    @Override
    public void execute(int key) {
        switch(key) {
            case KeyEvent.VK_UP:
                model.moveCannonUp();
                break;
            case KeyEvent.VK_DOWN:
                model.moveCannonDown();
                break;
            case KeyEvent.VK_SPACE:
                model.createMissile();
                break;
            case KeyEvent.VK_SHIFT:
                model.forceDown();
                break;
            case KeyEvent.VK_CONTROL:
                model.forceUp();
                break;
            case KeyEvent.VK_LEFT:
                model.angleDown();
                break;
            case KeyEvent.VK_RIGHT:
                model.angleUp();
                break;
            case KeyEvent.VK_CAPS_LOCK:
                model.toogleCannonState();
                break;
            case KeyEvent.VK_ADD:
                model.gravityUp();
                break;
            case KeyEvent.VK_SUBTRACT:
                model.gravityDown();
                break;
            case KeyEvent.VK_Q:
                model.toggleState();
                break;
        }

    }
}
