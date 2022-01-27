/**
 * This class represents a yes/no question, which is an extension of the {@code AbstractQuestion}
 * class.
 */
public class YesNoQuestion extends AbstractQuestion {

  /**
   * Constructs a {@code YesNoQuestion} object.
   * @param text the text of the question the user would like to input
   * @throws IllegalArgumentException if {@code text} is an empty string, or if {@code text} doesn't
   *         end with a question mark
   */
  public YesNoQuestion(String text) throws IllegalArgumentException {
    super(text);
    if ((text.charAt(text.length() - 1) != '?')) {
      throw new IllegalArgumentException("Invalid question text");
    }
  }

  @Override
  public String getType() {
    return "YesNo";
  }

  /**
   * This method ensures that the answer given is yes or no, regardless of case.
   * @param ans the answer the user would like to check for validity
   * @return true if valid, false if not
   */
  protected boolean isAnswerValid(String ans) {
    return (ans.equalsIgnoreCase("yes")) || (ans.equalsIgnoreCase("no"));
  }
}
