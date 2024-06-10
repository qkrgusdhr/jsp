package q2609;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();

		int res = gcd(n, m);
		System.out.println(res);
		System.out.println((n * m) / res);
		sc.close();
	}

	public static int gcd(int a, int b) {
		while(b != 0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}

}
