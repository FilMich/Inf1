import java.util.ArrayList;

public class Stojan {
    private Bicykel[] aPoleBicyklov;

    public Stojan(int paKapacita) {
        if (paKapacita > 0)
            this.aPoleBicyklov = new Bicykel[paKapacita];
        else 
            this.aPoleBicyklov = new Bicykel[5];

        for(int i = 0; i < this.aPoleBicyklov.length; i++)
            this.aPoleBicyklov[i] = null;
    }

    public int getKapacita() {
        return this.aPoleBicyklov.length;
    }

    public int getAktualnyPocetBicyklov() {
        int vysledok = 0;
        for(int i = 0; i < this.aPoleBicyklov.length; i++)
            if (this.aPoleBicyklov[i] != null)
                vysledok++;
        return vysledok;
    }

    public boolean existujeVolneMiesto() {
        for(int i = 0; i < this.aPoleBicyklov.length; i++)
            if (this.aPoleBicyklov[i] == null)
                return true;
        return false;
    }

    public Bicykel uvolniBicykel() {
        Bicykel bike = null;
        for(int i = 0; i < this.aPoleBicyklov.length; i++)
            if (this.aPoleBicyklov[i] != null) {
                bike = this.aPoleBicyklov[i];
                this.aPoleBicyklov[i] = null;
                break;
            }
        return bike;
    }

    public boolean pridajBicykel(Bicykel paBicykel) {
        for(int i = 0; i < this.aPoleBicyklov.length; i++)
            if (this.aPoleBicyklov[i] == null) {
                this.aPoleBicyklov[i] = paBicykel;
                return true;
            }
        return false;
    }

    public ArrayList<Bicykel> getZoznamBicyklov() {
        ArrayList<Bicykel> zoznam = new ArrayList<Bicykel>();
        for(int i = 0; i < this.aPoleBicyklov.length; i++)
            if (this.aPoleBicyklov[i] != null) 
                zoznam.add(this.aPoleBicyklov[i]);
        return zoznam;
    }
}
