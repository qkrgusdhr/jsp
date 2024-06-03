package q10810;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int basket[] = new int[n];
		for(int i = 0; i < m; i ++) {
			int start = sc.nextInt(); // 1
			int end = sc.nextInt(); // 2 
			int ball = sc.nextInt(); // 3
			for(int j = start - 1; j < end; j++) {
				basket[j] = ball;
			}
			for(int k = 0; k < basket.length; k++) {
				System.out.print(basket[k] + " ");
			}
		}
		sc.close();
	}
}
