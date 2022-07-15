
/**
 * Write a description of class Stvorec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stvorec {
    private int stranaA;

 
    /**
     * Constructor for objects of class Stvorec
     */
    public Stvorec(int stranaA) {
        this.stranaA = stranaA;
   
        
     
        
    }
public void setstranaA(int stranaA){
    this.stranaA = stranaA;
}
public int getobsahS(){
    return this.stranaA*this.stranaA;
        
}
public int getobvodO(){
    return this.stranaA+this.stranaA+this.stranaA+this.stranaA;
}
public void vzpisSa() {
    System.out.print("Strana a: ");
    System.out.println(this.stranaA);
    System.out.print("Obvod o: ");
    System.out.println(this.getobvodO());
    System.out.print("Obsah S: ");
    System.out.println(this.getobsahS());
}
}