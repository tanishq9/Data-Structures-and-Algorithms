package Arr;

import java.util.Scanner;

public class leftRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		//int n = s.nextInt();
		int n=5;
		int[] arr = new int[n];
		int[] output = new int[n];
		//int swaps = s.nextInt();
		int swaps=2;
		for (int i = 0; i < n; i++) {
	//		arr[i] = s.nextInt();
		}
		for (int i = 0; i < n; i++) {
			output[(i - swaps + n) % n] = arr[i];
		}
		for (int i = 0; i < n; i++) {
		//	System.out.print(output[i] + " ");
		}
		StringBuilder sb = new StringBuilder();
		char cc=(char)97;
		System.out.println(cc);
		//sb.setCharAt(0,);
		System.out.println('c'-'a');
	}
}
