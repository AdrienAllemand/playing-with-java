/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

interface Vehicule{
   public void avancer();
}

class Chameau implements Vehicule{
   void galoper(){
      System.out.println("Le Chameau Galope !");
   }
   
   public void avancer(){
      galoper();
   }
}

class Voiture implements Vehicule{
   void roule(){
      System.out.println("Vroum vroum !");
   }
   
   public void avancer(){
      roule();
   }
}
/* WRAPPER
class ChameauVehicule extends Chameau implements Vehicule{
   public void avancer(){
      galoper();
   }
}
*/
public class Wrappers {
   
}
