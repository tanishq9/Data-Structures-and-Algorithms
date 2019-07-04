package OOPS2;

import OOPS1.Test1;

public class Test3 extends Test1 {
	public static void main(String[] args) {
		Test3 t1 = new Test3();
		System.out.println(t1.var2); // public variable
		System.out.println(t1.var3); // protected variable
	}

	public static void funcInsideTest3() {

	}

}
