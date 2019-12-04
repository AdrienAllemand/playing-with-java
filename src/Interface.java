/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

interface I{
   void i();   //forcément public abstract
   int MAX = 12;  //constante publique statique finale
}

class G implements I{
   
   
   public void i(){
      System.out.println("méthode i redefinie");
   }
}
        
        
        
public class Interface {
   public static void main(String[] args) {
     I i; 
     G g = new G();
     g.i();
     
     i = g; //on instancie i en tant que G  
     i.i();
     
     int a;
     a = I.MAX; //constante accessible depuis l'interface comme depuis la classe
     a = G.MAX;
   }
}
