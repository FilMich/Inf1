import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Skupina {
    private String nazov;
    private ArrayList<Osoba> aZoznam;

    public Skupina() {
        this.setNazov("Informatika-cv.");
        this.aZoznam = new ArrayList<Osoba>();
        this.aZoznam.add(new Osoba("Marek", "Kvet", 1000));
        this.aZoznam.add(new Osoba("Michal", "Kvet", 1000));
    }    
       
    public Skupina(String paNazov) {
        this.setNazov(paNazov);
        this.aZoznam = new ArrayList<Osoba>();
    }

    public void setNazov(String novyNazov) {
        if (novyNazov.equals(""))
            this.nazov = "MojaSkupina";
        else
            this.nazov = novyNazov;
    }

    public void pridajOsobu(Osoba paOsoba) {
        this.aZoznam.add(paOsoba);
    }
    
    public void vypisClenovSkupiny() {
        if (this.aZoznam == null)
            System.out.println("Zoznam neexistuje!");
        else {
            if (this.aZoznam.size() == 0)
                System.out.println("Zoznam je prazdny!");
            else {
                System.out.println("Skupina: " + this.nazov);
                for(Osoba o: this.aZoznam) {
                    System.out.println(o.toString());
                }
            }
        }
    }

    public void odstranClenaSkupiny(int paPoradie) {
        if ((paPoradie >= 0) && (paPoradie < this.aZoznam.size()))
            this.aZoznam.remove(paPoradie);   
    }

    public void odstranClenaSkupiny(Osoba paOsoba) {
        this.aZoznam.remove(paOsoba);
    }

    public void zrusSkupinu() {          
        this.aZoznam.clear();    
    }
    
    public void ulozDoSuboru(String fileName) throws IOException {
        if (this.aZoznam == null)
            System.out.println("Zoznam neexistuje!");
        else {
            if (this.aZoznam.size() == 0)
                System.out.println("Zoznam je prazdny!");
            else {
                File subor = new File(fileName);
                PrintWriter zapisovac = new PrintWriter(subor);
                zapisovac.println(this.nazov);
                
                for(Osoba o: this.aZoznam) {
                    zapisovac.print(o.getMeno());
                    zapisovac.print(" ");
                    zapisovac.print(o.getPriezvisko());
                    zapisovac.print(" ");
                    zapisovac.print(o.getZaradenie());
                    zapisovac.print(" ");
                    zapisovac.println(o.getPlat());
                }
                zapisovac.close();
                System.out.println("Subor bol uspesne ulozeny.");
            }
        }
    }
    
    public void nacitajZoSuboru(String fileName) throws IOException {
        if (this.aZoznam == null)
            this.aZoznam = new ArrayList<Osoba>();
        else
            this.aZoznam.clear();
          
        String meno;
        String priezvisko;
        int plat;    
        PracovneZaradenie pracZar;   
            
        File subor = new File(fileName);
        Scanner citac = new Scanner(subor);
        this.nazov = citac.nextLine();
        while (citac.hasNextLine()) {
            meno = citac.next();
            priezvisko = citac.next();
            pracZar = PracovneZaradenie.nastavPodlaStringu(citac.next());
            plat = citac.nextInt();
            citac.nextLine();
            
            this.aZoznam.add(new Osoba(meno, priezvisko, plat, pracZar));
        }
        citac.close();    
            
        System.out.println("Citanie zo suboru ukoncene.");
        this.vypisClenovSkupiny();          
    }
}
