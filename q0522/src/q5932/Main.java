package q5932;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 0) {
					num++;
					System.out.print(num + " ");
				} else {
					System.out.print(num + " ");
					num--;
				}
			}
			System.out.println();
		}

		sc.close();
	}

}
