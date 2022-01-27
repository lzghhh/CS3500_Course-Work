package cs3500.tictactoe.my_strategies;

import cs3500.tictactoe.model.IReadOnlyTicTacToeModel;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.strategy.Posn;

/**
 * Created by vidojemihajlovikj on 10/29/21.
 */
public class CompositeStrategy implements IPlayStrategy {
  private final IPlayStrategy first;
  private final IPlayStrategy rest;

  public CompositeStrategy(IPlayStrategy first, IPlayStrategy rest) {
    this.first = first;
    this.rest = rest;
  }


  @Override
  public Posn getPos(IReadOnlyTicTacToeModel model, Piece piece) {
    Posn pos = first.getPos(model, piece);
    if ( pos == null ){
      return this.rest.getPos(model, piece);
    }
    return pos;
  }
}
