package betterpizza;

import java.util.HashMap;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a cheese pizza that extends the AlaCartePiiza and build a cheese pizza
 * that can be customized.
 */

public class CheesePizza extends AlaCartePizza {

  public CheesePizza(Size size, Crust crust, HashMap<ToppingName,ToppingPortion> toppings) {
    super(size, crust, toppings);
  }

  /**
   * This is the subclass of CheesePizza that is used for building a cheese pizza with default
   * setting while these setting can be customized.
   */

  public static class CheesePizzaBuilder extends PizzaBuilder<CheesePizzaBuilder> {

    /**
     * This is the builder method of the Cheese pizza that takes super fields from the AlaCartePizza
     * and has it own toppings with customized options in it.
     */

    public CheesePizzaBuilder() {
      super();
      super.toppings.put(ToppingName.Cheese, ToppingPortion.Full);
      super.toppings.put(ToppingName.Sauce, ToppingPortion.Full);
    }

    @Override
    public CheesePizza build() {
      if (this.size == null || this.crust == null) {
        throw new IllegalStateException("Missing size or crust");
      } else {
        return new betterpizza.CheesePizza(this.size,this.crust, this.toppings);
      }
    }

    /**
     * This method is to set uo a no cheese customized cheese pizza.
     * @return A no cheese pizza as builder field.
     */

    public CheesePizzaBuilder noCheese() {
      super.toppings.remove(ToppingName.Cheese);
      return this;
    }

    /**
     * This method is to set uo a no cheese customized cheese pizza.
     * @return A no cheese pizza as builder field.
     */

    public CheesePizzaBuilder noSauce() {
      super.toppings.remove(ToppingName.Sauce);
      return this;
    }

    /**
     * This method is to set uo a left-half cheese customized cheese pizza.
     * @return A left-half cheese pizza as builder field.
     */

    public CheesePizzaBuilder leftHalfCheese() {
      super.toppings.remove(ToppingName.Cheese);
      super.toppings.put(ToppingName.Cheese, ToppingPortion.LeftHalf);
      return this;
    }

    /**
     * This method is to set uo a right-half cheese customized cheese pizza.
     * @return A right-half cheese pizza as builder field.
     */

    public CheesePizzaBuilder rightHalfCheese() {
      super.toppings.remove(ToppingName.Cheese);
      super.toppings.put(ToppingName.Cheese, ToppingPortion.RightHalf);
      return this;
    }

    @Override
    protected CheesePizzaBuilder returnBuilder() {
      return this;
    }
  }
}
