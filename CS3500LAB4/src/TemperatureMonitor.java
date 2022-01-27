import java.util.List;

/**
 * This is an interface that monitors different thermal status that contains many statuses.
 */
public interface TemperatureMonitor {

  void add(Thermostat t);

  void remove(Thermostat t);

  int getNumberOfThermostats();

  boolean tooMuchHeating();

  List<Thermostat> getList();

}
