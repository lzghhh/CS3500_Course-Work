package view;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

import model.pixel.Pixel;

/**
 * This is a extened JPanel that will create a histogram basing on the given image.
 */
public class ImageHistogram extends JLabel {
  private int[][] indexes = new int[4][256];


  /**
   * This is the constructor for the ImageHistogram that takes a 2-D pixels that represents
   * an image.
   * @param pixels The 2-D pixels of an image.
   */
  public ImageHistogram(Pixel[][] pixels) {
    if (pixels == null) {
      throw new IllegalArgumentException("Incorrect List");
    }

    for (int i = 0; i < pixels.length; i++) {
      for (int k = 0; k < pixels[i].length; k++) {
        int r = pixels[i][k].getColor().get(0);
        int g = pixels[i][k].getColor().get(1);
        int b = pixels[i][k].getColor().get(2);
        int black = (pixels[i][k].getColor().get(0) + pixels[i][k].getColor().get(1) +
                pixels[i][k].getColor().get(2)) / 3;
        indexes[0][black]++;
        indexes[1][r]++;
        indexes[2][g]++;
        indexes[3][b]++;
      }
    }
  }

  @Override
  public void paint(Graphics g) {
    super.paintComponent(g);

    Graphics2D graphics2D = (Graphics2D) g.create();
    int redDivider = Arrays.stream(indexes[1]).max().getAsInt();
    int greenDivider = Arrays.stream(indexes[2]).max().getAsInt();
    int blueDivider = Arrays.stream(indexes[3]).max().getAsInt();
    int blackDiver = Arrays.stream(indexes[0]).max().getAsInt();
    int smallIndex = blackDiver / 150;


    for (int i = 0; i < indexes[0].length - 1; i++) {
      graphics2D.setColor(Color.black);
      graphics2D.drawLine(i, (redDivider - indexes[0][i]) / smallIndex , i + 1,
              (redDivider - indexes[0][i + 1]) / smallIndex);
      graphics2D.setColor(Color.red);
      graphics2D.drawLine(i, (greenDivider - indexes[1][i]) / smallIndex , i + 1,
              (greenDivider - indexes[1][i + 1]) / smallIndex);
      graphics2D.setColor(Color.green);
      graphics2D.drawLine(i, (blueDivider - indexes[2][i]) / smallIndex, i + 1,
              (blueDivider - indexes[2][i + 1]) / smallIndex);
      graphics2D.setColor(Color.blue);
      graphics2D.drawLine(i, (blackDiver - indexes[2][i]) / smallIndex  , i + 1,
              (blackDiver - indexes[2][i + 1]) / smallIndex );
    }

    graphics2D.dispose();
  }

  /**
   * This is to return the index for the test method only.
   * @return The indexs in the class as cloned.
   */
  public int[][] getIndexes() {
    return this.indexes.clone();
  }
}