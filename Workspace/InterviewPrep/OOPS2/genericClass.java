package OOPS2;

import java.util.ArrayList;

class Pair<T, S> {
	T first;
	S second;

	Pair(T first, S second) {
		this.first = first;
		this.second = second;
	}
}

public class genericClass {
	public static void main(String[] args) {
		Pair<Integer, String> p = new Pair<>(1, "ABC");
		System.out.println(p.first + " " + p.second);
		ArrayList<Pair<String, String>> customList = new ArrayList<>();
		customList.add(new Pair<>("A", "B"));
		customList.add(new Pair<>("B", "C"));
		customList.add(new Pair<>("C", "D"));
		customList.add(new Pair<>("D", "E"));
		customList.add(new Pair<>("E", "F"));
		for (Pair<String, String> pair : customList) {
			System.out.println(pair.first + " " + pair.second);
		}
	}
}
