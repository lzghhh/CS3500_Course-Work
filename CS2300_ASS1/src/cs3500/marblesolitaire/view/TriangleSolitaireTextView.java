package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This is the viewer for the Triangular solitaire as a string.
 */

public class TriangleSolitaireTextView extends AbstractMarbleSolitaireView {


  public TriangleSolitaireTextView(MarbleSolitaireModelState state, Appendable appendable) {
    super(state, appendable);
  }

  public TriangleSolitaireTextView(MarbleSolitaireModelState state) {
    super(state);
  }

  @Override
  public String toString() {
    MarbleSolitaireModelState.SlotState slotstate;
    String stringBoard = new String();

    for (int i = 0; i < state.getBoardSize() ; i++) {
      for (int h = state.getBoardSize(); h > i + 1; h--) {
        stringBoard += " ";
      }
      for (int k = 0; k < state.getBoardSize(); k++) {
        slotstate = state.getSlotAt(i, k);
        switch (slotstate) {
          case Empty:
            if (k == state.getBoardSize() - 1) {
              stringBoard += "_";
            } else {
              if (this.state.getSlotAt(i,k + 1).equals(
                      MarbleSolitaireModelState.SlotState.Invalid)) {
                stringBoard += "_";
              } else {
                stringBoard += "_ ";
              }
            }
            break;

          case Marble:
            if (k == state.getBoardSize() - 1) {
              stringBoard += "O";
            } else {
              if (this.state.getSlotAt(i,k + 1).equals(
                      MarbleSolitaireModelState.SlotState.Invalid)) {
                stringBoard += "O";
              } else {
                stringBoard += "O ";
              }
            }
            break;


          default: break;
        }
      }

      if (i != state.getBoardSize() - 1) {
        stringBoard += "\n";
      }
    }
    return stringBoard;
  }
}
