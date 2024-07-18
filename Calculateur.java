public class Calculateur {

    private Selecteur selecteur;

    public Expression calculer(String input) throws IllegalArgumentException{

        selecteur = new Selecteur(input);
        
        return calculeExpression();
    }

    private Expression calculeExpression() throws IllegalArgumentException{
        Expression left = calculeTerme();

        while(selecteur.hasNext() && 
                (selecteur.select().equals("+") || selecteur.select().equals("-"))) {        
            String operateur = selecteur.next();
            Expression right = calculeTerme();        
            if(operateur.equals("+")){
                left = new Addition(left, right);
            } 
            else{
                left = new Soustraction(left, right);
            }
        }
        return left;
    }

    private Expression calculeTerme() throws IllegalArgumentException{
        Expression left = calculeFacteur();
        while(selecteur.hasNext() && (selecteur.select().equals("*") || selecteur.select().equals("/"))) {
            String operateur = selecteur.next();
            Expression right = calculeFacteur();
            if(operateur.equals("*")){
                left = new Multiplication(left, right);
            } 
            else{
                left = new Division(left, right);
            }
        }
        return left;
    }

    private Expression calculeFacteur() throws IllegalArgumentException{
        if(selecteur.hasNext()){
            if(selecteur.select().equals("(")){
                selecteur.next(); 
                Expression expr = calculeExpression();
                if (!selecteur.hasNext() || !selecteur.next().equals(")")){
                    throw new IllegalArgumentException("Erreur sur les Parenthèses");
                }
                return expr;
            } 
            else{
                return new Nombre(Integer.parseInt(selecteur.next()));
            }
        }
        else{
            throw new IllegalArgumentException("");
        }
    }
}