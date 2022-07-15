import java.util.ArrayList;
import java.util.Random;

public class Banka{
    private String aNazovBanky;
    private ArrayList<BankovyUcet> zoznamUctov;

    public Banka(){
        this.setNazovBanky("Tatra banka");
        this.zoznamUctov = new ArrayList<BankovyUcet>();
    }    

    public int getCelkovaSuma(){
        if (this.zoznamUctov == null)
            return 0;
        else {
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
        if (!novyNazov.equals(""))
            this.aNazovBanky = novyNazov;
        else
            this.aNazovBanky = "Neznama banka";
    }

    public BankovyUcet vytvorNovyUcet(Klient paKlient) {
        String cisloUctu = "SK" ;
        Random generator = new Random();
        for(int i = 0; i < 10; i++)
            cisloUctu += generator.nextInt(10);
        BankovyUcet novy = new BankovyUcet(cisloUctu, this, paKlient);
        zoznamUctov.add(novy);
        return novy;
    }

    public void vypisCislaVsetkychUctov() {
        for(BankovyUcet bu: this.zoznamUctov)
            System.out.println(bu.getCisloUctu());
    }

    public void vypisZoznamKlientovBezDuplicit() {
        ArrayList<Klient> zoznamKlientov = new ArrayList<Klient>();
        for(BankovyUcet bu: this.zoznamUctov) {
            if(zoznamKlientov.contains(bu.getKlient())){
                continue;
                } else {
                    zoznamKlientov.add(bu.getKlient());
                }
            }
         for(Klient klient: zoznamKlientov)
            System.out.println(klient.toString());
    }
}
