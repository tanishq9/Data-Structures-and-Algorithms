package OOPS1;

import OOPS2.Test3;

public class Test4 {

	static int count = 0;

	static void fun() {
		// static int xyz = 0; -> Not Allowed
		// “Static local variables are not allowed”
	}

	void fun_nonstatic() {
		
	}

	public static void main(String[] args) {
		// static dm or mf are shared by all the objects of the class

		Test3.funcInsideTest3();
	}
}
