/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class J implements Cloneable{
   
   double d;
    public J clone(){
      J j = null;
      try{
         j = (J)super.clone();
      }catch(CloneNotSupportedException e){}
      return j;
    }
    
    J(double dd){
       d = dd;
    }
}

class K implements Cloneable{
   
   public J j;
   public int nombre;
   
   public K(int nbr, J j){
      nombre = nbr;
      this.j = j;
   }
   
   public K clone(){
      K k = null;
      try{
         k = (K)super.clone();
         k.j = j.clone();                 // permet de cloner "deep" j sinon ça serait que une copie "shallow"
      }catch(CloneNotSupportedException e){}
      return k;
   }
}


public class DeepCopy {
   
      public static void main(String[] args) {
         J j1 = new J(1);
         
         K k = new K(1, j1);
         
         K copie = k.clone();
         
         copie.j.d = 2;
         
         System.out.println(k.j.d);       // référence j1
         
         System.out.println(copie.j.d);   // référence une copie de j1 modifiée
      }
}
