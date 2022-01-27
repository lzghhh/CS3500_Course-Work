package spreadsheet;

import java.util.Objects;

/**
 * This is the mock class that uses for testing whether the controller passing the right input
 * to the model.
 */

public class MockSpreadSheet implements SpreadSheet {
  final StringBuilder log;

  public MockSpreadSheet(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }


  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    log.append(String.format("row = %d, col = %d\n", row,col));
    return 0;
  }

  @Override
  public void set(int row, int col, double value) throws IllegalArgumentException {
    log.append(String.format("row = %d, col = %d, value = %.3g\n", row,col,value));
  }

  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    log.append(String.format("row = %d, col = %d, value = %d\n", row,col));
    return true;
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
