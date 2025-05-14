
/*
ID: neealdo1
PROB: palsquare
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class palsquare {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    BufferedReader r = new BufferedReader(new FileReader("palsquare.in"));
    int B = Integer.parseInt(r.readLine());
    PrintWriter pw = new PrintWriter("palsquare.out");

    for (int i = 1; i <= 300; i++) {
      int area = i * i;
      String areaInBaseB = Integer.toString(area, B).toUpperCase();
      String areaInBaseBReverse = new StringBuilder(areaInBaseB).reverse().toString().toUpperCase();
      if (areaInBaseB.equals(areaInBaseBReverse)) {
        pw.println(Integer.toString(i, B).toUpperCase() + " " + areaInBaseB);
      }
    }

    pw.close();
    r.close();
  }
}
