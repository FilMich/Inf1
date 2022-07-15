public class Matematika {
    private double atributA;
    private double atributB;
    private double atributC;

    public Matematika() {
        this.atributA = 1;
        this.atributB = 2;
        this.atributC = 3;
    }

    public Matematika(double a, double b, double c) {
        this.atributA = a;
        this.atributB = b;
        this.atributC = c;
    }

    public double getA() {
        return this.atributA;
    }

    public double getB() {
        return this.atributB;
    }

    public double getC() {
        return this.atributC;
    }

    public void setA(double a) {
        this.atributA = a;
    }

    public void setB(double b) {
        this.atributB = b;
    }

    public void setC(double c) {
        this.atributC = c;
    }

    public void vypisAtributy() {
        System.out.println("Atribut A: " + this.atributA);
        System.out.println("Atribut B: " + this.atributB);
        System.out.println("Atribut C: " + this.atributC);
    }

    public void vymenAB() {
        System.out.println("Povodne hodnoty:");
        vypisAtributy();     

        double d = this.atributA;
        this.atributA = this.atributB;
        this.atributB = d; 

        System.out.println("Po vymene:");
        vypisAtributy();
    }

    
    
    
    
    
    
    public void vymenABbezLP() {
        System.out.println("Povodne hodnoty:");
        this.vypisAtributy();

        //                                                  Pamatove miesto
        //                                                  a             b
        this.atributA = this.atributA + this.atributB;
        //                                                  a+b           b
        this.atributB = this.atributA - this.atributB; 
        //                                                  a+b           a+b-b = a
        this.atributA = this.atributA - this.atributB;
        //                                                  a+b-a = b     a
        System.out.println("Po vymene:");
        this.vypisAtributy();
    }

    public double getMax() {
        double maximum = this.atributA;

        if (this.atributB > maximum) {
            maximum = this.atributB;
        }

        if (this.atributC > maximum) {
            maximum = this.atributC;
        }

        return maximum;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public void kvadratickaRovnica() {
        if (this.atributA == 0) {
            System.out.println("Koeficient A nesmie byt nulovy!");
        } else {
            double diskriminant = (this.atributB * this.atributB) - (4 * this.atributA * this.atributC);
            if (diskriminant < 0) {
                System.out.println("Kvadraticka rovnica nema realne korene!");
            }
            else if (diskriminant == 0) {
                double x = (-this.atributB) / (2 * this.atributA);
                System.out.println("Kvadraticka rovnica ma jeden dvojnasobny koren: x = " + x);
            } else {
                double x1 = (-this.atributB - Math.sqrt(diskriminant)) / (2 * this.atributA);
                double x2 = (-this.atributB + Math.sqrt(diskriminant)) / (2 * this.atributA);      
                System.out.println("Kvadraticka rovnica ma dva korene:");
                System.out.println("\tx1 = " + x1);
                System.out.println("\tx2 = " + x2);            
            }
        }        
    }

    public void vypisCifernySucet(int vstup) {
        int cifernySucet = 0;
        int cislo = vstup;
        if (cislo < 0) {
            cislo = -cislo;
        }

        while (cislo > 0) {
            cifernySucet = cifernySucet + (cislo % 10);
            cislo = cislo / 10;
        }

        System.out.println("Ciferny sucet cisla " + vstup + " je " + cifernySucet);
    }
}
