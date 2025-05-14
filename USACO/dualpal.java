
/*
ID: neealdo1
PROB: dualpal
LANG: JAVA
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class dualpal {
  private static boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  private static String convertToBase(int num, int base) {
    if (num == 0)
      return "0";
    StringBuilder digits = new StringBuilder();
    while (num > 0) {
      digits.append(num % base);
      num /= base;
    }
    return digits.reverse().toString();
  }

  private static int countPalindromeBases(int num) {
    int count = 0;
    for (int base = 2; base <= 10; base++) {
      if (isPalindrome(convertToBase(num, base))) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("dualpal.in"));
    PrintWriter pw = new PrintWriter("dualpal.out");

    int N = scanner.nextInt();
    int S = scanner.nextInt();

    int count = 0;
    int num = S + 1;
    while (count < N) {
      if (countPalindromeBases(num) >= 2) {
        pw.println(num);
        count++;
      }
      num++;
    }

    pw.close();
    scanner.close();
  }
}
