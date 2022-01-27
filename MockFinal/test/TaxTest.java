import org.junit.Test;

import tax.SimpleIncomeRecord;
import tax.SimpleTaxCalculator;
import tax.TaxCalculator;
import tax.TaxableIncome;

import static org.junit.Assert.assertEquals;

public class TaxTest {
  @Test
  public void testSimpleTaxCalculator() {
    TaxableIncome income = new SimpleIncomeRecord(7000.12f, 500.99f, true);
    assertEquals(1825.1785f, new SimpleTaxCalculator().getTax(income), 0.00001);
  }

//  @Test
//  public void testSimpleIncomeRecord() {
//    TaxableIncome income = new SimpleIncomeRecord(7000f, 500f, true);
//    assertEquals(1825.0f, new SimpleTaxCalculator().getTax(income), 0.001);
//  }

}
