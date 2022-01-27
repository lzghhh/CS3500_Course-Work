package listadt;

import java.util.Objects;
import java.util.function.Function;

/**
 * This is a class for representing an immutable list that implements the ImmutableListADT.
 * @param <T> The type this list contains.
 */
public class ImmutableListADTImpl<T> implements ImmutableListADT<T> {
  private ListADT<T> delegate;

  /**
   * This is the constructor for ImmutableListADT class that will construct an empty ListADTImpl
   * and pass it to another constructor.
   */
  public ImmutableListADTImpl() {
    this(new ListADTImpl<T>());
  }

  /**
   * The constructor that takes in a delegate as ListADT as the container of the elements but
   * keeps it immutable.
   * @param delegate The list that contains all the element information.
   */
  public ImmutableListADTImpl(ListADT<T> delegate) {
    this.delegate = Objects.requireNonNull(delegate);
  }

  @Override
  public <R> CommonListADT<R> map(Function<T, R> converter) {
    return null;
  }

  @Override
  public int getSize() {
    return delegate.getSize();
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    return delegate.get(index);
  }

  @Override
  public MutableListADT<T> getMutableList() {
    return null;
  }

  /**
   * This is a method for adding a new item to the Immutable list for builder.
   * @param object The added item.
   * @return The new immutable list with added item.
   */
  private ImmutableListADTImpl<T> addBack(T object) {
    this.delegate.addBack(object);
    return this;
  }

  /**
   * This class is to construct an immutable list that can be only built once.
   * @param <T> The type that is contained in the list.
   */
  public static class Builder<T> {
    ListADT<T> list;

    /**
     * This is the method to add an element to the builder with the addBack method on the
     * ImmutableListADTImpl.
     * @param object The added item.
     * @return The builder itself.
     */
    public Builder addBack(T object) {
      list.addBack(object);
      return this;
    }

    /**
     * This method is to create a finalized immutable list.
     * @return The Immutable List.
     */
    public ImmutableListADTImpl build() {
      return new ImmutableListADTImpl(list);
    }
  }
}
