import java.util.ArrayList;
import java.util.List;

public class PeachPit extends Location {
    protected List<Player> playersVisited;

    public PeachPit(Position p, String description, List<Player> people, List<Peach> peaches) {
        super(p, description, people, peaches);
        playersVisited = new ArrayList<>();
    }

    @Override
    public void enter(Player p) {
        p.setLocation(this);
        peopleAtLocation.add(p);
        /* player goes to this location
        add each player to the list of players
        once entered, player's health is halved
        it remembers the num. of times fallen */
        if (playersVisited.contains(p)){
            p.setLocation(p.getWorld().getHome());
            p.setHealth(p.health /2);
            System.out.println(p + " has fallen to the pit and has been sent back home!");
            return;
        }

        //regardless health is halved
        else{
            p.setHealth(p.health /2);
            System.out.println( p + " has fallen to the pit! ");
        }

        // first player to fall into the pit and survive can grab all of the peaches
        int peachSize = peachesAtLocation.size();
        if (!peachesAtLocation.isEmpty()) {
            System.out.println(p + " is now taking the peaches in the pit!");
            for (int i = 0; i< peachSize; i++) {
                p.peaches.add(peachesAtLocation.get(i));
            }
        }
        playersVisited.add(p);
    }

}
