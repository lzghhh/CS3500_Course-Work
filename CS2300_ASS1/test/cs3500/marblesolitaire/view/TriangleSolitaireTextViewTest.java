package cs3500.marblesolitaire.view;

import org.junit.Before;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test all methods in the TriangleSolitaireTextView class.
 */

public class TriangleSolitaireTextViewTest {
  TriangleSolitaireModel board1;
  TriangleSolitaireModel board2;
  TriangleSolitaireModel board3;
  TriangleSolitaireModel board4;

  @Before
  public void setUp() throws Exception {
    board1 = new TriangleSolitaireModel();
    board2 = new TriangleSolitaireModel(10);
    board3 = new TriangleSolitaireModel(3,2,0);
    board4 = new TriangleSolitaireModel(2,0);
  }

  @Test
  public void testToStringConstructor1() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", new TriangleSolitaireTextView(board1).toString());
  }

  @Test
  public void testToStringConstructor2() {
    assertEquals("         _\n" +
            "        O O\n" +
            "       O O O\n" +
            "      O O O O\n" +
            "     O O O O O\n" +
            "    O O O O O O\n" +
            "   O O O O O O O\n" +
            "  O O O O O O O O\n" +
            " O O O O O O O O O\n" +
            "O O O O O O O O O O", new TriangleSolitaireTextView(this.board2).toString());
  }

  @Test
  public void testToStringConstructor3() {
    assertEquals("  O\n" +
            " O O\n" +
            "_ O O", new TriangleSolitaireTextView(this.board3).toString());
  }

  @Test
  public void testToStringConstructor4() {
    assertEquals("    O\n" +
            "   O O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", new TriangleSolitaireTextView(this.board4).toString());
  }

  @Test
  public void testToStringConstructor4Move() {
    board1.move(2,0,0,0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", new TriangleSolitaireTextView(this.board1).toString());
  }

  @Test (expected =  IllegalArgumentException.class)
  public void testViewConstructFailWithNullState() {
    StringBuilder append = null;
    new TriangleSolitaireTextView(board1, append);
  }

  @Test (expected =  IllegalArgumentException.class)
  public void testViewConstructFailWithNullModel() {
    MarbleSolitaireModelState state = null;
    StringBuilder append = new StringBuilder("1 2");
    new TriangleSolitaireTextView(state, append);
  }

  @Test (expected =  IllegalArgumentException.class)
  public void testViewConstructFailWithNullBoth() {
    MarbleSolitaireModelState state = null;
    StringBuilder append = null;
    new TriangleSolitaireTextView(state, append);
  }

  @Test
  public void testrenderBoardDefault() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(board1, append);
      view.renderBoard();
      assertEquals("    _\n" +
              "   O O\n" +
              "  O O O\n" +
              " O O O O\n" +
              "O O O O O", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderBoardCenterElse() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(board3, append);
      view.renderBoard();
      assertEquals("  O\n" +
              " O O\n" +
              "_ O O", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderBoardLarge() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(board2, append);
      view.renderBoard();
      assertEquals("         _\n" +
              "        O O\n" +
              "       O O O\n" +
              "      O O O O\n" +
              "     O O O O O\n" +
              "    O O O O O O\n" +
              "   O O O O O O O\n" +
              "  O O O O O O O O\n" +
              " O O O O O O O O O\n" +
              "O O O O O O O O O O", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderMessage1() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(board1, append);
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
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(board1, append);
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
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(board3, append);
      view.renderBoard();
      view.renderMessage("Game not end yet!");
      assertEquals("  O\n" +
              " O O\n" +
              "_ O OGame not end yet!", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderMessageBeforerenderBoard() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(board3, append);
      view.renderMessage("Game not end yet!");
      view.renderBoard();
      assertEquals("Game not end yet!  O\n" +
              " O O\n" +
              "_ O O", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testrenderMass() throws IOException {
    try {
      StringBuilder append = new StringBuilder();
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(board3, append);
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
              "  O\n" +
              " O O\n" +
              "_ O O\n" +
              "Is Game en?\n" +
              "  O\n" +
              " O O\n" +
              "_ O O\n" +
              "Game end!", append.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
