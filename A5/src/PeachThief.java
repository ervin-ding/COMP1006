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
    private boolean didSteal;
    public PeachThief(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb) {
        super(w, name, location, peaches, health, rgb);

    }

    @Override
    public void setLocation(Location location){
        this.location = location;
        Player target = null;
        for (int i = 0; i < location.getPlayers().size(); i += 1) {
            if (location.getPlayers().get(i) instanceof PeachHunter || location.getPlayers().get(i) instanceof PitFinder) {
                target = location.getPlayers().get(i);
            }
        }
        if (target != null) {
            steal(target);
        }
        //pick up peaches
        if (location.numberOfPeaches() > 0){
            for (int i = 0; i < 5; i+=1){
                this.peaches.add(location.getPeach());
                if (location.numberOfPeaches() == 0) {
                    break;
                }
            }
        }
    }

    protected boolean probability;
    public void eat(Peach peach) {
        /*
        simply eat a peach and gain health
        */
        int peachRipeness = peach.getRipeness();
        setHealth(getHealth() + peachRipeness);
        System.out.println(this + " has gained " + peachRipeness + " health from the stolen peach" );
    }
    @Override
    public void interact(Player p) {
            /*
            interact with a player
            stealing a peach
             */
            didSteal = false;
        if (p.peaches.size() > 0) {
            eat(p.getPeach());
            System.out.println(this + " player has stolen a peach");
            didSteal = true;
        }
    }

    public void steal(Player p){
        Random rand = new Random();
        probability = rand.nextDouble() < 0.75;
            if (probability) {
                System.out.println(this + " is stealing from player " + p);
                interact(p);
                if (didSteal) {
                    steal(p);
                }
            }
        }
    }
