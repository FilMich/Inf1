import java.util.ArrayList;

public class Klient{
    private String aMeno;
    private String aPriezvisko;
    private ArrayList<BankovyUcet> mojeUcty;

    public Klient(){
        this.aMeno = "Marek";
        this.aPriezvisko = "Kvet";
        this.mojeUcty = new ArrayList<BankovyUcet>();
    }

    public String getMeno() {
        return this.aMeno;
    }

    public String getPriezvisko() {
        return this.aPriezvisko;
    }

    public String toString() {
        return this.aMeno + " " + this.aPriezvisko;
    }

    public void setMeno(String noveMeno) {
        if (!noveMeno.equals(""))
            this.aMeno = noveMeno;
        else
            this.aMeno = "Nezname meno";
    }

    public void setPriezvisko(String novePriezvisko) {
        if (!novePriezvisko.equals(""))
            this.aPriezvisko = novePriezvisko;
        else
            this.aPriezvisko = "Nezname priezvisko";
    }

    public void zriadSiUcetVbanke(Banka b) {
        if(b!=null){
            BankovyUcet vytvorenyUcet = b.vytvorNovyUcet(this);
            this.mojeUcty.add(vytvorenyUcet);
            System.out.println("Bol vytvoreny ucet s cislom " + vytvorenyUcet.getCisloUctu());
        }
    }

    private BankovyUcet najdiUcet(String paCisloUctu) {
        if (this.mojeUcty == null){
            System.out.println("Klient nema ziadne ucty!");    
            return null;
        }
        else{
            BankovyUcet hladanyUcet = null;
            for(BankovyUcet u: this.mojeUcty){
                if (u.getCisloUctu().equals(paCisloUctu)){
                    hladanyUcet = u;
                    break;
                }
            }

            if (hladanyUcet == null)
                System.out.println("Nenasiel sa ucet s cislom " + paCisloUctu);
            return hladanyUcet;
        }
    }

    public void vypisStavUctu(String paCisloUctu) {
        BankovyUcet hladanyUcet = this.najdiUcet(paCisloUctu);
        if(hladanyUcet != null)
            System.out.println("stav uctu" + paCisloUctu + hladanyUcet.getZostatok());
    }

    public void vypisMajetokKlienta() {
        if (this.mojeUcty == null)
            System.out.println("nema ziadny ucet");          
        else{
            int celkovyMajetok = 0;
            for(BankovyUcet u: this.mojeUcty){
                celkovyMajetok += u.getZostatok();
                this.vypisStavUctu(u.getCisloUctu());
            }
            System.out.println(" majetok klienta: " + celkovyMajetok);
        }
    }

    public void vlozNaUcet(String cu, int s) {
        // Doplnit!
    }

    public void vyberZUctu(String cu, int s, String pin) {
        // Doplnit!
    }

    public void vytlacVypisUctu(String cu) {
        // Doplnit!
    }

    public void prevedZuctuNaUcet(String odkial, String kam, int sum, String pin) {
        // Doplnit!
    }

    public void zistiPINkodSvojhoUctu(String cu) {
        // Doplnit!
    }

    public void zmenPINkodSvojhoUctu(String cu, String stary, String novy) {
        // Doplnit!
    }
}
