public final class CountedIntImlp implements IntSet{
  private int count;


  public CountedIntImlp(){
    super();

    this.count = 0;
  }

  @Override
  public void add(int value) {
    super.add(value);
    this.count++;
  }

  @Override
  public void addAll(int... values) {
    super.addAll(values);

    this.count += values.length;
  }

  @Override
  public void remove(int value) {

  }

  @Override
  public boolean member(int value) {
    return false;
  }

  @Override
  public int getCount() {
    return this.count;
  }
}
