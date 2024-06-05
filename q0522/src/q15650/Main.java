package q15650;

import java.util.Scanner;

public class Main {
	public static int n, m;
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		dfs(1,0);
		sc.close();
	}
	public static void dfs(int idx, int seq){
		if(m == seq) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i <= n; i++) {
			arr[seq] = i;
			dfs(i+1, seq+1);
		}
	}
}
