/*
Bludisko - zadanie problemu: 
Najdite cestu z bludiska, pricom mate moznost sa pohybovat hore, dolu, dolava 
a doprava. Vstup do bludiska je v lavom hornom rohu, výstup vpravo dole. 
Bludisko je reprezentovane nasledovnou maticou

private int[][] blud = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                         {1,0,1,1,1,0,1,1,1,1,0,0,1},
                         {0,0,0,0,1,0,1,0,1,0,1,0,0},
                         {1,1,1,0,1,1,1,0,1,0,1,1,1},
                         {1,0,1,0,0,0,0,1,1,1,0,0,1},
                         {1,0,1,1,1,1,1,1,0,1,1,1,1},
                         {1,0,0,0,0,0,0,0,0,0,0,0,0},
                         {1,1,1,1,1,1,1,1,1,1,1,1,1} };

1 znamena ze je tam cesta
0 znamena ze cesta tam nie je (na danom policku je prekazka)

Najdena cesta moze vyzerat: (Xkami prechadzam, Z je zaciatok a K koniec)
Z,X,X,0,1,1,0,0,0,1,1,1,1
1,0,X,X,X,0,X,X,X,1,0,0,1
0,0,0,0,X,0,X,0,X,0,1,0,0
X,X,X,0,X,X,X,0,X,0,1,1,1
X,0,X,0,0,0,0,X,X,1,0,0,1
X,0,X,X,X,X,X,X,0,1,1,1,1
X,0,0,0,0,0,0,0,0,0,0,0,0
X,X,X,X,X,X,X,X,X,X,X,X,K  
 */

public class Bludisko 
{
    // Samotne bludisko (matica priechodnosti policok) 
    // 1 znamena ze je tam cesta
    // 0 znamena ze cesta tam nie je (na danom policku je prekazka)
    private int[][] blud = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                             {1,0,1,1,1,0,1,1,1,1,0,0,1},
                             {0,0,0,0,1,0,1,0,1,0,1,0,0},
                             {1,1,1,0,1,1,1,0,1,0,1,1,1},
                             {1,0,1,0,0,0,0,1,1,1,0,0,1},
                             {1,0,1,1,1,1,1,1,0,1,1,1,1},
                             {1,0,0,0,0,0,0,0,0,0,0,0,0},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1} };

    private int[][] cesta; // Matica, v ktorej sa bude nachadzat najdena cesta

    // Mozne pohyby (mame 4 moznosti - hore, dole, dolava, doprava)
    private int a[];       // Xove suradnice moznych pohybov
    private int b[];       // Yove suradnice moznych pohybov

    // Suradnice ciela - pravy dolny roh matice (teoreticky by mohol byt ciel aj v inom bode)
    private int cielX;
    private int cielY;

    // Konstruktor
    public Bludisko(){
        // Mozne pohyby (mame 4 moznosti - hore, dole, dolava, doprava)        
        this.a = new int [4];           // Xove suradnice pohybu
        this.b = new int [4];           // Yove suradnice pohybu

        // Moznosti pohybu (a - riadok, b - stlpec)
        this.a[0] = -1; this.b[0] = 0;  // hore
        this.a[1] = 1;  this.b[1] = 0;  // dole
        this.a[2] = 0;  this.b[2] = 1;  // doprava
        this.a[3] = 0;  this.b[3] = -1; // dolava

        // Suradnice ciela - pravy dolny roh matice (teoreticky by mohol byt ciel aj v inom bode)
        this.cielX = this.blud.length - 1;
        this.cielY = this.blud[this.blud.length - 1].length - 1;

        // Pociatocne vytvorenie cesty
        this.cesta = new int[this.blud.length][];
        for (int i = 0; i < this.blud.length; i++)
            this.cesta[i] = new int[this.blud[i].length];

        // Inicializacia cesty - este som nebol na ziadnom policku
        for (int i = 0; i < this.blud.length; i++){
            for (int j = 0; j < this.blud[i].length; j++)
                this.cesta[i][j] = 0;
        }

        // Zacina sa v lavom hornom rohu
        this.cesta[0][0] = 1;
    }

    // Vypis vysledky (poradie navstivenia jednotlivych policok)
    private void vypisVysledky(){
        System.out.print("Bludisko:");
        for (int j = 0; j < 4 * this.blud[0].length - 1; j++)
            System.out.print(" ");
        System.out.println("Nájdená cesta:");

        // Vypis bludisko
        for (int i = 0; i < this.blud.length; i++){
            for (int j = 0; j < this.blud[i].length; j++){
                if (this.blud[i][j] < 10)
                    System.out.print(" ");
                System.out.print(blud[i][j]);
                if (j < this.blud[i].length - 1) // za posledny prvok uz medzery nepisem,
                    System.out.print("  ");
            }
            System.out.print("          ");

            // Vypis najdenu cestu
            for (int j = 0; j < this.cesta[i].length; j++){
                if (this.cesta[i][j] < 10)
                    System.out.print(" ");
                if (this.cesta[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print(this.cesta[i][j]);
                if (j < this.cesta[i].length - 1) // za posledny prvok uz medzery nepisem,
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
    
    // Rekurzivna metoda, ktora hlada dalsie skoky a nevhodne skoky rusi
    private boolean vyskusaj(int cisloSkoku, int aktX, int aktY)
    {
        int k, u, v;                // k - pomocna premenna pre indexovanie pohybu - hore, dole, doprava, dolava
                                    // u - Xova suradnica aktualneho policka
                                    // v - Yova suradnica aktualneho policka
        boolean skokDopadolUspesne; // pomocna premenna na uchovanie vysledku noveho pohybu
        k = -1;
        do // Postupne prechadzaj mozne tahy
        {
            k++;
            skokDopadolUspesne = false;

            // Najdi novy bod na zaklade sucasneho bodu a suradnic skoku
            u = aktX + a[k]; 
            v = aktY + b[k];
            if ((0 <= u) && (u < this.blud.length)){ // Ak sa bod nachadza v bludisku
                if ((0 <= v) && (v < this.blud[u].length)){
                    // Ak som tam este nebol a mozem tam ist
                    if ((this.cesta[u][v] == 0) && (this.blud[u][v] == 1)){
                        this.cesta[u][v] = cisloSkoku;

                        // Ak este nie som v cieli, pokusam sa ist dalej
                        if ((u != cielX) || (v != cielY)){
                            skokDopadolUspesne = vyskusaj(cisloSkoku + 1, u, v);
                            if (!skokDopadolUspesne)
                                this.cesta[u][v] = 0;
                        }
                        else
                            skokDopadolUspesne = true;
                    }
                }
            }
        }
        while (!(skokDopadolUspesne || (k == 3)));
        return skokDopadolUspesne;
    }

    public void najdiAvypisCestu(){
        if (this.vyskusaj(2, 0, 0))
            this.vypisVysledky();
        else
            System.out.println("Riešenie pre toto bludisko neexistuje!");
    }
}
