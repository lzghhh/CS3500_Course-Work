package betterpizza;

import java.util.HashMap;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a veggie pizza that extends the AlaCartePiiza and build a veggie pizza
 * that can be customized.
 */

public class VeggiePizza extends AlaCartePizza {

  public VeggiePizza(Size size, Crust crust, HashMap<ToppingName,ToppingPortion> toppings) {
    super(size, crust, toppings);
  }

  /**
   * This is the subclass of VeggiePizza that is used for building a veggie pizza with default
   * setting while these setting can be customized.
   */

  public static class VeggiePizzaBuilder extends PizzaBuilder<VeggiePizzaBuilder> {

    /**
     * This is the builder method of the Veggie pizza that takes super fields from the AlaCartePizza
     * and has it own toppings with customized options in it.
     */

    public VeggiePizzaBuilder() {
      super();
      super.toppings.put(ToppingName.Cheese, ToppingPortion.Full);
      super.toppings.put(ToppingName.Sauce, ToppingPortion.Full);
      super.toppings.put(ToppingName.BlackOlive,ToppingPortion.Full);
      super.toppings.put(ToppingName.GreenPepper,ToppingPortion.Full);
      super.toppings.put(ToppingName.Onion,ToppingPortion.Full);
      super.toppings.put(ToppingName.Jalapeno,ToppingPortion.Full);
      super.toppings.put(ToppingName.Tomato,ToppingPortion.Full);
    }

    public VeggiePizzaBuilder noCheese() {
      super.toppings.remove(ToppingName.Cheese);
      return this;
    }

    public VeggiePizzaBuilder noSauce() {
      super.toppings.remove(ToppingName.Sauce);
      return this;
    }

    public VeggiePizzaBuilder noBlackOlive() {
      super.toppings.remove(ToppingName.BlackOlive);
      return this;
    }

    public VeggiePizzaBuilder noGreenPepper() {
      super.toppings.remove(ToppingName.GreenPepper);
      return this;
    }

    public VeggiePizzaBuilder noOnion() {
      super.toppings.remove(ToppingName.Onion);
      return this;
    }

    public VeggiePizzaBuilder noJalapeno() {
      super.toppings.remove(ToppingName.Jalapeno);
      return this;
    }

    public VeggiePizzaBuilder noTomato() {
      super.toppings.remove(ToppingName.Tomato);
      return this;
    }

    @Override
    public VeggiePizza build() {
      if (this.size == null || this.crust == null) {
        throw new IllegalStateException("Missing size or crust");
      } else {
        return new betterpizza.VeggiePizza(this.size,this.crust, this.toppings);
      }
    }

    @Override
    protected VeggiePizzaBuilder returnBuilder() {
      return this;
    }
  }
}
