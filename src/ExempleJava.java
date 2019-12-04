//RAPPELS//
/*
méthode:   (private/public/protected) type_retour nom(parametres){}

*/

/**
 * Classe d'exemple pour tester plein de trucs
 */
public class ExempleJava {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      System.out.println("Main Principal");

      exampleCompare();
   }

   /**
    * Montres la différence entre int et Int
    */
   static void exampleCompare(){
      int A = 1;
      int B = 1;

      // ici ce sont les valeurs de A et B qui seront comparées
      // car ce sont des types primitifs !
      System.out.println("Is A == B ? " + (A == B));

      Integer C = 1;
      Integer D = 1;

      // Ici ce sont les "références" de C et D qui sont comparées
      // car ce ne sont pas des types primitifs mais des objets !
      System.out.println("Is C == D ? " + (C == D));

      // Grâce à la méthode equals (définie dans la classe "Objet", la classe mère de tout objet en java) on va comparer
      // les valeurs des objets. Attention, ceci n'est possible que grâce au fait que la classe Integer à définit une
      // surcharge de la méthode equals qui compare les valeurs des objets.
      System.out.println("Is C.equals(D) ? " + (C.equals(D)));

   }
}
