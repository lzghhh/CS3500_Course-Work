package model.operations;

import java.util.Arrays;

import model.pixel.EightBitPixelModel;
import model.pixel.Pixel;

/**
 * This is a class that uses for getting a filter for changing the color and apply it to a
 * 2-D array of pixels.
 */
public class ColorTransformation {
  private final double[][] transfer;

  /**
   * This is the constructor for ColorTransformation that takes in a filter that changes the
   * color of the image.
   * @param transfer The 2-D filter for changing color.
   */
  public ColorTransformation(double[][] transfer) {
    if (transfer == null) {
      throw new IllegalArgumentException();
    }
    this.transfer = transfer;
  }

  /**
   * This a method that uses for applying the 2-D filter to the given input 2-D pixels.
   * @param pixels The image's 2-D pixels.
   * @return Update 2-D pixels by applying 2-D filter.
   */
  public Pixel[][] process(Pixel[][] pixels) {
    for (int a = 0; a < pixels.length; a++) {
      for (int b = 0; b < pixels[a].length; b++) {
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int i = 0; i < this.transfer.length; i++) {

          for (int k = 0; k < this.transfer[0].length; k++) {
            if (i == 0) {
              red += Math.round(transfer[i][k] * pixels[a][b].getColor().get(k));
            } else {
              if (i == 1) {
                green += Math.round(transfer[i][k] * pixels[a][b].getColor().get(k));
              } else {
                if (i == 2) {
                  blue += Math.round(transfer[i][k] * pixels[a][b].getColor().get(k));
                }
              }
            }
          }
        }
        if (pixels[a][b].getColor().size() > 3) {
          pixels[a][b] = new EightBitPixelModel(Arrays.asList(red, green, blue,
                  pixels[a][b].getColor().get(3)));
        } else {
          pixels[a][b] = new EightBitPixelModel(Arrays.asList(red, green, blue));
        }

      }
    }
    return pixels;
  }
}
