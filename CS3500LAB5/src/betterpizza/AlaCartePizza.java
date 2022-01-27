package betterpizza;

import java.util.HashMap;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents an ala carte pizza (i.e. a pizza that can
 * have an arbitrary number of ingredients.
 */
public class AlaCartePizza implements ObservablePizza {
  protected Crust crust;
  protected Size size;
  protected HashMap<ToppingName, ToppingPortion> toppings;

  /**
   * Create a pizza given its crust type, size and toppings.
   */
  public AlaCartePizza(Size size, Crust crust) {
    this.crust = crust;
    this.size = size;
    this.toppings = new HashMap<ToppingName, ToppingPortion>();
  }

  protected  AlaCartePizza(Size size, Crust crust,HashMap<ToppingName,ToppingPortion> toppings) {
    if (size == null || crust == null || toppings == null) {
      throw new IllegalArgumentException("either of the parameters are null");
    }
    this.size = size;
    this.crust = crust;
    this.toppings = toppings;
  }

  @Override
  public ToppingPortion hasTopping(ToppingName name) {
    return this.toppings.getOrDefault(name, null);
  }

  @Override
  public double cost() {
    double cost = 0.0;
    for (HashMap.Entry<ToppingName, ToppingPortion> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultiplier();
    }
    return cost + this.size.getBaseCost();
  }

  /**
   * This class is the subclass of AlaCartePizza that is used to giver options to the users for
   * input and build the pizza. It extends methods from the Abstract generic class PizzaBuilder.
   */

  public static class AlaCartePizzaBuilder extends PizzaBuilder<AlaCartePizzaBuilder> {
    public AlaCartePizzaBuilder() {
      super();
    }

    @Override
    public AlaCartePizza build() {
      if (this.size == null || this.crust == null) {
        throw new IllegalStateException("Missing size or crust");
      } else {
        return new betterpizza.AlaCartePizza(this.size,this.crust,this.toppings);
      }
    }

    @Override
    protected AlaCartePizzaBuilder returnBuilder() {
      return this;
    }

  }

}
