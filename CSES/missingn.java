import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
 
public class missingn {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(r.readLine());
		String[] nus = r.readLine().split(" ");
		int[] nums = Arrays.stream(nus).mapToInt(Integer::parseInt).toArray();
 
		LinkedList<Integer> linkedList = new LinkedList<>();
 
		for (int i = 0; i < nums.length; i++) {
			linkedList.add(nums[i]);
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 1; i <= n; i++) {
			hs.add(i);
		}
		hs.removeAll(linkedList);
		for (int i : hs) {
			System.out.println(i);
		}
	}
}
