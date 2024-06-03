package q1309;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long fact[] = new long[n+1];
		fact[0] = 1;
		fact[1] = 1;
		
		for(int i = 1; i <= n; i++) {
			fact[i] = i * fact[i-1];
		}
		
		for(int i = n; i >= 1; i--) {
			System.out.print(i + "!" + " = ");
			if(i == 1) {
				System.out.println(i + " * " + 1);
			}else {
				System.out.println(i + " * " + (i-1) + "!");
			}
		}
		System.out.println(fact[n]);
		sc.close();
	}
}
