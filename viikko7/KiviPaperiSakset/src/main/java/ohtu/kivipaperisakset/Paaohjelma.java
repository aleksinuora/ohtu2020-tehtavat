package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.ui.UI;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {        
        UI ui = new UI(scanner);
        ui.init();
    }
}
