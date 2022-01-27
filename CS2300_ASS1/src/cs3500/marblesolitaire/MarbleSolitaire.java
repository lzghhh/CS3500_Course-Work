package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This the main class that allows the user to customize the game that has option of three different
 * type of solitaires with customized size and center point with arugment -size and -hole.
 */

public final class MarbleSolitaire {

  /**
   * The Main class to run the whole program with user input.
   * @param args The user input.
   */
  public static void main(String[] args) {

    switch (args[0]) {
      case "english":
        if (args.length <= 1) {
          EnglishSolitaireModel boardEng1 = new EnglishSolitaireModel();
          new MarbleSolitaireControllerImpl(boardEng1,
                  new MarbleSolitaireTextView(boardEng1),
                  new InputStreamReader(System.in)).playGame();
        } else {
          if (args[1].equals("-hole")) {
            if (args.length > 4) {
              EnglishSolitaireModel threeArg = new EnglishSolitaireModel(Integer.parseInt(args[5]),
                      Integer.parseInt(args[2]) - 1, Integer.parseInt(args[3]) - 1);
              new MarbleSolitaireControllerImpl(threeArg,
                      new MarbleSolitaireTextView(threeArg),
                      new InputStreamReader(System.in)).playGame();
            } else {
              EnglishSolitaireModel twoArg = new EnglishSolitaireModel(
                      Integer.parseInt(args[2]) - 1,
                      Integer.parseInt(args[3]) - 1);
              new MarbleSolitaireControllerImpl(twoArg,
                      new MarbleSolitaireTextView(twoArg),
                      new InputStreamReader(System.in)).playGame();
            }
          } else {
            if (args.length > 3) {
              EnglishSolitaireModel threeArg = new EnglishSolitaireModel(Integer.parseInt(args[2]),
                      Integer.parseInt(args[4]) - 1, Integer.parseInt(args[5]) - 1);
              new MarbleSolitaireControllerImpl(threeArg,
                      new MarbleSolitaireTextView(threeArg),
                      new InputStreamReader(System.in)).playGame();
            } else {
              EnglishSolitaireModel oneArg = new EnglishSolitaireModel(Integer.parseInt(args[2]));
              new MarbleSolitaireControllerImpl(oneArg,
                      new MarbleSolitaireTextView(oneArg),
                      new InputStreamReader(System.in)).playGame();
            }
          }
        }
        break;

      case "triangular":
        if (args.length <= 1) {
          TriangleSolitaireModel boardEng1 = new TriangleSolitaireModel();
          new MarbleSolitaireControllerImpl(boardEng1,
                  new TriangleSolitaireTextView(boardEng1),
                  new InputStreamReader(System.in)).playGame();
        } else {
          if (args[1].equals("-hole")) {
            if (args.length > 4) {
              TriangleSolitaireModel threeArg = new TriangleSolitaireModel(
                      Integer.parseInt(args[5]),
                      Integer.parseInt(args[2]) - 1, Integer.parseInt(args[3]) - 1);
              new MarbleSolitaireControllerImpl(threeArg,
                      new TriangleSolitaireTextView(threeArg),
                      new InputStreamReader(System.in)).playGame();
            } else {
              TriangleSolitaireModel twoArg = new TriangleSolitaireModel(
                      Integer.parseInt(args[2]) - 1,
                      Integer.parseInt(args[3]) - 1);
              new MarbleSolitaireControllerImpl(twoArg,
                      new TriangleSolitaireTextView(twoArg),
                      new InputStreamReader(System.in)).playGame();
            }
          } else {
            if (args.length > 3) {
              TriangleSolitaireModel threeArg = new TriangleSolitaireModel(
                      Integer.parseInt(args[2]),
                      Integer.parseInt(args[4]) - 1, Integer.parseInt(args[5]) - 1);
              new MarbleSolitaireControllerImpl(threeArg,
                      new TriangleSolitaireTextView(threeArg),
                      new InputStreamReader(System.in)).playGame();
            } else {
              TriangleSolitaireModel oneArg = new TriangleSolitaireModel(Integer.parseInt(args[2]));
              new MarbleSolitaireControllerImpl(oneArg,
                      new TriangleSolitaireTextView(oneArg),
                      new InputStreamReader(System.in)).playGame();
            }
          }
        }
        break;

      case "european":
        if (args.length <= 1) {
          EuropeanSolitaireModel boardEng1 = new EuropeanSolitaireModel();
          new MarbleSolitaireControllerImpl(boardEng1,
                  new MarbleSolitaireTextView(boardEng1),
                  new InputStreamReader(System.in)).playGame();
        } else {
          if (args[1].equals("-hole")) {
            if (args.length > 4) {
              EuropeanSolitaireModel threeArg = new EuropeanSolitaireModel(
                      Integer.parseInt(args[5]),
                      Integer.parseInt(args[2]) - 1, Integer.parseInt(args[3]) - 1);
              new MarbleSolitaireControllerImpl(threeArg,
                      new MarbleSolitaireTextView(threeArg),
                      new InputStreamReader(System.in)).playGame();
            } else {
              EuropeanSolitaireModel twoArg = new EuropeanSolitaireModel(
                      Integer.parseInt(args[2]) - 1,
                      Integer.parseInt(args[3]) - 1);
              new MarbleSolitaireControllerImpl(twoArg,
                      new MarbleSolitaireTextView(twoArg),
                      new InputStreamReader(System.in)).playGame();
            }
          } else {
            if (args.length > 3) {
              EuropeanSolitaireModel threeArg = new EuropeanSolitaireModel(
                      Integer.parseInt(args[2]),
                      Integer.parseInt(args[4]) - 1, Integer.parseInt(args[5]) - 1);
              new MarbleSolitaireControllerImpl(threeArg,
                      new MarbleSolitaireTextView(threeArg),
                      new InputStreamReader(System.in)).playGame();
            } else {
              EuropeanSolitaireModel oneArg = new EuropeanSolitaireModel(Integer.parseInt(args[2]));
              new MarbleSolitaireControllerImpl(oneArg,
                      new MarbleSolitaireTextView(oneArg),
                      new InputStreamReader(System.in)).playGame();
            }
          }
        }
        break;

      default: break;
    }
  }
}