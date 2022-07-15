import java.util.Random;
public class BikeSharingSystem {
    private Stojan[] poleStojanov;
    private Random generator;
    public BikeSharingSystem(int pocetStojanov, int velkostStojana, int pocetBicyklovVstojane) {
        Random generator = new Random();
        this.poleStojanov = new Stojan[pocetStojanov];
        int c = 1;
        for (int i = 0; i < pocetStojanov; i++) {
            this.poleStojanov[i] = new Stojan(velkostStojana);
            for (int j = 0; j < pocetBicyklovVstojane; j++) {
                Farba f =Farba.getFarba(generator.nextInt(4) + 1);
                boolean kosik = generator.nextBoolean();
                this.poleStojanov[i].pridajBicykel(new Bicykel(f, c, kosik));
                c++;
            }
        }
    }
    public double urciPoplatok(TypKlienta typKlienta) {
        switch(typKlienta) {
                case STANDARD: return 0.5;
                case STUDENT: return 0.3;
                case SENIOR: return 0.2;
                default: return 0;
            }
        }
    
    public void pozicajBicykel(Osoba osoba, int indexStojanu) {
        if (osoba.getMojBicykel() == null) {
            Stojan stojan = this.poleStojanov[indexStojanu];
            if (stojan.getAktualnyPocetBicyklov() != 0) {
                double poplatok = this.urciPoplatok(osoba.getTypKlienta());
                if (poplatok < osoba.getKredit()) {
                    stojan.uvolniBicykel();
                    osoba.znizKredit(poplatok);
                    osoba.setMojBicykel(stojan.uvolniBicykel());
                }
            }
        }
    }
}
