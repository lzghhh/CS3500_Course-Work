/**
 * The test class for LikertQuestions that inherits from the TestAbstract class.
 */
public class LikertQuestionTest extends TestAbstract {
  /**
   * The constructor for the test class of Likert Questions.
   */
  public LikertQuestionTest() {
    super();
    this.guestionType = "Likert";
    this.answers = new String[]{"strongly agree", "agree", "neither agree nor disagree", "disagree",
                                "strongly disagree"};
    this.givenQuestion = "Is this a trick question?";
    this.inCorrectAnswer = new String[]{"weakly disagree",""};
    this.failString = "Likert question accepted an invalid answer";
  }

  @Override
  public Question makeQuestion(String questionText) {
    if (questionText.equals("")) {
      throw new IllegalArgumentException("Invalid question text");
    }
    return new LikertQuestion(questionText + "?");
  }
}