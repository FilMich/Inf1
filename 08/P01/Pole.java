import java.util.Random;
public class Pole {
    private Random generator;
    private int[] pole;
    
    public Pole() {
        this.generator = new Random();
        this.pole = new int[20];
        for (int i = 0; i < this.pole.length; i++) {
            this.pole[i] = 1 + this.generator.nextInt(20);
        }
    }
    
    public void vypisPole() {
        for (int i = 0; i <this.pole.length; i++) {
            System.out.format("%3d", this.pole[i]);
        }
    }
    
    public void vypisMax() {
        int max = 0;
        for(int i = 0; i <this.pole.length; i++) {
            if(this.pole[i] > max) {
                max = this.pole[i];
            }
        }
        System.out.println(max);
    }
    
    public void vypisMin() {
        int min = 20;
        int indexMin = 0;
        for(int i = 0; i < this.pole.length; i++) {
            if(this.pole[i] < min) {
                min = this.pole[i];
                indexMin = i;
            }
        }
        System.out.println("index" + indexMin + "hodnota min" + min);
    }
}
