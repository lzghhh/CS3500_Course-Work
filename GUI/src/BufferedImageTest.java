import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BufferedImageTest extends JFrame{
  public BufferedImageTest(){
    BufferedImage buffer = null;
    try {
      buffer = ImageIO.read(new FileInputStream("C:\\Users\\ASUS\\Desktop\\oodjpg.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    ImageIcon image = new ImageIcon(buffer);
    JLabel label = new JLabel(image);
    JScrollPane panel = new JScrollPane(label);
    add(panel);
    setTitle("lol");
    setSize(400,400);
  }


  public static void main(String[] args) {
    new BufferedImageTest().setVisible(true);
  }
}