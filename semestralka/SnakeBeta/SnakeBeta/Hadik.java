import java.util.ArrayList;

public class Hadik {
    private ArrayList<Blok> telo;
    private Obrazok obrazok;
    private Blok blok;
    public Hadik(int zaciatokX, int zaciatokY) {
        this.telo = new ArrayList<Blok>();
        this.telo.add(new Blok(zaciatokX, zaciatokY, "hlava"));
        this.telo.add(new Blok(zaciatokX, zaciatokY + 20, "telo"));
    }
    
    public ArrayList<Blok> getTelo() {
        return this.telo;
    }
    
    public void zvacsiSa() {
        int poslednyX = this.telo.get(this.telo.size() - 1).getX();
        int poslednyY = this.telo.get(this.telo.size() - 1).getY();
        int predPoslednyX = this.telo.get(this.telo.size() - 2).getX();
        int predPoslednyY = this.telo.get(this.telo.size() - 2).getY();
        this.telo.add(new Blok(poslednyX + poslednyX - predPoslednyX, poslednyY + poslednyY - predPoslednyY , "telo"));
        this.nakresli();
    }
    
    public void nakresli() {
        for (Blok b: this.telo) {
            b.getObrazok().zobraz();
        }
    }
    
    
    public void pusunHada(Smer smer) {
        for (int i = 0; i < this.telo.size(); i++) {
            
        }
    }
}
