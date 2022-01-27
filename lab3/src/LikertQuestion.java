/**
 * This class represents a 5-scale likert question, which is an extension of the
 * {@code AbstractQuestion} class. It tracks the possible answer choices as well as the question
 * and answer. The scales are strongly agree, agree, neither agree nor disagree, disagree and
 * strongly disagree.
 */
public class LikertQuestion extends AbstractQuestion {
  private final String[] options;

  /**
   * Creates a {@code LikertQuestion} object.
   * @param text the text of the question the user would like to input
   * @throws IllegalArgumentException if {@code text} is an empty string
   */
  public LikertQuestion(String text) throws IllegalArgumentException {
    super(text);
    options = new String[]{"strongly agree","agree","neither agree nor disagree","disagree",
        "strongly disagree"};
  }

  @Override
  public String getType() {
    return "Likert";
  }

  /**
   * Checks to see if the given input is one of the 5 options, in a case-insensitive manner.
   * @param ans the answer the user would like to check for validity
   * @return true if valid, false if not
   */
  protected boolean isAnswerValid(String ans) {
    for (String option:options) {
      if (ans.toLowerCase().equals(option)) {
        return true;
      }
    }
    return false;
  }
}
