import java.util.ArrayList;
import java.util.List;

public class PeachGrove extends Location{
    protected List<List<Peach>> peachTrees;
    protected List<Player> playersThatVisited;
    public PeachGrove(Position p, String description, List<Player> people, List<Peach> peaches){
        super(p, description, people, peaches);
        peachTrees = new ArrayList<>();
        playersThatVisited = new ArrayList<>();
        int numOfTrees = 5 + (int) (Math.random() * 5);
        int numOfPeachesInTree = 5 + (int) (Math.random() * 5);

        for (int i = 0; i < numOfTrees; i+=1){
            List<Peach> peachTree = new ArrayList<>();
            for (int e = 0; e < numOfPeachesInTree; e+=1){
                Peach peach = new Peach(10,false);
                peachTree.add(peach);
                peaches.add(peach);
            }
            peachTrees.add(peachTree);
        }
    }
    //Generate peach trees.. list of lists of peaches.



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
                counter += 1;
                if (Math.random() > 0.5) {
                    p.setHealth(p.getHealth() - (5));
                    System.out.println(p.getName() + " got stung " + counter + " times and has " + p.getHealth() + " health left.");
                }

            }
        }
        System.out.println(p.getName() + " has visited " + counter + " times");
    }


    public int numberOfPeachesFromTrees(){
        List<Peach> numOfPeaches = new ArrayList<>();
        for (int i = 0; i < peachTrees.size(); i+=1) {
            for (int e = 0; e < peachTrees.get(i).size(); e += 1) {
                numOfPeaches.add(peachTrees.get(i).get(e));
            }
        }
        return numOfPeaches.size();
    }


}
