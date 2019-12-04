/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class F{
   int f;
   
   F(int f){
      this.f = f;
   }
   public boolean same(Object o){
      System.out.println("F.same(): " + getClass());
      
      return getClass().isInstance(o) && ((F)o).f == f;
   }
}

class H extends F{
   int h;
   H(int f,int h){
      super(f);
      this.h = h;
   }
   public boolean same(Object o){
      System.out.println("H.same(): " + getClass());
      
      return super.same(o) && ((H)o).h == h;
   }
}


public class Egalite {
   
   
   public static void main(String[] args) {
      F f = new F(1); 
      F f2 = new F(2);
      F f3 = new F(1);
      
      H h = new H(1, 5);
      H h2 = new H(1, 4);
      F f4 = new H(1, 5);
      
      //System.out.println(f.same(f2));
      //System.out.println(f.same(h));
      System.out.println(h.same(f));
      //System.out.println(f4.same(h));
      
   }
   
}
