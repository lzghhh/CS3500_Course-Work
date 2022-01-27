import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a temperature monitor. It tracks several thermostats, and specifically
 * monitors how many of them have been set to too hot.
 */

public class NaiveTemperatureMonitor implements TemperatureMonitor {
  private final List<Thermostat> thermostatList;


  public NaiveTemperatureMonitor() {
    this.thermostatList = new ArrayList<Thermostat>();
  }

  @Override
  public void add(Thermostat t) {
    boolean hasSame = false;
    if (this.thermostatList.size() == 0 ) {
      this.thermostatList.add(t);
    } else {
      for (int i = 0; i < this.thermostatList.size();i++) {
        hasSame = (hasSame || t == this.thermostatList.get(i));
      }
      if (!hasSame) {
        this.thermostatList.add(t);
      }
    }
  }

  @Override
  public void remove(Thermostat t) {
    thermostatList.remove(t);
  }

  @Override
  public int getNumberOfThermostats() {
    return thermostatList.size();
  }

  @Override
  public List<Thermostat> getList() {
    return thermostatList;
  }

  @Override
  public boolean tooMuchHeating() {
    int count = 0;
    for (Thermostat t: thermostatList) {
      if (t.getSetTemperature() > 23 + 273.15) {
        count += 1;
      }
    }
    return count > 1;
  }
}
