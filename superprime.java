
import io.github.pixee.security.BoundedLineReader;
import java.io.*;
import java.util.*;

public class sprime  {
  private static List<Integer> superprimes;

  public static void main(String[] args) throws IOException {
    BufferedReader scanner = new BufferedReader(new FileReader("sprime.in"));
    FileWriter writer = new FileWriter("sprime.out");
    int n = Integer.parseInt(BoundedLineReader.readLine(scanner, 5_000_000));
    superprimes = new ArrayList<>();

    // Start with single-digit primes
    int[] firstDigits = {2, 3, 5, 7};
    for (int digit : firstDigits) {
      generateSuperprimes(n, digit);
    }

    // Sort and print the superprimes
    Collections.sort(superprimes);
    for (int sp : superprimes) {
      CharSequence cs = sp + "\n";
      writer.append(cs);
    }

    scanner.close();
    writer.close();
  }

  private static void generateSuperprimes(int n, int currentNumber) {
    if (String.valueOf(currentNumber).length() == n) {
      superprimes.add(currentNumber);
      return;
    }

    // Append digits 1, 3, 7, 9 and check if the new number is prime
    int[] nextDigits = {1, 3, 7, 9};
    for (int digit : nextDigits) {
      int newNumber = currentNumber * 10 + digit;
      if (isPrime(newNumber)) {
        generateSuperprimes(n, newNumber);
      }
    }
  }

  private static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    if (n == 2 || n == 3) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    // Check divisibility up to the square root of n
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }
}
