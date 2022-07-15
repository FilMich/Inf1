import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Aplikacia {
    public Aplikacia() {
        ArrayList<Osoba> zoznam = new ArrayList<Osoba>();

        //int cislo = Integer.parseInt(JOptionPane.showInputDialog("Zadaj cislo", "10"));
        //JOptionPane.showMessageDialog(null, "Moje cislo je: " + cislo);

        zoznam.add(new Osoba("Osoba1", Zaradenie.PROFESOR));
        zoznam.add(new Osoba("Osoba2", Zaradenie.PROFESOR));
        zoznam.add(new Osoba("Osoba2", Zaradenie.STUDENT));
        zoznam.add(new Osoba("Osoba4", Zaradenie.PROFESOR));
        zoznam.add(new Osoba("Osoba5", Zaradenie.STUDENT));
        zoznam.add(new Osoba("Osoba6", Zaradenie.STUDENT));

        System.out.print('\u000c');
        System.out.println("Instancie enumu:");
        for(Zaradenie z: Zaradenie.values())
            System.out.println(z);

        System.out.println();

        for(Zaradenie z: Zaradenie.values())
            for(Osoba o: zoznam)
                if (o.getZaradenie() == z)
                    System.out.println(o);

        System.out.println();

        for(Osoba o: zoznam)
            System.out.println(o);        
    }
}
