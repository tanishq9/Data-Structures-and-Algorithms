package OOPS3;

interface Player {
	final int id = 10;

	// public and abstract
	void display();
}

class testclass implements Player {
	@Override
	public void display() {
		System.out.println("Geek.");
	}
}

public class Interfaces {
	public static void main(String[] args) {
		
	}
}
