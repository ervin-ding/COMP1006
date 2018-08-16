import java.util.List;
import java.util.ArrayList;



public class BearsDen extends Location {

    protected ArrayList<Player> safePlayers;
    protected ArrayList<Player> visitedPlayers;


    public BearsDen(Position p, String description, List<Player> people, List<Peach> peaches) {

        super(p, description, people, peaches);

        this.safePlayers = new ArrayList<Player>();
        this.visitedPlayers = new ArrayList<Player>();

    }

    @Override
    public String getDescription() {

        this.description = "A BearsDen has a bear in it. If a player offers a bear two or " +
                "more peaches then the bear will leave the player alone (do nothing). " +
                "If the player does not give two or more peaches to the bear then the bear " +
                "will attack the player resulting in 25 health points being deducted. The bear " +
                "will remember each player that gave it peaches and will not take peaches again " +
                "or attack that player again.";

        return this.description;

    }

    @Override
    public void enter(Player p) {

        super.enter(p);

        if (visitedPlayers.contains(p)) {

            System.out.println(p.getName() + "has returned Bears Den.");

            if (!safePlayers.contains(p)) {

                System.out.println("Current health of " + p.name + " is " + p.getHealth() + "." );

                System.out.println(p.getName() + " was not kind to the bear their last trip. The bear attacks again and their health decreases by 25.");

                p.setHealth(p.getHealth()- 25);

                System.out.println(p.getName() + " health is now " + p.getHealth());

                if (p.getHealth() <= 0) { // player has less than 0 health.
                    this.exit(p);
                    p.getWorld().getHome().enter(p);
                    p.setHealth(100);
                    System.out.println(p + " has died and been sent home, health restored");
                }

            }else{

                System.out.println(p.getName() + " was nice to the bear on their last visit. The bear does not attack.");

            }

        }else{

            bearAttack(p);
        }

        visitedPlayers.add(p);

    }

    public void bearAttack(Player p) {


        if (peopleAtLocation.size() == 0) {

            System.out.println("There are no players at the Bears Den");

        } else {

            System.out.println(p.getName() + " is visiting Bears Den for the first time.");

            if (p.peaches.size() < 2) {

                System.out.println("Current health of " + p.name + " is " + p.getHealth() + "." );

                p.setHealth(p.getHealth() - 25);

                if (p.getHealth() <= 0) { // player has less than 0 health.
                    this.exit(p);
                    p.getWorld().getHome().enter(p);
                    p.setHealth(100);
                    System.out.println(p + " has died and been sent home, health restored");
                }

                System.out.println(p.getName() + " did not offer any peaches to the bear. The bear attacks and their health decreases by 25.");
                System.out.println(p.getName() + " health is now " + p.getHealth());



            } else {

                for (int i = 0; i <= 1; i++) {

                    p.peaches.remove(0);

                    safePlayers.add(p);


                }

                System.out.println(p.getName() + "has given the bear 2 peaches. The bear does not attack and will remember them if they return");
                System.out.println(p.getName() + "now has" + p.peaches.size() +" peaches.");

            }

        }

    }


}
