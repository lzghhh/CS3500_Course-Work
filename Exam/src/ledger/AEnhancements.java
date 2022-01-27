package ledger;

import java.util.Iterator;
import java.util.Objects;

public abstract class AEnhancements implements Ledger{
  private final Ledger delegate;

  public AEnhancements(Ledger delegate) {
    this.delegate = delegate;
  }

  @Override
  public void addExpense(String description, int dollars, int cents, int date, int month, int year) throws IllegalArgumentException {
    this.delegate.addExpense(description,dollars,cents,date,month,year);
  }

  @Override
  public void addIncome(String description, int dollars, int cents, int date, int month, int year) throws IllegalArgumentException {
    this.delegate.addIncome(description,dollars,cents, date,month,year);
  }

  @Override
  public double getTotalExpenses() {
    return this.delegate.getTotalExpenses();
  }

  @Override
  public double getTotalIncome() {
    return this.delegate.getTotalIncome();
  }

  @Override
  public Iterator<LedgerItem> allExpenses() {
    return this.delegate.allExpenses();
  }

  @Override
  public Iterator<LedgerItem> allIncomes() {
    return this.delegate.allIncomes();
  }
}
