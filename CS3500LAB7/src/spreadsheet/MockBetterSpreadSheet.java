package spreadsheet;

import java.util.Objects;

public class MockBetterSpreadSheet implements BetterSpreadSheet{
  final StringBuilder log;

  public MockBetterSpreadSheet(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  @Override
  public void recRegion(int fromRow, int fromCol, int toRow, int toCol, double value) {
    log.append(String.format("fromRow = %d, fromCol = %d, toRow = %d, toCol = %dvalue = %.3g\n",
            fromRow,fromCol,toRow, toCol, value));
  }

  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    return 0;
  }

  @Override
  public void set(int row, int col, double value) throws IllegalArgumentException {

  }

  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    return false;
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }
}
