
/**
 * Write a description of class Bicykel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bicykel {
    private Farba farba;
    private int cisloBicykla;
    private boolean maNakupnyKosik;
    public Bicykel(Farba farba, int cisloBicykla, boolean maNakupnyKosik) {
        this.farba = farba;
        this.cisloBicykla = cisloBicykla;
        this.maNakupnyKosik = maNakupnyKosik;
    }
    
    public void setInfoMaNakupnyKosik(boolean novaHodnota) {
        this.maNakupnyKosik = novaHodnota;
    }
    
    public Farba getFarba() {
        return this.farba;
    }
    
    public int getCisloBicykla() {
        return this.cisloBicykla;
    }
    
    public boolean getInfoMaNakupnyKosik() {
        return this.maNakupnyKosik;
    }
    
    public String toString() {
        return String.format("farba %s cislo bicykla %d ma nakupny kosik %s", this.farba, this.cisloBicykla, this.maNakupnyKosik);
    }
}
