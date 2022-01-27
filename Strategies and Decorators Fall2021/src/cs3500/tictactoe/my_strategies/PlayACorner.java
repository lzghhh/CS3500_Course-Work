package cs3500.tictactoe.my_strategies;

import cs3500.tictactoe.model.IReadOnlyTicTacToeModel;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.strategy.Posn;

/**
 * Created by vidojemihajlovikj on 10/29/21.
 */
public class PlayACorner implements IPlayStrategy {
  @Override
  public Posn getPos(IReadOnlyTicTacToeModel model, Piece piece) {
    if (model.getPieceAt(0, 0) == Piece.EMPTY) {
      return new Posn(0, 0);
    } else if (model.getPieceAt(0, model.getWidth() - 1) == Piece.EMPTY) {
      return new Posn(0, model.getWidth() - 1);
    } else if (model.getPieceAt(model.getHeight() - 1, 0) == Piece.EMPTY) {
      return new Posn(model.getHeight() - 1, 0);
    } else if (model.getPieceAt(model.getWidth() - 1, model.getHeight() - 1) == Piece.EMPTY) {
      return new Posn(model.getWidth() - 1, model.getHeight() - 1);
    }else{
      return null;
    }
  }
}
