package RecursionClassics;

public class towerOfHanoi {

	public static void tower(int n, char src, char dest, char helper) {
		// Base case
		if (n == 0) {
			return;
		}
		// Recursive case

		// Move n-1 disks from source to helper
		tower(n - 1, src, helper, dest);
		// Move nth disk from source to helper
		System.out.println("Move " + n + " disk from " + src + " to " + dest);
		// Move n-1 disks from source to destination
		tower(n - 1, helper, dest, src);
	}

	public static void main(String[] args) {
		tower(3,'A','C','B');
	}	

}
