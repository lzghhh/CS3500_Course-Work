/**
 * The test class for Multiple Choice Questions that inherits from the TestAbstract class.
 */
public class MultiQuestionTest extends TestAbstract {
  /**
   * The constructor for the test class of Multiple Choice Questions.
   */
  public MultiQuestionTest() {
    super();
    this.guestionType = "Multiple Choice Question";
    this.answers = new String[]{"1Shanghai", "2Beijing", "3Nanjing", "4Guangzhou", "5Chongqing"};
    this.givenQuestion = "Which one is the capital of China";
    this.inCorrectAnswer = new String[]{"shanghai",""};
    this.failString = "Multiple Choice Question accepted an invalid answer";
  }


  @Override
  protected Question makeQuestion(String questionText) {
    if (questionText.equals("")) {
      throw new IllegalArgumentException("Invalid question text");
    }
    return new MultiQuestion(questionText + "?", answers);
  }
}
