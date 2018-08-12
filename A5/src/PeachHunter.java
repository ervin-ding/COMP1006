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
    public PeachHunter(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb) {
        super(w, name, location, peaches, health, rgb);
    }


}
