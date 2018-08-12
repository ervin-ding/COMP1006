import java.util.List;

public class PeachHunter extends Player {
    /**
     * Creates a player in the game
     *
     * @param w
     * @param name     is the name of the player
     * @param location is where in the world the player is
     * @param peaches  is a list of peaches the player starts with
     * @param health   is the health of the player (which may or may not be relevant in your game)
     * @param rgb
     */

    /**
     *  A PeachHunter searches for peaches to bring back to the home location. A peach hunter can carry lots
     * of peaches (as many as 100). The peach hunter should return to home to deposit its peaches once they have
     * 50 or more peaches. A peach hunter will remember where peach groves are when they find them and go back
     * to them to get more peaches until the grove runs out. If a hunter's health is less than 50 then it can only carry
     * 25 peaches. It must then put any excess peaches in the current location if this happens.
     * */

    public PeachHunter(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb) {
        super(w, name, location, peaches, health, rgb);


    }
    protected 


}
