/**
 * This is an interface that represents a thermal status that also have methods in it.
 */
public interface Thermostat {
  String getID();

  double getSetTemperature();

  void increaseSetTemperature();

  void decreaseSetTemperature();

}
