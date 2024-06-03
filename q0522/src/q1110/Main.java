package q1110;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int in = num;
		int cnt = 0;
		while (true) {
			num = ((num % 10) * 10) + ((num / 10 + num % 10) % 10);
			cnt++;
			if (in == num)
				break;

		}
		System.out.println(cnt);
		sc.close();
	}

}
