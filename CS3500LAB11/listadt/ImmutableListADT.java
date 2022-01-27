package listadt;

/**
 * This interface is to represent an immutable list that extends from CommonListADT with the
 * characteristic of being immutable.
 * @param <T> The type that list contains.
 */
public interface ImmutableListADT<T> extends CommonListADT<T> {
  /**
   * This method is to create a mutable list in an immutable list.
   * @return An mutable list.
   */
  MutableListADT<T> getMutableList();
}
