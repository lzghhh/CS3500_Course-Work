package tax;

/**
 * This class represents a simple tax calculator. It imposes a constant tax
 * rate of 25% on ordinary (unqualified) income, and 15% on qualified income.
 *
 * This class guarantees that there will not be negative tax liability, i.e.
 * it will not claim that the government owes money to the filer. In such
 * cases it will return a tax owed of 0
 */
public class SimpleTaxCalculator implements TaxCalculator { // (*\label{line:SimpleTaxCalculator} *)


  @Override
  public float getTax(TaxableIncome income) {
      if (income==null) {
        return 0;
      }
      return 0.25f*income.getOrdinaryIncome()
              + 0.15f * income.getQualifiedIncome();
  }
}
