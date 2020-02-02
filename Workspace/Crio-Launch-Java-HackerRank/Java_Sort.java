package Crio_Launch_HackerRank_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

public class Java_Sort {
	// Complete the code
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}
		Collections.sort(studentList, new StudentComparator());
		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}
}

class StudentComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if (s1.getCgpa() == s2.getCgpa()) {
			return s1.getFname().compareTo(s2.getFname());
		} else {
			if (s1.getCgpa() > s2.getCgpa()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
