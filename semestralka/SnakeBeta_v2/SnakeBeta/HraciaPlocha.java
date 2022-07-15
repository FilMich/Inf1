/**
 * Trieda HraciaPlocha, reprezentuje plochu suradnic a zobrazi sa ako obrazok
 * 
 * @author Filip Michalek
 * 
 * @version 1.0
 */
public class HraciaPlocha {
    private Suradnice[][] suradnice;
    private Obrazok pozadie;
    private int pocetX;
    private int pocetY;
    /**
     * Parametricky konstruktor vytvori hraciu plochu ako obrazok a do suradnic si ulozi jednotlive indexy po ktorych sa pohybuje had
     * 
     */
    public HraciaPlocha() {
        this.pozadie = new Obrazok("pics\\pozadie.png");
        this.pozadie.zmenPolohu(200, 200);
        this.pozadie.zobraz();
        this.pocetX = 20;
        this.pocetY = 20;
        this.suradnice = new Suradnice[this.pocetY][this.pocetX];
        
        for (int y = 0; y < this.pocetY; y++) {
            for (int x = 0; x < this.pocetX; x++) {
                this.suradnice[y][x] = new Suradnice(20 * x + 10, 20 * y + 10, x, y);
            }
        }
        
    }
    /**
     * Metoda getSuradnice pole suradnic
     */
    public Suradnice[][] getSuradnice() {
        return this.suradnice;
    }
    
    /**
     * Pomocka pre print vsetkych suradnic, po dokonceni programu sa moze vymazat
     */
    public void printSuradnice() {
        for (int y = 0; y < this.pocetY; y++) {
            for (int x = 0; x < this.pocetX; x++) {
                System.out.print("[" + this.suradnice[y][x].getX() + "," + this.suradnice[y][x].getY() + "] ");
            }
            System.out.println();
        }
    }
}