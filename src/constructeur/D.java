package constructeur;

public class D {
    D() {
        System.out.println("D()");
    }

    D(int d) {
        this(); //appel d'un autre consturcteur de la même classe
                // possible uniquement comme première instruction d'un constructeur
        System.out.println("int D(int d)");
    }
}