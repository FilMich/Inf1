/**
 * Tato trieda bola prevzata
 */
public class Segment {
    
    private Obdlznik obdlznik;
    
    public Segment(int x, int y, boolean jeZvisly, double velkost) {
        this.obdlznik = new Obdlznik();
        if (jeZvisly) {
            this.obdlznik.zmenStrany((int)Math.ceil(4 * velkost), (int)Math.ceil(30 * velkost));
        } else {
            this.obdlznik.zmenStrany((int)Math.ceil(30 * velkost), (int)Math.ceil(4 * velkost));
        }
        this.obdlznik.zobraz();
        this.obdlznik.posunVodorovne(x - 60);
        this.obdlznik.posunZvisle(y - 50);
    }
    
    public void zapni() {
        this.obdlznik.zmenFarbu("red");
    }
    
    public void vypni() {
        this.obdlznik.zmenFarbu("yellow");
    }
}
