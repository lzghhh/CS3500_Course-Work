package cs3500.tictactoe.my_strategies;

import cs3500.tictactoe.model.IReadOnlyTicTacToeModel;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.strategy.Posn;

/**
 * Created by vidojemihajlovikj on 10/29/21.
 */
public class PlayFirstEmptySpot implements IPlayStrategy {
  @Override
  public Posn getPos(IReadOnlyTicTacToeModel model, Piece piece) {
    for (int r = 0; r < model.getWidth(); r++) {
      for (int c = 0; c < model.getHeight(); c++) {
        if (model.getPieceAt(r, c) == Piece.EMPTY) {
          return new Posn(r, c);
        }
      }
    }
    return null;
  }
}
