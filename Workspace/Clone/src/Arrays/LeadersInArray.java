package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// import java.io.*;

public class LeadersInArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t != 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] strs = br.readLine().trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(strs[i]);
			}
			boolean[] store = new boolean[n];
			store[n - 1] = true;
			int max = arr[n - 1];

			for (int i = n - 2; i >= 0; i--) {
				if (max <= arr[i]) {
					max = arr[i];
					store[i] = true;
				}
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				if (store[i] == true) {
					sb.append(arr[i] + " ");
				}
			}
			System.out.println(sb);
			t--;
		}
	}
}