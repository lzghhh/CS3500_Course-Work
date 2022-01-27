package ledger;

public class Rounding extends AEnhancements{

  public Rounding() {
    super(new SimpleLedger());
  }
  public Rounding(Ledger delegate) {
    super(delegate);
  }

  @Override
  public void addExpense(String description, int dollars, int cents, int date, int month, int year) {
    if (cents >= 50) {
      dollars = dollars + 1;
    }
    super.addExpense(description,dollars, 0, date, month, year);
  }

  @Override
  public void addIncome(String description, int dollars, int cents, int date, int month, int year) {
    if (cents >= 50) {
      dollars = dollars + 1;
    }
    super.addIncome(description,dollars, 0, date, month, year);
  }
}
