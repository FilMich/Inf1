public class Bicykel {
    private Farba paFarba;
    private int paCisloBicykla;
    private boolean paMaNakupnyKosik;
    
    public Bicykel(Farba paFarba, int paCisloBicykla, boolean paMaNakupnyKosik) {
        this.paFarba = paFarba;
        this.paCisloBicykla = 0;
        this.paMaNakupnyKosik = paMaNakupnyKosik;
    }
    
    public void setInfoMaNakupnyKosik(boolean paNovaHodnota) {
        this.paMaNakupnyKosik = paNovaHodnota;
    }
    
    public Farba getFarba(int index) {
        return this.paFarba;
    }
    
    public int  getCisloBicykla() {
        return this.paCisloBicykla;
    }
    
    public boolean getInfoMaNakupnyKosik() {
        return this.paMaNakupnyKosik;
    }
    
    
}
