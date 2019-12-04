/*
    VOICI UN CODE DONT IL MANQUE UNE PARTIE, COMPLéTEZ LE UNIQUEMENT à L'ENDROIT 
    INDIQUé (UN SEUL ENDROIT).
    
    LORS DE SON EXéCUTION, LE PROGRAMME DEVRA AFFICHER EXACTEMENT :

1) Une TV est crée !
2) Naissance de René l'humain !
3) René regarde la tv, elle est éteinte !
4) Création d'une télécommande
5) René regarde la tv, elle est allumée sur la chaîne 0 !
6) René regarde la tv, elle est allumée sur la chaîne 5 !
7) René regarde la tv, elle est éteinte !

    LE BUT EST D'ENTRAINER LES CLASSES ANONYMES ET LE PRINCIPE DE CALLBACK
*/
package exemplejava;
import java.util.*;

interface Util {
    public static final Random random = new Random(0x42);
}


class TV {
    
    /*Interface interne de la classe TV*/
    interface Telecommande {
        void switchPower();
        void changerChaine(int chaine);
    }
    
    /* Variables privées ne pas donner de setters directs !!!*/
    private boolean isOn = false;
    private int chaine = 0;
    
    private LinkedList<Humain> observateurs = new LinkedList<Humain>();
    
    /* Le constructeur le plus utile de l'univers, ne pas toucher !!!*/
    TV(){
        System.out.println("Une TV est crée !");
    }


    /* AJOUTEZ VOTRE CODE ICI*/
    public boolean isOn() { return isOn; }
    public int chaine() { return chaine; }
    
    Telecommande getTelecommande() {
        return new Telecommande(){
            public void switchPower(){
                isOn = !isOn;
                ilYAUnChangement();
            }
            public void changerChaine(int c){
                chaine = c;
                ilYAUnChangement();
            }
        };
    }
    
    public void addHumainWatching(Humain h){
        observateurs.add(h);
        
        ilYAUnChangement();
    }
    
    private void ilYAUnChangement(){
        for(Humain h : observateurs){
            h.donnerStatusTV(this);
        }
    }
    /* FIN CODE A AJOUTER */
}


/*Utiliser uniquement l'humain pour afficher des informations dans la console (System.out)*/
class Humain {
    
    private String nom;
    
    public String nom() { return nom; };
    
    public Humain(String nom){
        this.nom = nom;
        System.out.println("Naissance de " + nom + " l'humain !");
    }
    
    public void donnerStatusTV(TV tv){
        if(tv.isOn()){
            System.out.println(nom + " regarde la tv, elle est allumée sur la chaîne " + tv.chaine() + " !");
        } else {
            System.out.println(nom + " regarde la tv, elle est éteinte !");
        }
    }
}

public class AnonymousIIIcorrection {
    public static void main(String[] args) {
        //Créer et stocker une nouvelle TV
        System.out.print("1) ");
        TV tv = new TV();
        
        // Créer un humain
        System.out.print("2) ");
        Humain rene = new Humain("René");
        
        // faire en sorte que l'humain "regarde la TV"
        System.out.print("3) ");
        tv.addHumainWatching(rene);
        
        //Créer et stocker une télécommande de la TV
        System.out.println("4) Création d'une télécommande");
        TV.Telecommande telecommande = tv.getTelecommande();
        
        // allumer la tv avec la télécommande
        System.out.print("5) ");
        telecommande.switchPower();
        
        // changer de chaine avec la télécommande
        System.out.print("6) ");
        telecommande.changerChaine(5);
        
        // éteindre la tv avec la télécommande
        System.out.print("7) ");
        telecommande.switchPower();
    }
}

interface Y {
    int a();
}
abstract class X implements Y{
    
}

class Z extends X {
    public int a(){
        return 1;
    }
}