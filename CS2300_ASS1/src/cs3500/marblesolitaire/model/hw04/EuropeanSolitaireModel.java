package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * This class is to generate a European Solitaire model that consists of several constants
 * and a 2-D arraylist of SlotState that represents each slot's state(Marble, Empty and Invalid),
 * while it has four constructors that takes in different inputs.
 */

public class EuropeanSolitaireModel extends AbstractSolitaireModel {

  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  public EuropeanSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  public EuropeanSolitaireModel(int armThick) {
    this(armThick, ((armThick * 3 - 2) - 1) / 2, ((armThick * 3 - 2) - 1) / 2);
  }

  /**
   * This class is the real constructor of this class. It will take in the arm thickness and the
   * position of the center that finally returns a 2-D arraylist with SlotState.
   *
   * @param armThick The length of the arm in the game.
   * @param sRow     The horizontal position of the center.
   * @param sCol     The vertical position of the center.
   */

  public EuropeanSolitaireModel(int armThick, int sRow, int sCol) {
    super(armThick, sRow, sCol);
    int sizeFront;
    int sizeBack;

    if (armThick < 3 || (armThick % 2 == 0)) {
      throw new IllegalArgumentException("Not a positive odd number");
    }

    if (sRow < 0 || sCol < 0 || sRow >= size || sCol >= size) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ","
              + sCol + ")");
    }

    for (int i = 0; i < size; i++) {
      layout.add(new ArrayList<SlotState>());
      for (int k = 0; k < size; k++) {
        if (i < size - armThick) {
          sizeFront = armThick - i - 1;
          sizeBack = size - armThick + i;
        } else {
          sizeFront = i - size + armThick;
          sizeBack = size - i + size - armThick - 1;
        }

        if (k < sizeFront || k > sizeBack) {
          if (sRow == i && sCol == k) {
            throw new IllegalArgumentException("Invalid empty cell position ("
                    + sRow + "," + sCol + ")");
          }
          layout.get(i).add(SlotState.Invalid);
        } else {
          if (i == sRow && k == sCol) {
            layout.get(i).add(SlotState.Empty);
          } else {
            layout.get(i).add(SlotState.Marble);
            this.marblesOnBoard++;
          }
        }
      }
    }
  }
}
