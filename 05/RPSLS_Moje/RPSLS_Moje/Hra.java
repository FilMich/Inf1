public class Hra {
    private OvladaniePocitacom pocitac;
    private OvladanieHracom hrac;
    private Casovac casovac;
    private Manazer manazer;
    private Rozhodca rozhodca;

    public Hra() {
        this.pocitac = new OvladaniePocitacom();
        this.hrac = new OvladanieHracom();
        this.casovac = new Casovac(this);
        this.manazer = new Manazer();
        this.rozhodca = new Rozhodca();
    }

    public void spustiHru(int pocetTikov) {
        this.manazer.spravujObjekt(this.casovac);      
        this.manazer.spravujObjekt(this.pocitac);
        this.manazer.spravujObjekt(this.hrac);
        this.casovac.start(pocetTikov);
    }
    
    public void jeCas() {
        this.manazer.prestanSpravovatObjekt(this.casovac);
        this.manazer.prestanSpravovatObjekt(this.pocitac);
        this.manazer.prestanSpravovatObjekt(this.hrac);

        System.out.println("Gesto hraca: " + this.hrac.getRuka().dajNazovGesta());
        System.out.println("Gesto PC: " + this.pocitac.getRuka().dajNazovGesta());
       
        Ruka vitaznaRuka = rozhodca.urciVitaza(pocitac.getRuka(), hrac.getRuka());    
        if (vitaznaRuka == null)
            System.out.println("Remiza - nevyhral nikto - obaja hraci ukazali gesto " + this.hrac.getRuka().dajNazovGesta());
        else {
            System.out.println("Vitazne gesto: " + vitaznaRuka.dajNazovGesta());
            if (vitaznaRuka == pocitac.getRuka())
                System.out.println("Vyhral pocitac.");
            else
                System.out.println("Vyhral hrac.");
        }
    }
}
