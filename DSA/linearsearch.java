import java.util.Arrays;

public class linearsearch {
  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int b = 11;

    boolean aa = linearsearchh(a, b);
    System.out.println(aa);
  }

  static boolean linearsearchh(int[] arr, int num) {
    for (int i = 0; i < arr.length; i++)
      if (arr[i] == num)
        return true;

    return false;
  }
}
