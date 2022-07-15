
/**
 * Enumeration class Smer - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Smer {
    HORE,
    DOLE,
    DOLAVA,
    DOPRAVA;
    
    public Smer otocDoprava() {
        switch (this) {
            case DOPRAVA :
                return DOLE;
            case DOLE :
                return DOLAVA;
            case DOLAVA :
                return HORE;
            case HORE :
                return DOPRAVA;
        } 
        return null;
    }
    
    public Smer otocDolava() {
        switch (this) {
            case DOPRAVA :
                return HORE;
            case HORE :
                return DOLAVA;
            case DOLAVA :
                return DOLE;
            case DOLE :
                return DOPRAVA;
        } 
        return null;
    }
}

