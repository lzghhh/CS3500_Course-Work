package listadt;

import java.util.Objects;
import java.util.function.Function;

/**
 * This class is for containing a mutable list that implement the MutableListADT interface.
 * @param <T> The type of data contains.
 */
public class MutableListADTImpl<T> implements MutableListADT<T> {
  private ListADT<T> delegate;

  /**
   * The constructor that contains an empty list.
   */
  public MutableListADTImpl() {
    this(new ListADTImpl<>());
  }

  /**
   * The constructor for creating a list that using a delegate of ListADT.
   * @param delegate The input real list that contains information.
   */
  public MutableListADTImpl(ListADT<T> delegate) {
    this.delegate = Objects.requireNonNull(delegate);
  }

  @Override
  public <R> CommonListADT<R> map(Function<T, R> converter) {
    return this.delegate.map(converter);
  }

  @Override
  public int getSize() {
    return this.delegate.getSize();
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    return this.delegate.get(index);
  }

  @Override
  public void addFront(T b) {
    this.delegate.addFront(b);
  }

  @Override
  public void addBack(T b) {
    this.delegate.addBack(b);
  }

  @Override
  public void add(int index, T b) {
    this.delegate.add(index, b);
  }

  @Override
  public void remove(T b) {
    this.remove(b);
  }

  @Override
  public ImmutableListADT<T> getImmutableList() {
    ImmutableListADTImpl<T> list = new ImmutableListADTImpl<>(delegate);
    return list;
  }
}
