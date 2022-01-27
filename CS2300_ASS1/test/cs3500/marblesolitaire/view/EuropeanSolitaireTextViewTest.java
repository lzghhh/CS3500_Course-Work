package cs3500.marblesolitaire.view;

import org.junit.Before;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test all methods in the EuropeanSolitaireTextView class.
 */

public class EuropeanSolitaireTextViewTest {
  EuropeanSolitaireModel board1;
  EuropeanSolitaireModel board2;
  EuropeanSolitaireModel board3;
  EuropeanSolitaireModel board4;

  @Before
  public void setUp() throws Exception {
    board1 = new EuropeanSolitaireModel();
    board2 = new EuropeanSolitaireModel(5);
    board3 = new EuropeanSolitaireModel(3,2,3);
    board4 = new EuropeanSolitaireModel(2,3);
  }

  @Test
  public void testToStringConstructor1() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.board1).toString());
  }

  @Test
  public void testToStringConstructor2() {
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", new MarbleSolitaireTextView(this.board2).toString());
  }

  @Test
  public void testToStringConstructor3() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.board3).toString());
  }

  @Test
  public void testToStringConstructorMove() {
    board3.move(2,1,2,3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.board3).toString());
  }

  @Test
  public void testToStringConstructor4() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.board4).toString());
  }

  @Test
  public void testToStringConstructor4Move() {
    board1.move(1,3,3,3);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.board1).toString());
  }

  @Test (expected =  IllegalArgumentException.class)
  public void testViewConstructFailWithNullState() {
    StringBuilder append = null;
    new MarbleSolitaireTextView(board1, append);
  }

  @Test (expected =  IllegalArgumentException.class)
  public void testViewConstructFailWithNullModel() {
    MarbleSolitaireModelState state = null;
    StringBuilder append = new StringBuilder("1 2");
    new MarbleSolitaireTextView(state, append);
  }

  @Test (expected =  IllegalArgumentException.class)
  public void testViewConstructFailWithNullBoth() {
    MarbleSolitaireModelState state = null;
    StringBuilder append = null;
    new MarbleSolitaireTextView(state, append);
  }

  @Test
  public void testrenderBoardDefault() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(board1, append);
      view.renderBoard();
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderBoardCenterElse() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(board3, append);
      view.renderBoard();
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderBoardLarge() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(board2, append);
      view.renderBoard();
      assertEquals("        O O O O O\n" +
              "      O O O O O O O\n" +
              "    O O O O O O O O O\n" +
              "  O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O _ O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "  O O O O O O O O O O O\n" +
              "    O O O O O O O O O\n" +
              "      O O O O O O O\n" +
              "        O O O O O", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderMessage1() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(board1, append);
      view.renderMessage("Game over:");
      assertEquals("Game over:", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderMessage2Null() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(board1, append);
      view.renderMessage("");
      assertEquals("", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderMessageAfterrenderBoard() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(board3, append);
      view.renderBoard();
      view.renderMessage("Game not end yet!");
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O OGame not end yet!", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderMessageBeforerenderBoard() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(board3, append);
      view.renderMessage("Game not end yet!");
      view.renderBoard();
      assertEquals("Game not end yet!    O O O\n" +
              "  O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderMass() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(board3, append);
      view.renderMessage("Game not end yet!");
      view.renderMessage("\n");
      view.renderBoard();
      view.renderMessage("\n");
      view.renderMessage("Is Game en?");
      view.renderMessage("\n");
      view.renderBoard();
      view.renderMessage("\n");
      view.renderMessage("Game end!");
      assertEquals("Game not end yet!\n" +
              "    O O O\n" +
              "  O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O\n" +
              "Is Game en?\n" +
              "    O O O\n" +
              "  O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O\n" +
              "Game end!", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
