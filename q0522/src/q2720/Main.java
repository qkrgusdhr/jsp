package q2720;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int money = sc.nextInt();
			int Quarter = money / 25;
			money = money % 25;
			int Dime = money / 10;
			money = money % 10;
			int Nickel = money / 5;
			money = money % 5;
			int Penny = money / 1;
			System.out.printf("%d %d %d %d\n",Quarter, Dime, Nickel, Penny);
		}

		sc.close();

	}
}
