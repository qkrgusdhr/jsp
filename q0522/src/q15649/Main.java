package q15649;

import java.util.Scanner;

public class Main {
	public static int arr[];
	public static boolean visit[];
	public static int n;
	public static int m;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		visit = new boolean[n];
		backTracking(0);
		sc.close();
	}
	public static void backTracking(int seq) {
		if(seq == m) {
			for(int val : arr) {
			System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < n; i ++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[seq] = i+1;
				backTracking(seq+1);
				visit[i] = false;
			}
		}
	}
}