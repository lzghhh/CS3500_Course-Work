package cs3500.tictactoe.model;

/**
 * Created by vidojemihajlovikj on 10/29/21.
 */
public interface IReadOnlyTicTacToeModel {
  int getWidth();
  int getHeight();
  int getGoal();
  Piece getPieceAt(int r, int c);
  Status gameStatus();
  Piece getWinner();
}
