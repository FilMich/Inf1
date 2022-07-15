import java.util.Random;

public class Hra {
    private Random generator;
    private int pocetTikov;
    private Ovladanie ovladanie;
    private Blok blok;
    private Manazer manazer;
    private Hadik hadik;
    private HraciaPlocha hraciaPlocha;
    private Smer smer;
    private boolean nabural;
    public Hra() {
        this.smer = Smer.HORE;
        this.manazer = new Manazer();
        this.ovladanie = new Ovladanie();
        this.generator = new Random();
        this.hadik = new Hadik(150, 100);
        this.hraciaPlocha = new HraciaPlocha();
        this.hadik.nakresli();
        this.pocetTikov = 0;
        this.nabural = false;
    }
    
    /*public void tik() {
        
    } */
    
    public void pohyb() {
        if (this.ovladanie.getSmerOtocenia() == 1) {
            this.smer.otocDoprava();
        } else if (this.ovladanie.getSmerOtocenia() == -1) {
            this.smer.otocDolava();
        }
    }
}
