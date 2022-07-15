public class Osoba {
    private String meno;
    private String priezvisko;
    private int plat;    
    private PracovneZaradenie pracovneZaradenie;

    public Osoba(String paMeno, String paPriezvisko, int paPlat) {
        this.setMeno(paMeno);
        this.setPriezvisko(paPriezvisko);
        this.setPlat(paPlat);
        this.pracovneZaradenie = PracovneZaradenie.vygenerujNahodneZaradenie();
    }
    
    public Osoba(String paMeno, String paPriezvisko, int paPlat, PracovneZaradenie paPracovneZaradenie) {
        this.setMeno(paMeno);
        this.setPriezvisko(paPriezvisko);
        this.setPlat(paPlat);
        this.pracovneZaradenie = paPracovneZaradenie;
    }

    public String getMeno() {
        return this.meno;
    }
    
    public String getPriezvisko() {
        return this.priezvisko;
    }
    
    public PracovneZaradenie getZaradenie() {
        return this.pracovneZaradenie;
    }    
    
    public int getPlat() {
        return this.plat;
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
        return this.meno + " " + this.priezvisko + " - " + this.pracovneZaradenie + " - "+ this.plat + " eur";
    }
}
