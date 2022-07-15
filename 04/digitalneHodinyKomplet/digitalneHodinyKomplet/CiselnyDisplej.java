/**
 * Trieda reprezentujuca jeden ciselny displej v digitalnych hodinach.
 * Stara sa o zmenu hodnoty v zadanych hraniciach a o formatovanie
 * cisla do tvaru dvojcifernej hodnoty.
 */
public class CiselnyDisplej {
    private int hornaHranica;
    private int hodnota;
    private SSD aLavySegment;
    private SSD aPravySegment;
    
    private int povodnaHornaHranica;
       
    /**
     * Inicializuje ciselny displej na hodnotu 0. Horna hranica sa pouzije
     * ta, co zada pouzivatel v parametri.
     * @param pthis.hornaHranica Predstavuje cislo, ktore hodnota ciselneho
     * displeja nemoze dosiahnut.
     */
    public CiselnyDisplej(int hornaHranica, int surX, int surY) {
        this.hornaHranica = hornaHranica;
        this.povodnaHornaHranica = hornaHranica;
        this.hodnota = 0;
        
        this.aLavySegment = new SSD(surX, surY);
        this.aPravySegment = new SSD(surX + 110, surY);
    }
        
    public void zobraz() {
        this.aLavySegment.zobraz(this.hodnota / 10);
        this.aPravySegment.zobraz(this.hodnota % 10);
    }    
        
    public int getHodnota() {
        return this.hodnota;
    }
    
    public void setHodnota(int hodnota) {
        if ((hodnota >= 0) && (hodnota < this.hornaHranica)) 
            this.hodnota = hodnota;
    }
    
    public String getHodnotaAkoRetazec() {
        if (this.hodnota < 10) {
            return "0" + this.hodnota;
        } else {
            return "" + this.hodnota;
        }
    }
            
    /**
     * Zvacsi hodnotu na ciselnom displeji o hodnotu jedna. Ak dosiahne hornu
     * hranicu, pokracuje znovu od nuly.
     */
    public void krok() {
        this.hodnota = (this.hodnota + 1) % this.hornaHranica;
        if (this.hodnota == 0)
            this.hornaHranica = this.povodnaHornaHranica;
    }
    
    public void priestupnaHodnota() {
        this.hornaHranica = this.hornaHranica + 1;
    }
}
