public class Rok {
    private boolean priestupnyRok;
    private int roky;
    
    public Rok(int roky) {
        if(roky >= 1900 && roky <= 10000) {
            this.roky = roky;
        } else {
            this.roky = 1900;
        }
        if((this.roky % 4 == 0) && ((this.roky % 100 != 0) || (this.roky % 400 == 0))) {
            this.priestupnyRok = true;
        } else {
            this.priestupnyRok = false;
        }
    }
    
    public boolean getPriestupnyRok() {
        return this.priestupnyRok;
    }
    
    public int getRoky() {
        return this.roky;
    }
}
