import java.util.List;
import java.util.Random;

public class PeachThief extends Player{

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
    public PeachThief(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb) {
        super(w, name, location, peaches, health, rgb);
    }
    protected boolean probs;
    public void eat(Peach p) {
        /*
        simply eat a peach and gain health
        */
        this.setHealth(this.health + 10);
        System.out.println(this + " has gained 10 health");
    }
    @Override
    public void interact(Player p){
            /*
            interact with a player
            stealing a peach
             */
            eat(p.getPeach());
            System.out.println("This player has stolen a peach");
    }

    public void steal(Player p){
        Random rand = new Random();
        probs = rand.nextDouble() < 0.75;
            if (probs) {
                System.out.println(this + " is stealing from player " + p);
                interact(p);
                steal(p);
            }
        }
    }
