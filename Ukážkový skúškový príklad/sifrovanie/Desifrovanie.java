
/**
 * Write a description of class Desifrovanie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Desifrovanie {
    private String vystup;
    private Abeceda abeceda;
    private Vstup vstup;
    public Desifrovanie(Vstup vstup, Abeceda abeceda) {
        this.vstup = vstup;
        this.vystup = "";
        this.abeceda = abeceda;
    }
    
    public void desifruj() {
        for (int j = 0; j < this.vstup.getCasti().length; j++) {
            for (int i = 0; i < this.vstup.getCasti()[j].length(); i++) {
                this.vystup += this.abeceda.preloz(this.vstup.getCastiNaIj(j, i));
            }
            this.vystup += " ";
        }
        
        System.out.println(this.vystup);
    }
}