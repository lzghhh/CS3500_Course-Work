package listadt;

/**
 * This interface is to represent a mutable list that extends from ListADT with the
 * characteristic of being mutable.
 * @param <T> The type the list contains.
 */
public interface MutableListADT<T> extends ListADT<T> {
  /**
   * This method is to create an immutable list basing on the current mutable list.
   * @return A mutable list with current elements.
   */
  ImmutableListADT<T> getImmutableList();
}
