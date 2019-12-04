package constructeur;

public class ConcreteA extends AbstractA{

    ConcreteA(){
        System.out.println("ConcreteA()");
    }

    ConcreteA(int i){
        super(i);
        System.out.println("ConcreteA(int i)");
    }
}
