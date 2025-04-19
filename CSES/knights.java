import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class knights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        for (long k = 1; k <= n; k++) {
            long totalWays = k * k * (k * k - 1) / 2;
            // Count the ways knights attack each other.
            // The number of attacking pairs is 4*(k-1)*(k-2).
            long attackingWays = 0;
            if (k > 2) {
                attackingWays = 4 * (k - 1) * (k - 2);
            }
            long nonAttackingWays = totalWays - attackingWays;
            sb.append(nonAttackingWays).append("\n");
        }
        
        System.out.print(sb);
    }
}

