public class Osoba {
    private String meno;
    private String priezvisko;
    private int rokNarodenia;
    private boolean narokNaVlakyZadarmo;
        
    public Osoba(String meno, String priezvisko, int rokNarodenia, boolean narok) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.rokNarodenia = rokNarodenia;
        this.narokNaVlakyZadarmo = narok;
    }
        
    public String getMenoApriezvisko() {
        return this.meno + " " + this.priezvisko; 
    }
    
    public int getVek() {
        return 2018 - this.rokNarodenia;
    }
    
    public boolean getNarokNaVlakyZadarmo() {
        return this.narokNaVlakyZadarmo;
    }
    
    public String toString() {
        return getMenoApriezvisko() + "\nvek: " + this.getVek() + "\nvlaky: " + this.getNarokNaVlakyZadarmo();
    }
    
    public void vypisInfo() {
        System.out.println(this);
    }
}
