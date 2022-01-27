package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This is the abstract class that implements the MarbleSolitaireView interface. There are
 * generalized methods in the abstract class that are shared by all the extended classes.
 */

public abstract class AbstractMarbleSolitaireView implements MarbleSolitaireView {

  public MarbleSolitaireModelState state;
  public Appendable appendable;

  /**
   * The contrusctor takes two inputs and return a string that represents the board state.
   * @param state The passed in state of the board.
   * @param appendable The output String.
   */

  public AbstractMarbleSolitaireView(MarbleSolitaireModelState state, Appendable appendable) {
    if (state == null || appendable == null) {
      throw new IllegalArgumentException("The provided model is null!");
    }
    this.state = state;
    this.appendable = appendable;
  }

  public AbstractMarbleSolitaireView(MarbleSolitaireModelState state) {
    this(state, System.out);
  }

  @Override
  public String toString() {
    MarbleSolitaireModelState.SlotState slotstate;
    String stringBoard = new String();

    for (int i = 0; i < state.getBoardSize(); i++) {
      outer: for (int k = 0; k < state.getBoardSize(); k++) {
        slotstate = state.getSlotAt(i, k);

        switch (slotstate) {
          case Empty:
            if ((k != 0 && k < state.getBoardSize() - 1 && state.getSlotAt(i, k + 1).equals(
                    MarbleSolitaireModelState.SlotState.Invalid))
                    || k == state.getBoardSize() - 1) {
              stringBoard += "_";
            } else {
              stringBoard += "_ ";
            }
            break;

          case Marble:
            if ((k != 0 && k < state.getBoardSize() - 1 && state.getSlotAt(i, k + 1).equals(
                    MarbleSolitaireModelState.SlotState.Invalid))
                    || k == state.getBoardSize() - 1) {
              stringBoard += "O";
            } else {
              stringBoard += "O ";
            }
            break;

          case Invalid:
            if ((k != 0 && state.getSlotAt(i, k - 1).equals(
                    MarbleSolitaireModelState.SlotState.Marble))
                    || (k != 0 && state.getSlotAt(i, k - 1 ).equals(
                            MarbleSolitaireModelState.SlotState.Empty))) {
              break outer;
            } else {
                stringBoard += "  ";
                break;
            }

          default: break;
        }
      }

      if (i != state.getBoardSize() - 1) {
        stringBoard += "\n";
      }
    }
    return stringBoard;
  }

  @Override
  public void renderBoard() throws IOException {
    this.appendable.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }
}
