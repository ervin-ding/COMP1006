import java.util.ArrayList;
import java.util.List;

public class PeachesGame{
  public static void main(String[] args) {
    World w = new World();
    PeachHunter peachHunter = new PeachHunter(w, "PeachHunter", w.home, new ArrayList<Peach>(), 50, RGB.RED);
    PeachThief peachThief = new PeachThief(w, "PeachThief", w.home, new ArrayList<Peach>(), 50, RGB.BLUE);
    PitFinder pitFinder = new PitFinder(w, "PitFinder", w.home, new ArrayList<Peach>(), 50, RGB.YELLOW);
    w.addPlayer(peachHunter).addPlayer(peachThief).addPlayer(pitFinder);

    List<Peach> peaches = new ArrayList<>();
    for (int i = 0; i < 50; i += 1) {
      peaches.add(new Peach(10, false));
    }

    Home home = new Home(w.locations[0][0].getPosition(), "Home", w.getPlayers(), new ArrayList<Peach>());
    PeachGrove peachGrove = new PeachGrove(w.locations[1][1].getPosition(), "PeachGrove", w.getPlayers(), new ArrayList<Peach>());
    PeachPit peachPit = new PeachPit(w.locations[1][2].getPosition(), "PeachPit", w.getPlayers(), peaches);
    BearsDen bearsDen = new BearsDen(w.locations[2][2].getPosition(), "Bear's Den", w.getPlayers(), new ArrayList<Peach>());
    w.locations[0][0] = home;
    w.home=home;
    w.locations[0][1] = peachGrove;
    w.locations[1][0] = peachPit;
    w.locations[1][1] = bearsDen;
    System.out.println(w.getHome());
    System.out.println(w.getLocations());


    // what the game might look like...
    while (w.getHome().numberOfPeaches() < 100) {
      // iterate over all locations in the world
      System.out.println(w.getHome().numberOfPeaches());
      System.out.println("tes1");
      for (Location location : w.getLocations()) {
        System.out.println("tes2");
        // iterate over all players in the current location
          for (int i = 0; i < location.getPlayers().size(); i += 1) {
            System.out.println("tes3");
            if (location.getPlayers() != null) {
              Player player = location.getPlayers().get(i);
              System.out.println("tes"+player.getName() + ", " + player.getLocation());
              player.play();
            }
            else {
              break;
            }
            break;
          }
          break;
        }
      }
    System.out.println(w.getHome().numberOfPeaches());
      System.out.println("SOMEONE WON");

    }
}