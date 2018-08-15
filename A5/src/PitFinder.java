import java.util.List;
import java.util.ArrayList;


public class PitFinder extends Player {

    protected ArrayList<Location> pitLocations;



    public PitFinder(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb) {


        super(w, name, location, peaches, health, rgb);

        pitLocations = new ArrayList<>();

        System.out.println("New PitFinder " + name + " created.");


    }

    @Override
    public void setLocation(Location location) {

        super.setLocation(location);

        if ( location instanceof PeachPit) {

            System.out.println("Player " + name + " entered a Peach Pit.");

            if(!pitLocations.contains(location)) {

                pitLocations.add(location);

                setLocation(getWorld().getHome());

                Home home = (Home) getWorld().getHome();
                home.addPeachPit(location);

                setLocation(location);

                System.out.println(getName() + " is now at home and has announced the new pit location.");



                System.out.println("Added previously undiscovered Peach Pit location to " + name + "'s list.");

            }

        }

    }

    @Override
    public void setHealth(int h) {


        this.health = h;


        if (h < 30) {

            if (this.peaches.size() > 10) {

                System.out.println(name + "'s Health is under 30. Reducing " + name + "'s peaches to 10.");

                while (this.peaches.size() > 10) {


                    location.addPeach(this.getPeach());




                }

            }


        }

    }

    @Override
    public void interact(Player p) {


        if (p instanceof PeachHunter) {

            System.out.println( name + " is interacting with a PeachHunter.");

            if (p.peaches.size() >= 5) {

                if (pitLocations.size() > 0) {

                    System.out.println(name + "Has revealed a Peach Pit location to the Peach Hunter in exchange for 5 peaches.");

                    ((PeachHunter) p).addPeachPit(pitLocations.get(0));

                    for (int i = 0; i < 5; i++) {

                        this.peaches.add(p.getPeach());



                    }

                    System.out.println(name + " has " + peaches.size() + " peaches.");
                }

            }



        }



    }



}
