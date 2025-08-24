public class selectionsort {

  public static void main(String[] args) {
    int[] arr = { 3, 2, 1, 4, 5 };
    sort(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  static void sort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {

      int lowest = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[lowest]) {
          lowest = j;
        }
      }

      int temp = arr[lowest];
      arr[lowest] = arr[i];
      arr[i] = temp;

    }
  }
}
