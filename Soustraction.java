public class Soustraction extends OperationBinaire {
    
    public Soustraction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int valeur() {
        return left.valeur() - right.valeur();
    }
}