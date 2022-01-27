import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;


import static org.junit.Assert.assertEquals;

/**
 * Test class for confirming the input.
 */

public class ConfirmInputsTest {
  @Test
  public void testInputs() throws IOException {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel controller = new ConfirmInput(log);
    try {
      MarbleSolitaireModel model = new EnglishSolitaireModel();
      Reader in = new StringReader("2 4 4 4");
      StringBuilder needLessOutput = new StringBuilder();
      MarbleSolitaireController test = new MarbleSolitaireControllerImpl(model,
              new MarbleSolitaireTextView(model, needLessOutput), in);

      test.playGame();

    } catch (IllegalStateException e) {
      controller.move(2, 4, 4, 4);
      assertEquals("2 4 4 4", log.toString());
    }
  }

  @Test
  public void testInputs2() throws IOException {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel controller = new ConfirmInput(log);
    try {
      MarbleSolitaireModel model = new EnglishSolitaireModel();
      Reader in = new StringReader("2 4 4 4 5 4 3 4");
      StringBuilder needLessOutput = new StringBuilder();
      MarbleSolitaireController test = new MarbleSolitaireControllerImpl(model,
              new MarbleSolitaireTextView(model, needLessOutput), in);

      test.playGame();

    } catch (IllegalStateException e) {
      controller.move(2, 4, 4, 4);
      controller.move(5, 4, 3, 4);
      assertEquals("2 4 4 45 4 3 4", log.toString());
    }
  }
}