/**
 * Write a description of class CezarovaSifra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CezarovaSifra {
    public CezarovaSifra(String string, int i, String a) {
        Vstup vstup = new Vstup(string, i, a);
        Abeceda abeceda = new Abeceda(vstup, a);
        Sifrovanie sifrovanie = new Sifrovanie(vstup, abeceda);
        Desifrovanie desifrovanie = new Desifrovanie(vstup, abeceda);
        if (a == "sifruj") {
            sifrovanie.sifruj();
        } else {
            desifrovanie.desifruj();
        }
    }
}
