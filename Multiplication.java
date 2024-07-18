public class Multiplication extends OperationBinaire {

    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int valeur() {
        return left.valeur() * right.valeur();
    }
}