package tax;

/**
 * This class represents a simple income profile for an individual or a
 * married couple filing jointly. It accepts directly the total ordinary
 * income and the total qualified income, without the opportunity to modify
 * them later.
 */
public class SimpleIncomeRecord implements TaxableIncome { //(* \label{line:SimpleIncomeRecord} *)

  private final float ordinaryIncome;
  private final float qualifiedIncome;
  private final boolean isJoint;

  /**
   * Create a SimpleIncomeRecord based on given data explicitly
   * @param ordinaryIncome the total ordinary income to be taxed at normal rates
   * @param q the total qualified income to be taxed at a preferential rate
   * @param isJoint true if married filing jointly, false otherwise
   * @throws IllegalArgumentException if invalid incomes are provided
   */

  public SimpleIncomeRecord(float ordinaryIncome, float q, boolean isJoint) {
    if ((ordinaryIncome<0) && (q<0)) {
      throw new IllegalArgumentException("Invalid income(s) provided");
    }
    this.ordinaryIncome = ordinaryIncome;
    qualifiedIncome = q;
    this.isJoint = isJoint;
  }

  @Override
  public float getOrdinaryIncome() {
    return this.ordinaryIncome;
  }

  @Override
  public float getQualifiedIncome() {
    return this.qualifiedIncome;
  }

  @Override
  public boolean isJointFiler() {
    return this.isJoint;
  }
}
