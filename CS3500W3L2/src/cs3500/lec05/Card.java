package cs3500.lec05;

import java.util.Objects;

public class Card implements ICard{
  private final Value value;
  private Suite suite;

  public Card(Value value, Suite suite) {
    this.value = value;
    this.suite =suite;
  }

  @Override
  public Value getValue() {
    return this.value;
  }

  @Override
  public Suite getSuite() {
    return this.suite;
  }

  public void setSuite(Suite suite) {
    this.suite = Objects.requireNonNull(suite);
  }
}
