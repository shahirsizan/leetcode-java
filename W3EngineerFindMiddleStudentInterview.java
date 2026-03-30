// https://www.glassdoor.com/Interview/W3-Engineers-Interview-Questions-E3438225_P3.htm

import java.util.Arrays;

public class W3EngineerFindMiddleStudentInterview {
	static class Student {
		int roll;
		String name;
		
		public Student(int roll, String name) {
			this.roll = roll;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "Roll: " + this.roll + ", Name: " + this.name;
		}
	}
	
	public static void main(String[] args) {
		// 2. Create Unsorted Array of Structures
		Student[] students = {
				new Student(105, "Alice"),
				new Student(101, "Bob"),
				new Student(103, "Charlie"),
				new Student(102, "David"),
				new Student(104, "Eve")
		};
		
		// 3. Sort Based on Roll Number
		Arrays.sort(students, (a, b) -> {
			return a.roll - b.roll;
		});
		
		// 4. Find the Middle Element
		int middleIndex = students.length / 2;
		Student middleStudent = students[middleIndex];
		
		System.out.println("Sorted Students: " + Arrays.toString(students));
		System.out.println("Middle Student (by roll): " + middleStudent);
	}
}
