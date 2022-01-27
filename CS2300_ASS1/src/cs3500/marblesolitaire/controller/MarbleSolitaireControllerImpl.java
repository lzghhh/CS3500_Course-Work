package cs3500.marblesolitaire.controller;

import java.io.IOException;

import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This is the implenmentation class of the controller that will give information to the model to
 * make moves and render board or message to the view to display the game.
 */

public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable in = null;

  /**
   * This is the constructor for the controller that takes inputs from model and view and gives
   * back some updated information.
   * @param model The model of the game state.
   * @param view The print of the game state and message.
   * @param readable The user input information.
   * @throws IllegalArgumentException When arguments are null.
   */

  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable readable) throws IllegalArgumentException {
    try {
      if (model == null || view == null || readable == null) {
        throw new IllegalArgumentException("Null argument.");
      }

      this.model = model;
      this.view = view;
      this.in = readable;
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }

  }


  private void renderQuit() {
    try {
      this.view.renderMessage("\n");
      this.view.renderMessage("Game quit!");
      this.view.renderMessage("\n");
      this.view.renderMessage("State of game when quit:");
      this.view.renderMessage("\n");
      this.view.renderBoard();
      this.view.renderMessage("\n");
      this.view.renderMessage("Score: " + this.model.getScore());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void playGame() throws IllegalStateException {
    try {
      Scanner scan = new Scanner(this.in);
      int num1;
      int num2 ;
      int num3;
      int num4 ;
      this.view.renderBoard();
      this.view.renderMessage("\n");
      while (true) {
        do {
          while (!scan.hasNextInt()) {
            if (!scan.hasNext()) {
              throw new IllegalStateException("hhh");
            } else {
              if (scan.next().equalsIgnoreCase("q")) {
                this.renderQuit();
                return;
              }
            }
          }
          num1 = scan.nextInt();
        }
        while (num1 <= 0);

        do {
          while (!scan.hasNextInt()) {
            if (!scan.hasNext()) {
              throw new IllegalStateException("hhh");
            } else {
              if (scan.next().equalsIgnoreCase("q")) {
                this.renderQuit();
                return;
              }
            }
          }
          num2 = scan.nextInt();
        }
        while (num2 <= 0);

        do {
          while (!scan.hasNextInt()) {
            if (!scan.hasNext()) {
              throw new IllegalStateException("hhh");
            } else {
              if (scan.next().equalsIgnoreCase("q")) {
                this.renderQuit();
                return;
              }
            }
          }
          num3 = scan.nextInt();
        }
        while (num3 <= 0);

        do {
          while (!scan.hasNextInt()) {
            if (!scan.hasNext()) {
              throw new IllegalStateException("hhh");
            } else {
              if (scan.next().equalsIgnoreCase("q")) {
                this.renderQuit();
                return;
              }
            }
          }
          num4 = scan.nextInt();
        }
        while (num4 <= 0);


        try {
          int fromRow = num1 - 1;
          int fromCOl = num2 - 1;
          int toRow = num3 - 1;
          int toCol = num4 - 1;
          this.model.move(fromRow, fromCOl, toRow, toCol);
          if (this.model.isGameOver()) {
            this.view.renderMessage("\n");
            this.view.renderMessage("Game over!");
            this.view.renderMessage("\n");
            this.view.renderBoard();
            this.view.renderMessage("\n");
            this.view.renderMessage("Score: " + this.model.getScore());
            return;
          }  else {
            this.view.renderBoard();
            this.view.renderMessage("\n");
            this.view.renderMessage("Score: " + this.model.getScore());
          }

        } catch (IllegalArgumentException a) {
          this.view.renderMessage("Invalid move. Play again.");
        }
      }
    } catch (IOException e) {
      throw new IllegalStateException("The appendable writes fail.");
    }

  }
}

