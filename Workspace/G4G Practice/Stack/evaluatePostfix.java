/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    String s = sc.next();
		    System.out.println(evalPostfix(s));
		}
	}
	public static int evalPostfix(String str){
	    Stack<Integer> stack = new Stack<>();
	    for(int i=0;i<str.length();i++){
	        char cc = str.charAt(i);
	        int offset = cc - '0';
	        if(offset>=0 && offset<=9){
	            stack.push(offset);
	        }
	        else{
	            int top1 = stack.pop();
	            int top2 = stack.pop();
	            if(cc=='+'){
	                stack.push(top2+top1);
	            }else if(cc=='-'){
	                stack.push(top2-top1);
	            }else if(cc=='*'){
	                stack.push(top2*top1);
	            }else if(cc=='/'){
	                stack.push(top2/top1);
	            }else if(cc=='^'){
	                stack.push((int)Math.pow(top2,top1));
	            }
	        }
	    }
	    return stack.pop();
	}
}
