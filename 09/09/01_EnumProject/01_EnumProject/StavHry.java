import java.util.Random;

public enum StavHry {
    VYHRA,
    PREHRA,
    REMIZA;
        
    public static StavHry vygenerujNahodnyVysledok() {
        Random generator = new Random();
        int nahodnaHodnota = generator.nextInt(3);

        if (nahodnaHodnota == 2)
            return VYHRA;
        else if (nahodnaHodnota == 1)
            return REMIZA;
        else
            return PREHRA;
    }
    
    public static StavHry vygenerujOpacnyVysledok(StavHry vstup) {
        if (vstup == StavHry.VYHRA)
            return PREHRA;
        else if (vstup == StavHry.PREHRA)
            return VYHRA;
        else 
            return REMIZA;
    }
        
    public static int getBody(StavHry vstup) {
        switch (vstup) {
            case VYHRA: return 2;
            case REMIZA: return 1;
            default: return 0;
        }
    }
    
    public static String getSkratka(StavHry vstup) {
        switch (vstup) {
            case VYHRA: return "V";
            case REMIZA: return "R";
            default: return "P";
        }
    }
}
