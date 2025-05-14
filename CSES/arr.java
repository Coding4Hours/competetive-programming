import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class arr {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] parts = br.readLine().split(" ");
    long moves = 0;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(parts[i]);
    }
    for (int i = 1; i < n; i++) {
      if (arr[i] < arr[i - 1]) {
        moves += arr[i - 1] - arr[i];
        arr[i] = arr[i - 1];
      }
    }
    System.out.println(moves);
  }
}
