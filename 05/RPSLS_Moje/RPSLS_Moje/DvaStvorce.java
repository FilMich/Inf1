import java.awt.Rectangle;
import java.util.ArrayList;

public class DvaStvorce {
    private Stvorec stvorec;
    private int strana;
    private int lavyHornyX;
    private int lavyHornyY;
    private String farba;
    //private ArrayList<Stvorec> stvorce;
    private Stvorec[] stvorce;
    
    public DvaStvorce(int p) {
        //this.stvorce = new ArrayList<Stvorec>();
        this.strana = 30;
        this.lavyHornyX = 180;
        this.lavyHornyY = 150;
        this.farba = "red";
        if (p < 1)
            stvorce = new Stvorec[1];
        else
            stvorce = new Stvorec[p];

        // Inicializacia skriniek (vsetky su otvorene)
        for (int i = 0; i < stvorce.length; i++){
            stvorce[i] = new Stvorec();
        }
    }

    public void vypisDvaStvorce() {
        for (int i = 0; i < stvorce.length; i++){
            this.nakresli();
        }
    }
    public void zvacsi(Stvorec dalsi) {
        //this.stvorce.add(dalsi);
    }
    
    public void nakresli() {
        int x = 0;
        int y = 0;
        for(Stvorec s: this.stvorce) {
            x += this.lavyHornyX;
            y += this.lavyHornyY;
            Platno canvas = Platno.dajPlatno();
                canvas.draw(this, this.farba,
                            new Rectangle(x + 20, y + 20, this.strana, this.strana));
                canvas.wait(10);
            }
    } 
}
