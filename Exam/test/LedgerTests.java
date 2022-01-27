import org.junit.Test;

import java.util.Iterator;

import ledger.BetterLedger;
import ledger.Budget;
import ledger.Budgeter;
import ledger.LargeExpense;
import ledger.Ledger;
import ledger.LedgerItem;
import ledger.Rounding;
import ledger.SimpleLedger;

import static org.junit.Assert.*;

public class LedgerTests {

  @Test
  public void testUsage() {
    //create an empty ledger
    Ledger accountBook = new SimpleLedger();

    //add monthly salary
    accountBook.addIncome("Salary",1000,00,1,1,2021);

    //rent
    accountBook.addExpense("Rent",500,0,5,1,2021);
    //cell phone bill
    accountBook.addExpense("Cell Phone",50,10,10,1,2021);
    //groceries
    accountBook.addExpense("Groceries",100,52,30,1,2021);

    //get all the incomes
    //the order in which the expected items are
    String []itemNames = {"Salary"};
    double []amounts = {1000.00};
    testItems(accountBook.allIncomes(),itemNames,amounts);

    //get all the expenses
    //the order in which the expected items are
    itemNames = new String[]{"Rent","Cell Phone","Groceries"};
    amounts = new double[]{500.00,50.10,100.52};
    testItems(accountBook.allExpenses(),itemNames,amounts);

    //verify total income
    assertEquals(1000,accountBook.getTotalIncome(),0.01);
    //verify total expenses
    assertEquals(650.62,accountBook.getTotalExpenses(),0.01);

    //help from parents! (Will pay back later)
    accountBook.addIncome("Advance from parents",400,0,15,1,2021);

    //get all the incomes again
    //the order in which the expected items are
    itemNames = new String[]{"Salary","Advance from parents"};
    amounts = new double[]{1000.00,400};
    testItems(accountBook.allIncomes(),itemNames,amounts);

    //get all the expenses again
    //the order in which the expected items are
    itemNames = new String[]{"Rent","Cell Phone","Groceries"};
    amounts = new double[]{500.00,50.10,100.52};
    testItems(accountBook.allExpenses(),itemNames,amounts);

    //verify total income
    assertEquals(1400,accountBook.getTotalIncome(),0.01);
    //verify total expenses
    assertEquals(650.62,accountBook.getTotalExpenses(),0.01);
  }

  private void testItems(Iterator<LedgerItem> items,String[] itemNames,double[] amounts) {
    int count = 0;
    while (items.hasNext()) {
      LedgerItem item = items.next();
      assertEquals(itemNames[count],item.getDescription());
      assertEquals(amounts[count],item.getAmount(),0.01);
      count = count + 1;
    }
    assertEquals(count, itemNames.length);
    assertEquals(count,amounts.length);
  }

  @Test
  public void testBudgeter() {
    //create a budgeter with a fixed budget
    Budgeter budgeter = new Budget(3000);
    //verify that we are under budget and find out how much we can spend
    assertFalse(budgeter.isOverBudget());
    assertEquals(3000.0, budgeter.moneyLeft(), 0.0001);
    //add some expenses, still within budget
    budgeter.addExpense("hotel", 300, 0);
    budgeter.addExpense("lyft", 100, 0);
    //verify that we are still under budget and find out how much we can spend
    assertFalse(budgeter.isOverBudget());
    assertEquals(2600.0, budgeter.moneyLeft(), 0.0001);
    //spend the remaining money
    budgeter.addExpense("plane ticket", 2600, 0);
    //verify that we are now at budget
    assertTrue(budgeter.isOverBudget());
    //spend some more...'coz we just can't help it!
    budgeter.addExpense("car rent", 300, 10);

    //verify that we went over budget and that we don't have any more to spend
    assertTrue(budgeter.isOverBudget());
    assertEquals(0.0,budgeter.moneyLeft(), 0.001);
  }


