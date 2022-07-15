public class Aplikacia {
    public static void main(String[] args) {
        Matica matica = new Matica(5, 5);
        matica.zobraz();
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(matica);   
    }
}
