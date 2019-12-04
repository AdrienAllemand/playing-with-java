/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;

   class C {
      private int[] tab = {1,2,3};
      
      public int[] tab(){ //mauvais getter (peut modifier éléments)
         return tab;
      }
      
      public int tab(int i){ //bon getter (bien encapsulé)
         return tab[i];
      }
   }
/**
 *
 * @author Tinker
 */
public class Tableau {
   
   public static void main(String[] args){
      int[] tableauInt;
      Object tableauObjects[];
      
      tableauInt = new int[3]; //Instanciation du tableau demande la taille : Valeurs par défaut des types primitifs
      tableauObjects = new Object[3]; // les objets ne sont pas instanciés : = null
      
      tableauInt[2] = 2; 
      tableauObjects[2] = new Double(2.2);
      
      for(int i: tableauInt){
         System.out.println(i);
      }
      
      for(Object i: tableauObjects){
         System.out.println(i);
      }
      
      C c;
      c = new C();
      c.tab()[1] = 42; //modifie le talbeau privé
      
      int[] array = {1,34,3,0};
      int[] array2 = {1,4,3,0};
      Arrays.sort(array); 
      Arrays.equals(array,array2);
   }
   
   
}

