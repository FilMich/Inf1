public class Osoba {
    private String aMeno;
    private String aPriezvisko;
    private TypKlienta aTyp;
    private double aKredit;
    private Bicykel aMojBicykel;

    public Osoba() {
        this.aMeno = "Marek";
        this.aPriezvisko = "Kvet";
        this.aTyp = TypKlienta.VIP;
        this.aKredit = 0;
        this.aMojBicykel = null;
    }   

    public Osoba(String paMeno, String paPriezvisko, TypKlienta paTyp) {
        this.aMeno = paMeno;
        this.aPriezvisko = paPriezvisko;
        this.aTyp = paTyp;
        this.aKredit = 0;
        this.aMojBicykel = null;
    }

    public String getMenoPriezvisko() {
        return this.aMeno + " " + this.aPriezvisko;
    }

    public TypKlienta getTypKlienta() {
        return this.aTyp;
    }

    public double getKredit() {
        return this.aKredit;
    }

    public void zvysKredit(double paSuma) {
        if (paSuma > 0)
            this.aKredit = this.aKredit + paSuma;
    }

    public void znizKredit(double paSuma) {
        if (this.aKredit - paSuma >= 0)
            this.aKredit = this.aKredit - paSuma;
    }

    public Bicykel getMojBicykel() {
        return this.aMojBicykel;
    }

    public void setMojBicykel(Bicykel paBicykel) {
        this.aMojBicykel = paBicykel;
    }

    public String toString() {
        return this.getMenoPriezvisko() + " - " + this.aTyp + " - kredit: " + this.aKredit;
    }
}
