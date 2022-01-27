package spreadsheet;

/**
 * This is an interface for the Sheetcoomands and execute those commands.
 */

public interface MacroSpreadSheet extends SpreadSheet {
  void exectue(SheetCommand command, SpreadSheet sheet);
}
