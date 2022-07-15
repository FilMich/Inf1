public class Skrinka {
    private boolean otvorena;

    public Skrinka() {
        this.otvorena = true;
    }
    
    public boolean jeOtvorena() {
        return this.otvorena;
    }
    
    public void otvor() {
        this.otvorena = true;
    }
    
    public void zavri() {
        this.otvorena = false;
    }
}
