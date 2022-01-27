package cs3500.tictactoe.model;

/**
 * Represents a TicTacToe board
 */
public interface TicTacToeModel extends IReadOnlyTicTacToeModel {
  void setPieceAt(int r, int c, Piece p);
}
