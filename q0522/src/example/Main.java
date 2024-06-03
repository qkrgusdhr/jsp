package example;

import java.util.Scanner;

public class Main {
	static String Name;
	static String School;
	static int Grade;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Name = sc.next();
		School = sc.next();
		Grade = sc.nextInt();
		
		Student std = new Student();
		std.setName(Name);
		std.setSchool(School);
		std.setGrade(Grade);
		std.print();
		
		sc.close();
	}

}
