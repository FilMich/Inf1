import java.util.Random;

public class CviceniePolia {
    // Atributmi bude generator nahodnych cisel a pole celych cisel
    private Random generator;
    private int[] pole;

    public CviceniePolia() {
        this.generator = new Random();

        // Pre potreby cvicenia bude stacit 20-prvkove pole, ktore naplnime 
        // nahodnymi cislami z intervalu <-5, 10>
        // Generator ma metody nextInt, ktora vsak generuje cisla cisla z intervalu <0, n). 
        // Ak chceme generovat vseobecne z intervalu <x, y>, mozeme to urobit takto:
        // x + generator.nextInt(y + 1 - x)
        // Priklad: Ak chceme generivat cisla z intervalu <3, 10>, staci nam generovat
        // cislo od 0 do 7, teda nextInt(8) a pripocitat to k 3.      

        this.pole = new int[20];
        for (int i = 0; i < this.pole.length; i++) {
            this.pole[i] = -5 + this.generator.nextInt(16);
        }

        System.out.print('\u000c'); // clear screen
        this.vypisPole();
    }

    public void vypisPole() {
        System.out.println("Pocet prvkov pola je: " + this.pole.length);
        System.out.print("Prvky pola: ");
        for (int i = 0; i < this.pole.length; i++) {
            //System.out.print(pole[i]);
            System.out.format("%3d", this.pole[i]);
            if (i < this.pole.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public boolean jePrvocislo(int vstup){
        if (vstup < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(vstup); i++) {
                if (vstup % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }   

    // 1. Vypíšte všetky prvočísla menšie ako zadaná hodnota. 
    // Predpokladajme, že zadaná hodnota bude aspoň 3.
    public void prva(int vstup) {
        if (vstup < 3) {
            System.out.print('\u000c'); // clear screen
            System.out.println("Neplatny vstup!");
        } else {
            System.out.print('\u000c'); // clear screen
            System.out.println("Prvocisla mensie ako " + vstup + " su:");
            for (int i = 1; i < vstup; i++) {
                if (jePrvocislo(i)) {
                    System.out.println(i);
                }
            }
        }
    }

    // 2. Vygenerujte pole celých čísel (aspoň 30) tak, aby medzi nimi boli aj záporné čísla.
    // Vytvorte metódy, ktoré zabezpečia nasledovné:
    // a, Nahraďte prvky poľa ich cifernými súčtami.
    public int cifernySucet(int vstup) {
        int cislo = vstup;
        if (cislo < 0) {
            cislo = -cislo;
        }

        int vysledok = 0;    
        while (cislo > 0) {
            vysledok += cislo % 10;
            cislo = cislo / 10;
        }

        return vysledok;
    }

    public void uloha2a() {
        System.out.print('\u000c');
        this.vypisPole();

        for (int i = 0; i < this.pole.length; i++) {
            this.pole[i] = this.cifernySucet(this.pole[i]);
        }  

        this.vypisPole();
    }

    // b, Vymeňte 2 prvky poľa, ich indexy sú dané parametrami metódy 
    // (ošetriť vstup).
    public void uloha2b(int index1, int index2) {
        if ((index1 < 0) || (index1 >= this.pole.length)) {
            return;
        }

        if ((index2 < 0) || (index2 >= pole.length)) {
            return;
        }

        if (index1 != index2) {
            System.out.print('\u000c');
            this.vypisPole();

            int pom = this.pole[index1];
            this.pole[index1] = this.pole[index2];
            this.pole[index2] = pom;

            this.vypisPole();
        }
    }

    // c, Vráťte počet prvkov s hodnotou 0.
    public int uloha2c() {
        int vysledok = 0;
        for (int i = 0; i < this.pole.length; i++) {
            if (this.pole[i] == 0) {
                vysledok++;
            }
        }       
        return vysledok;        
    }

    // d, Zistite počet prvkov, ktorých hodnota je 
    // deliteľná č. 3 so zvyškom 1.
    public int uloha2d() {
        int vysledok = 0;
        for (int i = 0; i < this.pole.length; i++) {
            if (this.pole[i] % 3 == 1) {
                vysledok++;
            }
        }       
        return vysledok;   
    }

    // e, Zistite počet prvkov, ktoré obsahujú číslicu 7 
    // (nemusia byť deliteľné 7) a vypíšte ich indexy.
    public boolean obsahuje7(int vstup) {
        int cislo = vstup;
        if (cislo < 0) {
            cislo = -cislo;
        }

        while (cislo > 0) {
            if (cislo % 10 == 7) {
                return true;
            }
            cislo = cislo / 10;
        }

        return false;
    }

    public int uloha2e() {
        System.out.print('\u000c');
        this.vypisPole();

        int vysledok = 0;
        System.out.println("Cisla obsahujuce cifru 7:");
        for (int i = 0; i < this.pole.length; i++) {
            if (this.obsahuje7(this.pole[i])) {
                vysledok++;
                System.out.println("Index: " + i + " hodnota: " + this.pole[i]);
            }
        }       
        return vysledok;  
    }

    // f, Vypočítajte súčet prvkov na nepárnych indexoch.
    public int uloha2f() {
        System.out.print('\u000c');
        this.vypisPole();

        int vysledok = 0;
        for (int i = 1; i < this.pole.length; i += 2) {
            vysledok += this.pole[i];
        }   

        System.out.println("Súčet prvkov na nepárnych indexoch je: " + vysledok);
        return vysledok;
    }

    // g, Vypíšte prvky poľa, ktorých hodnota je menšia ako priemer.
    public void uloha2g() {
        System.out.print('\u000c');
        this.vypisPole();

        double priemer;
        int sucet = 0;

        for (int i = 0; i < this.pole.length; i++) {
            sucet += this.pole[i];
        }
        priemer = (double) sucet / this.pole.length;         

        System.out.println("Priemer prvkov poľa: " + priemer);
        System.out.println("Prvky poľa, ktorých hodnota je menšia ako priemer, sú: ");
        for (int i = 0; i < this.pole.length; i++) {
            if (this.pole[i] < priemer) {
                System.out.println("Index: " + i + " hodnota: " + this.pole[i]);
            }
        }
    }

    // h, Nájdete minimum (index aj hodnotu) z prvej polovice poľa.
    public void uloha2h() {
        System.out.print('\u000c');
        this.vypisPole();

        int minimum = pole[0];
        int indexMinima = 0;

        for (int i = 0; i < this.pole.length/2; i++){
            if (this.pole[i] < minimum){
                minimum = this.pole[i];
                indexMinima = i;
            }
        }

        System.out.println("Index minima z prvej polovice: " + indexMinima + " hodnota: " + minimum);
    }

    // i, Zistite počet prvočísel v poli.
    public int uloha2i() {
        int vysledok = 0;
        for (int i = 0; i < this.pole.length; i++) {
            if (jePrvocislo(this.pole[i])) {
                vysledok++;
            }
        }

        return vysledok;
    }

    // j, Obráťte poradie prvkov v poli (nie výpis prvkov v opačnom poradí !!!).
    public void uloha2j() {
        System.out.print('\u000c');
        this.vypisPole();

        int pom;
        for (int i = 0; i < pole.length/2; i++) {
            pom = this.pole[i];
            this.pole[i] = this.pole[this.pole.length - i - 1];
            this.pole[this.pole.length - i - 1] = pom;
        }

        this.vypisPole();
    }

    // k, Vypočítajte súčet hodnôt s nepárnym indexom, ale párnou hodnotou.
    public int uloha2k() {
        System.out.print('\u000c');
        this.vypisPole();

        int vysledok = 0;
        for (int i = 1; i < this.pole.length; i += 2) {
            if (this.pole[i] % 2 == 0) {  
                vysledok += this.pole[i];
            }
        }   

        System.out.println("Súčet hodnôt s nepárnym indexom, ale párnou hodnotou je: " + vysledok);
        return vysledok;
    }

    // l, Preusporiadajte prvky poľa tak, aby boli v neklesajúcom poradí.
    public void uloha2l() {
        System.out.print('\u000c');
        this.vypisPole();

        int pom;
        for(int i = 0; i < this.pole.length; i++){  
            for(int j = 1; j < (this.pole.length - i); j++){  
                if(this.pole[j-1] > this.pole[j]){  
                    pom = this.pole[j-1];  
                    this.pole[j-1] = this.pole[j];  
                    this.pole[j] = pom;  
                }  
            }  
        }  
        
        this.vypisPole();
    }
}
