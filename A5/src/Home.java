import java.util.*;

public class Home extends Location {
    protected ArrayList<Location> pitHome; // used to keep track of who has been in the pit;
    protected Map<Player, ArrayList<Peach>> peaches; // used to keep track of peaches at the Home location

    public Home(Position p, String description, List<Player> people, List<Peach> peaches){
        super(p,description, people, peaches);
        this.peaches = new HashMap<Player, ArrayList<Peach>>();
        pitHome = new ArrayList<>();
    }

    public void addPeachPit(Location location){
        pitHome.add(location);
    }
    /** getter for peaches stored at Home location for all players */
    public Map<Player, ArrayList<Peach>> getPeaches(){ return peaches; }

    /** getter for peaches stored at Home location for a specific player */
    public ArrayList<Peach> getPeaches(Player p){
        if (!peaches.containsKey(p)) {return new ArrayList<>();}
        return peaches.get(p);
    }

    /** When a player calls the getHelp method, this method instantiates a new helper, sends them to that player's
     * location, and gives the player 10 ripe peaches. The helper then returns to Home, where they remain.
     * @param p the player who calls the getHelp method
     * @param l that player's current location
     */
    @Override
    public void callForHelp(Player p, Location l){
        Helper helper = new Helper(p.getWorld(),null, p.getWorld().getHome(), new ArrayList<Peach>(), 1000000, null);
        for (int i = 0; i < 10; i++) { // instantiate 10 good peaches with varying levels of ripeness
            helper.peaches.add(new Peach(new Random().nextInt(10) + 1, false));
        }
        helper.getLocation().exit(helper);
        l.enter(helper);
        helper.interact(p); // give the 10 ripe peaches to the player in distress
        helper.getLocation().exit(helper);
        this.enter(helper);
    }

}
