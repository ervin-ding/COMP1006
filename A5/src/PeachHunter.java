import java.util.ArrayList;
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
     * 50 or more peaches. -A peach hunter will remember where peach groves are when they find them- and go back
     * to them to get more peaches until the grove runs out. If a hunter's health is less than 50 then it can only carry
     * 25 peaches. It must then put any excess peaches in the current location if this happens.
     * */
    protected String descriptionOfPeachGrove = "PeachGrove";
    protected int maxPeaches;
    protected boolean healthBelowFifty;
    protected List<Location> peachGroves;
    public List <Location> peachPits;
    public PeachHunter(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb) {
        super(w, name, location, peaches, health, rgb);
        maxPeaches = 100;
        healthBelowFifty = false;
        peachGroves = new ArrayList<>();
        peachPits = new ArrayList<>();
    }

    protected boolean isPeachGrove;
    //if peaches > 50, setLocation home.
    @Override //when location is set, grab as many peaches as possible.
    public void setLocation(Location location) {
        this.location = location;
        if (health >= 50){
            maxPeaches = 100;
            healthBelowFifty = false;
        }
        else {
            maxPeaches = 25;
            healthBelowFifty = true;
        }
        //if the description of the location matches the description of a peachgrove, check if the position is already
        //in the peachGroves list. If not, add it to the list.
        if (location.getDescription().equals(descriptionOfPeachGrove)) {
           // isPeachGrove = true;
            if (!peachGroves.contains(location)) {
                peachGroves.add(location);
                System.out.println("This PeachGrove has been added to " + this + "\'s lists of PeachGroves");
            }
        }


        // grab peaches
        while (peaches.size() < maxPeaches && location.numberOfPeaches() > 0 && location != world.home) {
            peaches.add(location.getPeach());
            System.out.println(this + " grabbed " + peaches.size() + " peaches from " + location + ". Peaches left: " + location.numberOfPeaches());
        }

        if (!healthBelowFifty) {
            if (peaches.size() >= 50 && (!location.equals(world.home))) {
                goHomeAndReturnToPeachGrove();
            }
        }
        else if (healthBelowFifty && (!location.equals(world.home))){
            if (peaches.size() == 25){
                goHomeAndReturnToPeachGrove();
            }
        }
    }
    protected void goHomeAndReturnToPeachGrove() {
        if (!(location.equals(world.home))){
            this.getWorld().home.enter(this);
        }
        //drop all peaches at home
        while (peaches.size() > 0){
            location.addPeach(peaches.remove(0));
            System.out.println(this + " dropped " + peaches.size() + " peaches Home" /*+this.getWorld().getHome()*/);
        }
        //go back to a peachgrove if peaches are left.
        for (int i = 0; i < peachGroves.size(); i += 1) {
            if (peachGroves.get(i).numberOfPeaches() > 0) {
                peachGroves.get(i).enter(this);
            }
        }
    }
    @Override //Check for if less than 50, drop peaches until 25 peaches
    public void setHealth(int h){
        this.health = h;
        if (health < 50){
            while (peaches.size() > 25){
                location.addPeach(peaches.remove(0));
            }
        }
    }




}
