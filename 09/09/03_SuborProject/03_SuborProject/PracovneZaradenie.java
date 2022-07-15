import java.util.Random;

public enum PracovneZaradenie {
    STUDENT,
    ASISTENT,
    DOCENT,
    PROFESOR;
    
    public static PracovneZaradenie vygenerujNahodneZaradenie() {
        Random generator = new Random();
        int nahodnaHodnota = generator.nextInt(4);

        if (nahodnaHodnota == 3)
            return PROFESOR;
        else if (nahodnaHodnota == 2)
            return DOCENT;
        else if (nahodnaHodnota == 1)
            return ASISTENT;
        else
            return STUDENT;
    }
    
    public static PracovneZaradenie nastavPodlaStringu(String vstup) {
        if (vstup.equals("PROFESOR"))
            return PROFESOR;
        else if (vstup.equals("DOCENT"))
            return DOCENT;
        else if (vstup.equals("ASISTENT"))
            return ASISTENT;
        else
            return STUDENT;
        
    }
}
