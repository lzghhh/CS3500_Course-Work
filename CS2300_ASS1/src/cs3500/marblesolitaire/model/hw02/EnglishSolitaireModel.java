package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * This class is to generate an English Solitaire model that consists of several constants
 * and a 2-D arraylist of SlotState that represents each slot's state(Marble, Empty and Invalid),
 * while it has four constructors that takes in different inputs.
 */

public class EnglishSolitaireModel extends AbstractSolitaireModel {

  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  public EnglishSolitaireModel(int armThick) {
    this(armThick, ((armThick * 3 - 2) - 1) / 2, ((armThick * 3 - 2) - 1) / 2);
  }

  /**
   * This class is the real constructor of this class. It will take in the arm thickness and the
   * position of the center that finally returns a 2-D arraylist with SlotState.
   * @param armThick The length of the arm in the game.
   * @param sRow The horizontal position of the center.
   * @param sCol The vertical position of the center.
   */

  public EnglishSolitaireModel(int armThick, int sRow, int sCol) {
    super(armThick, sRow, sCol);
    marblesOnBoard = (armThick - 2) * (armThick - 2) + 4 * armThick * armThick - 5;
    int sizeFront = (size - armThick) / 2 - 1;
    int sizeBack = size - sizeFront - 1 ;

    if ((sRow <= sizeFront && sCol <= sizeFront) || (sRow <= sizeFront && sCol >= sizeBack)
            || (sRow >= sizeBack && sCol <= sizeFront) || (sRow >= sizeBack && sCol >= sizeBack)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    } else {
      if (armThick < 3  || (armThick % 2 == 0)) {
        throw new IllegalArgumentException("Not a positive odd number");
      }
    }

    for (int i = 0; i <= size; i++) {
      layout.add(new ArrayList<SlotState>());
      for (int k = 0; k <= size; k++) {
        if ((i <= sizeFront && k <= sizeFront) || (i <= sizeFront && k >= sizeBack)
                || (i >= sizeBack && k <= sizeFront)
                || (i >= sizeBack && k >= sizeBack)) {
          layout.get(i).add(SlotState.Invalid);
        } else {
          if (i == sRow && k == sCol) {
            layout.get(i).add(SlotState.Empty);
          } else {
            layout.get(i).add(SlotState.Marble);
          }
        }
      }
    }
  }






}

