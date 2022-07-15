import java.util.ArrayList;

/**
 * Write a description of class GrafickePocitadlo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class GrafickePocitadlo {
    
    private ArrayList<Cislica> cislice;
    private int hodnota;
    
    public GrafickePocitadlo(int x, int y, int pocetCisel) {
        this.cislice = new ArrayList<Cislica>();
        for (int i = 0; i < pocetCisel; i++) {
            this.cislice.add(new Cislica(x+15*i, y, 0.3));
        }
        this.setHodnota(0);
    }
    
    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
        int nasobic = 1;
        for (int i = this.cislice.size() - 1; i >= 0; i--) {
            this.cislice.get(i).zobrazCislo((this.hodnota % (nasobic*10)) / nasobic);
            nasobic *= 10;
        }
    }
    
    public void zvys() {
        this.setHodnota(this.hodnota + 1);
    }
    
    public void zvys(int hodnota) {
        this.setHodnota(this.hodnota + hodnota);
    }
}
