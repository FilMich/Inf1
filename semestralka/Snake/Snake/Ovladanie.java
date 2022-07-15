import javax.swing.JOptionPane;
/**
 * Trieda Ovladaine, spusta tik ktory zabezpecuje pohyb hada a kontrolu kolizie s jablkom a hraniciami
 * 
 * @author Filip Michalek
 * 
 * @version 1.0
 */
public class Ovladanie {
    private Hadik hadik;
    private Manazer manazer;
    private Smer smer;
    private int pocetTikov = 0;
    private Hra hra;
    private Jablko jablko;
    private HraciaPlocha hraciaPlocha;
    /**
     * Parametricky konstruktor dovoli manazerovi spravovanie tohoto objeku
     * 
     * @param hadik je hadik
     * @param smer je smer v ktorom sa hadik pohybuje
     * @param hra je hra
     */
    public Ovladanie(Hadik hadik, Smer smer, Hra hra) {
        this.hra = hra;
        this.hadik = hadik;
        this.smer = smer;
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
    }
    /**
     * Metoda posunVpravo zmeni hadov smer doprava
     */
    public void posunVpravo() {
        this.smer = Smer.otocDoprava(this.smer);
    }
    /**
     * Metoda posunVlavo zmeni hadov smer dolava
     */
    public void posunVlavo() {
        this.smer = Smer.otocDolava(this.smer);    
    }
    /**
     * Metoda posunHore zmeni hadov smer hore
     */
    public void posunHore() {
       this.smer = Smer.otocHore(this.smer);
    }
    /**
     * Metoda posunDole zmeni hadov smer dole
     */
    public void posunDole() {
       this.smer = Smer.otocDole(this.smer);
    }
    /**
     * Metoda tik sa vykonava opakovane a zabezpecuje pohyb a kontrolu kolizie jablka, hranic a podmienku na vyhru
     */
    public void tik() {
        if (this.pocetTikov > 0.5) {
            if (this.hra.vyhralSi()) {
                JOptionPane.showMessageDialog(null, "Had dosiahol skore 1000, Vyhral si");
                System.exit(0);
            }
            if (this.hra.koliziaHranice()) {
                JOptionPane.showMessageDialog(null, "Koniec hry");
                System.exit(0);
            }
            if (!this.hra.koliziaJablko()) {
                this.hadik.posunHadovuHlavu(this.smer);
                this.hadik.posunHadovChvost();
            }
            //this.hadik.skontrolujHada(); nefunguje
            this.pocetTikov = 0;
        }
        this.pocetTikov++;
    }
}
