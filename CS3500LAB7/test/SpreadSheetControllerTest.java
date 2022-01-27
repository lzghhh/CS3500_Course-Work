import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;


import spreadsheet.BetterSpreadSheetModel;
import spreadsheet.MockBetterSpreadSheet;
import spreadsheet.MockSpreadSheet;
import spreadsheet.SparseSpreadSheet;
import spreadsheet.SpreadSheetController;

import static org.junit.Assert.assertEquals;

/**
 * This is the test class for the controller of the SpreadSheet.
 */

public class SpreadSheetControllerTest {
  @Test
  public void testWelcomeMessage() {
    StringBuilder out = new StringBuilder();
    Readable in = new StringReader("q");
    BetterSpreadSheetModel sheet1 = new BetterSpreadSheetModel();
    SpreadSheetController controller = new SpreadSheetController(sheet1, in, out);
    controller.play();
    String[] splitOut = out.toString().split("(?=Type)",2);
    assertEquals("Welcome to the spreadsheet program!" + System.lineSeparator() +
            "Supported user instructions are: "
            + System.lineSeparator() +
            "assign-value row-num col-num value (set a cell to a value)"
            + System.lineSeparator() +
            "print-value row-num col-num (print the value at a given cell)"
            + System.lineSeparator() +
            "menu (Print supported instruction list)"
            + System.lineSeparator() +
            "bulk-assign fromRow-num fromCol-num tomRow-num toCol-num value"
            + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator(),
            splitOut[0]);
  }

  @Test
  public void testFarewellMessage() {
    StringBuilder out = new StringBuilder();
    Readable in = new StringReader("q");
    BetterSpreadSheetModel sheet1 = new BetterSpreadSheetModel();
    SpreadSheetController controller = new SpreadSheetController(sheet1, in, out);
    controller.play();
    String[] splitOut = out.toString().split("(?=Thank)");
    assertEquals("Thank you for using this program!",
            splitOut[1]);
  }

  @Test
  public void testInputs() throws IOException {
    Reader in = new StringReader("assign-value B 4 3 q");
    StringBuilder needlessOut = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockSpreadSheet mock = new MockSpreadSheet(log);
    SpreadSheetController controller = new SpreadSheetController(mock, in, needlessOut);
    controller.play();
    assertEquals("row = 1, col = 3, value = 3.00\n",
            log.toString());
  }

  @Test
  public void testInputsBetter() throws IOException {
    Reader in = new StringReader("bulk-assign A 1 B 4 100");
    StringBuilder needlessOut = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MockBetterSpreadSheet mock = new MockBetterSpreadSheet(log);
    SpreadSheetController controller = new SpreadSheetController(mock, in, needlessOut);
    controller.play();
    assertEquals("row = 1, col = 3, value = 3.00\n",
            log.toString());
  }
}
