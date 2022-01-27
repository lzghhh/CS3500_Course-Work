package ledger;

public interface Budgeter {
  void addExpense(String description, int dollars, int cents);
  boolean isOverBudget();
  double moneyLeft();
}
