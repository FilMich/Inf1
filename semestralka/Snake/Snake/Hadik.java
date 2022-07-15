import java.util.ArrayList;
/**
 * Trieda Hadik, reprezentuje telo hada, ktory sa pohybude po suradniciach hracej plochy a vykresluje sa na platno
 * 
 * @author Filip Michalek
 * 
 * @version 1.0
 */
public class Hadik {
    private ArrayList<Blok> telo;
    private Obrazok obrazok;
    private Blok blok;
    private Suradnice[][] suradnice;
    private int polohaX;
    private int polohaY;
    private HraciaPlocha hraciaPlocha;
    private Smer smer;
    private GrafickePocitadlo pocitadloSkore;
    private Hra hra;
    /**
     * Parametricky konstruktor vytvori list Blokov a posuva ich v danom smere po danych indexoch
     * 
     * @param suradnice su indexy jednotlivych blokov
     * @param hraciaPlocha je hracia plocha po ktorej sa hadik pohybuje
     */
    public Hadik(Suradnice[][] suradnice, HraciaPlocha hraciaPlocha) {
        this.pocitadloSkore = pocitadloSkore;
        this.telo = new ArrayList<Blok>();
        this.suradnice = suradnice;
        this.polohaX = 4;
        this.polohaY = 4;
        this.hraciaPlocha = hraciaPlocha;
        int pixelX = this.suradnice[this.polohaY][this.polohaX].getX();
        int pixelY = this.suradnice[this.polohaY][this.polohaX].getY();
        this.telo.add(new Blok(pixelX, pixelY, "hlava", this.polohaX, this.polohaY));
        this.posunHadovuHlavu(Smer.DOPRAVA);
        this.posunHadovuHlavu(Smer.DOPRAVA);
    }
    /**
     * Metoda getTelo vrati zoznam blokov v hadovom tele
     */
    public ArrayList<Blok> getTelo() {
        return this.telo;
    }
    /**
     * Metoda posunHadovuHlavu posunie hadovu hlavu v smere ktory je  prideleny ako parameter
     * @param smer je smer ktory urcuje smer v ktorom sa had posunie
     */
    public void posunHadovuHlavu(Smer smer) {
        switch (smer) {
            case HORE:
                this.polohaY--;
                break;
            case DOLE:
                this.polohaY++;
                break;
            case DOPRAVA:
                this.polohaX++;
                break;
            case DOLAVA:
                this.polohaX--;
                break;
        }
        int pixelX = this.suradnice[this.polohaY][this.polohaX].getX();
        int pixelY = this.suradnice[this.polohaY][this.polohaX].getY();
        this.telo.add(new Blok(pixelX, pixelY, "telo", this.polohaX, this.polohaY));
        this.smer = smer;
    }
    /**
     * Metoda getSmer vrati smer hada
     */
    public Smer getSmer() {
        return this.smer;
    }
    /**
     * Metoda posunHadovChvost zmaze obrazok bloku a potom ho odstrani
     */
    public void posunHadovChvost() {
        this.telo.get(0).zmaz();
        this.telo.remove(0);
    }
    /**
     * Metoda nakresli prejde cely list blokov (hadove telo) a nakresli kazdy jeden blok
     */
    public void nakresli() {
        for (Blok b: this.telo) {
            b.getObrazok().zobraz();
        }
    }
    /**
     * Metoda getPolohuX vrati index bloku x
     */
    public int getPolohuX() {
        return this.polohaX;
    }
    /**
     * Metoda getPolohuY vrati index bloku y
     */
    public int getPolohuY() {
        return this.polohaY;
    }
    /**
     * Metoda zvacsiSa posunie hadovu hlavu bez zmazania chvostu co vytvori efekt zvacsiena
     */
    public void zvacsiSa() {
        this.posunHadovuHlavu(this.smer);
    }
}
