
/**
 * Write a description of class Hra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hra {
   
    private Tetromino padajuceTetromino;
    
    
    public Hra() {
        // boolean[][] tvarL = new boolean[3][2];
        // tvarL[0][0] = true;
        // tvarL[1][0] = true;
        // tvarL[2][0] = true;
        // tvarL[0][1] = true;
        
        Tetromino tetromino = new Tetromino(new boolean[][] { {true, true, true, true} });  
        tetromino.zobraz();
        
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(tetromino);
        
        
        
        // Tetromino tetrominoL = new Tetromino(tvarL);    
        // tetrominoL.zobraz();
        
        // boolean[][] tvarO = new boolean[][] { {true, true}, {true, true} };
        // Tetromino tetrominoO = new Tetromino(tvarO);
        
        // Tetromino tetrominoT = new Tetromino(new boolean[][] { {true, false}, {true, true}, {true, false} });
        
        // // boolean[][] tvarT = new boolean[3][2];
        // // tvarT[0] = new boolean[] {true, false};
        // // tvarT[1] = new boolean[] {true, true};
        // // tvarT[2] = new boolean[] {true, false};
        
        // // boolean[][] tvarT = new boolean[3][2];
        // // tvarT[0][0] = true;
        // // tvarT[0][1] = false;
        // // tvarT[1][0] = true;
        // // tvarT[1][1] = true;
        // // tvarT[2][0] = true;
        // // tvarT[2][1] = false;
        
        
        
    }
}
