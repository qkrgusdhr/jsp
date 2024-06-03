package q1341;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int s, e;
		Scanner sc = new Scanner(System.in);
		while (true) {
			s = sc.nextInt();
			e = sc.nextInt();
			if ((s >= 2 && s <= 9) && (e >= 2 && e <= 9))
				break;
			else {
				System.out.println("INPUT ERROR");
			}
		}

		if (s < e) {
			for (int i = s; i <= e; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.printf("%d * %d = %2d", i, j, i * j);
					if (j % 3 != 0)
						System.out.print("   ");
					if (j % 3 == 0)
						System.out.println();
				}
				System.out.println();
			}

		} else {
			for (int i = s; i >= e; i--) {
				for (int j = 1; j <= 9; j++) {
					System.out.printf("%d * %d = %2d", i, j, i * j);
					if (j % 3 != 0)
						System.out.print("   ");
					if (j % 3 == 0)
						System.out.println();
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
