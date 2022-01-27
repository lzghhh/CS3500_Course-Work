/**
 * this class represents a yes/no question.
 */
public class YesNoQuestion extends QuestionAbstrct {

  /**
   * A question must be non empty and should end with a question mark.
   * @param text the input question text.
   * @throws IllegalArgumentException throw illegal argument when the input text is not valid.
   */
  public YesNoQuestion(String text) throws IllegalArgumentException {
    super(text);
    if (text.charAt(text.length() - 1) != '?') {
      throw new IllegalArgumentException("Invalid question text");
    }
    String[] realOption = {"yes", "no"};
    this.options = realOption;
  }

  @Override
  public String getType() {
    return "YesNo";
  }
}
