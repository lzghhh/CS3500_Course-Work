package spreadsheet;

/**
 * This is a set command class that belongs to sheetcommand interface.
 */
public class Set implements SheetCommand {
  int row;
  int col;
  double value;

  /**
   * This is a constructor for a better built sheet.
   * @param row The input row.
   * @param col The input column.
   * @param value The given value.
   */
  public Set(int row, int col, double value) {
    this.row = row;
    this.col = col;
    this.value = value;
  }

  @Override
  public void process(SpreadSheet sheet) {
    sheet.set(row,col,value);
  }
}
