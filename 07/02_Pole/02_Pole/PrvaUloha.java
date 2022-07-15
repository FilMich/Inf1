import java.util.Random;

public class PrvaUloha {
    private Random generator;

    public PrvaUloha() {
        generator = new Random();
    }

    public boolean jePrvocislo(int vstup){
        if (vstup < 2){
            System.out.println("Zadali ste nesprávny vstup!");
            return false;
        }
        else {
            boolean vysledok = true;
            for (int i = 2; i <= Math.sqrt(vstup); i++) {
                System.out.println("Testujem delitelnost cislom " + i);
                if (vstup % i == 0) {
                    vysledok = false;
                    break;
                }
            }

            if (vysledok)
                System.out.println("Cislo " + vstup + " je prvočíslo.");
            else
                System.out.println("Cislo " + vstup + " nie je prvočíslo.");

            return vysledok;
        }
    }   
    
    public void vypisMinMaxPola(int pocetPrvkovPola){
        if (pocetPrvkovPola < 1)
            System.out.println("Zadali ste nesprávny vstup!");
        else{
            int[] pole = new int[pocetPrvkovPola];

            // Generovanie hodnot z intervali [0, 10]
            // !!! POZOR, indexujeme od NULY !!!
            for (int i = 0; i < pole.length; i++) {
                pole[i] = generator.nextInt(11);
            }

            // Vypis prvkov pola
            System.out.println("Pocet prvkov pola: " + pole.length);
            System.out.print("Prvky pola: ");
            for (int i = 0; i < pole.length; i++){
                System.out.print(pole[i]);
                if (i < pole.length - 1)
                    System.out.print("  ");
            }
            System.out.println();

            int minimum = pole[0];
            int maximum = pole[0];
            int indexMinima = 0;
            int indexMaxima = 0;

            // Vyhladanie minima a maxima v poli
            for (int i = 0; i < pole.length; i++){
                if (pole[i] > maximum){
                    maximum = pole[i];
                    indexMaxima = i;
                }

                if (pole[i] < minimum){
                    minimum = pole[i];
                    indexMinima = i;
                }
            }

            System.out.println("Minimalny prvok pola: " + minimum + " je na indexe " + indexMinima);
            System.out.println("Maximalny prvok pola: " + maximum + " je na indexe " + indexMaxima);
        }
    }
}
