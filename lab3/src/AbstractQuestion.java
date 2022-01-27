/**
 * This class is an abstract version of the interface {@code Question}; all question classes
 * should extend this abstract class. It keeps track of the question asked, as well as the answer
 * entered by the client.
 */
public abstract class AbstractQuestion implements Question {
  protected String questionText;
  protected String enteredAnswer;

  /**
   * Constructs an {@code AbstractQuestion} object. This can only be done by subclasses of this
   * class.
   * @param text the text of the question the user would like to input
   * @throws IllegalArgumentException if the question is an empty string
   */
  protected AbstractQuestion(String text) throws IllegalArgumentException {
    if ((text.length() == 0)) {
      throw new IllegalArgumentException("Invalid question text");
    }
    enteredAnswer = "";
    this.questionText = text;
  }

  @Override
  public String getQuestionText() {
    return questionText;
  }

  @Override
  public abstract String getType();

  @Override
  public void answer(String enteredAnswer) {
    if (isAnswerValid(enteredAnswer)) {
      this.enteredAnswer = enteredAnswer.toLowerCase();
    }
    else {
      throw new IllegalArgumentException("Invalid answer: " + enteredAnswer);
    }
  }

  @Override
  public String getEnteredAnswer() {
    // answer is checked for validity in answer(), so it is not checked here
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("Question not attempted yet!");
    }
    else {
      return enteredAnswer;
    }
  }

  @Override
  public boolean hasBeenAnswered() {
    return !enteredAnswer.equals("");
  }

  /**
   * This method determines whether the given answer is valid for a particular
   * question type.
   * @param ans the answer the user would like to check for validity
   * @return true if valid, false if not.
   */
  protected abstract boolean isAnswerValid(String ans);
}
