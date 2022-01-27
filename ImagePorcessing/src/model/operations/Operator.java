package model.operations;

import model.pixel.Pixel;

/**
 * This is a class for implementing the operator as commanded.
 */
public class Operator implements Operations {
  private Pixel[][] pixels;

  /**
   * This is the constructor for Operator that takes an image's pixels.
   *
   * @param pixels Image's 2-D pixels.
   */
  public Operator(Pixel[][] pixels) {
    if (pixels == null) {
      throw new IllegalArgumentException();
    }
    this.pixels = pixels;
  }

  /**
   * This is a method for updating the pixels by given operation types.
   *
   * @param type   Required command for operation types.
   * @param change Changes might needed as integer.
   * @param way    String indicator might needed.
   * @return An updated 2-D pixels.
   */
  @Override
  public Pixel[][] update(OperationType type, int change, String way) {
    switch (type) {
      case GreyScale:
        this.greyScale(way);
        break;
      case Flip:
        this.flip(way);
        break;
      case Brighten:
        this.brighten(change);
        break;
      case Blur:
        this.blur();
        break;
      case Sharpen:
        this.sharpen();
        break;
      case LumaGreyScale:
        this.lumaGreyscale();
        break;
      case Sepia:
        this.sepia();
        break;
      default:
        break; //operations not supported
    }
    return this.pixels;
  }

  /**
   * Ensure the minimum value and maximum value of rgb doesn't go out of range.
   *
   * @param pixels represent the 2D array of pixels.
   * @return the Pixel list after its rgb values are ensured to be in the correct range.
   */
  protected Pixel[][] ensureVal(Pixel[][] pixels) {
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        for (int k = 0; k < pixels[i][j].getColor().size(); k++) {
          if (pixels[i][j].getColor().get(k) < 0) {
            pixels[i][j].getColor().set(k, 0);
          } else if (this.pixels[i][j].getColor().get(k) > 255) {
            pixels[i][j].getColor().set(k, 255);
          }
        }
      }
    }
    return pixels;
  }

  /**
   * Brighten or darken the image with the amount inputted by the user.
   *
   * @param amount represents the amount the user want to brighten/darken the image.
   */
  protected void brighten(int amount) {
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j++) {
        for (int k = 0; k < 3; k++) {
          this.pixels[i][j].getColor().set(k, this.pixels[i][j].getColor().get(k) + amount);
        }
      }
    }
    ensureVal(this.pixels);
  }

  /**
   * Flip the image vertically or horizontally.
   *
   * @param direction represents the direction of the flip, enter horizontal for horizontal flip
   *                  and vertical for vertical flip.
   */
  protected void flip(String direction) {
    if (direction.equals("horizontal")) {
      for (int i = 0; i < this.pixels.length; i++) {
        for (int j = 0; j < this.pixels[i].length / 2; j++) {
          Pixel temporary = this.pixels[i][j].copy();
          this.pixels[i][j] = this.pixels[i][this.pixels[i].length - j - 1].copy();
          this.pixels[i][this.pixels[i].length - j - 1] = temporary;
        }
      }
    } else if (direction.equals("vertical")) {
      for (int i = 0; i < this.pixels.length / 2; i++) {
        for (int j = 0; j < this.pixels[i].length; j++) {
          Pixel temporary = this.pixels[i][j];
          this.pixels[i][j] = this.pixels[this.pixels.length - i - 1][j];
          this.pixels[this.pixels.length - i - 1][j] = temporary;
        }
      }
    } else {
      throw new IllegalArgumentException("Invalid direction!");
    }
  }

  /**
   * Convert the image colors into greyscale.
   *
   * @param ways represents different way to turn the image into greyscale, enter:
   *             "luma" to convert it using the luma value,
   *             "intensity" to convert it using the intensity value,
   *             "value" to convert it using the maximum  value of rgb of a pixel,
   *             "red" to convert it by changing every rgb values of a pixel into its red value,
   *             "green" to convert it by changing every rgb values of a pixel into its green value,
   *             "blue" to convert it by changing every rgb values of a pixel into its blue value.
   */
  protected void greyScale(String ways) {
    for (int i = 0; i < this.pixels.length; i++) {
      for (int j = 0; j < this.pixels[i].length; j++) {
        this.pixels[i][j].setRGB(ways);
      }
    }
    ensureVal(this.pixels);
  }

  /**
   * Convert the image into blurred by kernel projection.
   */
  protected void blur() {
    double[][] kernel = {{1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0}, {1.0 / 8.0, 1.0 / 4.0, 1.0 / 8, 0},
      {1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0}};
    this.pixels = new KernelOperator(kernel, 3).processKernel(this.pixels);
    ensureVal(this.pixels);
  }

  /**
   * Convert the image into sharpened by kernel projection.
   */
  protected void sharpen() {
    double[][] kernel = {{-1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0},
      {-1.0 / 8.0, 1.0 / 4.0, 1.0 / 4.0, 1.0 / 4.0, -1.0 / 8.0},
        {-1.0 / 8.0, 1.0 / 4.0, 1, 1.0 / 4.0, -1.0 / 8.0},
                         {-1.0 / 8.0, 1.0 / 4.0, 1.0 / 4.0, 1.0 / 4.0, -1.0 / 8.0},
                            {-1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0}};
    this.pixels = new KernelOperator(kernel, 5).processKernel(this.pixels);
    ensureVal(this.pixels);
  }


  /**
   * Convert the image into greyscale by luma value by filtering.
   */
  protected void lumaGreyscale() {
    double[][] kernel = {{0.2126, 0.7152, 0.0722},
      {0.2126, 0.7152, 0.0722},
        {0.2126, 0.7152, 0.0722}};
    this.pixels = new ColorTransformation(kernel).process(this.pixels);
    ensureVal(this.pixels);
  }

  /**
   * Convert the image into greyscale by sepia value by filtering.
   */
  protected void sepia() {
    double[][] kernel = {{0.393, 0.769, 0.189},
      {0.349, 0.686, 0.168},
        {0.272, 0.534, 0.131}};
    this.pixels = new ColorTransformation(kernel).process(this.pixels);
    ensureVal(this.pixels);
  }
}
