public class Bicykel {
    private Farba aFarba;
    private int aCisloBicykla;
    private boolean aMaNakupnyKosik;
    
    public Bicykel(Farba paFarba, int paCisloBicykla, boolean paMaNakupnyKosik) {
        this.aFarba = paFarba;
        this.aCisloBicykla = paCisloBicykla;
        this.aMaNakupnyKosik = paMaNakupnyKosik;
    }
    
    public Farba getFarba() {
        return this.aFarba;
    }
    
    public int getCisloBicykla() {
        return this.aCisloBicykla;
    }
    
    public void setInfoMaNakupnyKosik(boolean paNovaHodnota) {
        this.aMaNakupnyKosik = paNovaHodnota;
    }
    
    public boolean getInfoMaNakupnyKosik() {
        return this.aMaNakupnyKosik;
    }

    public String toString() {
        return "Bicykel " + this.aCisloBicykla + " - farba: " + this.aFarba + ", nakupny kosik: " + this.aMaNakupnyKosik;
    }
}
