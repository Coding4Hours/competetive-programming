/*
USER: neealdo1
TASK: sort3
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class sort3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("sort3.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    int count1 = 0, count2 = 0, count3 = 0;
    for (int num : arr) {
      if (num == 1)
        count1++;
      else if (num == 2)
        count2++;
      else
        count3++;
    }

    int misplaced_2_in_1 = 0, misplaced_3_in_1 = 0;
    int misplaced_1_in_2 = 0, misplaced_3_in_2 = 0;
    int misplaced_1_in_3 = 0, misplaced_2_in_3 = 0;

    for (int i = 0; i < count1; i++) {
      if (arr[i] == 2)
        misplaced_2_in_1++;
      if (arr[i] == 3)
        misplaced_3_in_1++;
    }

    for (int i = count1; i < count1 + count2; i++) {
      if (arr[i] == 1)
        misplaced_1_in_2++;
      if (arr[i] == 3)
        misplaced_3_in_2++;
    }

    for (int i = count1 + count2; i < N; i++) {
      if (arr[i] == 1)
        misplaced_1_in_3++;
      if (arr[i] == 2)
        misplaced_2_in_3++;
    }

    int swaps = 0;

    int direct1_2 = Math.min(misplaced_1_in_2, misplaced_2_in_1);
    swaps += direct1_2;
    misplaced_1_in_2 -= direct1_2;
    misplaced_2_in_1 -= direct1_2;

    int direct1_3 = Math.min(misplaced_1_in_3, misplaced_3_in_1);
    swaps += direct1_3;
    misplaced_1_in_3 -= direct1_3;
    misplaced_3_in_1 -= direct1_3;

    int direct2_3 = Math.min(misplaced_2_in_3, misplaced_3_in_2);
    swaps += direct2_3;
    misplaced_2_in_3 -= direct2_3;
    misplaced_3_in_2 -= direct2_3;

    int remaining = (misplaced_1_in_2 + misplaced_1_in_3 +
        misplaced_2_in_1 + misplaced_2_in_3 +
        misplaced_3_in_1 + misplaced_3_in_2) / 3;
    swaps += remaining * 2;

    pw.println(swaps);
    pw.close();
  }
}
