
/**
 * Trieda reprezentuje 7 segmentovy displej.
 * Oznacenie segmentov:
 * ┌─ A ─┐
 * F        B
 * ├─ G ─┤
 * E        C
 * └─ D ─┘
 *  
 * @author Michal Varga
 * @version 1.0
 */
public class SSD {

    private Segment segmentA;
    private Segment segmentB;
    private Segment segmentC;
    private Segment segmentD;
    private Segment segmentE;
    private Segment segmentF;
    private Segment segmentG;
    
    /**
     * Constructor for objects of class Display
     */
    public SSD(int dlzkaSegmentu, int hrubkaSegmentu, int poziciaDisplejaX, int poziciaDisplejaY) {                     
        this.segmentA = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY);
        this.segmentB = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX + dlzkaSegmentu + hrubkaSegmentu, poziciaDisplejaY + hrubkaSegmentu);
        this.segmentC = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX + dlzkaSegmentu + hrubkaSegmentu, poziciaDisplejaY + dlzkaSegmentu + 2 * hrubkaSegmentu);
        this.segmentD = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY + 2 * dlzkaSegmentu + 2 * hrubkaSegmentu);
        this.segmentE = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX, poziciaDisplejaY + dlzkaSegmentu + 2 * hrubkaSegmentu);
        this.segmentF = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX, poziciaDisplejaY + hrubkaSegmentu);
        this.segmentG = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY + dlzkaSegmentu + hrubkaSegmentu);
    }
    
    public void rozsviet() {
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.rozsviet();
        this.segmentF.rozsviet();
        this.segmentG.rozsviet();      
    }
    
    public void zhasni() {
        this.segmentA.zhasni();
        this.segmentB.zhasni();
        this.segmentC.zhasni();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
        this.segmentG.zhasni();      
    }
    
    public void zobraz0() {
        this.rozsviet();
        this.segmentG.zhasni();
    }
    
    public void zobraz1() {
        this.zhasni();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
    }
    
    public void zobraz2() {
        this.rozsviet();
        this.segmentC.zhasni();
        this.segmentF.zhasni();        
    }
    
    public void zobraz3() {
        this.rozsviet();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
    }
    
    public void zobraz4() {
        this.rozsviet();
        this.segmentA.zhasni();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
    }
    
    public void zobraz5() {
        this.rozsviet();
        this.segmentB.zhasni();
        this.segmentE.zhasni();
    }
    
    public void zobraz6() {
        this.rozsviet();
        this.segmentB.zhasni();
    }
    
    public void zobraz7() {
        this.zhasni();
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
    }
    
    public void zobraz8() {
        this.rozsviet();
    }
    
    public void zobraz9() {
        this.rozsviet();
        this.segmentE.zhasni();
    }      
    
    public void zobraz(int cislo) {
        
        switch(Math.abs(cislo % 10)) {
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
            default:
                this.zhasni();
        }
    }
}
