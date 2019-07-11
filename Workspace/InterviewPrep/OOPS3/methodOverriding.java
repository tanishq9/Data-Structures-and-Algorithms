package OOPS3;

class A {
	void m() {
		System.out.println("Inside A");
	}

	void a_fun() {
		System.out.println("Fun A");
	}
}

class B extends A {
	void m() {
		System.out.println("Inside B");
	}

	void b_fun() {
		System.out.println("Fun B");
	}
}

class C extends A {
	void m() {
		System.out.println("Inside C");
	}

	void c_fun() {
		System.out.println("Fun C");
	}
}

public class methodOverriding {
	public static void main(String[] args) {
		A ref = null;

		// object of type A
		A a = new A();

		// object of type B
		B b = new B();

		// object of type C
		C c = new C();

		ref = a;
		a.m();
		a.a_fun();
		ref = b;
		a = new B();
		a.m();
		ref = c;
		a = new C();
		a.m();
	}
}
