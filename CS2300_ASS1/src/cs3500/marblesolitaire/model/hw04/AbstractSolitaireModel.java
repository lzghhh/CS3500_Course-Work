package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This is the abstract class that contains different methods for different types of solitaire game.
 * It inherits the methods from the MarbleSolitaireModel.
 */

public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected int armThickness;
  protected final ArrayList<ArrayList<SlotState>> layout = new ArrayList<ArrayList<SlotState>>();
  protected int marblesOnBoard;
  protected int size;

  /**
   * The abstract constructor that passes input information to different solitaire games class.
   * @param armThickness The thick of the game board.
   * @param sRow The row of the center.
   * @param sCol The colum of the center.
   */

  public AbstractSolitaireModel(int armThickness, int sRow, int sCol) {
    this.armThickness = armThickness;
    this.size = armThickness * 3 - 2;
    this.marblesOnBoard = 0;
  }


  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (fromRow == toRow) {
      this.moveRow(fromRow,fromCol,toRow,toCol);
    } else {
      if (fromCol == toCol) {
        this.moveCol(fromRow,fromCol,toRow,toCol);
      } else {
        throw new IllegalArgumentException("Invalid move.");
      }
    }
  }


  protected void moveRow(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (isEmpty(toRow, toCol) && isMarble(fromRow, fromCol) && isMarble(toRow,
            (toCol + fromCol) / 2) && Math.abs(fromCol - ((fromCol + toCol) / 2)) == 1
            && Math.abs(toCol - ((fromCol + toCol) / 2)) == 1) {
      layout.get(fromRow).set(toCol, SlotState.Marble);
      layout.get(fromRow).set((toCol + fromCol) / 2, SlotState.Empty);
      layout.get(fromRow).set(fromCol, SlotState.Empty);
      marblesOnBoard--;
    } else {
      throw new IllegalArgumentException("Invalid move.");
    }
  }

  protected void moveCol(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (isEmpty(toRow, toCol) && isMarble(fromRow, fromCol) && isMarble(
            (fromRow + toRow) / 2, fromCol)
            && Math.abs(fromRow - ((fromRow + toRow) / 2)) == 1
            && Math.abs(toRow - ((fromRow + toRow) / 2)) == 1) {
      layout.get(fromRow).set(fromCol, SlotState.Empty);
      layout.get((fromRow + toRow) / 2).set(toCol, SlotState.Empty);
      layout.get(toRow).set(toCol, SlotState.Marble);
      marblesOnBoard--;
    } else {
      throw new IllegalArgumentException("Invalid move.");
    }
  }

  /**
   * This method is used identify whether the given position in the chart is a marble or not.
   * @param sRow The horizontal position.
   * @param sCol The vertical position.
   * @return True as being a marble, False as not being a marble.
   */

  protected boolean isMarble(int sRow, int sCol) {
    boolean result = false;
    if (!(sRow < 0 || sRow > size - 1 || sCol < 0 || sCol > size - 1)) {
      if (layout.get(sRow).get(sCol) == SlotState.Marble) {
        result = true;
      }
    }
    return result;
  }

  /**
   * This method is used identify whether the given position in the chart is empty or not.
   * @param sRow The horizontal position.
   * @param sCol The vertical position.
   * @return True as being empty, False as not being empty.
   */

  protected boolean isEmpty(int sRow, int sCol) {
    boolean result = false;
    if (!(sRow < 0 || sRow > size - 1 || sCol < 0 || sCol > size - 1)) {
      if (layout.get(sRow).get(sCol) == SlotState.Empty) {
        result = true;
      }
    }
    return result;
  }

  /**
   * This method is used identify whether the given position in the chart is valid or not.
   * @param sRow The horizontal position.
   * @param sCol The vertical position.
   * @return True as being invalid, False as not being invalid.
   */

  protected boolean isInvalid(int sRow, int sCol) {
    boolean result = false;
    if (!(sRow < 0 || sRow > size - 1 || sCol < 0 || sCol > size - 1)) {
      if (layout.get(sRow).get(sCol) == SlotState.Invalid) {
        result = true;
      }
    }
    return result;
  }

  /**
   * This method is to determine whether the game is ended or not.
   * @return True as being no marble to move and False as being more marbles can be moved.
   */

  @Override
  public boolean isGameOver() {
    return checkDownSideHelper(this.size) && checkRightSideHelper(this.size);
  }

  protected boolean checkRightSideHelper(int armThickness) {
    boolean result = true;
    outter: for (int i = 0; i < armThickness; i++) {
      for (int k = 0; k < armThickness - 2; k++) {
        result = !((isMarble(i,k) && isMarble(i, k + 1) && isEmpty(i, k + 2))
                || (isEmpty(i,k) && isMarble(i,k + 1 ) && isMarble(i, k + 2)));
        if (!result) {
          break outter;
        }
      }
    }
    return result;
  }

  protected boolean checkDownSideHelper(int armThickness) {
    boolean result = true;
    outter: for (int i = 0; i < armThickness - 2; i++) {
      for (int k = 0; k < armThickness; k++) {
        result = !((isMarble(i,k) && isMarble(i + 1, k) && isEmpty(i + 2, k))
                || (isEmpty(i,k) && isMarble(i + 1,k) && isMarble(i + 2, k)));
        if (!result) {
          break outter;
        }
      }
    }
    return result;
  }

  @Override
  public int getBoardSize() {
    return 3 * this.armThickness - 2;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0 || row >= size || col >= size) {
      throw new IllegalArgumentException("Invalid slot position.");
    } else {
      return layout.get(row).get(col);
    }
  }

  @Override
  public int getScore() {
    return marblesOnBoard;
  }
}
