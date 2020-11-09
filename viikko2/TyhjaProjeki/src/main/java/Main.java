import java.util.*;
import ohtu.Multiplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("anna luku: ");
        Multiplier kolme = new Multiplier(3);
        int luku = scanner.nextInt();
        System.out.println("Luku kertaa kolme on " 
        + kolme.multipliedBy(luku));


    }
}