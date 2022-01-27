package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;


/**
 * This class is to generate a Triangular Solitaire model that consists of several constants
 * and a 2-D arraylist of SlotState that represents each slot's state(Marble, Empty and Invalid),
 * while it has four constructors that takes in different inputs.
 */

public class TriangleSolitaireModel extends AbstractSolitaireModel {
  public TriangleSolitaireModel() {
    this(5,0,0);
  }

  public TriangleSolitaireModel(int armThick) {
    this(armThick , 0,0);
  }

  public TriangleSolitaireModel(int sRow, int sCol) {
    this(5, sRow, sCol);
  }

  /**
   * This class is the real constructor of this class. It will take in the arm thickness and the
   * position of the center that finally returns a 2-D arraylist with SlotState.
   * @param armThick The length of the arm in the game.
   * @param sRow The horizontal position of the center.
   * @param sCol The vertical position of the center.
   */

  public TriangleSolitaireModel(int armThick , int sRow, int sCol) {
    super(armThick, sRow, sCol);
    if (armThick <= 0) {
      throw new IllegalArgumentException("Not a positive odd number");
    }

    if (sRow < 0 || sCol < 0 || sRow >= armThickness || sCol >= armThickness) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ","
              + sCol + ")");
    }


    super.size = armThick + 1;

    for (int i = 0; i < armThick; i++) {
      layout.add(new ArrayList<SlotState>());
      for (int k = 0; k < armThick; k++) {
        if (k <= i) {
          if (i == sRow && k == sCol) {
            this.layout.get(i).add(SlotState.Empty);
          } else {
            this.layout.get(i).add(SlotState.Marble);
            marblesOnBoard++;
          }
        } else {
          if (i == sRow && k == sCol) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ","
                    + sCol + ")");
          } else {
            this.layout.get(i).add(SlotState.Invalid);
          }
        }
      }

    }
  }



  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (toRow == this.armThickness || fromRow == this.armThickness
            || toCol == this.armThickness || fromCol == this.armThickness) {
      throw new IllegalArgumentException("Invalid move.");
    } else {
      if (fromRow == toRow) {
        this.moveRow(fromRow,fromCol,toRow,toCol);
      } else {
        if (fromCol == toCol) {
          this.moveCol(fromRow,fromCol,toRow,toCol);
        } else {
          if (isEmpty(toRow, toCol) && isMarble(fromRow, fromCol) && isMarble(
                  (fromRow + toRow) / 2, (fromCol + toCol) / 2)) {
            if (this.distanceCheck(fromRow, fromCol, toRow, toCol)) {
              if ((toRow > fromRow && toCol < fromCol) || (toRow < fromRow && toCol > fromCol)) {
                throw new IllegalArgumentException("Invalid move.");
              } else {
                layout.get(fromRow).set(fromCol, SlotState.Empty);
                layout.get(toRow).set(toCol, SlotState.Marble);
                layout.get((fromRow + toRow) / 2).set((fromCol + toCol) / 2, SlotState.Empty);
                marblesOnBoard--;
              }
            } else {
              throw new IllegalArgumentException("Invalid move.");
            }
          } else {
            throw new IllegalArgumentException("Invalid move.");
          }
        }
      }
    }
  }

  private boolean distanceCheck(int fromRow, int fromCol, int toRow, int toCol) {
    boolean result = false;
    if (Math.sqrt((Math.pow(toRow - fromRow, 2) + Math.pow(toCol - fromCol, 2)))
            == Math.sqrt(8)) {
      result = true;
    }
    return result;
  }


  @Override
  public boolean isGameOver() {
    return checkDownSideHelper(this.armThickness)
            && checkRightSideHelper(this.armThickness)
            && checkDiagonalSide();
  }


  private boolean checkDiagonalSide() {
    boolean result = true;
    outter: for (int i = 0; i < armThickness - 2; i++) {
      for (int k = 0; k < armThickness - 2; k++) {
        result = !((isMarble(i,k) && isMarble(i + 1, k + 1)
                && isEmpty(i + 2, k + 2))
                || (isEmpty(i,k) && isMarble(i + 1,k + 1)
                && isMarble(i + 2, k + 2)));
        if (!result) {
          break outter;
        }
      }
    }
    return result;
  }


  @Override
  public int getBoardSize() {
    return this.armThickness;
  }
}
