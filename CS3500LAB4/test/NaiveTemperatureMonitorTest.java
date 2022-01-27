import org.junit.Before;

import org.junit.Test;

import java.util.Arrays;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;

/**
 * This is the test class for the NaiveTemperatureMonitor class.
 */

public class NaiveTemperatureMonitorTest {
  Thermostat temp;
  Thermostat temp1;
  Thermostat temp2;
  Thermostat temp3;
  Thermostat temp4;
  Thermostat temp5;
  Thermostat temp6;
  Thermostat temp7;
  Thermostat temp8;
  Thermostat temp9;

  @Before
  public void setUp() throws Exception {
    temp = new SimpleThermostat("ab123", 23.001);
    temp1 = new SimpleThermostat("ab123", 23);
    temp2 = new SimpleThermostat("cs3500", 39.27299100000001);
    temp3 = new SimpleThermostat("cshhh", 39.25731);
    temp4 = new SimpleThermostat("cshhh", 39.261);
    temp5 = new SimpleThermostat("cshhh", 39.2755);
    temp6 = new SimpleThermostat("cs", 39.2755);
    temp7 = new SimpleThermostat("cs", 39.2745);
    temp8 = new SimpleThermostat("cs", 39.2765);
    temp9 = new SimpleThermostat("cs", 23.002);
  }

  @Test
  public void addFirstOne() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    assertEquals(new ArrayList<Thermostat>(Arrays.asList(temp)), themList.getList());
  }

  @Test
  public void addMoreone() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp1);
    assertEquals(new ArrayList<Thermostat>(Arrays.asList(temp,temp1)), themList.getList());
  }

  @Test
  public void addFail() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp1);
    themList.add(temp8);
    temp8.increaseSetTemperature();
    themList.add(temp8);
    assertEquals(new ArrayList<Thermostat>(Arrays.asList(temp,temp1,temp8)), themList.getList());
  }

  @Test
  public void removeMiddle() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp1);
    themList.add(temp8);
    themList.remove(temp1);
    assertEquals(new ArrayList<Thermostat>(Arrays.asList(temp,temp8)), themList.getList());
  }

  @Test
  public void removeHead() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp1);
    themList.add(temp2);
    themList.add(temp3);
    themList.add(temp5);
    themList.remove(temp);
    assertEquals(new ArrayList<Thermostat>(Arrays.asList(temp1,temp2,temp3,temp5)),
            themList.getList());
  }

  @Test
  public void removeTail() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp1);
    themList.add(temp2);
    themList.add(temp3);
    themList.add(temp5);
    themList.remove(temp5);
    assertEquals(new ArrayList<Thermostat>(Arrays.asList(temp,temp1,temp2,temp3)),
            themList.getList());
  }

  @Test
  public void getNumberOfThermostatsDefault() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    assertEquals(0,themList.getNumberOfThermostats());
  }

  @Test
  public void getNumberOfThermostatsFirstOne() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    assertEquals(1,themList.getNumberOfThermostats());
  }

  @Test
  public void getNumberOfThermostatsFirstSecond() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp2);
    assertEquals(2,themList.getNumberOfThermostats());
  }

  @Test
  public void getNumberOfThermostatsFirstThirdFail() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp2);
    temp2.increaseSetTemperature();
    themList.add(temp2);
    assertEquals(2,themList.getNumberOfThermostats());
  }

  @Test
  public void getListDefault() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    assertEquals(new ArrayList<Thermostat>(Arrays.asList()), themList.getList());
  }

  @Test
  public void getListFirstOne() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    assertEquals(new ArrayList<Thermostat>(Arrays.asList(temp)), themList.getList());
  }

  @Test
  public void getListFirstSecondAdded() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp1);
    assertEquals(new ArrayList<Thermostat>(Arrays.asList(temp,temp1)), themList.getList());
  }

  @Test
  public void tooMuchHeatingDefault() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    assertFalse(themList.tooMuchHeating());
  }

  @Test
  public void tooMuchHeatingOneAddeed() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    assertFalse(themList.tooMuchHeating());
  }

  @Test
  public void tooMuchHeatingTrueAtHead() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp3);
    themList.add(temp1);
    themList.add(temp);
    assertTrue(themList.tooMuchHeating());
  }

  @Test
  public void tooMuchHeatingTrueAtTail() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp1);
    themList.add(temp);
    themList.add(temp3);
    assertTrue(themList.tooMuchHeating());
  }

  @Test
  public void tooMuchHeatingTrueAtMiddle() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp1);
    themList.add(temp3);
    themList.add(temp);
    assertTrue(themList.tooMuchHeating());
  }

  @Test
  public void tooMuchHeatingTrueDouble() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp1);
    themList.add(temp3);
    themList.add(temp4);
    themList.add(temp);
    assertTrue(themList.tooMuchHeating());
  }

  @Test
  public void tooMuchHeatingTrueChange() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp1);
    assertFalse(themList.tooMuchHeating());
  }

  @Test
  public void tooMuchHeatingTrueChangeTwo() {
    NaiveTemperatureMonitor themList = new NaiveTemperatureMonitor();
    themList.add(temp);
    themList.add(temp1);
    themList.add(temp9);
    assertTrue(themList.tooMuchHeating());
  }
}