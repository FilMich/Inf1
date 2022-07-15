import java.util.Random;

public class TovarenNaTetromina {
    
    private Random generator;
    
    public TovarenNaTetromina() {
        this.generator = new Random();
    }
    
    public Tetromino vyrob(Tvar tvar) {
        switch (tvar) {
            case I:
                return new Tetromino(new boolean[][]{{true, true, true, true}}, Farba.dajNahodnu());
            case J:
                return new Tetromino(new boolean[][]{{true, true, true}, {false, false, true}}, Farba.dajNahodnu());
            case O:
                return new Tetromino(new boolean[][]{{true, true}, {true, true}}, Farba.dajNahodnu());
            case S:
                return new Tetromino(new boolean[][]{{false, true, true}, {true, true, false}}, Farba.dajNahodnu());
            case Z:
                return new Tetromino(new boolean[][]{{true, true, false}, {false, true, true}}, Farba.dajNahodnu());
            case L:
                return new Tetromino(new boolean[][]{{true, true, true}, {true, false, false}}, Farba.dajNahodnu());
            
            default:
                return null;
        }
    }
    
    public Tetromino vyrobNahodne() {
        Tvar[] tvary = Tvar.values();
        Tetromino tetromino = this.vyrob(tvary[this.generator.nextInt(tvary.length)]);
        int otoceni = this.generator.nextInt(4);
        for (int i = 0; i < otoceni; i++) {
            tetromino.otoc(null);
        }
        return tetromino;
    }
}
