
/**
 * Write a description of class Jedlo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jedlo {
    private Stvorec stvorec;
    private int suradnicaX;
    private int suradnicaY;
    
    public Jedlo() {
        suradnicaX = 0;
        suradnicaY = 0;
    }
    
    public int getSuradnicaX() {
        return this.suradnicaX;
    }
    
    public int getSuradnicaY() {
        return this.suradnicaY;
    }
    
    public void setSuradnicaX(int novaSuradnicaX) {
        this.suradnicaX = novaSuradnicaX;
    }
    
    public void setSuradnicaY(int novaSuradnicaY) {
         this.suradnicaY = novaSuradnicaY;
    }
}
