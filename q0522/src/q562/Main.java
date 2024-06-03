package q562;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if (i % 2 == 1) {
				sum += arr[i];
			} else {
				avg += arr[i] / 5.0;
			}
		}

		sc.close();
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f", avg);
	}
}
