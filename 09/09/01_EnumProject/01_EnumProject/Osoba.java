public class Osoba {
    final static int ASISTENT = 1;
    final static int DOCENT = 2;
    final static int PROFESOR = 3;
        
    private String meno;
    private String priezvisko;
    private int plat;    
    
    // Pracovna pozicia:
    // 1. Asistent
    // 2. Docent
    // 3. Profesor
    private int pracovneZaradenie;
    
    public Osoba(String paMeno, String paPriezvisko, int paPlat) {
        this.setMeno(paMeno);
        this.setPriezvisko(paPriezvisko);
        this.setPlat(paPlat);
        
        this.pracovneZaradenie = ASISTENT;
    }
    
    public void setMeno(String noveMeno) {
        if (noveMeno.equals(""))
            this.meno = "Marek";
        else
            this.meno = noveMeno;
    }
    
    public void setPriezvisko(String novePriezvisko) {
        if (novePriezvisko.equals(""))
            this.priezvisko = "Kvet";
        else
            this.priezvisko = novePriezvisko;
    }
    
    public void setPlat(int novyPlat) {
        if (novyPlat > 0)
            this.plat = novyPlat;
        else
            this.plat = 1000;
    }
    
    public String toString() {
        return this.meno + " " + this.priezvisko + " - " + this.plat + " eur";
    }
    
    public void znasobPlat() {
        if (this.pracovneZaradenie == ASISTENT)
            this.plat *= 2;
        else if (this.pracovneZaradenie == DOCENT)
            this.plat *= 3;
        else if (this.pracovneZaradenie == PROFESOR)
            this.plat *= 4;    
    }
    
    public void zvysKvalifikaciu() {
        this.pracovneZaradenie++; // Moze byt? Preco?
        
        // Lepsie?
        if (this.pracovneZaradenie != PROFESOR)
            this.pracovneZaradenie++;
            
        // Teoreticky hrozi riziko niecoho takehoto (alebo inej blbosti)
        this.pracovneZaradenie = 2 * this.pracovneZaradenie;
        // Toto sice ide (pracujeme s hodnotami typu int), ale v kontexte obsahu sa to nehodi!!!
    }
}
