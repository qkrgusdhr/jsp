package q1304;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		int num = 1;
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = num ++;
			}
			
		}
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				System.out.print(arr[j][i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
