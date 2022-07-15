public class Mesiac {
    private int poradie;
    private int pdni;
    
    public Mesiac(int poradie) {
        if(poradie < 13 && poradie > 0) {
            this.poradie = poradie;
        } else {
            this.poradie = 1;
        }
        
        switch(poradie) {
            case 1: 
                this.pdni = 31;
                break;
            case 2:
                this.pdni = 28;
                break;
            case 3:
                this.pdni = 31;
                break;
            case 4:
                this.pdni = 30;
                break;
            case 5:
                this.pdni = 31;
                break;
            case 6:
                this.pdni = 30;
                break;
            case 7:
                this.pdni = 31;
                break;
            case 8:
                this.pdni = 31;
                break;
            case 9:    
                this.pdni = 30;
                break;
            case 10:
                this.pdni = 31;
                break;
            case 11:
                this.pdni = 30;
                break;
            case 12:
                this.pdni = 31;
                break;
        }
    }
    
    public int getPoradie() {
        return this.poradie;
    }
    
    public int getPdni() {
        return this.pdni;
    }
    
    public void setPdni() {
        this.pdni++; 
    }
}
