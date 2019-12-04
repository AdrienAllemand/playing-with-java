/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.EnumSet;


enum Lieu {

    Bussigny("Bussigny"), Lavigny("Lavigny"), Yverdon("Yverdon-les-bains"), Lausanne("Lausanne");

    private final String lieu; //

    private Lieu(String nomLieu) {
        lieu = nomLieu;
    }

    public String toString() {
        return lieu;
    }
}


/**
 * Ce type d'enum est incroyablement pratique pour définir des Unités dans un jeu !
 */
enum Operation {
    plus {
        double eval(double x, double y) {
            return x + y;
        }
    },
    minus {
        double eval(double x, double y) {
            return x - y;
        }
    };

    abstract double eval(double x, double y);
}

class JoliEnum {

    public static void main(String[] args) {
        Lieu lieu = Lieu.Bussigny;
        System.out.println(lieu);

        Lieu[] tab = lieu.values(); //values() est héritée de Enum

        for (Lieu l : EnumSet.range(Lieu.Bussigny, Lieu.Yverdon)) {
            System.out.println(l);
        }

        System.out.println(Operation.plus.eval(1, 2));
    }
}
