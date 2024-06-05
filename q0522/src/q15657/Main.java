package q15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int n, m;
	public static int arr[];
	public static int ans[];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0,0);
		sc.close();
	}

	public static void dfs(int idx, int seq) {
		if(m == seq) {
			for(int val : ans) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i < n; i++) {
			ans[seq] = arr[i];
			dfs(i,seq+1);
		}
	}

}
