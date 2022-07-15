import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class Test {    
    // Podla navrhoveho vzoru SINGLETON chceme, aby z tejto triedy existovala jedna jedina instancia.
    // Ako to dosiahnut?
    // Správa new nemoze byt vo verejnom (public) rozhrani triedy, inak by bolo mozne vytvarat 
    // lubovolny pocet instancii.
    // Ak chceme instanciu, pouzijeme spravu getInstance. Ak uz instancia existuje, vratime ju 
    // a pracujeme s nou. Ak neexistuje, vytvorime ju.

    private static Test instancia;

    private Test() {
    }

    public static Test getInstance() {
        if (instancia == null)
            instancia = new Test();
        
        return instancia;   
    }
    
    public void SpustiScannovanie() throws IOException {
        Scanner sc = new Scanner(System.in);
        int cislo = -1;
        int pocetCisel = 0;
        int suma = 0;
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        double priemer = 0;
        ArrayList<Integer> zoznam = new ArrayList<Integer>();       
        
        while(cislo != 0) {
            System.out.print("Vase cislo: ");
            cislo = sc.nextInt();
            sc.nextLine();
            
            // Poslednu nulu do statistik pocitat nechcem!!!
            if (cislo != 0) {
                zoznam.add(new Integer(cislo));
                pocetCisel++;
                suma += cislo;
                if (cislo < minimum) {
                    minimum = cislo;
                }
                if (cislo > maximum) {
                    maximum = cislo;
                }
            }
        }

        if (pocetCisel > 0) {
            priemer = (double) suma / pocetCisel;

            System.out.println("Statistika:");
            System.out.println("Pocet cisel: " + pocetCisel);
            System.out.println("Minimum: " + minimum);
            System.out.println("Maximum: " + maximum);
            System.out.println("Priemer: " + priemer);
            
            // Ulozenie do suboru
            System.out.print("Nazov suboru (pripona .txt sa doplni automaticky): ");
            String cesta = sc.nextLine();
            File subor = new File(cesta + ".txt");
            PrintWriter zapisovac = new PrintWriter(subor);
            zapisovac.println("Vstupne data:");
            for(Integer i: zoznam) {
                zapisovac.println(i);
            }
            zapisovac.println();
            zapisovac.println("Statistika:");
            zapisovac.println("Pocet cisel: " + pocetCisel);
            zapisovac.println("Minimum: " + minimum);
            zapisovac.println("Maximum: " + maximum);
            zapisovac.println("Priemer: " + priemer);
            zapisovac.close();

            System.out.println("Analyza dokoncena.");
        } else {
            System.out.println("Statistika nie je mozna, nemam dostatok vstupnych dat !!!");
        }
    }
}
