import java.util.List;

public class Helper extends Player {

    /*A Helper is created and dispatched from the home location whenever a player (pit finder or peach
            hunter) asks for help. They bring a bunch of peaches to the player (giving them to the player when they interact
            with them). Once a helper helps someone they go back home (and do nothing for the rest of the game). A
            helper will not give any peaches to a bear.
    */

    public Helper(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb){
        super(w, name, location, peaches, health, rgb);
        this.name = "helper";
        this.location = w.getHome(); // helpers can only be instantiated in the home world
    }

    @Override
    /** Peaches cannot be taken from a helper, so we return null. */
    public Peach getPeach(){ return null; }

    @Override
    /** Helper do not play a turn. */
    public void play(){ }

    @Override
    /** Helper's do not move.
     * Once they have completed their task, they will remain in the home location and will do nothing. */
    public void move(int direction){  }

    @Override
    /** A helper's health will never change.
     *
     * @param h is the new health of the player
     */
    public void setHealth(int h) {}

    @Override
    /** Naturally helpers do not call for help. */
    public void getHelp() {}

    @Override
    /** gives the helper's peaches to the player in distress
     *
     * @param p is a player that is interacting with this player
     */
    public void interact(Player p){
        for (int i = this.peaches.size(); i > 0; i--) {
            p.peaches.add(this.peaches.remove(0));
        }
        System.out.println(p.name + " now has " + p.peaches.size() + " peaches.");
    }

    /** Helpers will always have the same name/health, and quite possibly location*/
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return false;
    }


}
