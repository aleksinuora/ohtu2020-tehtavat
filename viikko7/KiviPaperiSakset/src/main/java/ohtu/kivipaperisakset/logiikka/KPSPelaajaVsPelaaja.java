package ohtu.kivipaperisakset.logiikka;

import ohtu.kivipaperisakset.domain.Tuomari;
import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSaksetAbs{
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected String toisenSiirto(String ekanSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
}