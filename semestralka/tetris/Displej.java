
/**
 * Write a description of class Displej here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Displej {
    
    public static final int POCET_POLICOK_X = 10;
    public static final int POCET_POLICOK_Y = 20;
    public static final int VELKOST_POLICKA = 20;
    
    private Stvorec[][] mriezka;
    
    private static Displej instanciaDispleja;
    
    public static Displej getInstancia() {
        if (Displej.instanciaDispleja == null) {
            Displej.instanciaDispleja = new Displej();
        }
        
        return Displej.instanciaDispleja;        
    }
    
    private Displej() {
        int posunutieX = (400 - ((VELKOST_POLICKA + 1) * POCET_POLICOK_X)) / 2;
        int posunutieY = (600 - ((VELKOST_POLICKA + 1) * POCET_POLICOK_Y)) / 2;
        
        this.mriezka = new Stvorec[POCET_POLICOK_X][POCET_POLICOK_Y]; //null
        
        for (int x = 0; x < POCET_POLICOK_X; x++) {
            for (int y = 0; y < POCET_POLICOK_Y; y++) {
                Stvorec policko = new Stvorec();
                policko.zmenStranu(VELKOST_POLICKA);
                policko.zmenFarbu("black");
                policko.posunVodorovne(x * (VELKOST_POLICKA + 1) + posunutieX);
                policko.posunZvisle(y * (VELKOST_POLICKA + 1) + posunutieY);
                policko.zobraz();                
                
                this.mriezka[x][y] = policko;
            }
        }
    }
    
    public void zasviet(int x, int y) {
        Stvorec policko = this.mriezka[x][y];
        policko.zmenFarbu("magenta");
    }
    
    public void zhasni(int x, int y) {
        this.mriezka[x][y].zmenFarbu("black");
    }
    
}
