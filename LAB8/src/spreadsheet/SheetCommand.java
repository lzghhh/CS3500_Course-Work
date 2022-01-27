package spreadsheet;

/**
 * This is an interface for containing and prcess the commands.
 */
public interface SheetCommand {
  void process(SpreadSheet sheet);
}
