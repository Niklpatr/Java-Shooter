/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

import java.awt.event.KeyEvent;
import model.caretaker.Caretaker;

/**
 *
 * @author Patrik
 */
public class MementoCommand implements Command {

    private final Caretaker caretaker;

    public MementoCommand(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public void execute(int key) {
        if (key == KeyEvent.VK_F5) caretaker.save();
        else if (key == KeyEvent.VK_F6) caretaker.load();
        else {
            //nothing            
        }
    }
}