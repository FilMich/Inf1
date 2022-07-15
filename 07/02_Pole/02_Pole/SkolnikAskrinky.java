
//Školník a skrinky
//V škole je n (napr. n = 100) skriniek na veci pre študentov. Na začiatku sú všetky skrinky otvorené.
//Príde školník a pre každú druhú skrinku v poradí urobí nasledujúcu operáciu: Ak je skrinka otvorená, tak ju zatvorí;
//ak je zatvorená, tak ju otvorí. Ked príde na koniec radu skriniek, vráti sa na začiatok a začne opäť od začiatku
//vykonávať tú istú operáciu, ale teraz pre každú tretiu skrinku. No a takto to pokračuje, školník sa vždy vráti na začiatok
//a robí definovanú operáciu pre každú k-tu skrinku od začiatku, pričom k sa zväčšuje od 2 po n.
//Otázka znie: Ktoré skrinky budú po tomto procese otvorené a prečo? (riešte pre n=100)

public class SkolnikAskrinky {
    private boolean[] skrinky;   

    public SkolnikAskrinky(int pocetSkriniek) {
        if (pocetSkriniek < 1)
            skrinky = new boolean[1];
        else
            skrinky = new boolean[pocetSkriniek];

        // Inicializacia skriniek (vsetky su otvorene)
        for (int i = 0; i < skrinky.length; i++){
            skrinky[i] = true;
        }
    }

    public void vykonajPracuSkolnika(){   
        for(int modulo = 2; modulo <= skrinky.length; modulo++){
            for(int i = 0; i < skrinky.length; i++){
                // Otvorene zatvori a zatvorene otvori
                if (((i + 1) % (modulo)) == 0)
                    skrinky[i] = !skrinky[i];
            }
        }

        System.out.print("Otvorene skrinky: ");
        for(int i = 0; i < skrinky.length; i++){
            if (skrinky[i])
                System.out.print((i+1) + "  ");
        }
        System.out.println();
    }
}
