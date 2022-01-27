import java.util.ArrayList;
import java.util.List;

/**
 * An object storing the information for a group of passengers flying together.
 */
public class Reservation { 
  private final List<String> names;
  private final int flightNo;
  private final int confirmationId;
  private static int nextId = 1;

  /**
   * Constructs a new record showing the passengers flying together on a particular flight.
   * @param names The names of the passengers in this group reservation
   * @param flightNo The flight on which they are travelling
   */
  public Reservation(List<String> names, int flightNo) {
    this.names = new ArrayList<>(names);
    this.flightNo = flightNo;
    this.confirmationId = nextId;
    nextId++;
  }

  /**
   * Every reservation is associated with a collection of passengers.
   * @return The list of passengers involved in this reservation
   */
  public List<String> getPassengers() {
    return names;
  }

  /**
   * Every reservation is associated with a particular flight.
   * @return The flight number of the flight
   */
  public int getFlightNo() { return flightNo; }

  /**
   * Every reservation has a unique confirmation code.
   * @return This reservation's confirmation code.
   */
  public int getConfirmationId() { return confirmationId; }
}
