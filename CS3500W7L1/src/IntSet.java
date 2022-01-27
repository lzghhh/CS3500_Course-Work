public interface IntSet {
  void add(int value);
  void addAll(int... values);
  void remove(int value);
  boolean member(int value);
}
