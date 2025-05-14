import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class namenum {
  private static final Map<Character, char[]> digitToLetters = new HashMap<>();

  static {
    digitToLetters.put('2', new char[] { 'A', 'B', 'C' });
    digitToLetters.put('3', new char[] { 'D', 'E', 'F' });
    digitToLetters.put('4', new char[] { 'G', 'H', 'I' });
    digitToLetters.put('5', new char[] { 'J', 'K', 'L' });
    digitToLetters.put('6', new char[] { 'M', 'N', 'O' });
    digitToLetters.put('7', new char[] { 'P', 'R', 'S' });
    digitToLetters.put('8', new char[] { 'T', 'U', 'V' });
    digitToLetters.put('9', new char[] { 'W', 'X', 'Y' });
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
    PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
    String serialNumber = in.readLine();
    in.close();

    Set<String> validNames = new HashSet<>();
    BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
    String word;
    while ((word = dict.readLine()) != null) {
      validNames.add(word);
    }
    dict.close();

    List<String> matches = new ArrayList<>();
    generateNames(serialNumber, 0, new StringBuilder(), validNames, matches);

    if (matches.isEmpty()) {
      out.println("NONE");
    } else {
      Collections.sort(matches);
      for (String name : matches) {
        out.println(name);
      }
    }
    out.close();
  }

  private static void generateNames(String digits, int index, StringBuilder current,
      Set<String> dictionary, List<String> results) {
    if (index == digits.length()) {
      String name = current.toString();
      if (dictionary.contains(name)) {
        results.add(name);
      }
      return;
    }

    char digit = digits.charAt(index);
    if (!digitToLetters.containsKey(digit))
      return;

    for (char letter : digitToLetters.get(digit)) {
      current.append(letter);
      generateNames(digits, index + 1, current, dictionary, results);
      current.deleteCharAt(current.length() - 1); // backtrack
    }
  }
}
