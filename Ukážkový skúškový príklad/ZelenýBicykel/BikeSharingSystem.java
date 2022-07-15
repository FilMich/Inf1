import java.util.ArrayList;
import java.util.Random;

public class BikeSharingSystem {
    private Stojan[] aStojany;
    private ArrayList<Osoba> aZoznamUserov;
    private int aPocetJazd;
    private double aZisk;

    public BikeSharingSystem(int paPocetStojanov, int paVelkostStojana, int paPocetBicyklovVstojane) {
        Bicykel b;
        Random generator;

        this.aPocetJazd = 0;
        this.aZisk = 0;
        this.aZoznamUserov = new ArrayList<Osoba>();

        if (paPocetStojanov > 0)
            this.aStojany = new Stojan[paPocetStojanov];
        else
            this.aStojany = new Stojan[5];

        generator = new Random();    
        for(int i = 0; i < this.aStojany.length; i++) {
            // Vytvorenie stojanov
            this.aStojany[i] = new Stojan(paVelkostStojana);

            // Naplnenie bicyklami
            for(int j = 0; j < paPocetBicyklovVstojane; j++) {
                if (generator.nextInt(2) == 1)
                    b = new Bicykel(Farba.getFarba(generator.nextInt(4)), (i+1)*100 + (j+1), true);
                else
                    b = new Bicykel(Farba.getFarba(generator.nextInt(4)), (i+1)*100 + (j+1), false);

                this.aStojany[i].pridajBicykel(b);    
            }
        }
    }

    private double urciPoplatok(TypKlienta paTypKlienta) {
        switch(paTypKlienta) {
            case Student: return 0.3;
            case Senior: return 0.2;
            case VIP: return 0;
            default: return 0.5;
        }
    }

    public void vypisZoznamRegistrovanychUserov() {
        if (this.aZoznamUserov.size() == 0)
            System.out.println("Nikto sa este nezaregistroval.");
        else {
            System.out.println("Zoznam userov:");
            for(Osoba o: this.aZoznamUserov)
                System.out.println(o.toString());
        }
    }

    public void pridajUsera(Osoba paOsoba) {
        if (!this.aZoznamUserov.contains(paOsoba))
            this.aZoznamUserov.add(paOsoba);
    }

    public void vypisZoznamBicyklovVstojanoch() {
        ArrayList<Bicykel> zoznamBicyklov;        
        for(int i = 0; i < this.aStojany.length; i++) {
            System.out.println("Stojan " + i + ":");
            zoznamBicyklov = this.aStojany[i].getZoznamBicyklov();
            if (zoznamBicyklov.size() == 0)
                System.out.println("\tV danom stojane nie je ziadny bicykel.");
            else {
                for(Bicykel b: zoznamBicyklov)
                    System.out.println("\t" + b.toString());
            }
        }
    }

    public void vypisPriemernyZiskZjazdy() {
        if (this.aPocetJazd == 0)
            System.out.println("Este nebola vykonana ziadna jazda.");
        else {
            double priemer = this.aZisk / this.aPocetJazd;
            System.out.println("Priemerny zisk z jazdy: " + priemer);
        }
    }

    public void vypisZoznamPozicanychBicyklovSosobami() {
        if (this.aZoznamUserov.size() == 0)
            System.out.println("Nikto sa este nezaregistroval.");
        else {
            System.out.println("Zoznam pozicanych bicyklov:");
            Bicykel bike;
            for(Osoba o: this.aZoznamUserov) {
                bike = o.getMojBicykel();
                if (bike != null) {
                    System.out.println(o.toString());
                    System.out.println("\t" + bike.toString());
                }
            } 
        }
    }

    public void vratBicykel(Osoba paOsoba, int paIndexStojanu) {
        Bicykel b = paOsoba.getMojBicykel();
        if (b == null)
            System.out.println("Tato osoba nema pozicany ziadny bicykel!");
        else {
            if (paIndexStojanu >= 0 && paIndexStojanu < this.aStojany.length) {
                Stojan s = this.aStojany[paIndexStojanu];
                if (s.getAktualnyPocetBicyklov() < s.getKapacita()) {
                    s.pridajBicykel(b);
                    paOsoba.setMojBicykel(null);
                }
                else 
                    System.out.println("Tento stojan je uz plny, vyberte si iny stojan!");
            }
            else
                System.out.println("Index stojanu je mimo platneho rozsahu!");
        }
    }

    public void pozicajBicykel(Osoba paOsoba, int paIndexStojanu) {
        Bicykel b = paOsoba.getMojBicykel();
        Bicykel pozicany;
        if (b != null)
            System.out.println("Tato osoba uz ma pozicany bicykel!");
        else {
            if (paIndexStojanu >= 0 && paIndexStojanu < this.aStojany.length) {
                Stojan s = this.aStojany[paIndexStojanu];
                if (s.getAktualnyPocetBicyklov() > 0) {
                    double poplatok = this.urciPoplatok(paOsoba.getTypKlienta());
                    if (poplatok <= paOsoba.getKredit()) {
                        pozicany = s.uvolniBicykel();
                        paOsoba.setMojBicykel(pozicany);
                        this.aZisk += poplatok;
                        this.aPocetJazd++;
                        paOsoba.znizKredit(poplatok);
                    }
                    else
                        System.out.println("Osoba ma nedostatocny kredit!");
                }
                else 
                    System.out.println("Tento stojan neobsahuje bicykle, vyberte si iny stojan!");
            }
            else
                System.out.println("Index stojanu je mimo platneho rozsahu!");
        }
    }
}
