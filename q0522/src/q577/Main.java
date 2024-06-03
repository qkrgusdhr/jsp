package q577;

import java.util.Scanner;

class Mat {
	private int n1;
	private int n2;

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		Mat m = new Mat();
		m.setN1(a);
		m.setN2(b);

		Mat res = cal(m);
		System.out.println(res.getN1() + " " + res.getN2());
	}

	public static Mat cal(Mat m) {
		int max = 0;
		int min = 0;

		if (m.getN1() > m.getN2()) {
			max = m.getN1() / 2;
			min = m.getN2() * 2;
		} else if (m.getN1() < m.getN2()) {
			max = m.getN2() / 2;
			min = m.getN1() * 2;
		}

		Mat res = new Mat();
		res.setN1(min);
		res.setN2(max);
		return res;
	}
}
