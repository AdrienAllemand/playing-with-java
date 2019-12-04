package constructeur;
/**
 *
 * @author Tinker
 */
public class Constructeur {
   
   public static void main(String ... args) {

      // tests avec des constructeurs simples
      System.out.println("New A()----------");
      A a = new A();
      System.out.println("New B()----------");
      B b = new B();
      System.out.println("New B(1)---------");
      B b2 = new B(1);
      System.out.println("New D()----------");
      D d = new D();
      System.out.println("New D(1)---------");
      D d2 = new D(1);

      // tests avec des constructeurd dans une classe abstraite
      // AbstractA abs = new AbstractA(); // CECI NE COMPILE PAS ON NE PEUT PAS INSTANCIER UNE CLASSE ABSTRAITE

      System.out.println("New ConcreteA()--");
      AbstractA abs = new ConcreteA();
      System.out.println("New ConcreteA(1)-");
      AbstractA abs2 = new ConcreteA(1);
   }
}
