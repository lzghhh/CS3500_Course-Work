package tax;

/**
 * This interface represents a simple way to compute the taxes for a given
 * income profile. Implementations define specific details of this tax
 * computation.
 */
public interface TaxCalculator { //(* \label{line:TaxCalculator} *)

  /**
   * Get the tax owed due to the provided income
   * @param income the TaxableIncome for which tax is computed
   * @return the tax owed
   */
  float getTax(TaxableIncome income);
}
