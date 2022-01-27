package betterpizza;

import java.util.HashMap;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * An abstract generic class that functions as the main builder that sets up all fields for all the
 * other sub-builders.
 * @param <T> The built pizza.
 */

public abstract class PizzaBuilder<T extends PizzaBuilder<T>> {
  protected Crust crust;
  protected Size size;
  protected HashMap<ToppingName, ToppingPortion> toppings;

  PizzaBuilder() {
    this.crust = null;
    this.size = null;
    this.toppings = new HashMap<>();
  }

  public T crust(Crust crust) {
    this.crust = crust;
    return returnBuilder();
  }

  public T size(Size size) {
    this.size = size;
    return returnBuilder();
  }

  public T addTopping(ToppingName name, ToppingPortion portion) {
    this.toppings.put(name,portion);
    return returnBuilder();
  }

  public abstract ObservablePizza build() throws IllegalStateException;

  protected abstract T returnBuilder();
}
