package ArrayList;

import java.util.ArrayList;

public class Basics {

	public static void assign() {
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(10);
		l1.add(20);
		l1.add(30);
		System.out.println(l1 + " " + l1.size());

		ArrayList<Integer> l2 = l1;
		l2.add(40);
		System.out.println(l1 + " " + l1.size());
		System.out.println(l2 + " " + l2.size());

		ArrayList<Integer> l3 = new ArrayList<>(l1);
		l3.add(50);
		System.out.println(l1 + " " + l1.size());
		System.out.println(l2 + " " + l2.size());
		System.out.println(l3 + " " + l3.size());

	}

	public static void params(ArrayList<Integer> p) {
		p.add(40);
	}

	public static ArrayList<Integer> return_good() {
		ArrayList<Integer> t = new ArrayList<>();
		t.add(10);
		t.add(20);
		t.add(30);
		return t;
	}

	public static void main(String[] args) {
		assign();
		// ArrayList<Integer> l = new ArrayList<>();
		// l.add(10);
		// l.add(20);
		// l.add(30);
		// System.out.println(l);
		// params(l);
		// System.out.println(l);
		// ArrayList<Integer> mt1 = return_good();
		// System.out.println(mt1);
	}

}
