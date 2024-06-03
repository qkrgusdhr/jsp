package q1003;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int Student[] = new int[n];
		for(int i = 0; i < Student.length; i ++) {
			Student[i] = sc.nextInt();
		}
		
		ArrayList<Integer> order = new ArrayList<Integer>();
		for(int i = 0; i < n; i ++) {
			order.add(i - Student[i], i + 1);
		}
		
		for(int nums : order) {
			System.out.printf("%d ", nums);
		}
		sc.close();
	}
}