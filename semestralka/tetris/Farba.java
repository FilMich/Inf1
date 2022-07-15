import java.util.Random;

public enum Farba {
    Zlta("yellow"),
    Cervena("red"),
    Modra("blue"),
    Zelena("green"),
    Fialova("magenta");
    
    private static Random generator = new Random();
    private String farba;
    
    public static Farba dajNahodnu() {
        return Farba.values()[generator.nextInt(Farba.values().length)];
    }
    
    private Farba(String farba) {
        this.farba = farba;
    }
    
    public String dajFarbu() {
        return this.farba;
    }
}
