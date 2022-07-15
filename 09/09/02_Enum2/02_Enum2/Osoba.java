public class Osoba {
    private String meno;
    private Zaradenie zaradenie;    
    
    public Osoba(String meno, Zaradenie zaradenie) {
        this.meno = meno;
        this.zaradenie = zaradenie;
    }
    
    public Zaradenie getZaradenie() {
        return this.zaradenie;
    }
        
    public String toString() {
        return this.zaradenie + " " + this.meno;
    }
}
