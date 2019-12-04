package constructeur;

public class A{

    int aa = 1; //initialisé en 2
    double dd; //intialisé par défaut en 2

    A(){
        //appel par défaut de super() en 1
        //execution des autres instructions en 3
        System.out.println("A()");
    }
    A(int a){
        System.out.println("A(int a)");
    }
}