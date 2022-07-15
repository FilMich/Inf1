public class Turnaj {
    // Sachovy turnaj sa hra systemom "kazdy s kazdym".
    // Kazda dvojica hra len jednu hru.
    // Za vitazstvo sa hracovi pripisu 2 body, za remizu 1 a za prehru nic.
    // Turnaj vyhrava hrac s najvyssim poctom bodov.

    // Vytvorte triedu, ktora bude modelovat sachove turnaje a umozni 
    // generovanie vysledkov pre jednotlive zapasy. Na zaklade vysledkov vypiste vitaza (prvych troch najlepsich hracov).

    private StavHry[][] maticaVysledkov;
    private int pocetHracov;
    private String[] zoznamHracov;
    private int[] skoreHracov;
    
    public Turnaj(int paPocetHracov) {
        if (paPocetHracov < 3)
            this.pocetHracov = 3;
        else
            this.pocetHracov = paPocetHracov;

        // Vytvorenie zoznamu a skore hracoh    
        this.zoznamHracov = new String[this.pocetHracov];
        this.skoreHracov = new int[this.pocetHracov];
        for(int i = 0; i < this.pocetHracov; i++) {    
            if (i + 1 < 10)
                this.zoznamHracov[i] = "Hrac_0" + (i+1);
            else    
                this.zoznamHracov[i] = "Hrac_" + (i+1);
                
            skoreHracov[i] = 0;    
        }

        // Vytvorenie matice vysledkov (neexistujuce vysledky, pouzijem null)  
        this.maticaVysledkov = new StavHry[this.pocetHracov][];
        for(int i = 0; i < this.maticaVysledkov.length; i++) {
            this.maticaVysledkov[i] = new StavHry[this.pocetHracov];
            for(int j = 0; j < this.maticaVysledkov[i].length; j++) {
                this.maticaVysledkov[i][j] = null;
            }
        }

        // Vygenerovanie vysledkov jednotlivych hier - pouzijem spodny trojuholnik matice
        // POZOR, staci generovat polovicu matice, druha polovica bude zavisiet od vysledkov prvej polovice !!!
        // Priklad: Ak Marek vyhra nad Michalom, tak Michal s Marekom logicky prehra.
        // Na hlavnej diagonale zostanu neexistujuce zaznamy, teda null, hrac predsa nehra sam so sebou!
        for(int i = 1; i < this.maticaVysledkov.length; i++) {
            for (int j = 0; j < i; j++) {
                this.maticaVysledkov[i][j] = StavHry.vygenerujNahodnyVysledok();
            }
        }

        // Priebezny vypis
        System.out.print('\u000c');
        System.out.println("Tabulka zapasov:");
        
        for(int i = 0; i < this.maticaVysledkov.length; i++) {
            for(int j = 0; j < this.maticaVysledkov[i].length; j++) {
                if (i == j)
                    System.out.print(" - ");
                else {    
                    if (this.maticaVysledkov[i][j] != null)
                        System.out.print(" " + StavHry.getSkratka(this.maticaVysledkov[i][j]) + " ");
                }
                
                if (j < this.maticaVysledkov[i].length - 1)    
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();

        // Doplnenie hornej polovice matice
        for(int i = 0; i < this.maticaVysledkov.length - 1; i++){
            for(int j = i + 1; j < this.maticaVysledkov[i].length; j++)
                this.maticaVysledkov[i][j] = StavHry.vygenerujOpacnyVysledok(this.maticaVysledkov[j][i]);
        }
        
        // Kontrolny vypis
        System.out.println("Bodovanie:");
        System.out.println("Vyhra: 2 body");
        System.out.println("Remiza: 1 bod");
        System.out.println("Prehra: 0 bodov");
        System.out.println();
        System.out.println("Tabulka skore:");
        
        for(int i = 0; i < this.maticaVysledkov.length; i++) {
            for(int j = 0; j < this.maticaVysledkov[i].length; j++) {
                if (i == j)
                    System.out.print(" - ");
                else {    
                    if (this.maticaVysledkov[i][j] != null)
                        System.out.print(StavHry.getBody(this.maticaVysledkov[i][j]) + ":" + StavHry.getBody(this.maticaVysledkov[j][i]));
                }
                
                if (j < this.maticaVysledkov[i].length - 1)    
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
        
        // Vyhodnotenie turnaja
        System.out.println("Vyhodnotenie turnaja:");
        for(int i = 0; i < this.maticaVysledkov.length; i++) {
            for(int j = 0; j < this.maticaVysledkov[i].length; j++) {
                if (this.maticaVysledkov[i][j] != null)
                    this.skoreHracov[i] += StavHry.getBody(this.maticaVysledkov[i][j]);
            }
        }
        
        // Zoradenie hracov podla skore    
        int pom = 0;  
        String pomString;
        for(int i = 0; i < this.skoreHracov.length; i++){  
            for(int j = 1; j < this.skoreHracov.length - i; j++){   
                if (this.skoreHracov[j-1] < this.skoreHracov[j]){  
                    pom = this.skoreHracov[j-1];  
                    this.skoreHracov[j-1] = this.skoreHracov[j];  
                    this.skoreHracov[j] = pom;
                    
                    pomString = this.zoznamHracov[j-1];  
                    this.zoznamHracov[j-1] = this.zoznamHracov[j];  
                    this.zoznamHracov[j] = pomString;
                }       
            }  
         }  

        for(int i = 0; i < this.skoreHracov.length; i++)
            if (i + 1 < 10)
                System.out.println(" " + (i+1) + ".miesto: " + this.zoznamHracov[i] + " - " + this.skoreHracov[i]);
            else        
                System.out.println((i+1) + ".miesto: " + this.zoznamHracov[i] + " - " + this.skoreHracov[i]);
    }
}
