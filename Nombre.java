public class Nombre implements Expression {
    
    private final int val; // valeur du nombre

    public Nombre(int val) {
        this.val = val;
    }

    @Override
    public int valeur() {
        return val;
    }
}