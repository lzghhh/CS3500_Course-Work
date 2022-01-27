package spreadsheet;

import java.io.InputStreamReader;

/**
 * This is the main function that allows the user to run this sparseSpreadSheet program.
 */

public class SpreadSheetProgram {

  /**
   * The main method takes the user's input and proceeds the input and provides outputs.
   * @param args The user's input.
   */

  public static void main(String []args) {
    BetterSpreadSheetModel model = new BetterSpreadSheetModel();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    SpreadSheetController controller = new SpreadSheetController(model,rd,ap);
    controller.play();
  }
}
