package spreadsheet;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the controller of an interactive spreadsheet application.
 * This controller offers a simple text interface in which the user can
 * type instructions to manipulate a spreadsheet.
 * This controller works with any Readable to read its inputs and
 * any Appendable to transmit output. This controller directly uses
 * the Appendable object (i.e. there is no official "view")
 * A cell in the spreadsheet is referred to using a row-letter and a column number.
 * The row letter starts from A-Z and then AA-ZZ, then AAA-ZZZ and so on.
 * The column numbers begin with 1.
 * For example, the cell in the first row and column is A 1.
 * The cell in the 30th row and 26th column is AD 26.
 * In this way it tries to simulate how Microsoft Excel works (except that
 * it uses letters for rows, not columns).
 */
public class SpreadSheetController {
  private Readable readable;
  private Appendable appendable;
  private SpreadSheet sheet;

  /**
   * This is teh constructor for the SparseSpreadSheet. It takes into the model, in and out
   * information and being the bridge between the model and controller.
   * @param sheet The model that process all inputs.
   * @param readable The user's input.
   * @param appendable The output of the program.
   */

  public SpreadSheetController(BetterSpreadSheet sheet,Readable readable,Appendable appendable) {
    if ((sheet == null) || (readable == null) || (appendable == null)) {
      throw new IllegalArgumentException("Sheet, readable or appendable is null");
    }
    this.sheet = sheet;
    this.appendable = appendable;
    this.readable = readable;
  }

  /**
   * This is the method that allows the user to run the whole program. It will take into user's
   * inputs and passes them to the model and view.
   * @throws IllegalStateException The invalid input.
   */

  public void play() throws IllegalStateException {
    Scanner sc = new Scanner(readable);
    boolean quit = false;
    int row;
    int col;
    int fromRow;
    int fromCol;
    int toRow;
    int toCol;
    double value;

    //print the welcome message
    this.welcomeMessage();

    while (!quit) { //continue until the user quits
      writeMessage("Type instruction: "); //prompt for the instruction name
      String userInstruction = sc.next(); //take an instruction name
      switch (userInstruction) {
        case "assign-value": //assign a value to a cell
          try {
            row = getRowNum(sc.next()); //get in the row string
            col = sc.nextInt(); //get in the column number, starting with 1
            sheet.set(row,col - 1,sc.nextDouble()); //use the spreadsheet
          }
          catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "print-value": //print a value from the cell
          try {
            row = getRowNum(sc.next()); //get the row string
            col = sc.nextInt(); //get the column number, starting with 1
            writeMessage("Value: " + sheet.get(row, col - 1) + System.lineSeparator());
          }
          catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "menu": //print the menu of supported instructions
          welcomeMessage();
          break;
        case "bulk-assign": //a rectangular region in the spreadsheet
          try {
            fromRow = getRowNum(sc.next()); //get the from row string
            fromCol = sc.nextInt(); //get the from column number, starting with 1
            toRow = getRowNum(sc.next()); //get the to row string
            toCol = sc.nextInt(); //get the to column number, starting with 1

          }
          catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "q": //quit
        case "quit": //quit
          quit = true;
          break;
        default: //error due to unrecognized instruction
          writeMessage("Undefined instruction: " + userInstruction + System.lineSeparator());
      }
    }

    //after the user has quit, print farewell message
    this.farewellMessage();

  }

  //converts a row string into a row number starting with 0
  private int getRowNum(String rowLetters) throws IllegalArgumentException {
    int rownumber = 0;

    for (int i = rowLetters.length() - 1;i >= 0;i = i - 1) {
      char c = rowLetters.charAt(i);
      if (!Character.isAlphabetic(c)) {
        throw new IllegalArgumentException("Invalid row");
      }
      rownumber = 26 * rownumber + ((int)Character.toLowerCase(c) - 'a');
    }
    return rownumber;
  }


  private void writeMessage(String message) throws IllegalStateException {
    try {
      appendable.append(message);

    }
    catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  private void printMenu() throws IllegalStateException {
    writeMessage("Supported user instructions are: " + System.lineSeparator());
    writeMessage("assign-value row-num col-num value (set a cell to a value)"
            + System.lineSeparator());
    writeMessage("print-value row-num col-num (print the value at a given cell)"
            + System.lineSeparator());
    writeMessage("menu (Print supported instruction list)" + System.lineSeparator());
    writeMessage("bulk-assign fromRow-num fromCol-num tomRow-num toCol-num value"
            + System.lineSeparator()) ;
    writeMessage("q or quit (quit the program) " + System.lineSeparator());
  }

  private void welcomeMessage() throws IllegalStateException {
    writeMessage("Welcome to the spreadsheet program!" + System.lineSeparator());
    printMenu();
  }

  private void farewellMessage() throws IllegalStateException {
    writeMessage("Thank you for using this program!");
  }




}
