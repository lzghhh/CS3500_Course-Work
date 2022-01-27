import java.util.HashSet;
import java.util.Set;

public class IntSetImpl implements IntSet{
  private final Set<Integer> set;

  public IntSetImpl() {
    this.set = new HashSet<>();
  }

  @Override
  public void add(int value) {
    this.set.add(value);
  }

  @Override
  public void addAll(int... values) {
    for(int value: values) {
      this.add(value);
    }
  }

  @Override
  public void remove(int value) {
    this.set.remove(value);
  }

  @Override
  public boolean member(int value) {
    return this.set.contains(value);
  }
}
