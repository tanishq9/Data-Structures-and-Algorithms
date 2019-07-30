package OOPS1;

public class JavaIsPassByValue {

	static class T {
		int x = 0;
	}

	public static void main(String[] args) {
		Integer i = new Integer(1);
		System.out.println(i);
		change(i);
		System.out.println(i);
		String str = "abc";
		System.out.println(str);
		cs(str);
		System.out.println(str);
		T t = new T();
		System.out.println(t.x);
		ct(t);
		System.out.println(t.x);
		System.out.println("------------------------");
		i += 5;
		System.out.println(i);
		System.out.println("------------------------");
		str = str + "def";
		System.out.println(str);
		// An important point to note here is that, while the String object is
		// immutable, its reference variable is not. So that's why, in the above
		// example, the reference was made to refer to a newly formed String object.
	}

	static void change(Integer a) {
		a = 10;
	}

	static void cs(String n) {
		n = "yolo";
	}

	static void ct(T obj) {
		// obj = null ; this gives null pointer exception
		// if we try to access x variable of obj
		obj.x = 10;
	}

}
