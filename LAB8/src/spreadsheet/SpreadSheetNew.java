package spreadsheet;

/**
 * This is a class that extends the original sheet and also the macro commands.
 */
public class SpreadSheetNew extends SparseSpreadSheet implements MacroSpreadSheet {

  /**
   * Create an empty spreadsheet.
   */
  public SpreadSheetNew() {
    super();
  }


  @Override
  public void exectue(SheetCommand command, SpreadSheet sheet) {
    command.process(sheet);
  }

}
