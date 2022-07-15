/**
 * Enumeracna trieda Smer reprezentuje 4 smery akymi moze had ist
 * 
 * @Filip Michalek
 * @version 1.0
 */
public enum Smer {
    HORE,
    DOLE,
    DOLAVA,
    DOPRAVA;
    
    /**
     * Metoda otocDoprava zmeni polohu hada podla vstupu
     */
    public static Smer otocDoprava(Smer input) {
        switch (input) {
            case DOLAVA:
                return DOLAVA;
            default:
                return DOPRAVA;
        }
    }
    /**
     * Metoda otocDolava zmeni polohu hada podla vstupu
     */
    public static Smer otocDolava(Smer input) {
        switch (input) {
            case DOPRAVA:
                return DOPRAVA;
            default:
                return DOLAVA;
        }
    }
    /**
     * Metoda otocHore zmeni polohu hada podla vstupu
     */
    public static Smer otocHore(Smer input) {
        switch (input) {
            case DOLE:
                return DOLE;
            default:
                return HORE;
        }
    }
    /**
     * Metoda otocDole zmeni polohu hada podla vstupu
     */
    public static Smer otocDole(Smer input) {
        switch (input) {
            case HORE:
                return HORE;
            default:
                return DOLE;
        }
    }
}

