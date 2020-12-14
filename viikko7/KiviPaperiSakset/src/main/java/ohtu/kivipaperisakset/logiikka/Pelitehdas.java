/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset.logiikka;

/**
 *
 * @author aleksi
 */
public class Pelitehdas {
    public KiviPaperiSaksetAbs rakennaPeli(String peli){            
        KiviPaperiSaksetAbs peliolio = null;
        switch (peli) {
            case "KPSPelaajaVsPelaaja": 
                peliolio = new KPSPelaajaVsPelaaja();
                break;
            case "KPSTekoaly":
                peliolio = new KPSTekoaly();
                break;
            case "KPSParempiTekoaly":
                peliolio = new KPSParempiTekoaly();
                break;
        }
        
        return peliolio;
    }
}
