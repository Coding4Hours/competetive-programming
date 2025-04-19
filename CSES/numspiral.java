import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numspiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            sb.append(computeValue(y, x)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static long computeValue(long y, long x) {
        long n = Math.max(y, x);
        if (n % 2 == 0) {
            // Even layer
            if (y == n) {
                return n * n - x + 1;
            } else {
                return (n - 1) * (n - 1) + y;
            }
        } else {
            // Odd layer
            if (x == n) {
                return n * n - y + 1;
            } else {
                return (n - 1) * (n - 1) + x;
            }
        }
    }
}

