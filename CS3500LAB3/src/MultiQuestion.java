/**
 * this class represents a multiple choice question.
 * the answers are several listed answers with order numbers.
 */
public class MultiQuestion extends QuestionAbstrct {
  /**
   * This constructor represents a Multiple Choice question with question text input.
   * @param text the input question text.
   * @param answers the String list of provided answer choices.
   * @throws IllegalArgumentException throw illegal argument when the input text is not valid.
   */
  public MultiQuestion(String text, String[] answers) throws IllegalArgumentException {
    super(text);
    for (int i = 0; i < answers.length; i++) {
      if (!answers[i].substring(0, 1).equals(String.valueOf(i + 1))) {
        throw new IllegalArgumentException("Invalid answer text");
      }
    }
    this.options = answers;
  }

  @Override
  public String getType() {
    return "Multiple Choice Question";
  }
}