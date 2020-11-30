/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 *
 * @author aleksi
 */
public abstract class Komento {
    protected TextField tuloskentta, syotekentta;
    protected Button nollaa, undo;
    protected Sovelluslogiikka sovellus;
    protected String edellinenArvo;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.edellinenArvo = "0";
    }
    
    public abstract void suorita();
    
    public abstract void peru();
}
