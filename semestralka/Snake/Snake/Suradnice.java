/**
 * Trieda Suracnice, reprezentuje suradnice
 * 
 * @author Filip Michalek
 * 
 * @version 1.0
 */
public class Suradnice {
    private int X;
    private int Y;
    private int indexX;
    private int indexY;
    /**
     * Parametricky konstruktor priradi suradniciam parametr ktore dostane na vstup
     * 
     * @param X je suradnica x
     * @param Y je suradnica y
     * @param indexX je index X
     * @param indexY je indes Y
     */
    public Suradnice(int X, int Y, int indexX, int indexY) {
        this.X = X;
        this.Y = Y;
        this.indexX = indexX;
        this.indexY = indexY;
    }
    /**
     * Metoda getX vrati suradnicu x
     */
    public int getX() {
        return this.X;
    }
    /**
     * Metoda getY vrati suradnicu y
     */
    public int getY() {
        return this.Y;
    }
    /**
     * Metoda getIndexX vrati index x
     */
    public int getIndexX() {
        return this.indexX;
    }
    /**
     * Metoda getIndexY vrati index y
     */
    public int getIndexY() {
        return this.indexY;
    }
}
