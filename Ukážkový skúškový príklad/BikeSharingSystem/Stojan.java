import java.util.ArrayList;
public class Stojan {
    private Bicykel[] stojan;
    
    public Stojan(int paKapacita) {
        this.stojan = new Bicykel[paKapacita];
    }
    
    public int getKapacita() {
        return stojan.length;
    }
    
    public int getAktualnyPocetBicyklov() {
        int p = 0;
        for (Bicykel b: this.stojan) {
            if (b != null) {
                p++;
            }
        }
        return p;
    }
    
    public boolean existujeVolneMiesto() {
        if (stojan.length > this.getAktualnyPocetBicyklov()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Bicykel uvolniBicykel() {
        Bicykel b = this.stojan[this.getAktualnyPocetBicyklov() - 1];
        this.stojan[this.getAktualnyPocetBicyklov() - 1] = null;
        return b;
    }
    
    public boolean pridajBicykel(Bicykel paBicykel) {
        if (this.existujeVolneMiesto() == true) {
            this.stojan[this.getAktualnyPocetBicyklov()] = paBicykel;
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<Bicykel> getZotnamBicyklov() {
        ArrayList<Bicykel> zoznamBicyklov = new ArrayList<Bicykel>();
        for (Bicykel b: this.stojan) {
            if (b != null) {
                zoznamBicyklov.add(b);
            }
        }
        return zoznamBicyklov;
    }
}
