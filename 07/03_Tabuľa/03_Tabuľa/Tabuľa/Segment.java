
/**
 * Trieda reprezentuje jeden segment SSD
 * 
 * @author Michal Varga
 * @version 1.0
 */
public class Segment {
    
    private Obdlznik segment;
    
    public Segment(int dlzkaSegmentu, int hrubkaSegmentu, int poziciaX, int poziciaY) {
        this.segment = new Obdlznik();
        
        this.segment.zmenStrany(dlzkaSegmentu, hrubkaSegmentu);
        this.segment.zmenPolohu(poziciaX, poziciaY);
        
        this.segment.zobraz();
        this.zhasni();
    }
    
    public void rozsviet() {
        this.segment.zmenFarbu("red");
    }
    
    public void zhasni() {
        this.segment.zmenFarbu("white"); 
    }
    
}
