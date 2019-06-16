package LinkedList;

public class addPolynomial {
	class Node {
		int coeff;
		int pow;
		Node next;

		Node(int a, int b) {
			coeff = a;
			pow = b;
			next = null;
		}

		public void addPolynomial(Node p1, Node p2) {
			String str = "";
			int start = 0;
			while (p1 != null || p2 != null) {
				if (p1.pow > p2.pow) {
					if (start == 0) {
						str += p1.coeff + "x^" + p1.pow;
						start = 1;
					} else {
						str += " + " + p1.coeff + "x^" + p1.pow;
					}
					p1 = p1.next;
				} else if (p1.pow == p2.pow) {
					int coeff = p1.coeff + p2.coeff;
					if (start == 0) {
						str += coeff + "x^" + p1.pow;
						start = 1;
					} else {
						str += " + " + coeff + "x^" + p1.pow;
					}
					p1 = p1.next;
					p2 = p2.next;
				} else if (p1.pow < p2.pow) {
					if (start == 0) {
						str += p2.coeff + "x^" + p2.pow;
						start = 1;
					} else {
						str += " + " + p2.coeff + "x^" + p2.pow;
					}
					p2 = p2.next;
				}
			}
			while (p1 != null) {
				if (start == 0) {
					str += p1.coeff + "x^" + p1.pow;
					start = 1;
				} else {
					str += " + " + p1.coeff + "x^" + p1.pow;
				}
				p1 = p1.next;
			}
			while (p2 != null) {
				if (start == 0) {
					str += p2.coeff + "x^" + p2.pow;
					start = 1;
				} else {
					str += " + " + p2.coeff + "x^" + p2.pow;
				}
				p2 = p2.next;
			}
			System.out.print(str);
		}
	}
}
