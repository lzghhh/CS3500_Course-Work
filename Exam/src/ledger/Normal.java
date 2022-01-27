package ledger;

public class Normal extends AEnhancements{
  public Normal() {
    super(new SimpleLedger());
  }

  public Normal(Ledger delegate) {
    super(delegate);
  }
}
