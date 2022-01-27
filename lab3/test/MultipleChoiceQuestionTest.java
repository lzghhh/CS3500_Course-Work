import org.junit.Test;

/**
 * This class contains tests for {@code MultipleChoiceQuestion}.
 */
public class MultipleChoiceQuestionTest extends AbstractTest {
  /**
   * This constructs a {@code MultipleChoiceQuestionTest} object.
   */
  public MultipleChoiceQuestionTest() {
    super("Multiple Choice", new String[]{"1", "2", "3", "4"}, new String[]{"", "7"},
        new String[]{"Answer 1", "Number 2", "Ans 3", "Numero Quattro"});
  }

  @Override
  protected Question createQuestion(String questionText) {
    return new MultipleChoiceQuestion(questionText, new String[]{"Answer 1", "Number 2", "Ans 3",
        "Numero Quattro"});
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateMultipleChoiceQuestionNonPosNumAns() {
    new MultipleChoiceQuestion("Is this fun?", new String[]{});
  }
}
