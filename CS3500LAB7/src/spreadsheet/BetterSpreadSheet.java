package spreadsheet;

/**
 * Set a new rectangular region spreadsheet.
 */

public interface BetterSpreadSheet extends SpreadSheet{
  void recRegion(int fromRow, int fromCol, int toRow, int toCol, double value);
}
