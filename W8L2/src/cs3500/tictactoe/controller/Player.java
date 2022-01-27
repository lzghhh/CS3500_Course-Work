package cs3500.tictactoe.controller;

import cs3500.tictactoe.model.IReadOnlyTicTacToeModel;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TicTacToeModel;
import cs3500.tictactoe.strategy.Posn;

/**
 * A simple Player interface
 */
public interface Player {
  Piece getPiece();
  PlayerType getPlayerType();
  Posn getPositionToPlay(IReadOnlyTicTacToeModel model);
}
