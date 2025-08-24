public class bubblesort {

  public static void main(String[] args) {
    int[] arr = { 3, 2, 1, 4, 5 };
    sort(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  static void sort(int arr[]) {

    for (int i = 0; i < arr.length - 1; i++) {

      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
      }

    }
  }
}
