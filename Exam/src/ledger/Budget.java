package ledger;

import java.util.Iterator;
import java.util.Objects;

public class Budget implements Budgeter {
  private double budget;
  private Ledger delegate;

  public Budget(int budget) {
    this(new SimpleLedger());
    this.budget = budget;
  }

  public Budget(Ledger delegate) {
    this.delegate = Objects.requireNonNull(delegate);
  }

  @Override
  public void addExpense(String description, int dollars, int cents) {
    this.delegate.addExpense(description, dollars, cents, 0,0,0);
  }

  @Override
  public boolean isOverBudget() {
    return this.delegate.getTotalExpenses() >= budget;
  }

  @Override
  public double moneyLeft() {
    if (isOverBudget()) {
      return 0;
    } else {
      return this.budget - this.delegate.getTotalExpenses();
    }
  }
}
