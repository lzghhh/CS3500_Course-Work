import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;


/**
 * This is the test class for the SimpleThermostat class.
 */

public class SimpleThermostatTest {
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
  public void setUp() {
    temp = new SimpleThermostat("ab123", 23.001);
    temp1 = new SimpleThermostat("ab123", 23);
    temp2 = new SimpleThermostat("cs3500", 39.27299100000001);
    temp3 = new SimpleThermostat("cshhh", 39.25731);
    temp4 = new SimpleThermostat("cshhh", 39.261);
    temp5 = new SimpleThermostat("cshhh", 39.2755);
    temp6 = new SimpleThermostat("cs", 39.2755);
    temp7 = new SimpleThermostat("cs", 39.2745);
    temp8 = new SimpleThermostat("cs", 39.2765);
    temp9 = new SimpleThermostat("cs", 49.99);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSimplestatNullIDError() {
    new SimpleThermostat("", 23);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSimplestatLargeTemperatureError() {
    new SimpleThermostat("abc", 51);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSimplestatBothError() {
    new SimpleThermostat("", 51);
  }

  @Test
  public void getIDNormal() {
    assertEquals("ab123",temp.getID());
  }

  @Test
  public void getIDSame() {
    assertEquals("ab123",temp1.getID());
  }

  @Test
  public void getIDDifferent() {
    assertEquals("cs3500",temp2.getID());
  }

  @Test
  public void getSetTemperatureDecimal() {
    assertEquals(296.151,temp.getSetTemperature(), 0.000000001);
  }

  @Test
  public void getSetTemperatureInteger() {
    assertEquals(296.15,temp1.getSetTemperature(), 0.000000001);
  }

  @Test
  public void getSetTemperatureLongDecimal() {
    assertEquals(312.40731,temp3.getSetTemperature(), 0.0000000000000001);
  }

  @Test
  public void increaseSetTemperatureNormal() {
    temp.increaseSetTemperature();
    assertEquals(296.251,temp.getSetTemperature(), 0.0000000001);
  }

  @Test
  public void increaseSetTemperatureInteger() {
    temp1.increaseSetTemperature();
    assertEquals(296.25,temp1.getSetTemperature(), 0.0000000001);
  }

  @Test
  public void increaseSetTemperatureLongDecimal() {
    temp3.increaseSetTemperature();
    assertEquals(312.50731,temp3.getSetTemperature(), 0.001);
  }

  @Test
  public void increaseSetTemperatureNormalDoubleIncrease() {
    temp.increaseSetTemperature();
    temp.increaseSetTemperature();
    assertEquals(296.351,temp.getSetTemperature(), 0.0001);
  }

  @Test
  public void increaseSetTemperatureFail() {
    temp9.increaseSetTemperature();
    assertEquals(323.13,temp.getSetTemperature(), 0.0001);
  }

  @Test
  public void decreaseSetTemperatureNormal() {
    temp.decreaseSetTemperature();
    assertEquals(296.051,temp.getSetTemperature(),0.0000001);
  }

  @Test
  public void decreaseSetTemperatureLongDecimal() {
    temp3.decreaseSetTemperature();
    assertEquals(312.30731,temp3.getSetTemperature(),0.0000001);
  }

  @Test
  public void hashcodeTestTrue() {
    int t1 = temp.hashCode();
    int t2 = temp1.hashCode();
    boolean result = temp.hashCode() == temp1.hashCode();
    assertTrue(result);
  }

  @Test
  public void hashcodeTestTrueCloseRound() {
    int t1 = temp3.hashCode();
    int t2 = temp4.hashCode();
    boolean result = temp3.hashCode() == temp4.hashCode();
    assertTrue(result);
  }

  @Test
  public void hashcodeTestFalseBoth() {
    int t1 = temp2.hashCode();
    int t2 = temp3.hashCode();
    boolean result = temp2.hashCode() == temp3.hashCode();
    assertFalse(result);
  }

  @Test
  public void hashcodeTestFalseSingleTemperature() {
    int t1 = temp4.hashCode();
    int t2 = temp5.hashCode();
    boolean result = temp4.hashCode() == temp5.hashCode();
    assertFalse(result);
  }

  @Test
  public void hashcodeTestFalseSingleTemperatureRound() {
    int t1 = temp6.hashCode();
    int t2 = temp7.hashCode();
    boolean result = temp6.hashCode() == temp7.hashCode();
    assertFalse(result);
  }

  @Test
  public void hashcodeTestFalseSingleID() {
    int t1 = temp5.hashCode();
    int t2 = temp6.hashCode();
    boolean result = temp5.hashCode() == temp6.hashCode();
    assertFalse(result);
  }

  @Test
  public void testEqualsNormalDecimal() {
    boolean result = temp.equals(temp1);
    assertTrue(result);
  }

  @Test
  public void testEqualsNormalRoundup() {
    boolean result = temp6.equals(temp8);
    assertTrue(result);
  }

  @Test
  public void testEqualsFalseTemperature() {
    boolean result = temp5.equals(temp6);
    assertFalse(result);
  }

  @Test
  public void testEqualsFalseID() {
    boolean result = temp7.equals(temp8);
    assertFalse(result);
  }

  @Test
  public void testEqualsSelf() {
    boolean result = temp7.equals(temp7);
    assertTrue(result);
  }

  @Test
  public void testEqualsWrongClass() {
    boolean result = temp7.equals("");
    assertFalse(result);
  }
}