/**
 * This class contains tests for {@code LikertQuestion}.
 */
public class LikertQuestionTest extends AbstractTest {
  /**
   * This constructs a {@code LikertQuestionTest} object.
   */
  public LikertQuestionTest() {
    super("Likert", new String[]{"strongly agree", "agree", "neither agree nor disagree",
        "disagree", "strongly disagree"}, new String[]{"weakly disagree",""},
        new String[]{"strongly agree", "agree", "neither agree nor disagree", "disagree",
            "strongly disagree"});
  }

  protected Question createQuestion(String questionText) {
    return new LikertQuestion(questionText);
  }
}