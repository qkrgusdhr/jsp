package q5933;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = (i + 1) * (j + 1);
			}
		}
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
