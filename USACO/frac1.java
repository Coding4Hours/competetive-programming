
/*
USER: neealdo1
TASK: frac1
LANG: JAVA
*/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class frac1 {
	public static void main(String[] args) throws IOException {
		Scanner fr = new Scanner(new FileReader("frac1.in"));
		int MAX_DENOMINATOR = fr.nextInt();
		fr.close();

		TreeSet<Fraction> fractions = new TreeSet<>();

		for (int denominator = 1; denominator <= MAX_DENOMINATOR; denominator++) {
			for (int numerator = 0; numerator <= denominator; numerator++) {
				fractions.add(new Fraction(numerator, denominator).simplify());
			}
		}

		PrintWriter pw = new PrintWriter(new FileWriter("frac1.out"));
		for (Fraction fraction : fractions) {
			pw.println(fraction);
		}
		pw.close();
	}
}

class Fraction implements Comparable<Fraction> {
	private final int numerator;
	private final int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public Fraction simplify() {
		int gcd = gcd(numerator, denominator);
		return new Fraction(numerator / gcd, denominator / gcd);
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Fraction))
			return false;
		Fraction other = (Fraction) obj;
		return this.numerator * other.denominator == this.denominator * other.numerator;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numerator, denominator);
	}

	@Override
	public int compareTo(Fraction other) {
		return Integer.compare(this.numerator * other.denominator, this.denominator * other.numerator);
	}
}
