/**
 * Trieda Blok, reprezentuje blok hada alebo jedla, ktory moze byt vykresleny na platno.
 * 
 * @author Filip Michalek
 * 
 * @version 1.0
 */
public class Blok {
    private int suradnicaX;
    private int suradnicaY;
    private String typBloku;
    private Obrazok obrazok;
    private int polohaX;
    private int polohaY;
    /**
     * Parametricky konstruktor vytvori Blok a na pozicii suradnicaX, suradnicaY vytvorí nový Obrazok
     * 
     * @param suradnicaX je suradnica x obrázka
     * @param suradnicaY je suradnica y obrázka
     * @param typBloku určuje aký typ bloku sa má nakresliť
     * @param polohaX je index x obrázka v mriežke dvojrozmerného poľa
     * @param polohaY je index y obrázka v mriežke dvojrozmerného poľa
     */
    public Blok(int suradnicaX, int suradnicaY, String typBloku, int polohaX, int polohaY) {
        this.suradnicaX = suradnicaX;
        this.suradnicaY = suradnicaY;
        this.polohaX = polohaX;
        this.polohaY = polohaY;
        this.typBloku = typBloku;
        if (typBloku.equals("jedlo")) {
            this.obrazok = new Obrazok("pics\\jablko.png");
        } else {
            this.obrazok = new Obrazok("pics\\stvorec.png");
        }
        this.obrazok.zmenPolohu(this.suradnicaX, this.suradnicaY);
        this.nakresli();
    }
    /**
     * Metoda getObrazok vrati Obrazok
     */
    public Obrazok getObrazok() {
        return this.obrazok;
    }
    /**
     * Metoda getX vrati suradnicu bloku x
     */
    public int getX() {
        return this.suradnicaX;
    }
    /**
     * Metoda getY vrati suradnicu bloku y
     */
    public int getY() {
        return this.suradnicaY;
    }
    /**
     * Metoda getPolohuX vrati index bloku x
     */
    public int getPolohuX() {
        return this.polohaX;
    }
    /**
     * Metoda getPolohuY vrati index bloku y
     */
    public int getPolohuY() {
        return this.polohaY;
    }
    /**
     * Metoda setX nastavi suradnicu bloku x podla parametra x
     * @param x je pozadovana poloha ktoru chceme blok umiestnit
     */
    public void setX(int x) {
        this.suradnicaX = x;
    }
    /**
     * Metoda setY nastavi suradnicu bloku y podla parametra y
     * @param y je pozadovana poloha ktoru chceme blok umiestnit
     */
    public void setY(int y) {
        this.suradnicaY = y;
    }
    /**
     * Metoda setPolohuX nastavi index bloku polohaX podla parametra x
     * @param x je pozadovany index na ktory chceme blok umiestnit
     */
    public void setPolohuX(int x) {
        this.polohaX = x;
    }
    /**
     * Metoda setPolohuY nastavi index bloku polohaY podla parametra y
     * @param y je pozadovany index na ktory chceme blok umiestnit
     */
    public void setPolohuY(int y) {
        this.polohaY = y;
    }
    /**
     * Metoda nakresli nakresli obrazok
     */
    public void nakresli() {
        this.obrazok.zobraz();
    }
    /**
     * Metoda zmaz zmaze obrazok
     */
    public void zmaz() {
        this.obrazok.zmaz();
    }
}
