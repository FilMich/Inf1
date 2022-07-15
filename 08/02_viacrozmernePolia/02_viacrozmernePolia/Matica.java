import java.util.Random;

public class Matica {
    private int[][] matica;
    private Random generator;  

    public Matica(int m, int n, int x, int y) {
        // m - pocet riadkov matice
        // n - pocet stlpcov matice
        // x - dolna hranica intervalu pre generovanie hodnot do matice
        // y - horna hranica intervalu pre generovanie hodnot do matice

        // !!! Domaca uloha pre studentov - osetrit vstupne parametre !!! 
        this.generator = new Random();
        // Vytvorenie generatora nahodnych cisel
        this.matica = new int[m][];
        for(int i = 0; i < this.matica.length; i++)
            this.matica[i] = new int[n];

        // Naplnenie matice hodnotami
        for(int i = 0; i < this.matica.length; i++)
            for(int j = 0; j < this.matica[i].length; j++)
                this.matica[i][j] = x + generator.nextInt(y + 1 - x);

        System.out.print('\u000c');
        this.vypisMaticu();
    }

    public Matica(int n, int x, int y) {
        this(n, n, x, y);
        
        /* upozornit studentov na duplicitu kodu (okrem jedneho pismenka je to takmer identicky kod oproti povodnemu konstruktoru) !!!
        
        // n - pocet riadkov a stlpcov matice
        // x - dolna hranica intervalu pre generovanie hodnot do matice
        // y - dolna hranica intervalu pre generovanie hodnot do matice

        // !!! Domaca uloha pre studentov - osetrit vstupne parametre !!! 

        // Vytvorenie generatora nahodnych cisel
        this.generator = new Random();

        // Vytvorenie matice
        this.matica = new int[n][];
        for(int i = 0; i < this.matica.length; i++)
            this.matica[i] = new int[n];

        // Naplnenie matice hodnotami
        for(int i = 0; i < this.matica.length; i++)
            for(int j = 0; j < this.matica[i].length; j++)
                this.matica[i][j] = x + generator.nextInt(y + 1 - x);

        System.out.print('\u000c');
        this.vypisMaticu();
        */
    }

    public void vypisMaticu() {
        for(int i = 0; i < this.matica.length; i++){
            for(int j = 0; j < this.matica[i].length; j++){
                if (this.matica[i][j] < 10)
                    System.out.print(" " + this.matica[i][j]);
                else
                    System.out.print(this.matica[i][j]);

                if (j < this.matica[i].length - 1)    
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public void vypisPriemerPrvkovMatice() {
        int sucetPrvkov = 0;
        int pocetPrvkov = 0;
        double priemer = 0;

        for(int i = 0; i < this.matica.length; i++)
            for(int j = 0; j < this.matica[i].length; j++){
                sucetPrvkov += this.matica[i][j];
                pocetPrvkov++;
            }

        priemer = (double)sucetPrvkov / pocetPrvkov;
        System.out.println("Priemer prvkov matice je: " + priemer);
    }

    public void vypisPriemerPrvkovRiadku(int indexRiadku) {
        int sucetPrvkov = 0;
        int pocetPrvkov = 0;
        double priemer = 0;

        for(int j = 0; j < this.matica[indexRiadku].length; j++){
            sucetPrvkov += this.matica[indexRiadku][j];
            pocetPrvkov++;
        }

        priemer = (double)sucetPrvkov / pocetPrvkov;
        System.out.println("Priemer prvkov riadku " + indexRiadku + " je: " + priemer);
    }

    public void vypisPriemerPrvkovStlpca(int indexStlpca) {
        int sucetPrvkov = 0;
        int pocetPrvkov = 0;
        double priemer = 0;

        for(int i = 0; i < this.matica.length; i++){
            sucetPrvkov += this.matica[i][indexStlpca];
            pocetPrvkov++;
        }

        priemer = (double)sucetPrvkov / pocetPrvkov;
        System.out.println("Priemer prvkov stlpca " + indexStlpca + " je: " + priemer);
    }

    public void zistiSymetrickostPodlaHlavnejDiagonaly() {
        boolean jeSymetricka = true;

        for(int i = 1; i < this.matica.length; i++)
            for(int j = 0; j < i; j++)
                if (this.matica[i][j] != this.matica[j][i]){
                    jeSymetricka = false;
                    break;
                }

        if (jeSymetricka)
            System.out.println("Matica je symetricka podla hlavnej diagonaly.");
        else
            System.out.println("Matica nie je symetricka podla hlavnej diagonaly.");
    }

    public void vypisPrvkyHlavnejDiagonaly() {
        System.out.print("Prvky hlavnej diagonaly: ");
        for(int i = 0; i < this.matica.length; i++){
            if (this.matica[i][i] < 10)
                System.out.print(" " + this.matica[i][i]);
            else
                System.out.print(this.matica[i][i]);

            if (i < this.matica.length - 1)    
                System.out.print("  ");
        }
        System.out.println();
    }

    public void vypisPrvkyVedlajsejDiagonaly() {
        System.out.print("Prvky vedlajsej diagonaly: ");
        for(int i = 0; i < this.matica.length; i++){
            if (this.matica[i][this.matica.length - i - 1] < 10)
                System.out.print(" " + this.matica[i][this.matica.length - i - 1]);
            else
                System.out.print(this.matica[i][this.matica.length - i - 1]);

            if (i < this.matica.length - 1)    
                System.out.print("  ");
        }
        System.out.println();
    }

    public void vypisPrvkyObochDiagonal() {
        this.vypisPrvkyHlavnejDiagonaly();
        this.vypisPrvkyVedlajsejDiagonaly();
    }

    public void vypisMaxPrvokNadHlavnouDiagonalou() {
        int max = 0;
        int indexX = 0;
        int indexY = 0;

        for(int i = 0; i < this.matica.length - 1; i++)
            for(int j = i + 1; j < this.matica.length; j++)
                if (matica[i][j] > max) {
                    max = matica[i][j];
                    indexX = i;
                    indexY = j;
                }

        System.out.println("Maximalny prvok nad hlavnou diagonalou ma hodnotu " + max + " a je na pozicii [" + indexX + ", " + indexY + "].");
    }

    public void preusporiadajRiadkyPoslednyStlpecNeklesajuci() {
        System.out.println("Povodna matica:");
        this.vypisMaticu();

        int pom = 0;
        for (int i = 0; i < this.matica.length - 1; i++) {
            for (int j = 0; j < this.matica.length - i - 1; j++) {
                if (this.matica[j][this.matica.length - 1] > this.matica[j + 1][this.matica.length - 1]) {
                    for (int k = 0; k < this.matica.length; k++) {
                        pom = this.matica[j][k];
                        this.matica[j][k] = this.matica[j + 1][k];
                        this.matica[j + 1][k] = pom;
                    }
                }
            }
        }

        System.out.println();
        System.out.println("Vysledna matica:");
        this.vypisMaticu();
    }
}
