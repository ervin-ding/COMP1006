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




    /** Helper does not play */
    @Override
    public void play() {}

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
        for (int i = 0; i < 10; i +=1) {
            if (this.peaches.size() > 0) {
                forceFeed(p);
            }
        }
    }

    public void forceFeed(Player p) {
        /*
        simply eat a peach and gain health
        */
        int peachRipeness = this.getPeach().getRipeness();
        p.setHealth(p.getHealth() + peachRipeness);
        System.out.println(p + " has gained " + peachRipeness + " health" );
    }

}
