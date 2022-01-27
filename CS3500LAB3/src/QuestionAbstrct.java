/**
 * An abstract class that represents different types of questions with certain shared methods.
 */
public abstract class QuestionAbstrct implements Question {

  protected final String QuestionText;
  protected String enteredAnswer;
  protected String [] options;

  protected QuestionAbstrct(String text) {
    if (text.length() == 0) {
      throw new IllegalArgumentException("Invalid question text");
    }
    this.QuestionText = text;
    this.enteredAnswer = "";
  }

  /**
   * Get the text of this question.
   * @return the text of this question as a string
   */
  @Override
  public String getQuestionText() {
    return this.QuestionText;
  }

  /**
   * Get a string that represents the type of this question.
   * The actual string returned depends on the implementation.
   * @return the type of this question, as a string
   */
  public abstract String getType();

  /**
   * Enter an answer to this question. Specific implementations may enforce constraints
   * on what a valid answer can be.
   * @param enteredAnswer the answer entered for this question by a student
   */
  @Override
  public void answer(String enteredAnswer) {

    for (String option : options) {
      if (enteredAnswer.toLowerCase().equals(option.toLowerCase())) {
        this.enteredAnswer = enteredAnswer.toLowerCase();
        return;
      }
    }
    throw new IllegalArgumentException("Invalid answer");
  }

  /**
   * Returns whether this question has been answered by the student.
   * @return true if the question has been answered, false otherwise
   */
  @Override
  public boolean hasBeenAnswered() {
    for (String option:options) {
      if (enteredAnswer.toLowerCase().equals(option.toLowerCase())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Return the answer entered by the student, if it has been entered.
   * @return the answer entered by the student
   * @throws IllegalStateException if the question has not been answered yet
   */
  @Override
  public String getEnteredAnswer() throws IllegalStateException {
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("solution.Question not attempted yet!");
    }
    else {
      return enteredAnswer;
    }
  }
}
