
/**
 * Write a description of class Vstup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vstup {
    private String vstup;
    private String[] casti;
    private String sifrovanie;
    private int posun;
    public Vstup(String vstup, int posun, String sifrovanie) {
        this.casti = new String[vstup.length()];
        this.vstup = vstup;
        this.posun = posun;
        this.sifrovanie = sifrovanie;
        this.rozdelString();
    }
    
    public void rozdelString() {
        this.casti = this.vstup.split(" ");
    }
    
    public String[] getCasti() {
        return this.casti;
    }
    
    public char getCastiNaIj(int j, int i) {
        return this.casti[j].charAt(i);
    }
    
    public String getSifrovanie() {
        return this.sifrovanie;
    }
    
    public int getPosun() {
        return this.posun;
    }
    
    public String getVstup() {
        return this.vstup;
    }
    
    public char getVstupNaI(int i) {
        return this.vstup.charAt(i);
    }
}
