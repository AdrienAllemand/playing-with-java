package EnumHarryPotter;

import java.util.List;

public interface IHouse {
    /**
     * @return Returns the number of points of this house
     * Currently no check, points could be negative
     */
    public int getPoints();

    /**
     * Adds points to a house
     * @param points the number of points to add, negative to remove points
     */
    public void addPoints(int points);

    /**
     * Adds a wizard to the house,
     * Once a wizard has been added, he will allways be part of the house !
     * @param w
     */
    public void addWizard(Wizard w);

    /**
     * @return returns the list of wizards belonging to that house
     */
    public List<Wizard> getWizards();

    /**
     * @return returns the name of the IHouse
     */
    public String getName();

    /**get
     * @return returns the house with most points
     */
    public IHouse getWinner();
}
