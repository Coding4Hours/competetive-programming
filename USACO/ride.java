
/*
USER: neealdo1
PROB: ride
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {

  public static int letterToNumber(char letter) {
    return letter - 'A' + 1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    String str = f.readLine();
    String str2 = f.readLine();
    f.close();
    int[] strArray = new int[str.length()];
    int[] str2Array = new int[str2.length()];
    int strlength = str.length();
    int str2length = str2.length();
    int product = 1;
    int product2 = 1;
    for (int i = 0; i < strlength; i++) {
      strArray[i] = letterToNumber(str.charAt(i));
    }
    for (int a = 0; a < str2length; a++) {
      str2Array[a] = letterToNumber(str2.charAt(a));
    }

    for (int i = 0; i < strlength; i++) {
      product *= strArray[i];
    }
    for (int i = 0; i < str2length; i++) {
      product2 *= str2Array[i];
    }
    PrintWriter pw = new PrintWriter("ride.out");

    if (product2 % 47 == product % 47) {
      pw.println("GO");
    } else {
      pw.println("STAY");
    }
    pw.close();
  }
}
