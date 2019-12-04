package constructeur;

public class B extends A{
    B() {
        //super();  //appelé par défaut, mais possible de le spécifier
        System.out.println("B()");
    }

    B(int b) {
        //super();  //appelé par défaut si il n'y a pas d'autre super(...) définit dans ce constructeur
        super(3); //appel le constuctructeur A(int) de A
        System.out.println("int B");
        //this(); //pas le droit, uniquement si première instruction
    }
}