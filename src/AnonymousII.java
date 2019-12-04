/*
 * Ceci et un exemple de classe interne anonyme. Il met en scène un coffre fort, qui peut "produire" une télécommande
 * pour controler son ouverture.
 */


interface NumPad {
   void deverouiller(Object o);
}

class Coffre {
   
   // LE COFFRE EST INVIOLABLE HAHAHA TOUT EST PRIVE !
   private int montantDansCoffre;
   private int codeSecret;
   private boolean isLocked = true;

   // Constructeur publique
   public Coffre(int montant, int code) {
      montantDansCoffre = montant;
      codeSecret = code;
      System.out.println("Création d'un nouveau coffre avec " + montant + "$ dedans !");
   }

   // l'idée est de pouvoir faire un retrait
   public int retrait(int montant) {

      System.out.println("Tentative de retirer " + montant + "$ !");
      // mais impossible de retirer quoi que ce soit si il est vérouillé
      if (isLocked) {
         System.out.println("Coffre vérouillé, impossible de l'ouvrir !");
         return 0;
      } 
      // sinon c'est bon (tant qu'il reste assez dedans)
      else {
         System.out.println("Coffre dévérouillé, il y a " + montantDansCoffre + "$ dedans !");
         // si il reste assez d'argent
         if (montantDansCoffre - montant > 0) {
            // on retire le montant.
            System.out.println("Il y a assez pour retirer " + montant + "$ !On se sert !");
            montantDansCoffre -= montant;
            System.out.println("Il reste " + montantDansCoffre + "$ dans le coffre !");
            return montant;
         } else {
            int maxRetrait = montantDansCoffre;
            System.out.println("Il n'y a pas assez pour retirer " + montant + "$ ! On ne prends que " + maxRetrait + "$ !");
            montantDansCoffre = 0;
            return maxRetrait;
         }
      }
   }

   // pour le dévérouiller j'ai immaginé un système ingénieux de télécommande
   // cette fonction te retourne une télécommande (classe anonyme) qui implémente l'interface NumPad
   // l'interface NumPad demande juste de redéfinir la fonction void deverouiller(Object o) !
   public NumPad getNumPad() {

      // on retourne une télécommande déguisée en NumPad
      return new NumPad() {        // classe anonyme

         // on redéfinit deverouiller(Obeject o) pour notre classe anonyme pour qu'elle ouvres le coffre si
         // on lui file le bon code secret !
         public void deverouiller(Object o) {
            System.out.println("Tentative d'ouverture du coffre avec le code " + o + "!");      // ici o va fonctionner car Integer et String ont une fonction toString qui sera appelée par liaison dynamique
            
            // check si o est un int (mon code c'est un int mais ça ils le savent pas)
            // et que il est == au code Secret
            if (o instanceof Integer && ((Integer) o) == codeSecret) {
               System.out.println("Réussite !");

               // comme cette instance de NumPad est une classe anonyme interne, elle a accès a l'attribut isLocked de la classe coffre fort même si celui-ci est privée.
               // on dévérouille
               isLocked = false;
            } else {
               System.out.println("Echec !");
            }
         }
      };
   }
}

public class AnonymousII {

   public static void main(String[] args) {

      // on crée un nouveau coffre avec 1000$ et comme code 1234
      Coffre coffre = new Coffre(1000, 1234);

      // on crée une télécommande (classe anonyme) déguisée en (qui implémente) NumPad
      NumPad numPad = coffre.getNumPad();
      
      // on tente de retirer
      int retrait = coffre.retrait(100);
      
      // on tente d'ouvrir le coffre avec un string "htc-vive42"
      numPad.deverouiller("htc-vive42");
      
      // on tente d'ouvrir le coffre avec un code numérique 1982792193
      numPad.deverouiller(1982792193);
      
      // on ouvres le coffre avec la télécommande en lui filant le bon code
      numPad.deverouiller(1234);

      // on essaie de faire un retrait
      retrait = coffre.retrait(100);

      // le retrait a bien marché
      System.out.println("Retrait : " + retrait);

   }
}
