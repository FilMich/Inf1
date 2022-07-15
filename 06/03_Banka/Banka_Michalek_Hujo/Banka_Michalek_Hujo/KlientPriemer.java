
public class KlientPriemer {
    private Klient klient;
    private int priemer;
    
    public KlientPriemer(Klient klient, int priemer) {
        this.klient = klient;
        this.priemer = priemer;
    }
    
    public Klient getKlient() {
        return this.klient;
    }
    
    public int getPriemer() {
        return this.priemer;
    }
    
    public void setPriemer(int priemer) {
        this.priemer = priemer;
    }
}
