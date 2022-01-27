package cs3500.tictactoe.my_strategies;

import cs3500.tictactoe.model.IReadOnlyTicTacToeModel;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.strategy.Posn;

/**
 * Created by vidojemihajlovikj on 10/29/21.
 */
public interface IPlayStrategy {
  Posn getPos(IReadOnlyTicTacToeModel model, Piece piece);
}
