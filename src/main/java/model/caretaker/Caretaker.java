/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.caretaker;

import java.util.ArrayList;
import model.RealModel;
import model.proxy.Model;

/**
 *
 * @author Patrik
 */
public class Caretaker {
    private Model model;
    private ArrayList<RealModel.Memento> memento;
    
    public Caretaker(Model model) {
        memento = new ArrayList<RealModel.Memento>();
        this.model = model;
    }
    
    public void save() {
        memento.add(model.createMemento());
    }
    
    public void load() {
        RealModel.Memento ret;
        if (!memento.isEmpty()) {
            model.setMemento(memento.get(0));
            memento.remove(0);

        }
    } 
}
