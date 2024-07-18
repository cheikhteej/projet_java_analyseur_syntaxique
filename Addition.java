public class Addition extends OperationBinaire {
    
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int valeur() {
        return left.valeur() + right.valeur();
    }
}