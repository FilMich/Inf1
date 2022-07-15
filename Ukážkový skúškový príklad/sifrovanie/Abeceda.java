/**
 * Write a description of class Abeceda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Abeceda {
    private String pismenko;
    private Vstup vstup;
    private String a;
    public Abeceda(Vstup vstup, String a) {
        this.pismenko = "";
        this.vstup = vstup;
        this.a = a;
    }
    
    public void ZvacsiPismenko(String pismenko) {
        this.pismenko = pismenko.toUpperCase();
    }
    
    public String preloz(char pismenko) {
        if (this.a == "sifruj") {
            char ch = (char)((int)pismenko + this.vstup.getPosun());
            return String.valueOf(ch);
        } else {
            char ch = (char)((int)pismenko - this.vstup.getPosun());
            return String.valueOf(ch);
        }
    }
    
}
