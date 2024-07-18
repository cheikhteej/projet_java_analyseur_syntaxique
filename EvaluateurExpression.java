import java.util.Scanner;

public class EvaluateurExpression {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculateur calculateur = new Calculateur();

        while (true) {
            System.out.print("A toi : ");

            //lire_utile
            String s = "";
            do{
                s += scanner.nextLine().trim();
            } while(s.charAt(s.length()-1) != '=' && s.charAt(s.length()-1) != '.');


            if (s.equals(".")) {
                System.out.println("Au revoir...");
                break;
            }
            else if(s.endsWith("==")){
                System.out.println("La syntaxe de l'expression est erronée");
            } 
            else{
                s = s.substring(0, s.lastIndexOf('='));                                
                try {
                    Expression expr = calculateur.calculer(s);
                    int valeur = expr.valeur();
                    System.out.println("La syntaxe de l'expression est correcte");
                    System.out.println("Sa valeur est " + valeur);
                } catch (Exception e) {
                    System.out.println("La syntaxe de l'expression est erronée");
                    System.out.println(e.getMessage());
                }
            }

        }

        scanner.close();
    }
}