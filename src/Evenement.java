/*
 * On a des tanks et des healers, les tanks émettent un évènement quand ils prennent des dégats
 * les healers soignent les tanks quand ceux ci émettent l'évènement correspondant.
 */

import java.util.LinkedList;

// équivalenet de la classe ActionListener
interface HelpListener{
   
   // la méthode qui va être appelée lorsque l'évènement se déclanche
   // le paramètre Tank t correspond au ActionEvent e
   void someoneCallsForHelp(Tank t);
   
   // permet au tank d'avoie le nom du healer
   String getListenerName();
}

// le healer est la personne qui écoutes l'évènement 
class Healer implements HelpListener{
   
   String nom;
   
   // constructeur
   Healer(String nom){
      this.nom = nom;
      System.out.println(this + " est né !");
   }

   // réponse a l'évènement de demande d'aide
   @Override
   public void someoneCallsForHelp(Tank t) {
      // il heal que si le tank a moins de 75 pv
      if(t.hp() < 75){
         System.out.println(this +" : I will heal you <3");
         t.takeHeal(10);   // le heal en question
      } else {
         System.out.println(this + " : Not worth it, have to save my mana :(");
      }
   }
   
   // permet de donner son nom au tank qui ne sait pas que c'est un Healer mais le voit uniquement
   // comme un HelpListener.
   @Override
   public String getListenerName(){
      return nom;
   }
   
   public String toString(){
      return nom + " the healer";
   }
}

// le tank est celui qui émet l'évènement
// il a une fonction addHelpListener qui permet d'ajouter HelpListener à sa liste de gentilsSoigneurs.
// il a une fonction call for help qui va appeler une réaction à l'évènement
// sur tout ce qui écoutes l'évènement (tout les HelpListener de sa liste de gentilsSoigneurs
class Tank {
   
   // pvs
   int hp = 100;
   
   // liste d'amis soigneurs
   private LinkedList gentilsSoigneurs = new LinkedList();  //On ne veut que des LowHPListener
   String nom;
   
   // Constructeur
   public Tank(String nom){
      this.nom = nom;
      System.out.println(this + " est né !");
   }
   
   // un getter pour récupérer le nombre de pvs
   public int hp() {
      return hp;
   }
   
   // reçoit un coup, et appel à l'aide si il est toujours vivant
   public void takeDamage(int damage){
      // on soustrait les dégats aux hps
      hp -= damage;
      System.out.println(this +": takes "+ damage+" damages, has "+ hp + " left.");
      
      // on test si il est toujours vivant
      if(hp <= 0){
         hp = 0;  // garde-fou pour pas avoir un nombre de pv négatifs
         System.out.println(this +": Mamaaaaaaan..... -meurt-");
      } 
      // si il est toujours en vie il appel à l'aide
      else {
         callForHelp();
      }
      
   }
   
   // recoit un soin, remercie pour le soin !
   public void takeHeal(int amount){
      // ajoutes le soin aux pv
      hp += amount;
      if(hp > 100) hp = 100;  // garde-fou pour ne pas dépasser 100hp (le max)
      System.out.println(this +": Thanks bro ! I have now "+ hp+ "hp !");
      
   }
   
   // Ajoutes un HelpListener a sa liste de pote
   // C'est la liste qui contiens tout les objets qui sont à l'écoute de son
   // évènement "callForHelp"
   public void addHelpListener(HelpListener gentilHeal){
      gentilsSoigneurs.add(gentilHeal);
      System.out.println(this+": salut "+ gentilHeal.getListenerName() + " je comptes sur toi pour me healer !");
   }
   
   // C'est la fonction qui va notifier toute les HelpListener de sa liste
   // qu'il a besoin d'aide en appelant leurs fonctions de callback
   public void callForHelp(){
      System.out.println(this +": Help !");
      
      // parcourt la liste et notifie tout le monde
      for(Object o : gentilsSoigneurs){
         ((HelpListener)o).someoneCallsForHelp(this); // appel des fonctions de callback
      }
   }
     
   public String toString(){
      return nom + " the Tank";
   }
}


public class Evenement {
   
   public static void main(String[] args){
      
      System.out.println("--{ Création des perso }--");                             
      Tank tank = new Tank("Romuald");                                              // Romuald the Tank est né !
      Healer healer1 = new Healer("Edgar");                                         // Edgar the healer est né !
      
      // le tank ajoutes healer1 comme ami qui va le soigner
      tank.addHelpListener(healer1);                                                // Romuald the Tank: salut Edgar je comptes sur toi pour me healer !
      
      System.out.println("\n--{ Les deux partent à l'aventure }--");
      System.out.println("Un goblin frappe "+tank+" ! (-20hp)");
      tank.takeDamage(20);                                                          // Romuald the Tank: takes 20 damages, has 80 left.
                                                                                    // Romuald the Tank: Help !
                                                                                    // Edgar the healer : Not worth it, have to save my mana :(
                                                                                    // etc...
      System.out.println("Un goblin frappe "+tank+" ! (-20hp)");
      tank.takeDamage(20);
      
      System.out.println("Un Troll frappe "+tank+" ! (-50hp)");
      tank.takeDamage(50);
      
      System.out.println("\n--{ Un nouveau healer arrive }--");
      Healer healer2 = new Healer("Wilkins");
      
      tank.addHelpListener(healer2);
      
      
      System.out.println("\n--{ Les trois partent à l'aventure }--");
      System.out.println("Un goblin frappe "+tank+" ! (-20hp)");
      tank.takeDamage(20);
      
      
      System.out.println("Un Troll frappe "+tank+" ! (-50hp)");
      tank.takeDamage(50);
      
      
      System.out.println("\n--{ The End <3 }--");
   }
   
}
