public enum Farba {
    Biela,
    Modra,
    Cervena,
    Zelena;
    
    public static Farba getFarba(int index) {
        switch(index) {
            case 0: return Biela;
            case 1: return Modra;
            case 2: return Cervena;
            default: return Zelena;
        }        
    }
}
