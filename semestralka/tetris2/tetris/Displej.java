public class Displej {

    public static final int SIRKA = 10;
    public static final int VYSKA = 20;
    
    private static Displej instancia;
    private PixelovyDisplej displej;

    private Displej() {
        this.displej = new PixelovyDisplej(1,1, Displej.SIRKA, Displej.VYSKA, 20);
    }

    public static Displej getInstancia() {
        if (Displej.instancia == null) {
            Displej.instancia = new Displej();
        }
        return Displej.instancia;
    }
    
    //public void zmenPolicko(int x, int y, boolean stav) {
    public void zmenPolicko(int x, int y, Farba farba) {
        this.displej.zmenPolicko(x, y, farba);
        
        //this.policka[y][x].zmenFarbu(stav ? "yellow" : "black");
    }
}
