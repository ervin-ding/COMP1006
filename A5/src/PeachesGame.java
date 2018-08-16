import java.util.ArrayList;
import java.util.List;

public class PeachesGame{

  public static List<Peach> generatePeaches(int numberOfPeaches){
    List<Peach> peaches = new ArrayList<>();
    for (int i = 0; i < numberOfPeaches; i += 1) {
      peaches.add(new Peach(10, false));
    }
    return peaches;
  }

  public static void main(String[] args) {
    World w = new World();
    PitFinder pitFinder = new PitFinder(w, "PitFinder", w.home, generatePeaches(5), 100, RGB.YELLOW);
    PeachThief peachThief = new PeachThief(w, "PeachThief", w.home, new ArrayList<Peach>(), 100, RGB.BLUE);
    PeachHunter peachHunter = new PeachHunter(w, "PeachHunter", w.home, generatePeaches(10), 100, RGB.RED);

    w.addPlayer(pitFinder).addPlayer(peachThief).addPlayer(peachHunter);

    Home home = new Home(w.locations[0][0].getPosition(), "Home", w.getPlayers(), new ArrayList<Peach>());
    PeachGrove peachGrove = new PeachGrove(w.locations[1][1].getPosition(), "PeachGrove", w.getPlayers(), new ArrayList<Peach>());
    PeachPit peachPit = new PeachPit(w.locations[1][2].getPosition(), "PeachPit", w.getPlayers(), generatePeaches(50));
    BearsDen bearsDen = new BearsDen(w.locations[2][2].getPosition(), "Bear's Den", w.getPlayers(), new ArrayList<Peach>());
    w.locations[0][0] = home;
    w.home=home;
    w.locations[1][1] = peachPit;
    w.locations[0][1] = peachGrove;
    w.locations[1][0] = bearsDen;
    System.out.println(w.getHome());
    System.out.println(w.getLocations());

    while (w.getHome().numberOfPeaches() < 100) {
      // iterate over all locations in the world
      System.out.println("peaches at home: " + w.getHome().getPeaches());
      for (Location location : w.getLocations()) {
        // iterate over all players in the current location
          for (int i = 0; i < location.getPlayers().size(); i += 1) {
            if (location.getPlayers() != null) {
              Player player = location.getPlayers().get(i);
              System.out.println(player.getName() + ", " + player.getLocation());
              player.play();
            }
          }
        }
      }
      System.out.println(w.getHome().numberOfPeaches());
      System.out.println("WIN WIN WIN");
    }
}