import java.util.*;

public class search {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner r = new Scanner(System.in);
    int N = r.nextInt();
    int X = r.nextInt();
    int[] apples = new int[N];
    for (int i = 0; i < N; i++) {
      apples[i] = r.nextInt();
    }

    r.close();

    for (int a : apples) {
      if (a == X) {
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}
