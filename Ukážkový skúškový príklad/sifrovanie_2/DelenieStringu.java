
/**
 * Write a description of class DelenieStringu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DelenieStringu {
    private String text;
    private String[] casti;
    public DelenieStringu(String text) {
        this.text = text;
    }
    
    public void rozdelString() {
        casti = this.text.split(" ");
        System.out.println("cast 1 " + casti[0] + " cast 2 " + casti[1]);
    }
}
