import java.util.Scanner;

public class Pokus {
    private static Hra hra;

    private static void prvaMetoda() {
        hra.prvaMetoda();
        System.out.println("Toto bude prva metoda triedy Pokus...");
    }
    
    private static void druhaMetoda() {
        hra.druhaMetoda();
        System.out.println("Toto bude druha metoda triedy Pokus...");
    }

    public static void main(String[] args) {
        int cislo = 0;
        hra = new Hra();    
               
        Scanner sc = new Scanner(System.in);
        while (cislo != -1) {
            System.out.print("Zadaj cislo: ");
            cislo = sc.nextInt();
            sc.nextLine();
            
            switch (cislo) {
                case 1: prvaMetoda();
                        break;
                case 2: druhaMetoda();
                        break;
            }
        }
        
        System.out.println("Dakujem:) dovidenia");
    }
}
