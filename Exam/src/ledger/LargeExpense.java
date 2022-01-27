package ledger;

public class LargeExpense extends AEnhancements{
  private int amount;
  public LargeExpense(int amount) {
    super(new SimpleLedger());
    this.amount = amount;
  }

  public LargeExpense(Ledger delegate) {
    super(delegate);
  }

  @Override
  public void addExpense(String description, int dollars, int cents, int date, int month, int year) {
    if (dollars >= amount) {
      super.addExpense(description,dollars, 0, date, month, year);
    }
  }

  @Override
  public void addIncome(String description, int dollars, int cents, int date, int month, int year) {
    if (dollars >= amount) {
      super.addIncome(description,dollars, 0, date, month, year);
    }
  }

}
