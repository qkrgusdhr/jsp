package q1149;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] home = new int[num][3];
		for (int i = 0; i < num; i++) {
			home[i][0] = sc.nextInt(); // RED
			home[i][1] = sc.nextInt(); // GREEN
			home[i][2] = sc.nextInt(); // BLUE
		}

		for (int i = 1; i < num; i++) {
			home[i][0] += Math.min(home[i - 1][1], home[i - 1][2]);
			home[i][1] += Math.min(home[i - 1][0], home[i - 1][2]);
			home[i][2] += Math.min(home[i - 1][0], home[i - 1][1]);
		}

		System.out.println(Math.min(Math.min(home[num - 1][0], home[num - 1][1]), home[num - 1][2]));
		sc.close();
	}
}