/**
 * This class represents a multiple choice question, which is an extension of the
 * {@code AbstractQuestion} class. It tracks the desired answer options and the possible answer
 * choices, as well as the question and entered answer. The possible answers can be anything, but
 * they must be referenced by the numbers starting from 1 sequentially, ex "1", "2", "3"..., where
 * the number of options corresponds to the number of given answers.
 */
public class MultipleChoiceQuestion extends AbstractQuestion {
  private final String[] options;
  private final String[] answers;

  /**
   * Constructs a {@code MultipleChoiceQuestion} object.
   * @param text the text of the question the user would like to input
   * @param answers the list of answers being submitted
   * @throws IllegalArgumentException if {@code text} is an empty string, or if
   * {@code answers} has no items.
   */
  public MultipleChoiceQuestion(String text, String[] answers) throws IllegalArgumentException {
    super(text);

    if (answers.length == 0) {
      throw new IllegalArgumentException("Invalid number of answers!");
    }

    String[] lowercaseAns = new String[answers.length];
    for (int i = 0; i < answers.length; i++) {
      lowercaseAns[i] = answers[i].toLowerCase();
    }
    this.answers = lowercaseAns;

    String[] options = new String[answers.length];
    for (int i = 0; i < answers.length; i++) {
      options[i] = String.valueOf(i + 1);
    }
    this.options = options;
  }

  @Override
  public String getType() {
    return "Multiple Choice";
  }

  @Override
  public void answer(String enteredAnswer) {
    super.answer(enteredAnswer);
    // instead of being set to the entered answer (ex "1"), the enteredAnswer
    // field gets the corresponding answer
    this.enteredAnswer = answers[Integer.parseInt(enteredAnswer) - 1];
  }

  /**
   * This method ensures the answer given is one of the possible numbers (as a String).
   * @param ans the answer the user would like to check for validity
   * @return true is valid, false if not
   */
  protected boolean isAnswerValid(String ans) {
    for (String option : options) {
      if (ans.equals(option)) {
        return true;
      }
    }

    return false;
  }
}
