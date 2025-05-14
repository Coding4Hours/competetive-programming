
/*
ID: neealdo1
PROB: friday
LANG: JAVA
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class friday {

  static int doomsday(int year, int month, int day) {
    int century = year / 100;
    int y = year % 100;

    int century_anchor = (5 * (century % 4) + 2) % 7;
    int year_doomsday_offset = (y / 12) + (y % 12) + ((y % 12) / 4);
    int year_doomsday = (century_anchor + year_doomsday_offset) % 7;

    boolean is_leap_year = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

    int[] doomsday_dates = { 0, 3, 28, 14, 4, 9, 6, 11, 8, 5, 10, 7, 12 };
    if (is_leap_year) {
      doomsday_dates[1] = 4; // January
      doomsday_dates[2] = 29; // February
    }

    int month_doomsday = doomsday_dates[month];
    int day_difference = day - month_doomsday;
    int day_of_week = ((year_doomsday + day_difference) % 7 + 7) % 7; // Ensure positive result
    return day_of_week;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("friday.in"));
    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

    int N = Integer.parseInt(reader.readLine());
i
    int[] day_counts = new int[7];

    for (int year = 1900; year < 1900 + N; year++) {
      for (int month = 1; month <= 12; month++) {
        int day_of_week = doomsday(year, month, 13);
        day_counts[day_of_week]++;
      }
    }

    writer.print(day_counts[6]); // Saturday
    for (int i = 0; i < 6; i++) { // Sunday to Friday
      writer.print(" " + day_counts[i]);
    }
    writer.println();

    reader.close(;
    writer.close();
  }
}
