import java.util.LinkedList;
import java.util.List;

/**
 * A basic flight maintains a <i>flight manifest</i> of the names of its passengers,
 * along with where the flight is going, and how many seats remain available.
 */
public class BasicFlight implements Flight { 

  private final int flightNo;
  private final String from;
  private final String to;
  private final int capacity;
  private int availableSeats;
  private final List<String> flightManifest; /*list of all confirmed passengers*/

  /**
   * Constructs a new flight with the given information.
   * @param flightNo The flight number: should be used to uniquely identify the flight
   * @param from The departure airport (non-null)
   * @param to The arrival airport (non-null)
   * @param capacity How many seats exist on this flight (positive)
   */
  public BasicFlight(int flightNo, String from, String to, int capacity) {
    if (from == null || to == null || capacity <= 0) {
      throw new IllegalArgumentException("Invalid Flight options");
    }
    this.flightNo = flightNo;
    this.from = from;
    this.to = to;
    this.capacity = capacity;
    this.availableSeats = this.capacity;
    flightManifest = new LinkedList<String>();
  }

  private BasicFlight(BasicFlight f) {
    this.flightNo = f.flightNo;
    this.from = f.from;
    this.to = f.to;
    this.capacity = f.capacity;
    this.availableSeats = f.availableSeats;
    this.flightManifest = new LinkedList<>(f.flightManifest);
  }

  public Flight copy() { return new BasicFlight(this); }

  @Override
  public int getFlightNumber() { return flightNo; }

  @Override
  public String getFromAirport() { return from; }

  @Override
  public String getToAirport() { return to; }

  @Override
  public int getCapacity() { return capacity; }

  @Override
  public int getNumAvailableSeats() { return availableSeats; }

  @Override
  public Reservation reserveSeats(List<String> names) {
    if (names.isEmpty()) {
      throw new IllegalStateException("Cannot make a reservation for zero people");
    }
    for (String name : names) {
      reserveSeat(name);
    }

    Reservation r = new Reservation(names, this.flightNo);
    return r;
  }

  protected void reserveSeat(String name) {
    if (availableSeats <= 0) {
      throw new IllegalStateException("No space left in flight");
    }
    availableSeats--;
    flightManifest.add(name);
  }

  @Override
  public void cancelReservation(Reservation r) {
    for (String name : r.getPassengers()) {
      if (flightManifest.contains(name)) {
        flightManifest.remove(name);
        availableSeats++;
      }
    }
  }

  @Override
  public String getConfirmationStatus(Reservation r) {
    if (r.getFlightNo() == this.flightNo) {
      return "Confirmed";
    } else {
      return "Unknown reservation";
    }
  }
}