  @Test
  public void BetterUsageOriginal() {
    //create an empty ledger
    Ledger accountBook = new BetterLedger();

    //add monthly salary
    accountBook.addIncome("Salary",1000,00,1,1,2021);

    //rent
    accountBook.addExpense("Rent",500,0,5,1,2021);
    //cell phone bill
    accountBook.addExpense("Cell Phone",50,10,10,1,2021);
    //groceries
    accountBook.addExpense("Groceries",100,52,30,1,2021);

    //get all the incomes
    //the order in which the expected items are
    String []itemNames = {"Salary"};
    double []amounts = {1000.00};
    testItems(accountBook.allIncomes(),itemNames,amounts);

    //get all the expenses
    //the order in which the expected items are
    itemNames = new String[]{"Rent","Cell Phone","Groceries"};
    amounts = new double[]{500.00,50.10,100.52};
    testItems(accountBook.allExpenses(),itemNames,amounts);

    //verify total income
    assertEquals(1000,accountBook.getTotalIncome(),0.01);
    //verify total expenses
    assertEquals(650.62,accountBook.getTotalExpenses(),0.01);

    //help from parents! (Will pay back later)
    accountBook.addIncome("Advance from parents",400,0,15,1,2021);

    //get all the incomes again
    //the order in which the expected items are
    itemNames = new String[]{"Salary","Advance from parents"};
    amounts = new double[]{1000.00,400};
    testItems(accountBook.allIncomes(),itemNames,amounts);

    //get all the expenses again
    //the order in which the expected items are
    itemNames = new String[]{"Rent","Cell Phone","Groceries"};
    amounts = new double[]{500.00,50.10,100.52};
    testItems(accountBook.allExpenses(),itemNames,amounts);

    //verify total income
    assertEquals(1400,accountBook.getTotalIncome(),0.01);
    //verify total expenses
    assertEquals(650.62,accountBook.getTotalExpenses(),0.01);
  }

  @Test
  public void BetterUsageetterTest() {
    //create an empty ledger
    Ledger accountBook = new BetterLedger(new Rounding());

    //add monthly salary
    accountBook.addIncome("Salary",1000,00,1,1,2021);

    //rent
    accountBook.addExpense("Rent",500,0,5,1,2021);
    //cell phone bill
    accountBook.addExpense("Cell Phone",50,10,10,1,2021);
    //groceries
    accountBook.addExpense("Groceries",100,52,30,1,2021);

    //get all the incomes
    //the order in which the expected items are
    String []itemNames = {"Salary"};
    double []amounts = {1000.00};
    testItems(accountBook.allIncomes(),itemNames,amounts);

    //get all the expenses
    //the order in which the expected items are
    itemNames = new String[]{"Rent","Cell Phone","Groceries"};
    amounts = new double[]{500.00,50.00,101.00};
    testItems(accountBook.allExpenses(),itemNames,amounts);

    //verify total income
    assertEquals(1000,accountBook.getTotalIncome(),0.01);
    //verify total expenses
    assertEquals(651.00,accountBook.getTotalExpenses(),0.01);

    //help from parents! (Will pay back later)
    accountBook.addIncome("Advance from parents",400,0,15,1,2021);

    //get all the incomes again
    //the order in which the expected items are
    itemNames = new String[]{"Salary","Advance from parents"};
    amounts = new double[]{1000.00,400};
    testItems(accountBook.allIncomes(),itemNames,amounts);

    //get all the expenses again
    //the order in which the expected items are
    itemNames = new String[]{"Rent","Cell Phone","Groceries"};
    amounts = new double[]{500.00,50.00,101.00};
    testItems(accountBook.allExpenses(),itemNames,amounts);

    //verify total income
    assertEquals(1400,accountBook.getTotalIncome(),0.01);
    //verify total expenses
    assertEquals(651.00,accountBook.getTotalExpenses(),0.01);
  }

  @Test
  public void BetterUsageetterTest2() {
    //create an empty ledger
    Ledger accountBook = new BetterLedger(new Rounding(new LargeExpense(100)));

    //add monthly salary
    accountBook.addIncome("Salary",1000,00,1,1,2021);

    //rent
    accountBook.addExpense("Rent",500,0,5,1,2021);
    //cell phone bill
    accountBook.addExpense("Cell Phone",50,10,10,1,2021);
    //groceries
    accountBook.addExpense("Groceries",100,52,30,1,2021);

    //get all the incomes
    //the order in which the expected items are
    String []itemNames = {"Salary"};
    double []amounts = {1000.00};
    testItems(accountBook.allIncomes(),itemNames,amounts);

    //get all the expenses
    //the order in which the expected items are
    itemNames = new String[]{"Rent","Groceries"};
    amounts = new double[]{500.00,101.00};
    testItems(accountBook.allExpenses(),itemNames,amounts);

    //verify total income
    assertEquals(1000,accountBook.getTotalIncome(),0.01);
    //verify total expenses
    assertEquals(601.00,accountBook.getTotalExpenses(),0.01);


    //get all the expenses again
    //the order in which the expected items are
    itemNames = new String[]{"Rent","Groceries"};
    amounts = new double[]{500.00,101.00};
    testItems(accountBook.allExpenses(),itemNames,amounts);

    //help from parents! (Will pay back later)
    accountBook.addIncome("Advance from parents",400,0,15,1,2021);

    //get all the incomes again
    //the order in which the expected items are
    itemNames = new String[]{"Salary","Advance from parents"};
    amounts = new double[]{1000.00,400};
    testItems(accountBook.allIncomes(),itemNames,amounts);

    //verify total income
    assertEquals(1400,accountBook.getTotalIncome(),0.01);
    //verify total expenses
    assertEquals(601.00,accountBook.getTotalExpenses(),0.01);
  }
}