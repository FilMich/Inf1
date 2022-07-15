import java.util.Random;
import java.util.ArrayList;
/**
 * Trieda Jablko, reprezentuje hadove jedlo v podobe bloku jablka ktore sa zobrazi ako obrazok
 * 
 * @Filip Michalek 
 * @version 1.0
 */
public class Jablko {
    private Random generator;
    private Obrazok obrazok;
    private Blok blok;
    private Suradnice[][] suradnice;
    private int polohaX;
    private int polohaY;
    private HraciaPlocha hraciaPlocha;
    private Hadik hadik;
    private ArrayList<Blok> telo;
    /**
     * Parametricky konstruktor vytvori blok typu jablko so suradniciami takymi aby sa nenachadzalo v tele hada
     * 
     * @param suradnice su suradnice hracej plochy
     * @param hadik je hadik
     * @param telo je list blokov(hadove telo)
     */
    public Jablko(Suradnice[][] suradnice, Hadik hadik, ArrayList<Blok> telo) {
        this.telo = telo;
        this.hadik = hadik;
        this.generator = new Random();
        this.suradnice = suradnice;
        this.polohaX = this.generator.nextInt(18) + 1;
        this.polohaY = this.generator.nextInt(18) + 1;
        this.skontroluj();
        int pixelX = this.suradnice[this.polohaY][this.polohaX].getX();
        int pixelY = this.suradnice[this.polohaY][this.polohaX].getY();
        this.blok = new Blok(pixelX, pixelY, "jedlo", this.polohaX, this.polohaY);
    }
    /**
     * Metoda getPolohuX vrati index bloku x
     */
    public int getPolohuX() {
        return this.polohaX;
    }
    /**
     * Metoda getPolohuY vrati index bloku x
     */
    public int getPolohuY() {
        return this.polohaY;
    }
    /**
     * Metoda zmazJ zmaze obrazok bloku typu jablko
     */
    public void zmazJ() {
        this.blok.getObrazok().zmaz();
    }
    /**
     * Metoda skontroluj prejde kazdy blok v hodovom tele a porovna index daneho bloku s polohou jablka
     * Ide o kontrolu ci sa jablko nevygenerovalo do tela hada a ak hej nech sa vygeneruje znovu a skontroluje
     */
    public void skontroluj() {
        for (Blok b: this.telo) {
            if (b.getPolohuX() == this.polohaX && b.getPolohuY() == this.polohaY) {
                this.polohaX = this.generator.nextInt(18) + 1;
                this.polohaY = this.generator.nextInt(18) + 1;
                this.skontroluj();
            }
        }
    }
}
