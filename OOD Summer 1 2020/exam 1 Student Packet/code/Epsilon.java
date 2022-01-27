import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the reservation system of Epsilon airlines. It offers operations to find
 * flights between two cities, book and cancel reservations. It also offers services like getting
 * the price and canceling a reservation using a confirmation number.
 */
public final class Epsilon { 
  private final Map<Integer, Flight> flights;
  private final Map<Integer, Reservation> reservations;

  /**
   * Creates a new airline manager.  There is nothing to configure at construction time.
   */
  public Epsilon() {
    flights = new HashMap<Integer, Flight>();
    reservations = new HashMap<Integer, Reservation>();
  }

  /**
   * Adds a new {@link Flight} to the set of flights available from Epsilon Airlines.
   * @param f The desired flight information.
   */
  public void addFlight(Flight f) {
    flights.put(f.getFlightNumber(), f.copy());
  }

  /**
   * The primary method for customers to find flights to and from desired destinations.
   * @param source The airport the customer wishes to depart from
   * @param dest   The airport the customer wants to get to
   * @return A list containing the flight numbers of all the flights matching the desired criteria.
   */
  public List<Integer> findFlights(String source, String dest) { 
    List<Integer> list = new ArrayList<>();
    for (Flight f : flights.values()) {
      if (f.getFromAirport().equals(source) && f.getToAirport().equals(dest)) {
        list.add(f.getFlightNumber());
      }
    }
    return list;
  }

  /**
   * Once a customer has found the particular flight they want, they need to reserve seats.
   * A customer can reserve several seats at once, and the reservation will either succeed
   * entirely or fail.
   * @param flightNo The desired flight number
   * @param names    The names of all the passengers
   * @return The confirmation number of the reservation that was made.
   * @throws IllegalArgumentException if the requested flight number is not known
   */
  public int reserve(int flightNo, List<String> names) throws IllegalArgumentException {
    if (!flights.containsKey(flightNo)) {
      throw new IllegalArgumentException("Flight not found");
    }

    Flight f = flights.get(flightNo);
    Reservation r = f.reserveSeats(names);
    reservations.put(r.getConfirmationId(), r);
    return r.getConfirmationId();
  }

  /**
   * Allows customers to check the status (confirmed or otherwise) of their reservation.
   * @param confirmationNo The confirmation number for their reservation
   * @return A string describing the status
   */
  public String getReservationStatus(int confirmationNo) {
    if (reservations.containsKey(confirmationNo)) {
      Reservation r = reservations.get(confirmationNo);
      Flight f = flights.get(r.getFlightNo());
      return f.getConfirmationStatus(r);
    } else {
      return "Unknown reservation";
    }
  }

  /**
   * Allows a customer to cancel their reservation.  The reservation is canceled entirely:
   * all passengers in it lose their seats.
   * @param confirmationNo The confirmation number for the reservation
   *                       (as returned by {@link Epsilon#reserve(int, List)})
   */
  public void cancel(int confirmationNo) {
    if (reservations.containsKey(confirmationNo)) {
      Reservation r = reservations.get(confirmationNo);
      Flight f = flights.get(r.getFlightNo());
      f.cancelReservation(r);
      reservations.remove(confirmationNo);
    }
  }

  /**
   * Allows customers to find out how many seats are still available on the desired flight.
   * @param flightNo The flight number to check
   * @return The number of seats currently available on that flight
   */
  public int getRemainingSeats(int flightNo) {
    if (!flights.containsKey(flightNo)) {
      throw new IllegalArgumentException("Flight not found");
    }
    return flights.get(flightNo).getNumAvailableSeats();
  }
}
