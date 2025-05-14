import java.util.Scanner;
 
public class repetitions {
	public static int findLongestRepetition(String s) {
		int maxLen = 1, currentLen = 1;
 
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				currentLen++;
				maxLen = Math.max(maxLen, currentLen);
			} else {
				currentLen = 1;
			}
		}
		return maxLen;
	}
 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String dnaSequence = scanner.next().trim();
		scanner.close();
 
		System.out.println(findLongestRepetition(dnaSequence));
	}
}
