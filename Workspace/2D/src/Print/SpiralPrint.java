package Print;

import java.util.Scanner;

public class SpiralPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[][] arr=new int[3][3];
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				arr[row][col]=scanner.nextInt();
			}
		}
		spiralPrint(arr);
		System.out.println();
		scanner.close();
	}
	
	public static void spiralPrint(int[][] arr) {
		int left=0,top=0,right=arr[top].length-1,bottom=arr.length-1,count=(bottom+1)*(right+1),dir=1;
		//count is a check value i.e if all values are printed then we wont print anything else
		while(left<=right && top<=bottom) {
			if(count>0) {
				if(dir==1) {
					for(int i=left;i<=right;i++) {
						System.out.println(arr[top][i]);
						count--;
					}
				}
				top++;
				dir=2;
			}
			if(count>0) {
				if(dir==2) {
					for(int i=top;i<=bottom;i++) {
						System.out.println(arr[i][right]);
						count--;
					}
				}
				right--;
				dir=3;
			}
			if(count>0) {
				if(dir==3) {
					for(int i=right;i>=left;i--) {
						System.out.println(arr[bottom][i]);
						count--;
					}
				}
				bottom--;
				dir=4;
			}
			if(count>0) {
				if(dir==4) {
					for(int i=bottom;i>=top;i--) {
						System.out.println(arr[i][left]);
						count--;
					}
				}
				left++;
				dir=1;
			}
		}
	}
	
}
