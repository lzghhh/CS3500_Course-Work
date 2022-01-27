import java.util.List;

/**
 * Represents an individual airplane flight, as operated by an airline such as {@link Epsilon}.
 * Flights maintain identifying information, such as flight numbers, departure and arrival
 * airports, and seating availability.
 */
public interface Flight { 
  /**
   * Every flight has an identification number, correlating with its scheduled route,
   * so airlines can keep track of how popular each route is.
   * @return The identification number for this flight
   */
  int getFlightNumber();

  /**
   * Every flight has a departure and arrival city.
   * @return The airport code (e.g. "BOS", "JFK") of the departure city
   */
  String getFromAirport();

  /**
   * Every flight has a departure and arrival city.
   * @return The airport code (e.g. "SEA", "LGA") of the arrival city
   */
  String getToAirport();

  /**
   * Every flight has a maximum number of passengers it can seat.
   * (This value is fixed for each flight.)
   *
   * @return How many seats exist on this flight.
   */
  int getCapacity();

  /**
   * Every flight keep track of how many seats have been reserved, and how many remain.
   * @return How many seats are currently available for reservation on this flight
   */
  int getNumAvailableSeats();

  /**
   * When customers attempt to purchase seats, they may fly in groups of one or more people.
   * When attempting to make a reservation for multiple people, either everyone in the party
   * should be able to obtain a seat, or the entire reservation attempt should not succeed.
   *
   * @param names The names of the passengers
   * @return A {@link Reservation} containing all the information for this party of passengers
   * @throws IllegalStateException If there are no passengers, or this request
   *                               cannot be accommodated.
   */
  Reservation reserveSeats(List<String> names) throws IllegalStateException;

  /**
   * Regrettably, some passengers have to cancel their tickets.
   * This method cancels the seats for everyone in the provided {@link Reservation}
   * @param r The reservation information to be canceled
   */
  void cancelReservation(Reservation r);

  String getConfirmationStatus(Reservation r);

  /**
   * Constructs a duplicate of this Flight.
   * @return A new Flight with the same fields as this one
   */
  Flight copy();
}
