import java.util.ArrayList;
/**
 * Write a description of class Stojan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stojan {
    private Bicykel[] stojan;
    public Stojan(int kapacita) {
        this.stojan = new Bicykel[kapacita];
    }
    
    public int getKapacita() {
        return this.stojan.length;
    }
    
    public int getAktualnyPocetBicyklov() {
        int pocet = 0;
        for (Bicykel b: this.stojan) {
            pocet++;
        }
        return pocet;
    }
    
    public boolean existujeVolneMiesto() {
        if (this.getAktualnyPocetBicyklov() < this.getKapacita()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Bicykel uvolniBicykel() {
        Bicykel bicykel = this.stojan[this.getAktualnyPocetBicyklov() - 1];
        this.stojan[this.getAktualnyPocetBicyklov() - 1] = null;
        return bicykel;
    }
    
    public boolean pridajBicykel(Bicykel bicykel) {
        if (this.existujeVolneMiesto()) {
            this.stojan[this.getAktualnyPocetBicyklov()] = bicykel;
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<Bicykel> getZoznamBicyklov() {
        ArrayList<Bicykel> zoznamBicyklov = new ArrayList<Bicykel>();
        for (Bicykel b: this.stojan) {
            zoznamBicyklov.add(b);
        }
        return zoznamBicyklov;
    }
}
