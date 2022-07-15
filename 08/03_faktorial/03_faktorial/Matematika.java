public class Matematika {
    public int faktorialCyklus(int n) {
        int vysledok = 1;
        for(int i = 2; i <= n; i++) {
            vysledok *= i;
        }
        return vysledok;
    }

    public int faktorial(int n) {
        if (n < 1) {
            return 1;
        } else {
            return n * this.faktorial(n - 1);
        }
    }
    
    public int getFib(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return getFib(n-1) + getFib(n-2);
        }
    }
    
    public int getFibCyklus(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            int vysledok = 0;
            for(int i = 3; i <= n; i++) {
                vysledok = a + b;
                a = b;
                b = vysledok;
            }
            return vysledok;
        }
    }
}
