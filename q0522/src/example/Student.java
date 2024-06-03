package example;

public class Student {
	private String Name;
	private String School;
	private int Grade;

	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSchool() {
		return School;
	}

	public void setSchool(String school) {
		School = school;
	}

	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}

	public void print() {
		System.out.println("Name : " + Name);
		System.out.println("School : " + School);
		System.out.println("Grade : " + Grade);
	}
}
