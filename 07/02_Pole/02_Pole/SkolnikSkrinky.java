public class SkolnikSkrinky {
    private Skrinka[] skrinky;   

    public SkolnikSkrinky(int pocetSkriniek) {
        if (pocetSkriniek < 1)
            skrinky = new Skrinka[1];
        else
            skrinky = new Skrinka[pocetSkriniek];

        // Inicializacia skriniek (vsetky su otvorene)
        for (int i = 0; i < skrinky.length; i++){
            skrinky[i] = new Skrinka();
        }
    }

    public void vykonajPracuSkolnika(){   
        for(int modulo = 2; modulo <= skrinky.length; modulo++){
            for(int i = 0; i < skrinky.length; i++){
                // Otvorene zatvori a zatvorene otvori
                if (((i + 1) % (modulo)) == 0) {
                    if (skrinky[i].jeOtvorena())
                        skrinky[i].zavri();
                    else
                        skrinky[i].otvor();  
                }
            }
        }

        System.out.print("Otvorene skrinky: ");
        for(int i = 0; i < skrinky.length; i++){
            if (skrinky[i].jeOtvorena())
                System.out.print((i+1) + "  ");
        }
        System.out.println();
    }
}
