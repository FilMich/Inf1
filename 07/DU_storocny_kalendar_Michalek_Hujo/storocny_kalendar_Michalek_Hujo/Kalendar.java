public class Kalendar {
    private Rok rok;
    private Mesiac mesiac;
    
    public Kalendar(int rok, int mesiac) {
        if(rok >= 1900 && rok <= 10000) {
            this.rok = new Rok(rok);
        } else {
            System.out.println("Rok nie je z intervalu <1900, 10000>");
            this.rok = new Rok(1900);
        }
        
        if(mesiac >= 1 && mesiac <= 12) {
            this.mesiac = new Mesiac(mesiac);
        } else {
            System.out.println("Mesiac nie je z intervalu <1, 12>");
            this.mesiac = new Mesiac(1);
        }
    }
    
    private void jePriestupny() {
        if(this.rok.getPriestupnyRok()) {
            if(this.mesiac.getPoradie() == 2) {
                this.mesiac.setPdni();
            }
        }
    }
    
    public void vypisSa() {
        Den den = new Den(this.rok.getRoky(), this.mesiac.getPoradie());
        if(this.rok.getPriestupnyRok()) {
            den.setDen();
        }
        den.setDen();
        for(int i = 0; i < 7;i++) {
            switch (i) {
                case 0:
                    System.out.print("PO\t");
                    break;
                case 1:
                    System.out.print("UT\t");
                    break;
                case 2:
                    System.out.print("ST\t");
                    break;
                case 3:
                    System.out.print("ŠT\t");
                    break;
                case 4:
                    System.out.print("PI\t");
                    break;
                case 5:
                    System.out.print("SO\t");
                    break;
                case 6:
                    System.out.print("NE\t");
                    break;
            }
            for(int j = 0; j < 5; j++) {
                if(i + 1 >= den.getDen() && j == 0) {
                    System.out.print((i+1) - (den.getDen()-1) + "\t");
                } else if(i + 1 < den.getDen() && j == 0) {
                    System.out.print("\t");
                } else if (i + ((1 + j * 7)-(den.getDen()-1)) <= this.mesiac.getPdni()) {
                    System.out.print(i + ((1 + j * 7)-(den.getDen()-1)) + "\t");
                }
            }
            System.out.println();
        }
    }
}
