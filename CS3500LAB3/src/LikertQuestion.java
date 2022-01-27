/**
 * this class represents a 5-scale likert question.
 * the scales are strongly agree, agree, neither agree nor disagree, disagree and strongly disagree.
 */
public class LikertQuestion extends QuestionAbstrct {
  //a valid question must have text

  /**
   * This constructor represents a Likert question with question text input.
   * @param text the input question text.
   * @throws IllegalArgumentException throw illegal argument when the input text is not valid.
   */
  public LikertQuestion(String text) throws IllegalArgumentException {
    super(text);
    String[] realOption = {"strongly agree","agree","neither agree nor disagree",
                           "disagree","strongly disagree"};
    this.options = realOption;
  }

  @Override
  public String getType() {
    return "Likert";
  }
}
