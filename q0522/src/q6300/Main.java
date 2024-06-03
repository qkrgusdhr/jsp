package q6300;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal2.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		int sunday = cal.get(Calendar.DAY_OF_MONTH);
		int tuseday = cal2.get(Calendar.DAY_OF_MONTH);
		int x = sc.nextInt();
		
		if(sunday + x == tuseday) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		sc.close();
	}
}
