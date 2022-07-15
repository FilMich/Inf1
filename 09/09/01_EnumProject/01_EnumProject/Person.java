public class Person {
    private String meno;
    private String priezvisko;
    private int plat;    
    private PracovneZaradenie pracovneZaradenie;
    
    public Person(String paMeno, String paPriezvisko, int paPlat) {
        this.setMeno(paMeno);
        this.setPriezvisko(paPriezvisko);
        this.setPlat(paPlat);
        this.pracovneZaradenie = PracovneZaradenie.ASISTENT;
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
        if (this.pracovneZaradenie == PracovneZaradenie.ASISTENT)
            this.plat *= 2;
        else if (this.pracovneZaradenie == PracovneZaradenie.DOCENT)
            this.plat *= 3;
        else if (this.pracovneZaradenie == PracovneZaradenie.PROFESOR)
            this.plat *= 4;    
    }
    
    public void zvysKvalifikaciu() {
        if (this.pracovneZaradenie == PracovneZaradenie.ASISTENT)
            this.pracovneZaradenie = PracovneZaradenie.DOCENT;
        else if (this.pracovneZaradenie == PracovneZaradenie.DOCENT)
            this.pracovneZaradenie = PracovneZaradenie.PROFESOR;
    }
}
