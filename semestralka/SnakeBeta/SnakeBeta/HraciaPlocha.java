public class HraciaPlocha {
    private Suradnice[][] suradnice;
    private Obrazok pozadie;
    private int pocetX;
    private int pocetY;
    public HraciaPlocha() {
        this.pozadie = new Obrazok("pics\\pozadie.png");
        this.pozadie.zmenPolohu(0, 0);
        this.pozadie.zobraz();
        this.pocetX = 20;
        this.pocetY = 20;
        this.suradnice = new Suradnice[this.pocetY][this.pocetX];
        for (int y = 0; y < this.pocetY; y++) {
            for (int x = 0; x < this.pocetX; x++) {
                this.suradnice[y][x] = new Suradnice(20 * x + 10, 20 * y + 10);
            }
        }
    }
    
    public Suradnice[][] getSuradnice() {
        return this.suradnice;
    }
}
