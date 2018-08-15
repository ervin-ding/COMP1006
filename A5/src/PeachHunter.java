import java.util.ArrayList;
import java.util.List;

public class PeachHunter extends Player {
    /**
     *  A PeachHunter searches for peaches to bring back to the home location. A peach hunter can carry lots
     * of peaches (as many as 100). The peach hunter should return to home to deposit its peaches once they have
     * 50 or more peaches. -A peach hunter will remember where peach groves are when they find them- and go back
     * to them to get more peaches until the grove runs out. If a hunter's health is less than 50 then it can only carry
     * 25 peaches. It must then put any excess peaches in the current location if this happens.
     * */
    protected int maxPeaches;
    protected boolean healthBelowFifty;
    protected List<Location> peachGroves;
    protected List <Location> peachPits;
    public PeachHunter(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb) {
        super(w, name, location, peaches, health, rgb);
        maxPeaches = 100;
        healthBelowFifty = false;
        peachGroves = new ArrayList<>();
        peachPits = new ArrayList<>();
    }

    public void addPeachPit(Location location){
        peachPits.add(location);
    }
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
        if (location instanceof PeachGrove) {
           // isPeachGrove = true;
            if (!peachGroves.contains(location)) {
                peachGroves.add(location);
                System.out.println("This PeachGrove has been added to " + this + "\'s lists of PeachGroves");
            }
        }
        
        // grab peaches
        if (location.numberOfPeaches() > 0 && (location instanceof PeachGrove)) {
            while (peaches.size() < maxPeaches && location.numberOfPeaches() > 0) {
                peaches.add(location.getPeach());
                System.out.println(this + " grabbed " + peaches.size() + " peaches from " + location + ". Peaches left: " + location.numberOfPeaches());
            }
        }

        if (!healthBelowFifty && (!location.equals(getWorld().getHome()))) {
            if (peaches.size() >= 50 && location.numberOfPeaches() > 0) {
                goHomeAndReturnToPeachGrove();
            }
            else if (location instanceof PeachGrove){
                getLocation().exit(this);
                getWorld().getHome().enter(this);
            }
        }
        else if (healthBelowFifty && (!location.equals(getWorld().getHome()))) {
            if (peaches.size() == 25 && location.numberOfPeaches() > 0) {
                goHomeAndReturnToPeachGrove();
            }
            else if (location instanceof PeachGrove) {
                getLocation().exit(this);
                getWorld().getHome().enter(this);
            }

        }
    }
    protected void goHomeAndReturnToPeachGrove() {
        getLocation().exit(this);
        getWorld().getHome().enter(this);
        //drop all peaches at home
        while (peaches.size() > 0){
            location.addPeach(peaches.remove(0));
            System.out.println(this + " dropped " + peaches.size() + " peaches Home" /*+this.getWorld().getHome()*/);
        }
        //go back to a peachgrove if peaches are left.
        if (health > 0){
            for (int i = 0; i < peachGroves.size(); i += 1) {
                if (peachGroves.get(i).numberOfPeaches() > 0) {
                    getLocation().exit(this);
                    peachGroves.get(i).enter(this);
                }
            }
        }
        else {
            getLocation().exit(this);
            getWorld().getHome().enter(this);
        }
    }

    @Override //Check for if less than 50, drop peaches until 25 peaches
    public void setHealth(int h){
        this.health = h;
        if (health < 50){
            if (peaches.size() > 25) {
                System.out.println("Dropping "+ (peaches.size()-25) + " peaches at " +getLocation() );
                while (peaches.size() > 25) {
                    location.addPeach(peaches.remove(0));
                }
            }
        }
    }




}
