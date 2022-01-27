import org.junit.Test;

/**
 * This class contains tests for {@code YesNoQuestion}.
 */
public class YesNoQuestionTest extends AbstractTest {
  /**
   * This constructs a {@code YesNoQuestionTest} object.
   */
  public YesNoQuestionTest() {
    super("YesNo", new String[]{"yes","Yes","YEs","YeS","YES","yEs","yES","yeS","no",
        "No","nO","NO"}, new String[]{"yess",""}, new String[]{"yes","Yes","YEs","YeS","YES",
        "yEs","yES","yeS","no","No","nO","NO"});
  }

  @Override
  protected Question createQuestion(String questionText) {
    return new YesNoQuestion(questionText);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateYesNoQuestionNoQuestionMark() {
    new YesNoQuestion("Is this fun");
  }
}