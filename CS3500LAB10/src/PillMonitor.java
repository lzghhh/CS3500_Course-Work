import java.util.ArrayList;
import java.util.List;

/**
 * This is the decorator extended class that uses the delegate to get all methods from the
 * LoggingPillCounter and adds new functionalities to it.
 */
public class PillMonitor extends PillDecorator {
  private List<Integer> counts;
  private int count;

  /**
   * This is the constructor for the PillMonitor that takes in a delegate and implements its
   * methods by using the delegate and also keeps the recording of the adding history.
   * @param delegate The field for getting the PillCounter's method.
   */
  public PillMonitor(PillCounter delegate) {
    super(delegate);
    this.counts = new ArrayList<>();
    this.count = 0;
  }

  @Override
  public void addPill(int count) {
    super.addPill(count);
    this.count = this.count + 1;
  }

  @Override
  public void removePill() {
    super.removePill();
  }

  @Override
  public void reset() {
    super.reset();
    counts.add(count);
    this.count = 0;
  }

  @Override
  public int getPillCount() {
    return super.getPillCount();
  }

  /**
   * This method is to output the list of pill's added history.
   * @return A list that contains the history of pills' added.
   */
  public List<Integer> addedCounts() {
    return this.counts;
  }
}
