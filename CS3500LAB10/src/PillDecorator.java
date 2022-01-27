import java.util.Objects;

/**
 * This is the decorator base class that uses the delegate to get all methods from the LoggingPill-
 * Counter.
 */
public class PillDecorator implements PillCounter {
  private final PillCounter delegate;

  /**
   * This is the constructor for the PillDecorator that takes in a delegate and implements its
   * methods by using the delegate.
   * @param delegate The field for getting the PillCounter's method.
   */
  public PillDecorator(PillCounter delegate) {
    Objects.requireNonNull(delegate);
    this.delegate = delegate;
  }

  @Override
  public void addPill(int count) {
    Objects.requireNonNull(delegate);
    this.delegate.addPill(count);
  }

  @Override
  public void removePill() {
    Objects.requireNonNull(delegate);
    this.delegate.removePill();
  }

  @Override
  public void reset() {
    Objects.requireNonNull(delegate);
    this.delegate.reset();
  }

  @Override
  public int getPillCount() {
    Objects.requireNonNull(delegate);
    return this.delegate.getPillCount();
  }
}
