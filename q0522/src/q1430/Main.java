package q1430;

import java.util.Scanner;

public class Main {
	public static void main(String args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		String mul = Integer.toString((n1 * n2 * n3));
		
		int ans[] = new int[10];
		for(int i =0; i < mul.length(); i++) {
			ans[mul.charAt(i)-'0'] ++;
		}
		for(int val : ans) {
			System.out.println(val);
		}
		sc.close();
	}
}
