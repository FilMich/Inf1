public class Osoba {
    private String meno;
    private Osoba otec;

    public Osoba(String meno, Osoba otec) {
        this.meno = meno;
        this.otec = otec;
    }

    public String getMeno() {
        return this.meno;
    }

    public Osoba getOtec() {
        return this.otec;
    }

    public Osoba dajAdama() {
        if (this.otec == null) {
            return this;
        } else {
            return this.otec.dajAdama();
        }
    }
}
