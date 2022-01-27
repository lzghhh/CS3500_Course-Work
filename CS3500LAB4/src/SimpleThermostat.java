import java.util.Objects;

/**
 * This class represents a Thermal status that constructs a Temperature with a unique ID.
 */
public class SimpleThermostat implements Thermostat {
  String iD;
  double celsiusTemperature;

  /**
   * This is the constructor for this class that takes a unique ID and a Temperature in celsius.
   * @param iD The unique ID of this thermal status.
   * @param celsiusTemperature The temperature on this thermal status.
   */
  public SimpleThermostat(String iD, double celsiusTemperature) {
    if (iD.equals("")  || celsiusTemperature > 50) {
      throw new IllegalArgumentException("Invalid input.");
    }
    this.iD = iD;
    this.celsiusTemperature = celsiusTemperature;
  }

  @Override
  public String getID() {
    return this.iD;
  }

  @Override
  public double getSetTemperature() {
    return this.celsiusTemperature + 273.15;
  }

  @Override
  public void increaseSetTemperature() {
    if (this.celsiusTemperature + 0.1 < 50) {
      this.celsiusTemperature += 0.1;
    }
  }

  @Override
  public void decreaseSetTemperature() {
    this.celsiusTemperature -= 0.1;
  }
  //  @Override
  //  public boolean equals(Object o) {
  //    if (o == null ) throw new IllegalArgumentException("hhh");
  //    if (this == o) return true;
  //    if (getClass() != o.getClass()) return false;
  //    SimpleThermostat newOne = (SimpleThermostat) o;
  //    return (Math.abs(((SimpleThermostat) o).celsiusTemperature - newOne.celsiusTemperature)
  //    < 0.01)
  //            && iD == iD;
  //  }
  //
  //  @Override
  //  public int hashCode() {
  //    return Objects.hash(getID(),getSetTemperature());
  // }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleThermostat newOne = (SimpleThermostat) o;
    //    String actoNum = ((SimpleThermostat) o).getSetTemperature() + "";
    //    String actnewOneNum = ((SimpleThermostat) newOne).getSetTemperature() + "";
    //    BigDecimal oNewNum = new BigDecimal(actoNum);
    //    BigDecimal newOneNewNum = new BigDecimal(actnewOneNum);
    //    double oResult = oNewNum.setScale(2, BigDecimal.ROUND_UP).doubleValue();
    //    System.out.println(oResult + "o");
    //    double newOneResult = newOneNewNum.setScale(2, BigDecimal.ROUND_UP).doubleValue();
    //    System.out.println(newOneResult + "newOne");`
    double thisResult = Math.round(this.celsiusTemperature * 100.00) / 100.00;
    double newOneResult = Math.round(newOne.celsiusTemperature * 100.00) / 100.00;
    return (thisResult == newOneResult)
            && iD == newOne.getID();
  }

  @Override
  public int hashCode() {
    double newOneResult = Math.round((this.celsiusTemperature) * 100.00) / 100.00;
    return Objects.hash(getID(),newOneResult);
  }
}
