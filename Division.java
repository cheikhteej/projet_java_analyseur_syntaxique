public class Division extends OperationBinaire {

    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int valeur() throws ArithmeticException{
        int rightValue = right.valeur();
        if(rightValue == 0){
            throw new ArithmeticException("Division par zero");
        }
        return left.valeur() / rightValue;
    }
}