public class Cislica {
    
    private Segment segmentA;
    private Segment segmentB;
    private Segment segmentC;
    private Segment segmentD;
    private Segment segmentE;
    private Segment segmentF;
    private Segment segmentG;
    
    public Cislica(int x, int y, double velkost) {
        this.segmentA = new Segment(((int)(14*velkost))+x, ((int)(10*velkost))+y, false, velkost);
        this.segmentB = new Segment(((int)(44*velkost))+x, ((int)(14*velkost))+y, true, velkost);
        this.segmentC = new Segment(((int)(44*velkost))+x, ((int)(48*velkost))+y, true, velkost);
        this.segmentD = new Segment(((int)(14*velkost))+x, ((int)(78*velkost))+y, false, velkost);
        this.segmentE = new Segment(((int)(10*velkost))+x, ((int)(48*velkost))+y, true, velkost);
        this.segmentF = new Segment(((int)(10*velkost))+x, ((int)(14*velkost))+y, true, velkost);
        this.segmentG = new Segment(((int)(14*velkost))+x, ((int)(44*velkost))+y, false, velkost);
    }
    
    public void zobrazCislo(int cislo) {
        switch (cislo) {
           case 0:
               this.zobraz0();
               break;
           case 1:
               this.zobraz1();
               break;
           case 2:
               this.zobraz2();
               break;
           case 3:
               this.zobraz3();
               break;
           case 4:
               this.zobraz4();
               break;
           case 5:
               this.zobraz5();
               break;
           case 6:
               this.zobraz6();
               break;
           case 7:
               this.zobraz7();
               break;
           case 8:
               this.zobraz8();
               break;
           case 9:
               this.zobraz9();
               break;
        }
    }
    
    public void zobraz1() {
        this.vypni();
        this.segmentB.zapni();
        this.segmentC.zapni();
    }
    
    public void zobraz2() {
        this.vypni();
        this.segmentA.zapni();
        this.segmentB.zapni();
        this.segmentG.zapni();
        this.segmentE.zapni();
        this.segmentD.zapni();
    }
    
    public void zobraz3() {
        this.vypni();
        this.segmentA.zapni();
        this.segmentB.zapni();
        this.segmentC.zapni();
        this.segmentD.zapni();
        this.segmentG.zapni();
    }
    
    public void zobraz4() {
        this.vypni();
        this.segmentF.zapni();
        this.segmentG.zapni();
        this.segmentB.zapni();
        this.segmentC.zapni();
    }
    
    public void zobraz5() {
        this.vypni();
        this.segmentA.zapni();
        this.segmentF.zapni();
        this.segmentG.zapni();
        this.segmentC.zapni();
        this.segmentD.zapni();
    }
    
    public void zobraz6() {
        this.vypni();
        this.segmentA.zapni();
        this.segmentC.zapni();
        this.segmentD.zapni();
        this.segmentE.zapni();
        this.segmentF.zapni();
        this.segmentG.zapni();
    }
    
    public void zobraz7() {
        this.vypni();
        this.segmentA.zapni();
        this.segmentB.zapni();
        this.segmentC.zapni();
    }
    
    public void zobraz8() {
        this.vypni();
        this.segmentA.zapni();
        this.segmentB.zapni();
        this.segmentC.zapni();
        this.segmentD.zapni();
        this.segmentE.zapni();
        this.segmentF.zapni();
        this.segmentG.zapni();
    }
    
    public void zobraz9() {
        this.vypni();
        this.segmentA.zapni();
        this.segmentB.zapni();
        this.segmentC.zapni();
        this.segmentD.zapni();
        this.segmentF.zapni();
        this.segmentG.zapni();
    }
    
    public void zobraz0() {
        this.vypni();
        this.segmentA.zapni();
        this.segmentB.zapni();
        this.segmentC.zapni();
        this.segmentD.zapni();
        this.segmentE.zapni();
        this.segmentF.zapni();
    }
  
    
    public void vypni() {
        this.segmentA.vypni();
        this.segmentB.vypni();
        this.segmentC.vypni();
        this.segmentD.vypni();
        this.segmentE.vypni();
        this.segmentF.vypni();
        this.segmentG.vypni();
    }
}
