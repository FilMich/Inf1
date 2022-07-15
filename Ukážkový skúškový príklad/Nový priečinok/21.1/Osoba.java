
/**
 * Write a description of class Osoba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Osoba {
    private String meno;
    private String priezvisko;
    private TypKlienta typ;
    private double kredit;
    private Bicykel bicykel;
    public Osoba(String meno, String priezvisko, TypKlienta typ) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.typ = typ;
        this.kredit = 0; 
    }
    
    public void zvysKredit(double suma) {
        if (suma > 0) {
            this.kredit += suma;
        }
    }
    
    public void znizKredit(double suma) {
        if (suma > 0) {
            this.kredit -= suma;
        }
    }
    
    public void setMojBicykel(Bicykel bicykel) {
        this.bicykel = bicykel;
    }
    
    public String getMenoPriezvisko() {
        return this.meno + this.priezvisko;
    }
    
    public TypKlienta getTypKlienta() {
        return this.typ;
    }
    
    public double getKredit() {
        return this.kredit;
    }
    
    public Bicykel getMojBicykel() {
        return this.bicykel;
    }
    
    public String toString() {
        return String.format("meno a priezvisko %s kredit %s typ klienta %s moj bicykel %s",this.getMenoPriezvisko(), this.kredit
        , this.typ, this.bicykel);
    }
}
