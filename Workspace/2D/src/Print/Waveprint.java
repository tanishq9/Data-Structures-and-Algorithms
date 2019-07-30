package Print;

import java.util.Scanner;

public class Waveprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[][] arr=new int[3][3];
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				arr[row][col]=scanner.nextInt();
			}
		}
		RowWavePrint(arr);
		System.out.println();
		ColumnWavePrint(arr);
		scanner.close();
	}
	
	public static void RowWavePrint(int[][] arr) {
		for(int row=0;row<3;row++) {
			if(row%2!=0) {
				for(int col=2;col>=0;col--) {
					System.out.print(arr[row][col]+" ");				
				}
			}else {
				for(int col=0;col<3;col++) {
					System.out.print(arr[row][col]+" ");				
				}				
			}
		}
	}
	
	public static void ColumnWavePrint(int[][] arr) {
		for(int col=0;col<3;col++) {
			if(col%2==0) {
				for(int row=0;row<=2;row++) {
					System.out.print(arr[row][col]+" ");				
				}
			}else {
				for(int row=2;row>=0;row--) {
					System.out.print(arr[row][col]+" ");				
				}				
			}
		}
	}
}

