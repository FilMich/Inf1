
/**
 * Write a description of class BikeSharingSystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BikeSharingSystem {
    private Stojan[] poleStojanov;
    public BikeSharingSystem(int pocetStojanov, int velkostStojana, int pocetBicyklovVstojane) {
        this.poleStojanov = new Stojan[pocetStojanov];
        for (int i = 0; i < pocetStojanov; i++) {
            this.poleStojanov[i] = new Stojan(velkostStojana);
        }
    }
    
    private double urciPoplatok(TypKlienta typ) {
        switch(typ) {
            case SENIOR:
                return 0.20;
            case STANDARD:
                return 0.50;
            case STUDENT:
                return 0.30;
            default:
                return 0;
        }
    }
    
}
