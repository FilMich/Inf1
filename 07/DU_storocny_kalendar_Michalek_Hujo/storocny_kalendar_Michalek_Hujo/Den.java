public class Den {
    private int cDna;
    public Den(int rok, int mesiac) {
        int dni = 0;
        for(int i = 1900; i < rok; i++) {
            if((i % 4 == 0) && ((i % 100 != 0) || (i % 400 == 0))) {
                dni += 366;
            } else {
                dni += 365;
            }   
        }
        int den = dni-((dni / 7)*7);
        dni = 0;
        for(int i = 1; i < mesiac; i++) {
            if(i<=7 && i % 2 == 1) {
                dni += 31;
            } else if(i<=7 && i % 2 == 0 && i != 2) {
                dni += 30;
            } else if(i>=8 && i % 2 == 1) {
                dni += 30;
            } else if(i>=8 && i % 2 == 0) {
                dni += 31;
            } else if(i == 2) {
                dni += 28;
            }
        }
        dni += den;
        den = dni-((dni / 7)*7);
        this.cDna = den;
    }
    
    public int getDen() {
        return this.cDna;
    }
    
    public void setDen() {
        this.cDna++;
        this.cDna = this.cDna % 8; 
    }
}
