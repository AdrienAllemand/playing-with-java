public abstract class Hero {

    public static void main(String[] args) {


        Hero hero1 = new Assassin();
        Hero hero2 = new Dragon();

        try {
            System.out.println("Hero 1" + hero1.attaque());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hero 2" + hero2.attaque());

        System.out.println("Hero 1 " + hero1.apply(5));
        System.out.println("Hero 2 " + hero2.apply(5));
    }

    public abstract int apply(int i);

    public abstract String attaque();
}

class Assassin extends Hero {

    @Override
    public int apply(int i) {
        return i + 1;
    }

    public String attaque() {
        return "Poignard";
    }
}

class Dragon extends Hero {
    @Override
    public int apply(int i) {
        return i-1;
    }

    public String attaque() {
        return "Feu";
    }

}