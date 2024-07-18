
public abstract class OperationBinaire implements Expression {
   
    protected Expression left; //expression a gauche
    protected Expression right; // expression a droite

    public OperationBinaire(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract int valeur();
}