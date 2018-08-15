import java.util.ArrayList;
import java.util.List;

public class PeachGrove extends Location{
    protected List<List<Peach>> peachTrees;
    protected List<Player> playersThatVisited;
    protected List<Peach> peaches;
    public PeachGrove(Position p, String description, List<Player> people, List<Peach> peaches){
        super(p, description, people, peaches);
        peachTrees = new ArrayList<>();
        playersThatVisited = new ArrayList<>();
        int numOfTrees = 10 + (int) (Math.random() * 5); //# of trees
        int numOfPeachesInTree; //# of peaches

        for (int i = 0; i < numOfTrees; i+=1){
            List<Peach> peachTree = new ArrayList<>();
            numOfPeachesInTree = 10 + (int) (Math.random() * 5);
            for (int e = 0; e < numOfPeachesInTree; e+=1){
                Peach peach = new Peach(10,false);
                peachTree.add(peach);
                peaches.add(peach);
            }
            peachTrees.add(peachTree);
        }
    }




    //Generate bees(numberOfTimesVisited.. have a method Sting(int numberOfTimesVisited) that stings the player 50%.
    @Override
    public void enter(Player p){
        System.out.println(p.getName() + " just entered location " + description + position);
        playersThatVisited.add(p);
        peopleAtLocation.add(p);
        System.out.println("Players that visited: " + playersThatVisited.toString());
        beeSting(p);
        p.setLocation(this);
    }

    @Override
    public Peach getPeach(){
        Peach peach = peachesAtLocation.get(0);
        for (int i = 0; i < peachTrees.size(); i+=1) {
            peachTrees.get(i).remove(peach);
        }
        return peachesAtLocation.remove(0);
    }

    public void beeSting(Player p) {
        int counter = 0;
        for (int i = 0; i < playersThatVisited.size(); i += 1) {
            if (playersThatVisited.get(i).equals(p)){
                if (Math.random() > 0.5) {
                    if (p.getHealth() > 0) {
                        p.setHealth(p.getHealth() - (5));
                        counter += 1;
                    }
                    else {
                        this.exit(p);
                        p.getWorld().getHome().enter(p);
                        p.setHealth(100);
                        break;
                    }
                    System.out.println(p.getName() + " got stung " + counter + " times and has " + p.getHealth() + " health left.");
                }
            }
        }
    }

}
