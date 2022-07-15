import javax.swing.JOptionPane;


public class Tetris {
    
    private Tetromino padajuce;
    private Tetromino nasledujuce;
    private TovarenNaTetromina tovaren;
    private Kopa kopa;
    private PixelovyDisplej displejDalsie;
    private GrafickePocitadlo pocitadloSkore;

    
    public Tetris() {
        this.displejDalsie = new PixelovyDisplej(250, 1, 4, 4, 15);
        this.pocitadloSkore = new GrafickePocitadlo(250, 80, 4);
        this.tovaren = new TovarenNaTetromina();
        this.kopa = new Kopa();
        this.padajuce = this.tovaren.vyrobNahodne();
        this.nasledujuce = this.tovaren.vyrobNahodne();
        this.nasledujuce.skry();
        this.padajuce.zobraz();
        this.zobrazDalsie();
        this.pocitadloSkore.setHodnota(0);
    }
    
    public void spusti() {
        new Manazer().spravujObjekt(this);
    }
    
    public void posunDole() {
        this.padajuce.posunDole(this.kopa);
    }
    
    public void posunVpravo() {
        this.padajuce.posunVpravo(this.kopa);
    }
    
    public void posunVlavo() {
        this.padajuce.posunVlavo(this.kopa);
    }
    
    public void aktivuj() {
        this.padajuce.otoc(this.kopa);
    }
    
    public void tik() {
        if (!this.padajuce.posunDole(this.kopa)) {
            this.pocitadloSkore.zvys(9);
            this.kopa.pohlt(this.padajuce);
            this.padajuce = this.nasledujuce;
            this.nasledujuce = this.tovaren.vyrobNahodne();
            this.nasledujuce.skry(); //Aby sa nezobrazovalo na displeji
            this.padajuce.zobraz();
            this.zobrazDalsie();
            if (this.kopa.koliduje(this.padajuce)) {
                JOptionPane.showMessageDialog(null, "Koniec hry");
                this.kopa.reset();
                this.pocitadloSkore.setHodnota(0);
            }
        }
    }
    
    public void zrus() {
        //Ukonči aplikaciu
        System.exit(0);
    }
    
    private void zobrazDalsie() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                this.displejDalsie.zmenPolicko(x, y, this.nasledujuce.jeKocka(x, y) ? this.nasledujuce.getFarba() : null);
            }
        }
    }
}
