package Stack;
import java.util.Scanner;
import java.util.Stack;

public class KsubArrayMaximum {
	public static void printMax(int[] arr, int k) {
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		int[] nge = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			nge[i] = stack.size() > 0 ? stack.peek() : n;
			stack.push(i);
		}
		for (int i = 0; i <= (n - k); i++) {
			int j = i;
			while (nge[j] < i + k) {
				j = nge[j];
			}
			System.out.print(arr[j] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		printMax(arr, k);
	}

}
