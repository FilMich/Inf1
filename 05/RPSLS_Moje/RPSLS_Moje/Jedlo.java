import java.awt.Rectangle;
import java.util.Random;

public class Jedlo {
    private int strana;
    private int lavyHornyX;
    private int lavyHornyY;
    private int x;
    private int y;
    private String farba;
    private Random generator;
    private Stvorec stvorec;
    
    public Jedlo() {
        this.strana = 30;
        this.lavyHornyX = 80;
        this.lavyHornyY = 50;
        this.farba = "red";
        this.generator = new Random();
        this.x = this.generator.nextInt(1+400)-1;
        this.y = this.generator.nextInt(1+300)-1;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void nakresli() {
         
        Platno canvas = Platno.dajPlatno();
            canvas.draw(this, this.farba,
                        new Rectangle(x , y , this.strana, this.strana));
            canvas.wait(10);
    }
    
    public void noveJedlo() {
        
            this.zmaz();
            this.nakresli();
        
    }
    
    private void zmaz() {
        Platno canvas = Platno.dajPlatno();
        canvas.erase(this);
    }
}
