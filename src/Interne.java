/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Base{
   int a = 1;
   
   class Inner{
      int a = 2;
   }
}

class Extended extends Base{
   int a  = 3;
   
   class ExtendedInner extends Inner{
      int a  = 4;
      int b = a;                          // vaut 4
      int c  = this.a;                    // vaut 4
      int d  = Extended.this.a;           // vaut 3 (obligé de mettre le this, sinon a static)
      int e = super.a;                    // vaut 2
      int f = Extended.super.a;           // vaut 1
      int g = ((Base)Extended.this).a;    // vaut 1 (pas de liaison dynamique pour les attributs)
   }
}


//Exemple 2
class Guerrier{
   void attaquer(){
      System.out.println("Coup d'épée dans ta gueule!");
   }
}

class Mage{
   void attaquer(){
      System.out.println("Boule de feu dans ta gueule!");
   }
}

class Loyse extends Guerrier{
   class LoyseMage extends Mage{
      Loyse getBase(){
         return Loyse.this;
      }
   }
}

public class Interne {
   public static void main(String[] args) {
      Loyse.LoyseMage loysemage = new Loyse().new LoyseMage();
      loysemage.attaquer();
      loysemage.getBase().attaquer();
   }
   
}
