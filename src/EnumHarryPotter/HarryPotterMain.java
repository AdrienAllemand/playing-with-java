package EnumHarryPotter;

public class HarryPotterMain {

    public static void main(String ... args) {

        // Adding some wizards to houses
        Wizard harry = new Wizard("Harry Potter");
        House.GRIFFONDOR.addWizard(harry);
        Wizard ron = new Wizard("Ron Wisley");
        House.GRIFFONDOR.addWizard(ron);
        Wizard hermione = new Wizard("Hermione Granger");
        House.GRIFFONDOR.addWizard(hermione);
        Wizard malfoy = new Wizard ("Draco Malfoy");
        House.SERPENTARD.addWizard(malfoy);
        System.out.println();

        // Giving some points to houses
        House.GRIFFONDOR.addPoints(20);
        House.SERPENTARD.addPoints(25);
        System.out.println();


        // Checking Hogwarts state
        System.out.println("Current state of Hogwarts is :");
        for(IHouse h : House.values()){
            System.out.println("House : " + h.getName());
            System.out.print("Students : {");
            for(Wizard w : h.getWizards()) {
                System.out.print(w + " ");
            }
            System.out.println("}");
            System.out.println("Points : " + h.getPoints());
        }

        // Ensuring good guys win in the end
        System.out.println("Thanks to suspens, the leading house is " + House.getHouseWinner());
        House.SERPENTARD.addPoints(-10);
        System.out.println("Thanks to deus ex machina, the winner is now " + House.getHouseWinner());
    }
}
