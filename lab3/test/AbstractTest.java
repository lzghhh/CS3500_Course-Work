import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;
import org.junit.Test;

/**
 * This class tests all subclasses of {@code AbstractQuestion}.
 */
public abstract class AbstractTest {
  protected String longRandom;
  protected String type;
  protected String[] answerOptions;
  protected String[] incorrectAns;
  protected String[] answers;

  protected AbstractTest(String type, String[] answerOptions, String[] incorrectAns,
      String[] answers) {
    longRandom = "aosdifjaso oifhas;ldihv;al skdfha;osidghv;osiadhvbasdjkhvn";
    this.type = type;
    this.answerOptions = answerOptions;
    this.incorrectAns = incorrectAns;
    this.answers = answers;
  }

  protected abstract Question createQuestion(String questionText);

  @Test
  public void testCreateValidQuestion() {
    Random r = new Random(200);
    for (int i = 0; i < 1000; i++) {
      int start = r.nextInt(longRandom.length() - 1);
      int end = start + r.nextInt(longRandom.length() - start - 1) + 1;
      String questionText = longRandom.substring(start, end);
      Question q = createQuestion(questionText + "?");
      assertEquals(questionText + "?", q.getQuestionText());
      assertEquals(type, q.getType());
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateQuestionNoText() {
    createQuestion("");
  }

  @Test
  public void testAnswerCorrectly() {
    int i = 0;
    for (String answer:answerOptions) {
      Question q = createQuestion("Is this a trick question?");
      assertFalse(q.hasBeenAnswered());

      q.answer(answer);
      assertEquals(answers[i].toLowerCase(), q.getEnteredAnswer());
      assertTrue(q.hasBeenAnswered());
      i++;
    }
  }

  @Test
  public void testAnswerInCorrectly() {
    String[] answers = {"weakly disagree", ""};
    for (String answer : answers) {
      Question q = createQuestion("Is this a trick question?");
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer(answer);
        fail(q.getType() + " question accepted an invalid answer");
      } catch (IllegalArgumentException e) {
        assertFalse(q.hasBeenAnswered());
      }
    }
  }
}
