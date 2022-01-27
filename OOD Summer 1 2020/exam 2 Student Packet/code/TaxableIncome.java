package tax;

/**
 * This interface represents a set of operations for a taxable income profile
 * . A profile consists of two kinds of income: non-qualified income (e.g.
 * wages) and qualified income (e.g. capital).
 */
public interface TaxableIncome { //(* \label{line:TaxableIncome} *)

  /**
   * Get the total ordinary income (income that is not treated at
   * special rates for tax computation)
   * @return the total non-qualified income
   */
  float getOrdinaryIncome();

  /**
   * Get the total qualified income (income that enjoys preferential tax
   * treatment)
   * @return the total qualified income
   */
  float getQualifiedIncome();

  /**
   * Return if this taxable income is for single person or married filing
   * jointly
   * @return true if this income is for joint filers, false otherwise
   */
  boolean isJointFiler();
}
