import org.junit.Test;

/**
 * The test class for YesNo Questions that inherits from the TestAbstract class.
 */
public class YesNoQuestionTest extends TestAbstract {
  /**
   * The constructor for the test class of YesNo Questions.
   */
  public YesNoQuestionTest() {
    super();
    this.guestionType = "YesNo";
    this.answers = new String[]{"yes","Yes","YEs","YeS","YES", "yEs","yES","yeS","no","No","nO",
                                "NO"};
    this.givenQuestion = "Is this a trick question?";
    this.inCorrectAnswer = new String[]{"yess",""};
    this.failString = "Yes No question accepted an invalid answer";
  }

  @Override
  public Question makeQuestion(String questionText) {
    if (questionText.equals("")) {
      throw new IllegalArgumentException("Invalid question text");
    }
    return new YesNoQuestion(questionText + "?");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCreateYesNoQuestionNoQuestionMark() {
    new YesNoQuestion("Is this fun");
  }
}