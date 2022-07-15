public class Datum {
    private int aDen;
    private int aMesiac;
    private int aRok;

    public Datum(int paDen, int paMesiac, int paRok) {
        this.setRok(paRok);
        this.setMesiac(paMesiac);
        this.setDen(paDen);
    }

    public int getRok() {
        return this.aRok;    
    }  

    public int getMesiac() {
        return this.aMesiac;    
    }  

    public int getDen() {
        return this.aDen;    
    }  

    public void setRok(int paRok) {
        if (paRok >= 1900)
            this.aRok = paRok;
        else
            this.aRok = 1900;    
    }

    public void setMesiac(int paMesiac) {
        if ((paMesiac > 0) && (paMesiac < 13))
            this.aMesiac = paMesiac;
        else
            this.aMesiac = 1;    
    }   

    public void setDen(int paDen) {
        if (paDen < 1)
            this.aDen = 1;
        else {
            if (paDen <= this.getMaxPocetDniMesiaca())
                this.aDen = paDen; 
            else
                this.aDen = 1;
        }
    } 

    public boolean jePriestupnyRok() {
        return ((this.aRok % 4 == 0) && ((this.aRok % 100 != 0) || (this.aRok % 400 == 0)));
    }

    public int getMaxPocetDniMesiaca() {
        switch (this.aMesiac) {
            case 2: if (this.jePriestupnyRok())
                return 29;
            else
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public int getPocDniZacRok() {
        switch(this.aMesiac) { 
            case 1: return this.aDen;
            case 2: return 31 + this.aDen;
            case 3: if (this.jePriestupnyRok())
                return 31 + 29 + this.aDen;
            else
                return 31 + 28 + this.aDen;
            case 4: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + this.aDen;
            else
                return 31 + 28 + 31 + this.aDen;
            case 5: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + 30 + this.aDen;
            else
                return 31 + 28 + 31 + 30 + this.aDen;
            case 6: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + 30 + 31 + this.aDen;
            else
                return 31 + 28 + 31 + 30 + 31 + this.aDen; 
            case 7: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + 30 + 31 + 30 + this.aDen;
            else
                return 31 + 28 + 31 + 30 + 31 + 30 + this.aDen; 
            case 8: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + 30 + 31 + 30 + 31 + this.aDen;
            else
                return 31 + 28 + 31 + 30 + 31 + 30 + 31 + this.aDen;
            case 9: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + this.aDen;
            else
                return 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + this.aDen;
            case 10: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + this.aDen;
            else
                return 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + this.aDen;  
            case 11: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + this.aDen;
            else
                return 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + this.aDen;
            default: if (this.jePriestupnyRok())
                return 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + this.aDen;
            else
                return 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + this.aDen;             
        }
    }
    
    public void vypisNazovDna() {
        int dnes = (getPocDniZacRok() % 7);
        dnes = dnes + (this.aRok - 1900);
        for (int i = 1900; i < this.aRok; i++)
            if ((i % 4 == 0) && (i % 100 != 0) || (i % 400 == 0)) 
                 dnes++;
        dnes = dnes % 7;            

        System.out.print(this.aDen + "." + this.aMesiac + "." + this.aRok + " - dnes je ");

        switch (dnes) {
            case 1: System.out.println("pondelok");
            break;
            case 2: System.out.println("utorok");
            break;
            case 3: System.out.println("streda");
            break;
            case 4: System.out.println("štvrtok");
            break;
            case 5: System.out.println("piatok");
            break;
            case 6: System.out.println("sobota");
            break; 
            case 0: System.out.println("nedeľa");
        }
    }    
        
    public void vypisNazov(int poradieDna) {
        // NESPRAVNY POSTUP - takto to robia amateri :)
        
        if (poradieDna == 1)
            System.out.println("Pondelok");
        else if (poradieDna == 2)
            System.out.println("Utorok");
        else if (poradieDna == 3)
            System.out.println("Streda");
        else if (poradieDna == 4)
            System.out.println("Stvrtok");
        else if (poradieDna == 5)
            System.out.println("Piatok");            
        else if (poradieDna == 6)
            System.out.println("Sobota");
        else if (poradieDna == 7)
            System.out.println("Nedela"); 
        else
            System.out.println("Neexistujuci den");
            
        // LEPSI PRISTUP
        switch(poradieDna) {
            case 1: System.out.println("Pondelok");
                    break;
            case 2: System.out.println("Utorok");
                    break;
            case 3: System.out.println("Streda");
                    break;                    
            case 4: System.out.println("Stvrtok");
                    break; 
            case 5: System.out.println("Piatok");
                    break;  
            case 6: System.out.println("Sobota");
                    break; 
            case 7: System.out.println("Nedela");
                    break;
            default: System.out.println("Neexistujuci den");
                    // prikaz break tu byt nemusi, kedze vetva default sa pise na konci switchu.
        }
    }
    
    public boolean jePracovnyDen(int poradieDna) {
        switch(poradieDna) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: 
                return true;
            case 6:
            case 7:
                return false;
            
            // Co sa stane, ak vynecham vetvu default???    
                
            default: 
                return false; 
        }
    }
}
