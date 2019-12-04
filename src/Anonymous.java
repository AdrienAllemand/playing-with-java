/*
 * Une classe anonyme c'est super pratique pour implémenter "à la volée" une interface ou une classe abstraite
 */

interface M{
   int value();
}

class L{
   /**
    * la fonction m retourne une interface (ou qqch qui implémente l'interface I, par transtypage)
    * @return
    */
   public M m() {
     //On utilise uniquement l'interface, du coup on crée à la volée une classe qui ne fait rien d'autre que l'implémenter
      return new M(){
         private int m = 42;
         
         //Attention, la méthode doit être publique
         public int value(){     //redefinition de la fonction value() de l'interface I implémenté par la classe anonyme
            return m;
         }
      };    //Ne pas oublier le ; à la fin du retour 
      
   }
}

public class Anonymous {
   public static void main(String[] args) {

      // affiche 42
      M m = new L().m();
   }
}
