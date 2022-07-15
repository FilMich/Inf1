import java.util.Random;
/**
 * Trieda Hra, reprezentuje hru Hadik
 * 
 * @author Filip Michalek
 * 
 * @version 1.0
 */
public class Hra {
    private int pocetTikov = 0;
    private Ovladanie ovladanie;
    private Blok blok;
    private Manazer manazer;
    private Hadik hadik;
    private HraciaPlocha hraciaPlocha;
    private Smer smer;
    private Jablko jablko;
    private GrafickePocitadlo pocitadloSkore;
    /**
     * Parametricky konstruktor vytvori hru ktora pozostava z jednotlivych tried
     */
    public Hra() {
        this.pocitadloSkore = new GrafickePocitadlo(410, 10, 4);
        this.smer = Smer.DOPRAVA;
        this.manazer = new Manazer();
        this.hraciaPlocha = new HraciaPlocha();
        this.hadik = new Hadik(this.hraciaPlocha.getSuradnice(), this.hraciaPlocha);
        this.ovladanie = new Ovladanie(this.hadik, this.smer, this);
        this.jablko = new Jablko(this.hraciaPlocha.getSuradnice(), this.hadik, this.hadik.getTelo());
        this.hadik.nakresli();
        this.pocitadloSkore.setHodnota(0);
        //this.hadik.vypisHada();
    }
    /**
     * Metoda koliziaJablko kontoluje koliziu hadovej hlavy s jablkom, ak kolizia nastane vrati sa hodnota true
     */
    public boolean koliziaJablko() {
        if (this.hadik.getPolohuX() == this.jablko.getPolohuX() && this.hadik.getPolohuY() == this.jablko.getPolohuY()) {
            this.jablko.zmazJ();
            this.pocitadloSkore.zvys(10);
            this.hadik.zvacsiSa();
            this.jablko = new Jablko(this.hraciaPlocha.getSuradnice(), this.hadik, this.hadik.getTelo());
            return true;
        }
        return false; 
    }
    /**
     * Metoda koliziaHranice kontoluje koliziu hadovej hlavy s hranicami, ak kolizia nastane vrati sa hodnota true
     */
    public boolean koliziaHranice() {
        if (this.hadik.getPolohuX() < 0 || this.hadik.getPolohuX() > 20 || this.hadik.getPolohuY() < 0 || this.hadik.getPolohuY() > 20) {
            this.pocitadloSkore.setHodnota(0);
            return true;
        }
        return false;
    }
    /**
     * Metoda vyhralSi kontoluje skore, ak si dosiahol pozadovane skore vrati sa hodnota true
     */
    public boolean vyhralSi() {
        if (this.hadik.getTelo().size() - 3 == 100) {
            return true;
        }
        return false;
    }
}
