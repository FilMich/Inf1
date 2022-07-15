public class Tabula {
    private SSD[] aDispleje;   
    
    public Tabula(int paPocetDisplejov) {
        // Vytvorenie pola SSD displejov
        if (paPocetDisplejov < 1)
            this.aDispleje = new SSD[1];
        else
            this.aDispleje = new SSD[paPocetDisplejov];
            
        // Vytvorenie jednotlivych SSD displejov
        for(int i = 0; i < this.aDispleje.length; i++)
            this.aDispleje[i] = new SSD(20 + (110 * i), 20);
    }
    
    public void rozsvietVsetko() {
        for(int i = 0; i < this.aDispleje.length; i++)
            this.aDispleje[i].rozsvietVsetko();
    }
    
    public void zhasniVsetko() {
        for(int i = 0; i < this.aDispleje.length; i++)
            this.aDispleje[i].zhasniVsetko();
    }
    
    private void zobrazCislo(int paCislo, int paSustava) {
        int vstup = Math.abs(paCislo);
        int pocitadloCifier = 0;
        
        this.zhasniVsetko();
        while ((vstup > 0) && (pocitadloCifier < this.aDispleje.length)) {
            pocitadloCifier++;
            this.aDispleje[this.aDispleje.length - pocitadloCifier].zobraz(vstup % paSustava);
            vstup = vstup / paSustava;
        }
    }

    public void zobraz(int paCislo) {
        this.zobrazCislo(paCislo, 10);
    }
    
    public void zobrazBinary(int paCislo) {
        this.zobrazCislo(paCislo, 2);
    }
    
    public void zobrazHexa(int paCislo) {
        this.zobrazCislo(paCislo, 16);
    }
    
    public void zobrazOtocene(int paCislo) {
        int vstup = Math.abs(paCislo);
        int pocitadloCifier = 0;
        
        this.zhasniVsetko();
        while ((vstup > 0) && (pocitadloCifier < this.aDispleje.length)) {
            this.aDispleje[pocitadloCifier].zobraz(vstup % 10);
            pocitadloCifier++;
            vstup = vstup / 10;
        }
    }
}
