
/**
 * Write a description of class CezarovaSifra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CezarovaSifra {
    private String vstup;
    private String vystup;
    private int posun;
    private String sifruj;
    public CezarovaSifra(String textNaPrelozenie, int posun, String sifruj) {
        this.vstup = textNaPrelozenie;
        this.posun = posun;
        this.sifruj = sifruj;
        this.vystup = "";
    }
    
    public void sifra() {
        if (this.sifruj == "zakoduj") {
            for (int i = 0; i < this.vstup.length(); i++) {
                char ch = (char)(((int)vstup.charAt(i) + this.posun - 65) % 26 + 25);
                this.vystup += String.valueOf(ch);
            }
        } else {
            for (int i = 0; i < this.vstup.length(); i++) {
                char ch = (char)(((int)vstup.charAt(i) + this.posun - 65) % 26 - 25);
                this.vystup += String.valueOf(ch);
            }
        }
    }
    
    public void print() {
        System.out.println("vstup" + this.vstup);
        System.out.println("vystup" + this.vystup);
    }
    
}
