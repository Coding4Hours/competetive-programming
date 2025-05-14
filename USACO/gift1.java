
/*
USER: neealdo1
PROB: gift1
LANG: JAVA
*/
import java.util.Scanner;
import java.io.File;
import java.util.LinkedHashMap;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class gift1 {
  static LinkedHashMap<String, Integer> balances = new LinkedHashMap<>();

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scan = new Scanner(new File("gift1.in"));
    int NP = Integer.parseInt(scan.nextLine());
    for (int i = 0; i < NP; i++) {
      balances.put(scan.nextLine(), 0);
    }

    // transactions
    while (scan.hasNextLine()) {
      String giver = scan.nextLine();
      int money = scan.nextInt();
      int originalMoney = money;
      int recipientCount = scan.nextInt();
      scan.nextLine(); // consume the rest of the line
      for (int i = 0; i < recipientCount; i++) {
        String recipient = scan.nextLine();
        balances.put(recipient, balances.get(recipient) + money / recipientCount);
      }
      for (int a = 0; a < recipientCount; a++) {
        money -= originalMoney / recipientCount;
      }
      balances.put(giver, balances.get(giver) - originalMoney);
      balances.put(giver, balances.get(giver) + money);
    }

    PrintWriter pw = new PrintWriter(new File("gift1.out"));
    for (String name : balances.keySet()) {
      pw.println(name + " " + balances.get(name));
    }

    scan.close();
    pw.close();
  }
}
