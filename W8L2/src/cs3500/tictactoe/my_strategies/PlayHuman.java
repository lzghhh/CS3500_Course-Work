package cs3500.tictactoe.my_strategies;

import java.util.Scanner;

import cs3500.tictactoe.model.IReadOnlyTicTacToeModel;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.strategy.Posn;

/**
 * Created by vidojemihajlovikj on 10/29/21.
 */
public class PlayHuman implements IPlayStrategy {
  @Override
  public Posn getPos(IReadOnlyTicTacToeModel model, Piece piece) {
    Scanner scanner = new Scanner(System.in);
    return new Posn( scanner.nextInt(), scanner.nextInt());
  }
}
