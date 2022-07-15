import java.awt.Rectangle;

public class Stvorec {
    private int strana;
    private int lavyHornyX;
    private int lavyHornyY;
    private String farba;
    private Jedlo jedlo;
    
    public Stvorec() {
        this.strana = 30;
        this.lavyHornyX = 180;
        this.lavyHornyY = 50;
        this.farba = "red";
    }
    
    public int getLavyHornyX() {
        return this.lavyHornyX;
    }
    public void nakresli() {
        Platno canvas = Platno.dajPlatno();
            canvas.draw(this, this.farba,
                        new Rectangle(this.lavyHornyX, this.lavyHornyY, this.strana, this.strana));
            canvas.wait(10);
    }
    public int getX() {
        return this.lavyHornyX;
    }
    public void posunHore() {
        this.posunZvisle(-1);    
    }

    public void posunDole() {
        this.posunZvisle(1);
    }

    public void posunVpravo() {
        this.posunVodorovne(1);
    }

    public void posunVlavo() {
        this.posunVodorovne(-1);
        jedlo.noveJedlo();
    }
    
    public void posunVodorovne(int vzdialenost) {
        this.zmaz();
        this.lavyHornyX += vzdialenost;
        this.nakresli();
        
    }
    
    public void posunZvisle(int vzdialenost) {
        this.zmaz();
        this.lavyHornyY += vzdialenost;
        this.nakresli();
    }
    
    private void zmaz() {
        Platno canvas = Platno.dajPlatno();
        canvas.erase(this);
    }
    
}