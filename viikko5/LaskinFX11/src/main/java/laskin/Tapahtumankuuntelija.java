package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.*;

public class Tapahtumankuuntelija implements EventHandler {
    private Button undo;
    private Sovelluslogiikka sovellus;
    private HashMap<Button, Komento> komennot;
    private Komento edellinen = null;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<>();
        komennot.put(plus, new Summa(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, nollaa, undo, sovellus));        
    }
    
    @Override
    public void handle(Event event) {
        if (event.getTarget() != undo) {
            Komento komento = this.komennot.get((Button)event.getTarget());
            komento.suorita();
            this.edellinen = komento;
        } else {
            if (this.edellinen == null) {
                return;
            }
            this.edellinen.peru();
            this.edellinen = null;
        } 
    }
    
    
}

class Summa extends Komento {
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
        
    @Override
    public void suorita() {
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        this.edellinenArvo = tuloskentta.getText();
        int laskunTulos = sovellus.tulos();
    
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
        }
        
    @Override
    public void peru() {
        tuloskentta.setText(this.edellinenArvo);
        sovellus.nollaa();
        sovellus.plus(Integer.parseInt(edellinenArvo));
    }
}


class Erotus extends Komento {
    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
    sovellus.miinus(Integer.parseInt(syotekentta.getText()));
    this.edellinenArvo = tuloskentta.getText();
    int laskunTulos = sovellus.tulos();
    
    syotekentta.setText("");
    tuloskentta.setText("" + laskunTulos);
    
    if ( laskunTulos==0) {
        nollaa.disableProperty().set(true);
    } else {
        nollaa.disableProperty().set(false);
    }
    undo.disableProperty().set(false);
    }
    
    @Override
    public void peru() {
        tuloskentta.setText(this.edellinenArvo);
        sovellus.nollaa();
        sovellus.plus(Integer.parseInt(edellinenArvo));
    }
}

class Nollaa extends Komento {
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        sovellus.nollaa();
        this.edellinenArvo = tuloskentta.getText();
        int laskunTulos = sovellus.tulos();
    
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
        }
    
    @Override
    public void peru() {
        tuloskentta.setText(this.edellinenArvo);
        sovellus.nollaa();
        sovellus.plus(Integer.parseInt(edellinenArvo));
    }
}
