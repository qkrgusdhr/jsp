package q576;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		char cal = sc.next().charAt(0);
		int b = sc.nextInt();
		int sum = a + b;
		int min = a - b;
		int mul = a * b;
		int div = a / b;
		if (cal == '+') {
			System.out.println(a + " " + cal + " " + b + " = " + sum);
		} else if (cal == '-') {
			System.out.println(a + " " + cal + " " + b + " = " + min);
		} else if (cal == '*') {
			System.out.println(a + " " + cal + " " + b + " = " + mul);
		} else if (cal == '/') {
			System.out.println(a + " " + cal + " " + b + " = " + div);
		}else {
			System.out.println(a + " " + cal + " " + b + " = " + 0);
		}
		sc.close();
	}

}
