import java.util.ArrayList;
import java.util.Random;

public class Banka {
    private String aNazovBanky;
    private ArrayList<BankovyUcet> zoznamUctov;

    public Banka() {
        this.setNazovBanky("FRI banka");
        this.zoznamUctov = new ArrayList<BankovyUcet>();
    }    

    public int getCelkovaSuma() {
        if (this.zoznamUctov == null) {
            return 0;
        } else {
            int celkovaSuma = 0;
            for (BankovyUcet bu: this.zoznamUctov) { 
                celkovaSuma += bu.getZostatok();
            }
            return celkovaSuma;
        }
    }

    public String getNazovBanky() {
        return this.aNazovBanky;
    }

    public ArrayList<BankovyUcet> vratZoznamUctov() {
        return this.zoznamUctov;
    }    

    public void setNazovBanky(String novyNazov) {
        if (!novyNazov.equals("")) {
            this.aNazovBanky = novyNazov;
        } else {
            this.aNazovBanky = "Neznama banka";
        }
    }

    public BankovyUcet vytvorNovyUcet(Klient paKlient) {
        // Vygenerivanie noveho IBAN cisla uctu
        String noveCislo = "SK";
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            noveCislo += generator.nextInt(10);
        }
            // Metoda nextInt(10) vygeneruje nahodne cele cislo z intervalu <0, 10), teda 0-9

        // Zalozenie noveho uctu a pridanie do zoznamu uctov danej banky    
        // Tu sa pouzitie anonymneho objektu nehodi, nakolko ucet musim vratit cey return
        BankovyUcet novy = new BankovyUcet(noveCislo, this, paKlient);
        this.zoznamUctov.add(novy);
        return novy;
    }

    public void vypisCislaVsetkychUctov() {
        if (this.zoznamUctov.isEmpty()) {
            System.out.println("Banka nema ziadny ucet!");
        } else {
            for(BankovyUcet bu: this.zoznamUctov) {
                System.out.println(bu.getCisloUctu());
            }
        }       
    }

    public void vypisZoznamKlientovBezDuplicit() {
        if (zoznamUctov != null){

            // Vo vypise klientov chceme potlacit duplicity
            ArrayList<Klient> zoznamKlientov = new ArrayList<Klient>();
            Klient k;
            for(BankovyUcet bu: this.zoznamUctov){
                k = bu.getKlient();
                if (k != null){
                    if (!zoznamKlientov.contains(k))
                        zoznamKlientov.add(k);
                }
            }

            // Vypis zoznamu klientov
            if (zoznamKlientov.isEmpty())
                System.out.println("Banka nema ziadneho klienta!");
            else{
                System.out.println("Zoznam klientov:");
                for(Klient kl: zoznamKlientov){
                    System.out.println(kl);
                }
            }
        }
        else
            System.out.println("Zoznam uctov neexistuje!");
    }
    
    public void zrusenieUctu(Klient klient, String cisloUctu) {
        int index = -1;
        for(BankovyUcet bu: this.zoznamUctov) {
            if(cisloUctu.equals(bu.getCisloUctu())) {
                index = this.zoznamUctov.indexOf(bu);
            }
        }
        if(index >= 0){
            if(this.zoznamUctov.get(index).getKlient() == klient) {
                this.zoznamUctov.remove(index);
                klient.zmazUcet(cisloUctu);
                System.out.format("Ucet cislo %s bol zmazany \n", cisloUctu);
            }
        }   
    }
    
    public void vypisNajbohatsieho() {
        ArrayList<KlientZostatok> klientZostatok = new ArrayList<KlientZostatok>();
        for(BankovyUcet bu: this.zoznamUctov) {
            if(klientZostatok.size() == 0) {
                klientZostatok.add(new KlientZostatok (bu.getKlient(), bu.getZostatok()));
            } else {
                for(KlientZostatok kz: klientZostatok) {
                    if(bu.getKlient() == kz.getKlient()) {
                        kz.setZostatok(bu.getZostatok());
                    }
                }
            }
        }
        
        int max = 0;
        for(KlientZostatok kz: klientZostatok) {
            if(max < kz.getZostatok()) {
                max = kz.getZostatok();
            }
        }
        
        for(KlientZostatok kz: klientZostatok) {
            if(max == kz.getZostatok()) {
                System.out.format("Najbohatsi klient je %s %s \n", kz.getKlient().getMeno(), kz.getKlient().getPriezvisko());
            }
        }
    }
    
    public void manipulacia() {
        int max = 0;
        for(BankovyUcet bu: this.zoznamUctov) {
            if(max < bu.getPohybyNaUcte().size()) {
                max = bu.getPohybyNaUcte().size();
            }
        }
        
        for(BankovyUcet bu: this.zoznamUctov) {
            if(max == bu.getPohybyNaUcte().size()) {
                System.out.format("%s %s %s %d \n", bu.getKlient().getMeno(), bu.getKlient().getPriezvisko(),bu.getCisloUctu() ,bu.getPohybyNaUcte().size());
            }
        }
    }
    
    public void NajvyssiaPriemernaCiastka() {
        int max = 0;
        ArrayList<KlientPriemer> klientPriemer = new ArrayList<KlientPriemer>();
        for(BankovyUcet bu: this.zoznamUctov) {
            int svkladov = 0;
            int pvkladov = 0;
            for(Transakcia t: bu.getPohybyNaUcte()) {
                if(t.getTyp().equals("Vklad")) {
                    svkladov += t.getCiastka();
                    pvkladov++;
                }
            }
            klientPriemer.add(new KlientPriemer(bu.getKlient(), svkladov / pvkladov ));
        }
        
        for(KlientPriemer kp: klientPriemer) {
            if(max < kp.getPriemer()) {
                max = kp.getPriemer();
            }
        }
        
        for(KlientPriemer kp: klientPriemer) {
            if(max == kp.getPriemer()) {
                System.out.format("%s %s \n",kp.getKlient().getMeno(), kp.getKlient().getPriezvisko());
            }
        }
    }
}
