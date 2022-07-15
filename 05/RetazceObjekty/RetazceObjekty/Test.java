public class Test {
    public static void Test() {
        // Majme dva retazce:        
        String retazecA = "Marek";
        String retazecB = "Ma";
        
        // Vykonajme nasledovnu operaciu:
        retazecB = retazecB + "rek";
        
        // Vypiseme retazce na obrazovku:
        System.out.println("retazecA: " + retazecA);
        System.out.println("retazecB: " + retazecB);
        
        // Rovnaju sa? PRECO?
        System.out.println("Rovnaju sa? " + (retazecA == retazecB));
        
        // Maju rovnake obsahy? PRECO?
        System.out.println("Maju rovnake obsahy? " + (retazecA.equals(retazecB)));
        
        // Aky je rozdiel medzi operaciami == a equals ???
    }
}
