public class Kopa {

    //private boolean[][] kocky;
    private Farba[][] kocky;

    public Kopa() {
        this.kocky = new Farba[Displej.VYSKA][Displej.SIRKA];
    }

    public void pohlt(Tetromino tetromino) {
        for (int x = 0; x < tetromino.getSirka(); x++) {
            for (int y = 0; y < tetromino.getVyska(); y++) {
                if (tetromino.jeKocka(x, y)) {
                    this.kocky[tetromino.getPoziciaY()+y][tetromino.getPoziciaX()+x] = tetromino.getFarba();
                }
            } 
        }
        
        this.skontrolujRiadky();
    }

    public boolean koliduje(Tetromino tetromino) {
        for (int x = 0; x < tetromino.getSirka(); x++) {
            for (int y = 0; y < tetromino.getVyska(); y++) {
                if (tetromino.jeKocka(x, y) && this.kocky[tetromino.getPoziciaY()+y][tetromino.getPoziciaX()+x] != null) {
                    return true;
                }
            } 
        }
        return false;
    }
    
    
    private void skontrolujRiadky() {
        for (int y = Displej.VYSKA - 1; y >= 0; y--) {
            int sum = 0;
            for (int x = 0; x < Displej.SIRKA; x++) {
                if (this.kocky[y][x] != null) {
                    sum++;
                }
            }
            
            if (sum == Displej.SIRKA) {
                for (int i = y; i > 0; i--) {
                    for (int x = 0; x < Displej.SIRKA; x++) {
                        this.kocky[i][x] = this.kocky[i-1][x];
                    }
                }
                
                //Musime znova skontrolovať riadok ktorý sme posunuli dole.
                y++;
            }
            
            //Aktualizacia kociek na displeju
            for (int x = 0; x < Displej.SIRKA; x++) {
                Displej.getInstancia().zmenPolicko(x, y, this.kocky[y][x]);
            }
        }
    }
    
    public void reset() {
        for (int y = Displej.VYSKA - 1; y >= 0; y--) {
            for (int x = 0; x < Displej.SIRKA; x++) {
                this.kocky[y][x] = null;
                Displej.getInstancia().zmenPolicko(x, y, this.kocky[y][x]);
            }
        }
    }
}
