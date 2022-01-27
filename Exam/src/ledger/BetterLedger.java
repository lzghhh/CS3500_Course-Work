package ledger;

import java.util.Iterator;
import java.util.Objects;

public class BetterLedger implements Ledger{
  private Ledger delegate;
  private AEnhancements enhancements;

  public BetterLedger() {
    this(new Normal());
  }

  public BetterLedger(AEnhancements enhancements, Ledger delegate) {
    this.enhancements = Objects.requireNonNull(enhancements);
    this.delegate = Objects.requireNonNull(delegate);
  }

  public BetterLedger(AEnhancements enhancements) {
    this(enhancements, new SimpleLedger());
  }

  @Override
  public void addExpense(String description, int dollars, int cents, int date, int month, int year) throws IllegalArgumentException {
    this.enhancements.addExpense(description, dollars,cents,date,month,year);
  }

  @Override
  public void addIncome(String description, int dollars, int cents, int date, int month, int year) throws IllegalArgumentException {
    this.enhancements.addIncome(description, dollars, cents, date, month, year);
  }

  @Override
  public double getTotalExpenses() {
    return this.enhancements.getTotalExpenses();
  }

  @Override
  public double getTotalIncome() {
    return this.enhancements.getTotalIncome();
  }

  @Override
  public Iterator<LedgerItem> allExpenses() {
    return this.enhancements.allExpenses();
  }

  @Override
  public Iterator<LedgerItem> allIncomes() {
    return this.enhancements.allIncomes();
  }
}
