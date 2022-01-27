package cs3500.tictactoe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import cs3500.tictactoe.model.*;
import cs3500.tictactoe.my_strategies.BlockWin;
import cs3500.tictactoe.my_strategies.IPlayStrategy;
import cs3500.tictactoe.my_strategies.PlayACorner;
import cs3500.tictactoe.my_strategies.PlayFirstEmptySpot;
import cs3500.tictactoe.my_strategies.PlayHuman;
import cs3500.tictactoe.my_strategies.TryToWin;
import cs3500.tictactoe.strategy.Posn;

/**
 * Simple TicTacToe controller
 */
public class TTTController implements TicTacToeController {
  private final TicTacToeModel model;
  private int playerIndex;
  private final List<Player> players;
  private final Appendable output;
//  private final List<IPlayStrategy> hard;
//  private final List<IPlayStrategy> medium;
//  private final List<IPlayStrategy> easy;

  public TTTController(TicTacToeModel model, Appendable output) {
    this.model = Objects.requireNonNull(model);
    this.players = new ArrayList<Player>();
    this.output = Objects.requireNonNull(output);
    //this.easy = new ArrayList<IPlayStrategy>(Arrays.asList( new PlayACorner(), new PlayFirstEmptySpot()));
  }

  @Override
  public void addPlayer(Player player) {
    this.players.add(Objects.requireNonNull(player));
  }



  @Override
  public void play() {
    this.playerIndex = 0;
    while (this.model.gameStatus() == Status.Playing) {
      this.printBoard();

      Player currentPlayer = this.players.get(this.playerIndex);
      Posn pos = currentPlayer.getPositionToPlay(model);

      try {
        this.model.setPieceAt(pos.r, pos.c, currentPlayer.getPiece());
        this.playerIndex = (this.playerIndex + 1) % this.players.size();
      } catch (Exception e) {
        System.out.println("Got an exception.");
      }
    }

    this.printBoard();
    try {
      if (this.model.gameStatus() == Status.Won)
        output.append("Player " + this.model.getWinner().toString() + " won");
      else
        output.append("Tie game");
    } catch (IOException e) {

    }
  }

  public void printBoard() {
    try {
      output.append("\n");
      for (int r = 0; r < this.model.getHeight(); r++) {
        if (r > 0) {
          for (int c = 0; c < this.model.getWidth(); c++) {
            if (c > 0)
              output.append("+");
            output.append("-");
          }
          output.append("\n");
        }
        for (int c = 0; c < this.model.getWidth(); c++) {
          if (c > 0) output.append("|");
          output.append(this.model.getPieceAt(r, c).toString());
        }
        output.append("\n");
      }
    } catch (IOException e) {

    }
  }
}
