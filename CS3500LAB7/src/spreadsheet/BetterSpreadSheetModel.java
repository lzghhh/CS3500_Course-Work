package spreadsheet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BetterSpreadSheetModel implements BetterSpreadSheet{
  private final Map<BetterSpreadSheetModel.CellPosition,Double> sheet;
  private int width;
  private int height;

  /**
   * This is the constructor for the BetterSpreadSheetModel that creates a sheet with different cells
   * with position and values on it.
   */

  public BetterSpreadSheetModel() {
    this.sheet = new HashMap<BetterSpreadSheetModel.CellPosition,Double>();
    this.width = 0;
    this.height = 0;
  }
  @Override
  public void recRegion(int fromRow, int fromCol, int toRow, int toCol, double value) {
    for (int i = fromRow; i <= toRow; i++) {
      for (int k = fromCol; k <= toCol; k++) {
        sheet.put(new CellPosition(i,k),value);
      }
    }
  }

  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    if ((row < 0) || (col < 0 )) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    return this.sheet.getOrDefault(new BetterSpreadSheetModel.CellPosition(row,col),0.0);
  }

  @Override
  public void set(int row, int col,double value) throws IllegalArgumentException {
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    this.sheet.put(new BetterSpreadSheetModel.CellPosition(row,col),value);
    if ((row + 1) > height) {
      height = row + 1;
    }

    if ((col + 1) > width) {
      width = col + 1;
    }
  }

  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    return !this.sheet.containsKey(new BetterSpreadSheetModel.CellPosition(row,col));
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  private static class CellPosition {
    private final int row;
    private final int column;

    private CellPosition(int row,int column) {
      this.row = row;
      this.column = column;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof BetterSpreadSheetModel.CellPosition)) {
        return false;
      }
      BetterSpreadSheetModel.CellPosition other = (BetterSpreadSheetModel.CellPosition)o;
      return this.row == other.row && this.column == other.column;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.row,this.column);
    }
  }
}
