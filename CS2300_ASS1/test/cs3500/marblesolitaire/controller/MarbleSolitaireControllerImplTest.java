package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;


/**
 * This is the test class for the controller.
 */

public class MarbleSolitaireControllerImplTest {

  @Test (expected = IllegalArgumentException.class)
  public void testPlayGameConsNullIn() {
    StringBuilder out = new StringBuilder();
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    new MarbleSolitaireControllerImpl(model, new MarbleSolitaireTextView(model, out),null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPlayGameConsNullModel() {
    StringBuilder out = new StringBuilder();
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    new MarbleSolitaireControllerImpl(null, new MarbleSolitaireTextView(model, out),
            null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPlayGameConsNullView() {
    Reader in = new StringReader("");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    new MarbleSolitaireControllerImpl(model, null,in);
  }

  @Test
  public void playGameFailLongInput() {
    StringBuilder out = new StringBuilder();
    try {

      Reader in = new StringReader("2 4 4 4 1");
      EnglishSolitaireModel model = new EnglishSolitaireModel();
      MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
              new MarbleSolitaireTextView(model, out),
              in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O _ O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 31", out.toString());
    }
  }

  @Test
  public void playGameFailInvalidMoveNormal() {
    StringBuilder out = new StringBuilder();
    try {

      Reader in = new StringReader("2 4 3 4");
      EnglishSolitaireModel model = new EnglishSolitaireModel();
      MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
              new MarbleSolitaireTextView(model, out),
              in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Invalid move. Play again.", out.toString());
    }
  }

  @Test
  public void playGameFailInvalidMoveNormalNegative() {
    StringBuilder out = new StringBuilder();
    try {

      Reader in = new StringReader("-1 4 -3 4");
      EnglishSolitaireModel model = new EnglishSolitaireModel();
      MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
              new MarbleSolitaireTextView(model, out),
              in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n", out.toString());
    }
  }

  @Test
  public void playGameFailvalidMoveNormalNegative() {
    StringBuilder out = new StringBuilder();
    try {

      Reader in = new StringReader("-1 2 a 4 4 4");
      EnglishSolitaireModel model = new EnglishSolitaireModel();
      MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
              new MarbleSolitaireTextView(model, out),
              in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O _ O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 31", out.toString());
    }
  }

  @Test
  public void playGameFailvalidMoveNormal() {
    StringBuilder out = new StringBuilder();
    try {
      Reader in = new StringReader("2 4 4 4");
      EnglishSolitaireModel model = new EnglishSolitaireModel();
      MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
              new MarbleSolitaireTextView(model, out),
              in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O _ O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 31", out.toString());
    }
  }

  @Test
  public void playGameGamOver() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("2 4 4 4 5 4 3 4 7 4 5 4 4 2 4 4 4 5 4 3 4 7 4 5");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 29    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 28    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 27\n" +
            "Game over!\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 26", out.toString());

  }

  @Test
  public void playGameQuitIStart() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("q 2 4 4 4");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", out.toString());

  }

  @Test
  public void playGameQuitInOne() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("2 4 q 4 4");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", out.toString());

  }

  @Test
  public void playGameQuitAfterValidMove() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("2 4 4 4 q");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());

  }

  @Test
  public void playGameQuitAfterTwoValidMove() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("2 4 4 4 5 4 3 4 q");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30", out.toString());

  }

  @Test
  public void playGameQuitBetweenTwoValidMove() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("2 4 4 4 q 5 4 3 4 ");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());

  }

  @Test
  public void playGameQuitAfterFirstValidMoveThenMove() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("2 4 4 4 5 q 4 3 4 ");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());

  }

  @Test
  public void playGameQuitAfterInvalidMove() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("2 4 3 4 q ");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Invalid move. Play again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", out.toString());

  }

  @Test
  public void playGameQuitInInvalidNoYetMove() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("2 4 q 3 4");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", out.toString());

  }

  @Test
  public void playGameWin() {
    StringBuilder out = new StringBuilder();

    Reader in = new StringReader("4 2 4 4 6 3 4 3 5 1 5 3 5 4 5 2 5 6 5 4 7 5 5 5 4 5 6 5 7 3 7 "
            +
            "5 7 5 5 5 3 3 5 3 1 3 3 3 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 3 2 3 3 1 5 1 5 1 5 3 5 3 "
            +
            "5 5 3 7 3 5 3 4 3 6 5 7 3 7 3 7 3 5 1 5 1 3 1 3 3 3 3 2 3 4 3 4 3 6 3 6 5 6 5 6 5 4 5 "
            +
            "4 3 4 2 4 4 4");
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model,
            new MarbleSolitaireTextView(model, out),
            in);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 30    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 29    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 28    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 27    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ O O _ O\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 26    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "Score: 25    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 24    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 23    O O O\n" +
            "    O O O\n" +
            "O O _ O O O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 22    _ O O\n" +
            "    _ O O\n" +
            "O O O O O O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 21    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O O O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 20    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O _ _ O\n" +
            "    _ O O\n" +
            "    _ _ _\n" +
            "Score: 19    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O _ _ O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 18    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 17    _ O O\n" +
            "    O O _\n" +
            "O O _ O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 16    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "O O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 15    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 14    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 13    _ O O\n" +
            "    O O _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 12    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ _ O _\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 11    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ _ O O\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 10    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 9    O _ _\n" +
            "    O O _\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 8    _ _ _\n" +
            "    _ O _\n" +
            "_ O O _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 7    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 6    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ O _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 5    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 4    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1", out.toString());

  }

}