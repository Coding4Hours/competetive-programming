/*
USER: neealdo1
TASK: hamming
LANG: JAVA
*/
import java.io.*;
import java.util.*;

public class hamming {

    // Helper method to calculate Hamming distance
    public static int hammingDistance(int a, int b) {
        return Integer.bitCount(a ^ b); // XOR and count the 1's in the result
    }

    public static void main(String[] args) throws IOException {
        // Read input from file
        BufferedReader reader = new BufferedReader(
            new FileReader("hamming.in")
        );
        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // Number of codewords
        int B = Integer.parseInt(input[1]); // Length of codewords
        int D = Integer.parseInt(input[2]); // Minimum Hamming distance
        reader.close();

        // Generate all possible codewords of B bits
        List<Integer> codewords = new ArrayList<>();
        for (int i = 0; i < (1 << B); i++) {
            codewords.add(i);
        }

        // List to store the final N codewords
        List<Integer> selectedCodewords = new ArrayList<>();

        // Try to pick the codewords with the required Hamming distance
        outerLoop: for (int i = 0; i < codewords.size(); i++) {
            int currentCodeword = codewords.get(i);

            // Check if currentCodeword has at least distance D from all previously selected codewords
            for (int selected : selectedCodewords) {
                if (hammingDistance(currentCodeword, selected) < D) {
                    continue outerLoop; // If any of the previous codewords is too close, skip this one
                }
            }

            // If we pass the check, add it to the selected list
            selectedCodewords.add(currentCodeword);

            // If we have selected N codewords, stop
            if (selectedCodewords.size() == N) {
                break;
            }
        }

        // Sort the selected codewords
        Collections.sort(selectedCodewords);

        // Output the results to file
        BufferedWriter writer = new BufferedWriter(
            new FileWriter("hamming.out")
        );
        for (int i = 0; i < selectedCodewords.size(); i += 10) {
            // Determine the end index for this line (max 10 codewords per line)
            int end = Math.min(i + 10, selectedCodewords.size());
            // Build a line without a trailing space by joining the codewords with a single space
            for (int j = i; j < end; j++) {
                writer.write(String.valueOf(selectedCodewords.get(j)));
                if (j != end - 1) {
                    writer.write(" ");
                }
            }
            if (end < selectedCodewords.size()) {
                writer.newLine();
            }
        }
        writer.newLine(); // Ensure the output file ends with a new line
        writer.close();
    }
}
