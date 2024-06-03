package q1307;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char arr[][] = new char[n][n];
		
		char start ='A';
		
		for(int i = n-1; i >= 0; i --) {
			for(int j = n-1; j >= 0; j--) {
				if(start > 'Z')
					start = 'A';
					arr[j][i] = start ++;
			}
		}
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
