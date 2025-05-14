/*
ID: neealdo1
PROB: milk2
LANG: JAVA
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class milk2 {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
    PrintWriter out = new PrintWriter(new FileWriter("milk2.out"));

    int N = Integer.parseInt(in.readLine());

    int[][] times = new int[N][2];
    for (int i = 0; i < N; i++) {
      String[] line = in.readLine().split(" ");
      times[i][0] = Integer.parseInt(line[0]);
      times[i][1] = Integer.parseInt(line[1]);
    }

    Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

    int maxMilking = 0;
    int maxIdle = 0;
    int currentStart = times[0][0];
    int currentEnd = times[0][1];

    for (int i = 1; i < N; i++) {
      int start = times[i][0];
      int end = times[i][1];

      if (start <= currentEnd) {
        currentEnd = Math.max(currentEnd, end);
      } else {
        maxMilking = Math.max(maxMilking, currentEnd - currentStart);
        maxIdle = Math.max(maxIdle, start - currentEnd);
        currentStart = start;
        currentEnd = end;
      }
    }

    maxMilking = Math.max(maxMilking, currentEnd - currentStart);

    out.println(maxMilking + " " + maxIdle);

    in.close();
    out.close();
  }
}
