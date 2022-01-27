package amit;

/**
 * My own custom tax situation. I just customize this every year
 */

public class AmitsTaxes { // (* \label{line:AmitsTaxes} *)
  //regular job, should be paid per Piazza post!
  private final float teachersSalary = 70000.0f;
  //my wife's smarter, she went to industry!
  private final float wifeSalary = 100000.0f;
  //the little cherubs...
  private final int numKids = 2;

  /* this year I added to my income...*/

  //uber gig on weekends only! Ordinary income, but hey!
  private final float uber = 2000.0f;
  //amateur photographer: another gig, but ordinary income
  private final float photos = 3000.0f;
  //this year was good!
  private final float profitFromStockSales = 10000.0f;



  public float teachersSalary() {
    return this.teachersSalary;
  }

  public float uberIncome() {
    return this.uber;
  }

  public float saleOfPhotos() {
    return photos;
  }

  public float profitFromStockSales() {
    return this.profitFromStockSales;
  }

  public float wifeIncome() {
    return this.wifeSalary;
  }

  public int howManyKids() {
    return this.numKids;
  }

  public float doTaxes() {
    /*

    Every year I pull in the tax tables from IRS,
    and write code here to to compute my taxes.
    I'm a geek with too much time!

    But seriously, I need to use some tax software now.

    */

    return 0.0f;
  }

}
