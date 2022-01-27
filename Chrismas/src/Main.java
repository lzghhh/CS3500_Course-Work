import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int height = 0;
    int width = 0;


    try {
      System.out.println("输入圣诞树高度(必须大于5）");
      height = scanner.nextInt();
    } catch (Exception e) {
      System.out.println("让你不输入数字，重新来吧");
    }

    try {
      System.out.println("输入圣诞树宽度");
      width = scanner.nextInt();
    } catch (Exception e) {
      System.out.println("让你不输入数字，重新来吧");
    }

    StringBuilder tree = new StringBuilder();
    for (int i = 0; i < height + 1; i++) {
      int lol = i % 5;
      int lll = i / 5 + 1;
      for (int k = 0; k < width; k++) {

      }
    }


  }

}
