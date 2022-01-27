import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Helper class for confirming the correctness of the input.
 */

public class ConfirmInput implements MarbleSolitaireModel {

  final StringBuilder log;

  public ConfirmInput(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }


  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(fromRow + " " + fromCol + " " + toRow + " " + toCol);
  }

  @Override
  public boolean isGameOver() {
    return false;
  }
}
