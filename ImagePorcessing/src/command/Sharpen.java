package command;

import java.util.List;

import model.image.ImageModel;
import model.operations.Operations;
import model.storage.ImageLibrary;

/**
 * This is Sharpen class that functions as a command for sharpen the image.
 */
public class Sharpen implements ImageCommand {
  private final String fileNameIn;
  private final String fileNameOut;

  /**
   * This is the constructor for the Blur that takes in the image name and sharpen the image
   * and save a new one with the name output in the library.
   * @param fileNameIn The input image name.
   * @param fileNameOut The output image name.
   */
  public Sharpen(String fileNameIn, String fileNameOut) {
    this.fileNameIn = fileNameIn;
    this.fileNameOut = fileNameOut;
  }

  /**
   * This method is used to execute the blur command in the model to sharpen the image.
   * @param library The library that stores all models.
   * @param stringCommands The list of command's names.
   * @throws IllegalArgumentException When the command fails, it will occur.
   */
  @Override
  public void process(ImageLibrary library, List<String> stringCommands)
          throws IllegalArgumentException {
    if (stringCommands.contains(fileNameOut)) {
      System.out.println("The name cannot be the command's name");
      throw new IllegalArgumentException();
    }
    ImageModel model = library.contain(fileNameIn);
    if (model == null) {
      System.out.println("Cannot find image");
      throw new IllegalArgumentException("Cannot find image");
    }
    model.getUpdated(Operations.OperationType.Sharpen, 0, "");
    library.put(this.fileNameOut, model);
    System.out.println(fileNameIn + " has been sharpened as " + fileNameOut);
  }
}
