public class Ovladanie {
    private Hadik hadik;
    private int smerOtocenia;
    public Ovladanie() {
        this.smerOtocenia = 0;
        this.hadik = new Hadik(200, 200);
    }
        
    public void posunVpravo() {
        this.smerOtocenia = 1;
    }
    
    public void posunVlavo() {
        this.smerOtocenia = -1;
    }
    
    public int getSmerOtocenia() {
        return this.smerOtocenia;
    }
    
    public void setSmerOtocenia() {
        this.smerOtocenia = 0;
    }
    
}
