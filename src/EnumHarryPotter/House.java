package EnumHarryPotter;

import java.util.ArrayList;
import java.util.List;

public enum House implements IHouse {

    GRIFFONDOR("Griffondor"),
    SERPENTARD("Serpentard"),
    POUFSOUFFLE("Poufsouffle"),
    SERDAIGLE("Serdaigle");

    private House(String name) {
        this.name = name;
    }

    private String name;
    private int points;
    private List<Wizard> wizards = new ArrayList<>();

    /**
     * @return returns the house with most points
     */
    public static IHouse getHouseWinner() {
        IHouse winner = null;
        for(IHouse m : House.values()){
            if(winner == null || winner.getPoints() < m.getPoints()) {
                winner = m;
            }
        }

        return winner;
    }
    @Override
    public int getPoints() {
        return points;
    }
    @Override
    public void addPoints(int points) {
        System.out.println("Adding " + points + " points to " + name);
        this.points += points;
    }

    @Override
    public void addWizard(Wizard w) {
        System.out.println("Adding " + w + " to " + name);
        this.wizards.add(w);
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public List<Wizard> getWizards(){
        return wizards;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public IHouse getWinner() {
        return getHouseWinner();
    }
}
