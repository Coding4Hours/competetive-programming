/*
ID: neealdo1
PROB: holstein
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class holstein {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("holstein.in"));
    PrintWriter pw = new PrintWriter(new PrintWriter("holstein.out"));

    int V = Integer.parseInt(br.readLine());

    int[] minRequirements = new int[V];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < V; i++) {
      minRequirements[i] = Integer.parseInt(st.nextToken());
    }

    int G = Integer.parseInt(br.readLine());

    int[][] feeds = new int[G][V];
    for (int i = 0; i < G; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < V; j++) {
        feeds[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();

    int minScoops = G + 1;
    ArrayList<Integer> bestCombinationFeeds = new ArrayList<>();

    for (int i = 0; i < (1 << G); i++) {
      int[] currentVitamins = new int[V];
      int currentScoops = 0;
      ArrayList<Integer> currentFeedTypes = new ArrayList<>();

      for (int j = 0; j < G; j++) {
        if (((i >> j) & 1) == 1) {
          currentScoops++;
          currentFeedTypes.add(j + 1);

          for (int k = 0; k < V; k++) {
            currentVitamins[k] += feeds[j][k];
          }
        }
      }

      boolean meetsRequirements = true;
      for (int k = 0; k < V; k++) {
        if (currentVitamins[k] < minRequirements[k]) {
          meetsRequirements = false;
          break;
        }
      }

      if (meetsRequirements) {
        if (currentScoops < minScoops) {
          minScoops = currentScoops;
          bestCombinationFeeds = new ArrayList<>(currentFeedTypes);
        } else if (currentScoops == minScoops) {
          boolean currentIsBetter = false;
          for (int k = 0; k < currentFeedTypes.size(); k++) {
            if (currentFeedTypes.get(k) < bestCombinationFeeds.get(k)) {
              currentIsBetter = true;
              break;
            } else if (currentFeedTypes.get(k) > bestCombinationFeeds.get(k)) {
              break;
            }
          }
          if (currentIsBetter) {
            bestCombinationFeeds = new ArrayList<>(currentFeedTypes);
          }
        }
      }
    }

    pw.print(minScoops);
    for (int feedType : bestCombinationFeeds) {
      pw.print(" " + feedType);
    }
    pw.println();
    pw.close();
  }
}

