public class KlientZostatok {
    private Klient klient;
    private int zostatok;
    
    public KlientZostatok(Klient klient, int zostatok) {
        this.klient = klient;
        this.zostatok = zostatok;
    }
    
    public Klient getKlient() {
        return this.klient;
    }
    
    public int getZostatok() {
        return this.zostatok;
    }
    
    public void setZostatok(int zostatok) {
        this.zostatok += zostatok;
    }
}
