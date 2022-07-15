
/**
 * Enumeration class Farba - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Farba {
    BIELA,
    MODRA,
    CERVENA,
    ZELENA;
    
    public static Farba getFarba(int index) {
        switch (index) {
            case 1: 
                return Farba.BIELA;
            case 2: 
                return Farba.MODRA;
            case 3:
                return Farba.CERVENA;
            default:
                return Farba.ZELENA;
        }
    }
}
