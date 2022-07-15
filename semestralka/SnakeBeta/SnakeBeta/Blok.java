public class Blok {
    private int suradnicaX;
    private int suradnicaY;
    private String typBloku;
    private Obrazok obrazok;
    
    public Blok(int suradnicaX, int suradnicaY, String typBloku) {
        this.suradnicaX = suradnicaX;
        this.suradnicaY = suradnicaY;
        this.typBloku = typBloku;
        if (typBloku.equals("jedlo")) {
            this.obrazok = new Obrazok("pics\\jablko.png");
        } else {
            this.obrazok = new Obrazok("pics\\stvorec.png");
        }
        this.obrazok.zmenPolohu(this.suradnicaX, this.suradnicaY);
    }
    
    public Obrazok getObrazok() {
        return this.obrazok;
    }
    
    public int getX() {
        return this.suradnicaX;
    }
    
    public int getY() {
        return this.suradnicaY;
    }
    
    public String getTyp() {
        return this.typBloku;
    }
    
    public void setX(int x) {
        this.suradnicaX = x;
    }
    
    public void setY(int y) {
        this.suradnicaY = y;
    }
    
    public void nakresli() {
        this.obrazok.zobraz();
    }
}
