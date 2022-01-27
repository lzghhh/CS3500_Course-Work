import org.junit.Before;
import org.junit.Test;

import betterpizza.AlaCartePizza;
import betterpizza.CheesePizza;
import betterpizza.ObservablePizza;
import betterpizza.VeggiePizza;
import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

import static org.junit.Assert.assertEquals;

/**
 * This is the test class for the ObserbablePizza interface.
 */

public class BetterPizzaTest {
  private ObservablePizza alacarte;
  private ObservablePizza cheese;
  private ObservablePizza halfCheese;
  private ObservablePizza noCheese;
  private ObservablePizza veggie;
  private ObservablePizza noSauce;
  private ObservablePizza righHalfCheese;
  private ObservablePizza noCheeseVeggie;
  private ObservablePizza noBlackOliveVeggie;
  private ObservablePizza noTomatoVeggie;
  private ObservablePizza noCheeseandTomatoVeggie;
  private ObservablePizza noSauceandOnionVeggie;
  private ObservablePizza noSuaceandBlackOliveandJapapenoVeggie;

  @Before
  public void setup() {
    alacarte = new AlaCartePizza.AlaCartePizzaBuilder()
            .crust(Crust.Classic)
            .size(Size.Medium)
            .addTopping(ToppingName.Cheese, ToppingPortion.Full)
            .addTopping(ToppingName.Sauce,ToppingPortion.Full)
            .addTopping(ToppingName.GreenPepper,ToppingPortion.Full)
            .addTopping(ToppingName.Onion,ToppingPortion.Full)
            .addTopping(ToppingName.Jalapeno,ToppingPortion.LeftHalf)
            .build();

    cheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();

    halfCheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .leftHalfCheese()
            .build();

    noCheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .noCheese()
            .build();

    veggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Medium)
            .build();

    noSauce = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .noSauce()
            .build();

    righHalfCheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .rightHalfCheese()
            .build();

    noCheeseVeggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Medium)
            .noCheese()
            .build();

    noBlackOliveVeggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Medium)
            .noBlackOlive()
            .build();

    noTomatoVeggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Medium)
            .noTomato()
            .build();

    noCheeseandTomatoVeggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Medium)
            .noCheese()
            .noTomato()
            .build();

    noSauceandOnionVeggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Medium)
            .noSauce()
            .noOnion()
            .build();

    noSuaceandBlackOliveandJapapenoVeggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Medium)
            .noSauce()
            .noBlackOlive()
            .noJalapeno()
            .build();

  }

  @Test
  public void testCost() {
    assertEquals(8.25,this.alacarte.cost(),0.001);
    assertEquals(9,cheese.cost(),0.01);
    assertEquals(8.5,halfCheese.cost(),0.000001);
    assertEquals(8,noCheese.cost(), 0.01);
    assertEquals(9.5,veggie.cost(), 0.00001);
  }

  @Test (expected = IllegalStateException.class)
  public void testNullSizeAlaCarteBuilder() {
    ObservablePizza pizza = new AlaCartePizza.AlaCartePizzaBuilder()
            .size(Size.Large)
            .build();
  }

  @Test (expected = IllegalStateException.class)
  public void testNullCrustAlaCarteBuilder() {
    ObservablePizza pizza = new AlaCartePizza.AlaCartePizzaBuilder()
            .crust(Crust.Thin)
            .build();
  }

  @Test (expected = IllegalStateException.class)
  public void testNullBothAlaCarteBuilder() {
    ObservablePizza pizza = new AlaCartePizza.AlaCartePizzaBuilder()
            .build();
  }

  @Test (expected = IllegalStateException.class)
  public void testNullBothCheesePizzaBuilder() {
    ObservablePizza pizza = new CheesePizza.CheesePizzaBuilder()
            .build();
  }

  @Test (expected = IllegalStateException.class)
  public void testNullCrustCheesePizzaBuilder() {
    ObservablePizza pizza = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .build();
  }

  @Test (expected = IllegalStateException.class)
  public void testNullSizeCheesePizzaBuilder() {
    ObservablePizza pizza = new CheesePizza.CheesePizzaBuilder()
            .size(Size.Large)
            .build();

  }

  @Test (expected = IllegalStateException.class)
  public void testNullBothVeggiePizzaBuilder() {
    ObservablePizza pizza = new VeggiePizza.VeggiePizzaBuilder()
            .build();
  }

  @Test (expected = IllegalStateException.class)
  public void testNullCrustVeggiePizzaBuilder() {
    ObservablePizza pizza = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .build();
  }

  @Test (expected = IllegalStateException.class)
  public void testNullSizeVeggiePizzaBuilder() {
    ObservablePizza pizza = new VeggiePizza.VeggiePizzaBuilder()
            .size(Size.Large)
            .build();

  }

  @Test
  public void testHasTopping() {
    assertEquals(ToppingPortion.Full, alacarte.hasTopping(ToppingName.GreenPepper));
    assertEquals(ToppingPortion.LeftHalf, alacarte.hasTopping(ToppingName.Jalapeno));
    assertEquals(ToppingPortion.Full, cheese.hasTopping(ToppingName.Cheese));
    assertEquals(ToppingPortion.Full, cheese.hasTopping(ToppingName.Sauce));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Cheese));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Sauce));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.BlackOlive));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.GreenPepper));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Onion));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Jalapeno));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Tomato));
  }

  @Test
  public void testCustomizedOptionsCheesePizza() {
    assertEquals(null, noCheese.hasTopping(ToppingName.Cheese));
    assertEquals(null, noSauce.hasTopping(ToppingName.Sauce));
    assertEquals(ToppingPortion.LeftHalf, halfCheese.hasTopping(ToppingName.Cheese));
    assertEquals(ToppingPortion.RightHalf, righHalfCheese.hasTopping(ToppingName.Cheese));
    assertEquals(ToppingPortion.Full,noCheese.hasTopping(ToppingName.Sauce));
    assertEquals(ToppingPortion.Full,noSauce.hasTopping(ToppingName.Cheese));
  }

  @Test
  public void testCustomizedOptionsVeggiePizza() {
    assertEquals(null, noCheeseVeggie.hasTopping(ToppingName.Cheese));
    assertEquals(null, noBlackOliveVeggie.hasTopping(ToppingName.BlackOlive));
    assertEquals(null, noTomatoVeggie.hasTopping(ToppingName.Tomato));

    assertEquals(null, noCheeseandTomatoVeggie.hasTopping(ToppingName.Cheese));
    assertEquals(null, noCheeseandTomatoVeggie.hasTopping(ToppingName.Tomato));

    assertEquals(null, noSauceandOnionVeggie.hasTopping(ToppingName.Sauce));
    assertEquals(null, noSauceandOnionVeggie.hasTopping(ToppingName.Onion));

    assertEquals(null, noSuaceandBlackOliveandJapapenoVeggie
            .hasTopping(ToppingName.Sauce));
    assertEquals(null, noSuaceandBlackOliveandJapapenoVeggie
            .hasTopping(ToppingName.BlackOlive));
    assertEquals(null, noSuaceandBlackOliveandJapapenoVeggie
            .hasTopping(ToppingName.Jalapeno));
  }

}
