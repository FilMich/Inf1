public class Tetromino {

    private boolean[][] tvar;
    private int poziciaX;
    private int poziciaY;
    private Farba farba;

    public Tetromino(boolean[][] tvar, Farba farba) {
        this.tvar = tvar;
        this.poziciaY = 0;
        this.poziciaX = 5 - (tvar[0].length / 2);
        this.farba = farba;
    }
    
    public int getPoziciaX() {
        return this.poziciaX;
    }
    
    public int getPoziciaY() {
        return this.poziciaY;
    }
    
    public int getSirka() {
        return this.tvar[0].length;
    }
    
    public int getVyska() {
        return this.tvar.length;
    }
    
    public Farba getFarba() {
        return this.farba;
    }
    
    public boolean jeKocka(int x, int y) {
        return x >= 0 && x < this.getSirka()
            && y >= 0 && y < this.getVyska()
            && this.tvar[y][x];
    }


    public void posunVpravo(Kopa kopa) {
        this.skry();
        if (this.poziciaX < 10 - this.getSirka()) {
            this.poziciaX++;
            if (kopa.koliduje(this)) {
                this.poziciaX--;
            }
        }
        this.zobraz();
    }

    public void posunVlavo(Kopa kopa) {
        this.skry();
        if (this.poziciaX > 0) {
            this.poziciaX--;
            if (kopa.koliduje(this)) {
                this.poziciaX++;
            }
        }
        this.zobraz();
    }

    public boolean posunDole(Kopa kopa) {
        this.skry();
        if (this.poziciaY < 20 - this.getVyska()) {
            this.poziciaY++;
            if (kopa.koliduje(this)) {
                this.poziciaY--;
                this.zobraz();
                return false;
            }
            this.zobraz();
            return true;
        }
        this.zobraz();
        return false;
    }

    public void otoc(Kopa kopa) {
        boolean[][] novyTvar = new boolean[this.getSirka()][this.getVyska()];

        for (int y = 0; y < this.getVyska(); y++) {
            for (int x = 0; x < this.getSirka(); x++) {
                novyTvar[x][novyTvar[0].length - 1 - y] = this.tvar[y][x];
            }
        }

        this.skry();
        
        boolean[][] staryTvar = this.tvar;
        if (novyTvar[0].length + this.poziciaX <= 10 && novyTvar.length + this.poziciaY <= 20) {
            this.tvar = novyTvar;
        }
        
        if (kopa != null && kopa.koliduje(this)) {
            this.tvar = staryTvar;
        }
        
        this.zobraz();
    }

    public void zobraz() {
        for (int y = 0; y < this.getVyska(); y++) {
            for (int x = 0; x < this.getSirka(); x++) {
                if (tvar[y][x]) {
                    Displej.getInstancia().zmenPolicko(
                        x + this.poziciaX, 
                        y + this.poziciaY, 
                        this.farba//tvar[y][x]
                    );
                }
            }
        }
    }

    public void skry() {
        for (int y = 0; y < this.getVyska(); y++) {
            for (int x = 0; x < this.getSirka(); x++) {
                if (tvar[y][x]) {
                    Displej.getInstancia().zmenPolicko(
                        x + this.poziciaX, 
                        y + this.poziciaY, 
                        null//false
                    );
                }
            }
        }
    }
}
