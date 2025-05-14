import java.util.Scanner;

public class basketball {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    System.out.println(s.charAt(s.length() - 2));
    in.close();
  }
}
