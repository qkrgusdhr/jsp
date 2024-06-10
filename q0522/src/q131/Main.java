package q131;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		if (n < m) {
			for (int i = n; i <= m; i++)
				System.out.print(i + " ");

		} else {
			for (int i = m; i <= n; i++)
				System.out.print(i + " ");

		}

		sc.close();
	}
}
