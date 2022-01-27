import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.fail;

/**
 * An abstract class that represents different types tests for different types of questions.
 */
public abstract class TestAbstract {
  protected String longRandom;
  protected String guestionType;
  protected String[] answers;
  protected String givenQuestion;
  protected String[] inCorrectAnswer;
  protected String failString;

  public TestAbstract() {
    this.longRandom = "aosdifjaso oifhas;ldihv;al skdfha;osidghv;osiadhvbasdjkhvn";
  }

  protected abstract Question makeQuestion(String questionText);

  @Test
  public void testCreateValidQuestion() {
    Random r = new Random(200);
    for (int i = 0; i < 1000; i++) {
      int start = r.nextInt(longRandom.length() - 1);
      int end = start + r.nextInt(longRandom.length() - start - 1) + 1;
      String questionText = longRandom.substring(start,end);
      Question q = makeQuestion(questionText);
      assertEquals(questionText + "?",q.getQuestionText());
      assertEquals(guestionType, q.getType());
    }
  }


  @Test (expected = IllegalArgumentException.class)
  public void testCreateQuestionNoText() {
    makeQuestion("");
  }

  @Test
  public void testAnswerCorrectly() {
    for (String answer:answers) {
      Question q = makeQuestion(this.givenQuestion);
      assertFalse(q.hasBeenAnswered());
      q.answer(answer);
      assertEquals(answer.toLowerCase(), q.getEnteredAnswer());
      assertTrue(q.hasBeenAnswered());
    }
  }

  @Test
  public void testAnswerInCorrectly() {
    String []answers = this.inCorrectAnswer;
    for (String answer:answers) {
      Question q = makeQuestion(givenQuestion);
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer(answer);
        fail(this.failString);
      }
      catch (IllegalArgumentException e) {
        assertFalse(q.hasBeenAnswered());
      }
    }
  }

}
