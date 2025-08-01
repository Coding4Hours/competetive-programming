import java.util.Arrays;

public class binarysearch {
  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int b = 11;

    boolean aa = binarysearchh(a, b);
    System.out.println(aa);
  }

  static boolean binarysearchh(int[] arr, int num) {
    if (arr == null || arr.length == 0)
      return false;

    int index = (arr.length - 1) / 2;

    if (arr[index] > num) {
      int[] a = Arrays.copyOfRange(arr, 0, index);
      return binarysearchh(a, num);
    } else if (arr[index] < num) {
      int[] a = Arrays.copyOfRange(arr, index + 1, arr.length);
      return binarysearchh(a, num);
    }

    return true;
  }
}
