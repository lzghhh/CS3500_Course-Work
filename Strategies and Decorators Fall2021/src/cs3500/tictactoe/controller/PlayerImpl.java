package cs3500.tictactoe.controller;

import java.util.Objects;

import cs3500.tictactoe.model.IReadOnlyTicTacToeModel;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.my_strategies.IPlayStrategy;
import cs3500.tictactoe.strategy.Posn;

public class PlayerImpl implements Player {
  private final Piece piece;
  private final IPlayStrategy strategy;

  public PlayerImpl(Piece piece, IPlayStrategy strategy) {
    this.strategy = Objects.requireNonNull(strategy);
    this.piece = Objects.requireNonNull(piece);
  }

  @Override
  public Piece getPiece() {
    return this.piece;
  }

  @Override
  public PlayerType getPlayerType() {
    return getPlayerType();
  }

  @Override
  public Posn getPositionToPlay(IReadOnlyTicTacToeModel model) {
    return this.strategy.getPos(model, this.piece);
  }
}
