public class Osoba {
    private String paMeno;
    private String paPriezvisko;
    private TypKlienta paTyp;
    private double paKredit;
    private Bicykel mojBicykel;
    public Osoba(String paMeno, String paPriezvisko, TypKlienta paTyp) {
        this.paMeno = paMeno;
        this.paPriezvisko = paPriezvisko;
        this.paTyp = paTyp;
        this.paKredit = 0;
    }
    
    public void zvysKredit(double paSuma) {
        if (paSuma > 0) {
            this.paKredit += paSuma;
        }
    }
    
    public void znizKredit(double paSuma) {
        if (paSuma > 0 && this.paKredit >= 0) {
            this.paKredit -= paSuma;
        }
    }
    
    public void setMojBicykel(Bicykel paBicykel) {
        this.mojBicykel = paBicykel;
    }
    
    public String getMenoPriezvisko() {
        return this.paMeno + this.paPriezvisko;
    }
    
    public TypKlienta getTypKlienta() {
        return this.paTyp;
    }
    
    public double getKredit() {
        return this.paKredit;
    }
    
    public Bicykel getMojBicykel() {
        return this.mojBicykel;
    }
    
    public String toString() {
        return String.format("%s typ klieta %s kredit %s bicykel %s", 
        this.getMenoPriezvisko(), this.paTyp, this.paKredit,
        this.mojBicykel);
    }
}
