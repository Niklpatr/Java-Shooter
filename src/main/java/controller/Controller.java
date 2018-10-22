/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import model.RealModel;
import controller.commands.PressedKeyCommand;
import controller.commands.MementoCommand;
import model.caretaker.Caretaker;
import model.proxy.Model;
/**
 *
 * @author Patrik
 */
public class Controller {
    private final Model model;
    private final PressedKeyCommand pKCommand;
    private final MementoCommand mCommand;
    private final Caretaker caretaker;
    
    public Controller(Model model)
    {
        
        this.model = model;
        this.caretaker = new Caretaker(model);
        this.pKCommand = new PressedKeyCommand(model);
        this.mCommand = new MementoCommand(caretaker);
    }
    
    public void keyPressed(int key){
        if (key == KeyEvent.VK_F5 || key == KeyEvent.VK_F6) {
            this.mCommand.execute(key);
        } else {
            this.pKCommand.execute(key);
        }
    }
    
}
