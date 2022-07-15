public class PixelovyDisplej {

    private Stvorec[][] policka;

    public PixelovyDisplej(int xPos, int yPos, int sirka, int vyska, int velkost) {
        this.policka = new Stvorec[vyska][sirka];
        for(int y = 0; y < vyska; y++) {
            for(int x = 0; x < sirka; x++) {
                this.policka[y][x] = new Stvorec();
                this.policka[y][x].zmenFarbu("black");
                this.policka[y][x].zmenStranu(velkost);
                this.policka[y][x].posunVodorovne(-60+xPos+x*(velkost+1));
                this.policka[y][x].posunZvisle(-50+yPos+y*(velkost+1));
                this.policka[y][x].zobraz();
            }
        }
    }
    
    public void zmenPolicko(int x, int y, Farba farba) {
        if (farba == null) {
            this.policka[y][x].zmenFarbu("black");
        }
        else {
            this.policka[y][x].zmenFarbu(farba.dajFarbu());
        }
    }
}
