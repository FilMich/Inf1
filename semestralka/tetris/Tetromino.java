
/**
 * Write a description of class Tetromino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tetromino {
    
    private int poziciaX;
    private int poziciaY;
    
    //private ArrayList<Suradnica> tvar; 
    private boolean[][] tvar;
    
    public Tetromino(boolean[][] tvar) {
        this.tvar = tvar;  
        
        this.poziciaX = (Displej.POCET_POLICOK_X - this.tvar.length) / 2;
        this.poziciaY = 0;
    }
    
    public void zobraz() {
        for (int x = 0; x < this.getSirka(); x++) {
            for (int y = 0; y < this.getVyska(); y++) {
                if (this.tvar[x][y]) {
                    Displej.getInstancia().zasviet(x + this.poziciaX, y + this.poziciaY);
                }
            }
        }
    }
    
    public void skry() {
        for (int x = 0; x < this.getSirka(); x++) {
            for (int y = 0; y < this.getVyska(); y++) {
                if (this.tvar[x][y]) {
                    Displej.getInstancia().zhasni(x + this.poziciaX, y + this.poziciaY);
                }
            }
        }
    }
    
    public int getSirka() {
        return this.tvar.length;
    }
    
    public int getVyska() {
        return this.tvar[0].length;
    }
    
    public void posunVpravo() {
        if (Displej.POCET_POLICOK_X - this.getSirka() <= poziciaX) {
            return;
        }
        
        this.skry();
        this.poziciaX++;
        this.zobraz();
    }
    
    public void posunVlavo() {
        if (this.poziciaX <= 0) {
            return;
        }
        
        this.skry();
        this.poziciaX--;
        this.zobraz();
    }
    
    public void posunHore() {
        // Urobit rotaciu tetromina doprava o 90 stupnov
    }
    
    public void tik() {
        if (this.poziciaY >= Displej.POCET_POLICOK_Y - this.getVyska()) {
            return;
        }
        
        this.skry();
        this.poziciaY++;
        this.zobraz();
    }
}
