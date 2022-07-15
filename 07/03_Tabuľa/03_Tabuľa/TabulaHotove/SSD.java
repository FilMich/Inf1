public class SSD {
    private Segment[] aSegmenty; // pole 7 segmentov

    public SSD(int paLHX, int paLHY) {
        // Vytvorenie pola segmentov
        this.aSegmenty = new Segment[7];
        
        // Vytvorenie jednotlivych segmentov
        this.aSegmenty[0] = new Segment(50, 15, 15+paLHX, paLHY);
        this.aSegmenty[1] = new Segment(15, 50, 65+paLHX, 15+paLHY);
        this.aSegmenty[2] = new Segment(15, 50, 65+paLHX, 80+paLHY);
        this.aSegmenty[3] = new Segment(50, 15, 15+paLHX, 100+30+paLHY);
        this.aSegmenty[4] = new Segment(15, 50, paLHX, 80+paLHY);
        this.aSegmenty[5] = new Segment(15, 50, paLHX, 15+paLHY);
        this.aSegmenty[6] = new Segment(50, 15, 15+paLHX, 65+paLHY);
    }

    private void zobraz0() {
        for(int i = 0; i < 6; i++)
            this.aSegmenty[i].rozsviet();
        this.aSegmenty[6].zhasni();
    }
    
    private void zobraz1() {
        this.zhasniVsetko();
        this.aSegmenty[1].rozsviet();
        this.aSegmenty[2].rozsviet();
    }

    private void zobraz2() {
        this.rozsvietVsetko();
        this.aSegmenty[2].zhasni();
        this.aSegmenty[5].zhasni();
    }

    private void zobraz3() {
        this.rozsvietVsetko();
        this.aSegmenty[4].zhasni();
        this.aSegmenty[5].zhasni();
    }

    private void zobraz4() {
        this.rozsvietVsetko();
        this.aSegmenty[0].zhasni();
        this.aSegmenty[3].zhasni();
        this.aSegmenty[4].zhasni();
    }
    
    private void zobraz5() {
        this.rozsvietVsetko();
        this.aSegmenty[1].zhasni();
        this.aSegmenty[4].zhasni();
    }

    private void zobraz6() {
        this.rozsvietVsetko();
        this.aSegmenty[1].zhasni();
    }

    private void zobraz7() {
        for(int i = 0; i < 3; i++)
            this.aSegmenty[i].rozsviet();
        
        for(int i = 3; i < this.aSegmenty.length; i++)
            this.aSegmenty[i].zhasni();
    }   

    private void zobraz8() {
        this.rozsvietVsetko();
    }

    private void zobraz9() {
        this.rozsvietVsetko();
        this.aSegmenty[4].zhasni();
    }

    private void zobrazA() {
        this.rozsvietVsetko();
        this.aSegmenty[3].zhasni();
    }
    
    private void zobrazB() {
        this.rozsvietVsetko();
        this.aSegmenty[0].zhasni();
        this.aSegmenty[1].zhasni();
    }
    
    private void zobrazC() {
        this.zhasniVsetko();
        this.aSegmenty[3].rozsviet();
        this.aSegmenty[4].rozsviet();
        this.aSegmenty[6].rozsviet();
    }
    
    private void zobrazD() {
        this.rozsvietVsetko();
        this.aSegmenty[0].zhasni();
        this.aSegmenty[5].zhasni();
    }
    
    private void zobrazE() {
        this.rozsvietVsetko();
        this.aSegmenty[1].zhasni();
        this.aSegmenty[2].zhasni();
    }
    
    private void zobrazF() {
        this.rozsvietVsetko();
        this.aSegmenty[1].zhasni();
        this.aSegmenty[2].zhasni();
        this.aSegmenty[3].zhasni();
    }
    
    public void zobraz(int paCislo) {
        switch (paCislo) {
            case 0: this.zobraz0();
                    break;
            case 1: this.zobraz1();
                    break;
            case 2: this.zobraz2();
                    break;
            case 3: this.zobraz3();
                    break;
            case 4: this.zobraz4();
                    break;
            case 5: this.zobraz5();
                    break;
            case 6: this.zobraz6();
                    break;
            case 7: this.zobraz7();
                    break;
            case 8: this.zobraz8();
                    break;
            case 9: this.zobraz9();
                    break;
            case 10: this.zobrazA();
                     break;
            case 11: this.zobrazB();
                     break;                    
            case 12: this.zobrazC();
                     break;
            case 13: this.zobrazD();
                     break;                     
            case 14: this.zobrazE();
                     break;
            case 15: this.zobrazF();
                     break;                    
            default: zhasniVsetko();       
        }
    }  
    
    public void rozsvietVsetko() {
        for(int i = 0; i < this.aSegmenty.length; i++)
            this.aSegmenty[i].rozsviet();
    }

    public void zhasniVsetko() {
        for(int i = 0; i < this.aSegmenty.length; i++)
            this.aSegmenty[i].zhasni();
    }
}
