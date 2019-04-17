package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
	static class Student implements Comparable<Student> {
		String name;
		int marks;
		int rank;

		Student(String name, int marks, int r) {
			this.name = name;
			this.marks = marks;
			this.rank = r;
		}

		@Override
		public int compareTo(Student other) {
			// The result is a negative integer if this String object lexicographically
			// precedes the argument string. The result is a positive integer if this String
			// object lexicographically follows the argument string. The result is zero if
			// the strings are equal; compareTo returns 0 exactly when the equals(Object)
			// method would return true.
			if (this.name.compareTo(other.name) < 0) {
				return -1;
			} else if (this.name.compareTo(other.name) > 0) {
				return 1;
			} else {
				return 0;
			}
			/*
			 * if (this.rank < other.rank) { if (this.marks > other.marks) { return -1; } }
			 * else if (this.rank > other.rank) { return 1; } return 0;
			 */
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>();
		ArrayList<Student> list = new ArrayList<>();
		Student st1 = new Student("Tanishq", 100, 1);
		pq.add(st1);
		Student st2 = new Student("Akshit", 90, 3);
		pq.add(st2);
		Student st3 = new Student("Sumeet", 100, 2);
		pq.add(st3);
		Student st4 = new Student("Ahmad", 50, 4);
		pq.add(st4);
		while (pq.size() > 0) {
			Student top = pq.peek();
			System.out.println(top.name + " -> Marks : " + top.marks);
			pq.remove();
		}
	}

}
