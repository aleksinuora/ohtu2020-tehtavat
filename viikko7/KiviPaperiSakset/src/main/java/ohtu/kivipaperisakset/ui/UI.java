/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset.ui;

import java.util.*;
import ohtu.kivipaperisakset.logiikka.KPSParempiTekoaly;
import ohtu.kivipaperisakset.logiikka.KPSPelaajaVsPelaaja;
import ohtu.kivipaperisakset.logiikka.KPSTekoaly;
import ohtu.kivipaperisakset.logiikka.Pelitehdas;
import ohtu.kivipaperisakset.logiikka.KiviPaperiSaksetAbs;
/**
 *
 * @author aleksi
 */
public class UI {
    Scanner scanner;
    Pelitehdas pelitehdas;
    
    public UI(Scanner scanner) {
        this.scanner = scanner;
        this.pelitehdas = new Pelitehdas();
    }
    
    public void init() {
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            switch (vastaus) {
                case "a":
                    vastaus = "KPSPelaajaVsPelaaja";
                    break;
                case "b":
                    vastaus = "KPSTekoaly";
                    break;
                case "c":
                    vastaus = "KPSParempiTekoaly";
                    break;
            }  
            KiviPaperiSaksetAbs peli = pelitehdas.rakennaPeli(vastaus);
            if (peli != (null)) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                peli.pelaa();
            } else {
                break;
            }
        }
    }
}
