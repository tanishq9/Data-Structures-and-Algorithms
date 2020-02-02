package Crio_Launch_HackerRank_Java;

import java.util.Scanner;

public class Java_Stdin_Stdout_2 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        String s = "";
        while(scan.hasNextLine()){
            s+=scan.nextLine();
        }
        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
