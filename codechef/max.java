import java.io.BufferedReader;

import java.io.InputStreamReader;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            
 String[] heightsStr = br.readLine().split(" ");
          
        int max=    Integer.MIN_VALUE;
            
            for(  int i= 0; i < N; i++) {
                int height = Integer.parseInt(heightsStr[i]);
                if (height > max) {
		  max = height;
		}
                
            }

	    System.out.println(max);
        }
    }
}

