package cs3500.tictactoe.my_strategies;

import cs3500.tictactoe.model.IReadOnlyTicTacToeModel;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import cs3500.tictactoe.strategy.FirstAvailableOpening;
import cs3500.tictactoe.strategy.Posn;
import cs3500.tictactoe.strategy.PosnStrategy;

/**
 * A Strategy: tries to block a win, and if that fails,
 * just tries the first available opening
 */
public class BlockWin implements IPlayStrategy {
  @Override
  public Posn getPos(IReadOnlyTicTacToeModel model, Piece player){
    Posn tryBlock = tryToBlock(model, player);
    if (tryBlock == null) {
      return new PlayFirstEmptySpot().getPos(model, player);
    }
    return tryBlock;
  }

  Posn tryToBlock(IReadOnlyTicTacToeModel model, Piece player) {
    Posn ret = null;
    // Try any gaps in cols
    for (int r = 0; r <= model.getHeight() - model.getGoal(); r++) {
      for (int c = 0; c < model.getWidth(); c++) {
        ret = findGapAt(model, player, r, c, 1, 0);
        if (ret != null) return ret;
      }
    }
    // Try any gaps in rows
    for (int c = 0; c <= model.getWidth() - model.getGoal(); c++) {
      for (int r = 0; r < model.getHeight(); r++) {
        ret = findGapAt(model, player, r, c, 0, 1);
        if (ret != null) return ret;
      }
    }
    // Try any gaps on diagonals
    for (int r = 0; r <= model.getHeight() - model.getGoal(); r++) {
      for (int c = 0; c <= model.getWidth() - model.getGoal(); c++) {
        ret = findGapAt(model, player, r, c, 1, 1);
        if (ret != null) return ret;
        ret = findGapAt(model, player, r + model.getGoal() - 1, c, -1, 1);
        if (ret != null) return ret;
      }
    }
    return ret;
  }
  Posn findGapAt(IReadOnlyTicTacToeModel model, Piece player, int r, int c, int dr, int dc) {
    Posn ret = null;
    for (int g = 0; g < model.getGoal(); g++) {
      Piece next = model.getPieceAt(r + g * dr, c + g * dc);
      if (next == Piece.EMPTY) {
        if (ret == null) {
          ret = new Posn(r + g * dr, c + g * dc);
        } else {
          return null;
        }
      } else if (next == player) {
        return null;
      }
    }
    return ret;
  }
}
